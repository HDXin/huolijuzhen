package com.sudaotech.huolijuzhen.notice.easemob.comm.utils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

@SuppressWarnings("deprecation")
public class RestAPIUtils {

    /**
     * Create a httpClient instance
     *
     * @param isSSL if the request is protected by ssl
     * @return HttpClient instance
     */
    public static HttpClient getHttpClient(boolean isSSL) {
        CloseableHttpClient client = null;

        if(isSSL) {
            try {
                X509HostnameVerifier verifier = new X509HostnameVerifier() {
                    public void verify(String host, SSLSocket ssl) throws IOException {
                    }

                    public void verify(String host, X509Certificate cert) throws SSLException {
                    }

                    public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
                    }

                    public boolean verify(String s, SSLSession sslSession) {
                        return true;
                    }
                };

                TrustManager[] tm = new TrustManager[]{new X509TrustManager() {

                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkServerTrusted(X509Certificate[] chain, String authType)
                            throws CertificateException {
                    }

                    public void checkClientTrusted(X509Certificate[] chain, String authType)
                            throws CertificateException {
                    }
                }};

                SSLContext sslContext = SSLContext.getInstance("SSL");

                sslContext.init(null, tm, new SecureRandom());

                client = HttpClients.custom().setSslcontext(sslContext).setHostnameVerifier(verifier).build();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }

        } else {
            client = HttpClients.createDefault();
        }

        return client;
    }

    /**
     * Check illegal String
     *
     * @param regex reg expression
     * @param str string to be validated
     * @return if matched
     */
    public static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.lookingAt();
    }
}
