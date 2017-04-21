package com.sudaotech.image.service;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sudaotech.core.Session;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.image.ImageConfig;
import com.sudaotech.image.ImageSize;
import com.sudaotech.image.compressor.DefaultImageCompressor;
import com.sudaotech.image.compressor.ImageCompressor;

public class ImageServiceImpl extends BaseServiceImpl implements ImageService {
    private static final String ORIGIN = "origin";

    /**
     * 原图尺寸
     */
    public static final String DEFAULT_IMAGE_SIZE = "0x0";

    private final ImageCompressor imageCompressor;
    private final ImageConfig imageConfig;
    private final List<ImageSize> imageSizes = new ArrayList<ImageSize>();
    private final File root;

    private static final Pattern IMAGE_SIZE_PATTERN = Pattern.compile("\\dx\\d");

    @Inject
    public ImageServiceImpl(@Named("filestorage.root") String root) throws IOException {
        this.root = new File(root, "image");
        this.imageConfig = ImageConfig.load();
        this.imageCompressor = new DefaultImageCompressor(this.imageConfig.getImageQuality());
        for (String size : imageConfig.getImageSizes()) {
            this.imageSizes.add(new ImageSize(size));
        }
    }

    @Override
    public InputStream read(String path) throws IOException {
        File file = new File(this.root, path);
        if (file.isFile()) {
            if (file.canRead()) {
                return new FileInputStream(file);
            } else {
                throw new IOException("file cannot be read: " + path);
            }
        }
        
        
        // 若没有指定格式,则返回原图
        String fileName = file.getName().toLowerCase();
        final String size = IMAGE_SIZE_PATTERN.matcher(fileName).find() ? fileName : DEFAULT_IMAGE_SIZE;
        final File dir = file.isDirectory() ? file : file.getParentFile();
        
        file = this.loadSizedFile(dir, size);
        if (file != null) {
            return new FileInputStream(file);
        }

        return null;
    }
    
