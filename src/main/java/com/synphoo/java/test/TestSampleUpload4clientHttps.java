package com.synphoo.java.test;

import java.io.File;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/*
 * 测试类(比较完善)
 * 测试Https接口 post
 *https接口的调用与http有些不同
 *  * apache官网可以下载最新的jar包和demo
 * http://hc.apache.org/downloads.cgi
 */
public class TestSampleUpload4clientHttps {
	public static void main(String[] args) throws Exception {
		CloseableHttpClient closeableHttpClient = createHttpsClient();
		// 建立HttpPost对象
		HttpPost httppost = new HttpPost(
				"https://192.168.10.XXX:8443/XXXXX/XXXX/sampleUpload4client.action");
		// 配置要 POST 的数据begin
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder
				.create();
		// 设置为浏览器兼容模式
		multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		// 设置请求的编码格式
		multipartEntityBuilder.setCharset(Charset.forName(HTTP.UTF_8));
		ContentType TEXT_PLAIN = ContentType.create("text/plain",
				Charset.forName(HTTP.UTF_8));
		multipartEntityBuilder.addTextBody("userName", "admin", TEXT_PLAIN);
		multipartEntityBuilder.addTextBody("psd", "admin", TEXT_PLAIN);
		multipartEntityBuilder.addTextBody("mac", "abw3232jjf2swsj3",
				TEXT_PLAIN);
		multipartEntityBuilder.addTextBody("md5", "uy0kfwefess8e6", TEXT_PLAIN);
		multipartEntityBuilder.addTextBody("type", "sample", TEXT_PLAIN);
		// 文件路径
		File file = new File("D:\\glpt\\XXXXX.txt");
		multipartEntityBuilder.addBinaryBody("file", file);
		// 配置要 POST 的数据end
		// 生成 HTTP POST 实体
		HttpEntity httpEntity = multipartEntityBuilder.build();
		httppost.setEntity(httpEntity);
		// 发送Post,并返回一个HttpResponse对象
		HttpResponse httpResponse = closeableHttpClient.execute(httppost);
		HttpEntity httpEntity2 = httpResponse.getEntity();
		System.out.println("httpResponse.getStatusLine().getStatusCode():"
				+ httpResponse.getStatusLine().getStatusCode());
		// 如果状态码为200,就是正常返回
		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			String result = EntityUtils.toString(httpEntity2);
			// 得到返回的字符串
			System.out.println(result);
			// 如果是下载文件,可以用response.getEntity().getContent()返回InputStream
		} else {
			String result = EntityUtils.toString(httpEntity2);
			// 得到返回的字符串
			System.out.println(result);
		}
		// 关闭连接
		closeableHttpClient.close();

	}

	public static CloseableHttpClient createHttpsClient() throws Exception {
		X509TrustManager x509mgr = new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] xcs, String string) {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] xcs, String string) {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, new TrustManager[] { x509mgr },
				new java.security.SecureRandom());
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslContext,
				SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}

}
