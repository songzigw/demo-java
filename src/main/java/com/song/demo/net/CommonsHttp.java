/*
 * Copyright (c) 2016, zhangsong <songm.cn>.
 *
 */

package com.song.demo.net;

import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * Apache commons-httpclient库的使用方法
 *
 * @author  zhangsong
 * @since   1.0
 * @version 1.0
 * 
 */
public class CommonsHttp {

	public static void main(String[] args) {
		/*
		 * String targetURL =
		 * "http://service.vlook.cn:8080/down/servlet/FileUpload?t=act";// TODO
		 * 指定URL File targetFile = new
		 * File("C:\\Documents and Settings\\Administrator\\桌面\\aaa\\90097458.jpg"
		 * );// TODO 指定上传文件
		 * 
		 * PostMethod filePost = new PostMethod(targetURL); //
		 * 若没有commons-codec-1.4-bin.zip,
		 * 
		 * try { // 通过以下方法可以模拟页面参数提交 // filePost.setParameter("name", "中文"); //
		 * filePost.setParameter("pass", "1234"); Part[] parts = { new
		 * FilePart(targetFile.getName(), targetFile) };
		 * filePost.setRequestEntity(new MultipartRequestEntity(parts,
		 * filePost.getParams())); HttpClient client = new HttpClient();
		 * client.getHttpConnectionManager().getParams().setConnectionTimeout(
		 * 5000); int status = client.executeMethod(filePost); if (status ==
		 * HttpStatus.SC_OK) { System.out.println("上传成功"); byte[] responseBody =
		 * filePost.getResponseBody(); //ByteArrayInputStream binput = new
		 * ByteArrayInputStream(responseBody); System.out.println(new
		 * String(responseBody)); } else { System.out.println("上传失败"); } } catch
		 * (Exception e) { e.printStackTrace(); } finally {
		 * filePost.releaseConnection(); }
		 */

		// 构造HttpClient的实例
		HttpClient httpClient = new HttpClient();
		// 创建GET方法的实例
		GetMethod getMethod = new GetMethod("http://www.ibm.com");
		// 使用系统提供的默认的恢复策略
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		try {
			// 执行getMethod
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ getMethod.getStatusLine());
			}
			// 读取内容
			byte[] responseBody = getMethod.getResponseBody();
			// 处理内容
			System.out.println(new String(responseBody));
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
		} catch (IOException e) {
			// 发生网络异常
			e.printStackTrace();
		} finally {
			// 释放连接
			getMethod.releaseConnection();
		}
	}

	public static void send2() throws HttpException, IOException {
		// 构造HttpClient的实例
		HttpClient httpClient = new HttpClient();
		String url = "http://www.newsmth.net/bbslogin2.php";
		PostMethod postMethod = new PostMethod(url);
		// 填入各个表单域的值
		NameValuePair[] data = { new NameValuePair("id", "youUserName"),
		new NameValuePair("passwd", "yourPwd") };
		// 将表单的值放入postMethod中
		postMethod.setRequestBody(data);
		// 执行postMethod
		int statusCode = httpClient.executeMethod(postMethod);
		// HttpClient对于要求接受后继服务的请求，象POST和PUT等不能自动处理转发
		// 301或者302
		if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY || 
		statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
		    // 从头中取出转向的地址
		    Header locationHeader = postMethod.getResponseHeader("location");
		    String location = null;
		    if (locationHeader != null) {
		     location = locationHeader.getValue();
		     System.out.println("The page was redirected to:" + location);
		    } else {
		     System.err.println("Location field value is null.");
		    }
		    return;
		}
	}
}
