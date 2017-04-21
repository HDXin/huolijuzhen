package com.sudaotech.huolijuzhen.commons.conf;

import com.sudaotech.core.config.ConfigLoader;

public class HuolijuzhenConfig {

	private static final HuolijuzhenConfig instance = ConfigLoader.loadYamlAs("huolijuzhen-conf.yaml", HuolijuzhenConfig.class);
	public static HuolijuzhenConfig getInstance(){
		return instance;
	}
	
	//主域名
	private String domainUrl;
	public String getDomainUrl() {
		return domainUrl;
	}

	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}

	//图片前缀
	private String imagePre;
	public String getImagePre() {
		return imagePre;
	}
	public void setImagePre(String imagePre) {
		this.imagePre = imagePre;
	}
	
	//H5 頁面
	private String domainHtmlUrl;
	public String getDomainHtmlUrl() {
		return domainHtmlUrl;
	}

	public void setDomainHtmlUrl(String domainHtmlUrl) {
		this.domainHtmlUrl = domainHtmlUrl;
	}
	
	//Excel 临时文件存放路劲
	private String filePath;
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