    private File searchFile(File dir, final String searchName) throws FileNotFoundException {
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(searchName);
            }
        };
        
        File[] files = dir.listFiles(filter);
        if (!ArrayUtils.isEmpty(files)) {
            File file = files[0];
            if (file.isFile() && file.canRead()) {
                return file;
            }
        }
        
        return null;
    }

    @Override
    public String save(String name, InputStream inputStream, Session session) throws IOException {
        // save original file
        String suffix = getSuffix(name);
        String uri = "";
        if (session.getUserId() != null && session.getUserId().equals(0)) {
        	uri = buildUri(session);
        } else {
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        	Date date = new Date();
        	String format = dateFormat.format(date);
        	uri = "01/" + format + "/" + date.getTime() + "/";
        }
        logger.debug("Creating file: {} -> {}", name, uri);
        
        File srcFile = new File(this.root, uri + ORIGIN + suffix);
        File dir = srcFile.getParentFile();
        dir.mkdirs();
        
        OutputStream output = null;
        try {
            output = new FileOutputStream(srcFile);
            IOUtils.copy(inputStream, output);
        } finally {
            IOUtils.closeQuietly(output);
            IOUtils.closeQuietly(inputStream);
        }
        File targetFile = new File(this.root, uri + DEFAULT_IMAGE_SIZE + suffix);
        compressImage(srcFile, targetFile);
        
        logger.info("Created file: {} -> {}", name, uri);
        
        return uri + ORIGIN + suffix;
    }

    @Override
    public String saveToVague(String name, InputStream inputStream, Session session) throws IOException {
        // save original file
        String suffix = getSuffix(name);
        String uri = "";
        if (session.getUserId() != null && session.getUserId().equals(0)) {
        	uri = buildUri(session);
        } else {
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        	Date date = new Date();
        	String format = dateFormat.format(date);
        	uri = "01/" + format + "/" + date.getTime() + "/";
        }
        logger.debug("Creating file: {} -> {}", name, uri);
        
        File srcFile = new File(this.root, uri + ORIGIN + suffix);
        File dir = srcFile.getParentFile();
        dir.mkdirs();
        
        OutputStream output = null;
        try {
            output = new FileOutputStream(srcFile);
            IOUtils.copy(inputStream, output);
        } finally {
            IOUtils.closeQuietly(output);
            IOUtils.closeQuietly(inputStream);
        }
        
        File targetFile = new File(this.root, uri + DEFAULT_IMAGE_SIZE + suffix);
        compressImageToVague(srcFile, targetFile);
        
        logger.info("Created file: {} -> {}", name, uri);
        
        return uri + ORIGIN + suffix;
    }
    
    private void compressImageToVague(File srcFile, File targetFile) throws FileNotFoundException, IOException {
        imageCompressor.compressImageToVague(srcFile, targetFile);
    }
    
    private void compressImage(File srcFile, File targetFile, ImageSize imageSize) throws FileNotFoundException, IOException {
        imageCompressor.compressImage(srcFile, targetFile, imageSize);
    }
    
    private void compressImage(File srcFile, File targetFile) throws FileNotFoundException, IOException {
    	imageCompressor.compressImage(srcFile, targetFile);
    }
    
    private File loadSizedFile(File dir, String size) throws IOException {
        // 检查是否存在目录
        if (!dir.isDirectory()) {
            return null;
        }
        
        // 检查所需尺寸图是否存在
        File file = searchFile(dir, size);
        if (file != null) {
            return file;
        }

        // 加载默认图
        File defaultImageFile = loadDefaultImageFile(dir);
        if (defaultImageFile == null) {
            return null;
        }
        
        if (size.equals(DEFAULT_IMAGE_SIZE)) {
            return defaultImageFile;
        }
        
        // 仅仅生成支持的尺寸
        ImageSize targetImageSize = new ImageSize(size);
        for (ImageSize imageSize : imageSizes) {
            if (imageSize.equals(targetImageSize)) {
                String suffix = getSuffix(defaultImageFile.getName());
                File targetFile = new File(dir, targetImageSize.size + suffix);
                resize(defaultImageFile, targetFile, targetImageSize.width, targetImageSize.height);
                
                return targetFile;
            }
        }
        
        this.logger.warn("Not found sized image, using default.");
        
        // 默认返回默认图
        return defaultImageFile;
    }
    
    /**
     * 加载默认图，若不存在，则使用原图生成。
     * @param dir
     * @return 默认图或null
     * @throws IOException
     */
	private File loadDefaultImageFile(File dir) throws IOException {
	    File targetFile = searchFile(dir, DEFAULT_IMAGE_SIZE);
	    if (targetFile == null) {
	        File srcFile = searchFile(dir, ORIGIN);
	        if (srcFile == null) {
	            return null;
	        }
	        
	        targetFile = new File(dir, DEFAULT_IMAGE_SIZE + getSuffix(srcFile.getName()));
            compressImage(srcFile, targetFile);
	    }
	    
	    return targetFile;
    }

    /**
	 * 强制压缩/放大图片到固定的大小
	 * @param targetWidth int 新宽度
	 * @param targetHeight, int 新高度
	 * @param srcImage 源图片
	 * @throws IOException
	 */
    private void resize(File srcFile, File targetFile, int targetWidth, int targetHeight) throws IOException {
        // 若target是0x0，应该使用原图
        if (targetWidth == 0 && targetHeight == 0) {
            return;
        }
        
        FileInputStream input = new FileInputStream(srcFile);
        BufferedImage srcImage = ImageIO.read(input);
        IOUtils.closeQuietly(input);
        
        int srcWidth = srcImage.getWidth();
        int srcHeight = srcImage.getHeight();
        
        // 若宽为0，参考原高等比例缩放; 
        if (targetWidth == 0) {
            targetWidth = (int) (1L * targetHeight * srcWidth / srcHeight);
        } 
        // 若高为0，参考原宽等比例缩放;
        else if (targetHeight == 0) {
            targetHeight = (int) (1L * targetWidth * srcHeight / srcWidth);
        } 

        // 等比例压缩；若目标尺寸比较原图大，则压缩为与目标尺寸等比例的小图
        double rate1 = ((double) srcWidth) / srcHeight;
        double rate2 = ((double) targetWidth) / targetHeight;

        int width = srcWidth, height = srcHeight;
        if (rate1 > rate2) {
            width = (int)(1L * srcHeight * targetWidth /  targetHeight);
        } else {
            height = (int)(1L * srcWidth * targetHeight / targetWidth);
        }
        
        // 先从原图截取与目标尺寸等比例最大图，然后再压缩
        int x = (srcWidth - width) / 2, y = (srcHeight - height) / 2;
        srcImage = srcImage.getSubimage(x, y, width, height);
        
        // 如目标尺寸比截图大，则采用截图尺寸
        if (targetWidth > width) {
            targetWidth = width;
            targetHeight = height;
        }
        
        writeImage(srcImage, targetFile, targetWidth, targetHeight);
    }

    private void writeImage(BufferedImage srcImage, File targetFile, int targetWidth, int targetHeight)
            throws IOException {
        //构建图片对象
        BufferedImage image = new BufferedImage(targetWidth, targetHeight, srcImage.getType());
        //绘制缩放后的图
        Image scaledInstance = srcImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        image.getGraphics().drawImage(scaledInstance, 0, 0, targetWidth, targetHeight, Color.WHITE, null);
		//输出到文件
		ImageIO.write(image, "jpg", targetFile);
		
		logger.info("Created image: {}", targetFile);
    }

    private String buildUri(Session session) {
        final Date date = new Date();

        Long userId = null;
        if (session != null) {
            userId = session.getUserId();
        }
        SimpleDateFormat format = new SimpleDateFormat("/yyyyMMdd/");
        return "/" + userId.toString() + format.format(date) + UUID.randomUUID().toString() + "/";
    }

    private String getSuffix(String name) {
        if (name != null) {
            int i = name.lastIndexOf('.');
            if (i >= 0) {
                return name.substring(i);
            }
        }

        return "";
    }

    @Override
    public ImageSize getImageSize(String imageUri) throws IOException {
        File srcFile = this.loadDefaultImageFile(new File(this.root, imageUri));
        if (srcFile == null) {
            return null;
        }
        FileInputStream input = new FileInputStream(srcFile);
        BufferedImage srcImage = ImageIO.read(input);
        IOUtils.closeQuietly(input);
        
        int srcWidth = srcImage.getWidth();
        int srcHeight = srcImage.getHeight();
        return new ImageSize(srcWidth, srcHeight);
    }
    
    @Override
	public String downloadImageFromUri(String imageUri, Session session){
		BufferedReader reader = null;
		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		try {
			URL url = new URL(imageUri);
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(2000);
			inputStream = conn.getInputStream();
			
			String suffix = getSuffix(imageUri);
			String uri = buildUri(session);
	        logger.debug("Creating file: {} -> {}", imageUri, uri);
	        
	        File srcFile = new File(this.root, uri + ORIGIN + suffix);
	        File dir = srcFile.getParentFile();
	        dir.mkdirs();
			
			fileOutputStream = new FileOutputStream(srcFile);
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(buf)) != -1) {
				fileOutputStream.write(buf, 0, len);// 写
			}
			
			return uri;
		} catch (UnknownHostException e) {
			logger.warn("URL Image is UnknownHost :{}", e.getMessage());
		} catch (FileNotFoundException e) {
			logger.warn("URL Image is not found :{}", e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return "";
	}
}
