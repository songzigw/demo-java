package com.song.demo.net;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class NetTest {
	public static void main(String[] args) throws IOException {
		HttpClient client = new HttpClient();
		//client.getHostConfiguration().setHost("www.imobile.com.cn", 80, "http");
		HttpMethod method = getGetMethod();// 使用POST方式提交数据
		client.executeMethod(method);
		// 打印服务器返回的状态
		System.out.println(method.getStatusLine());
		System.out.println(method.getStatusText());
		System.out.println(method.getStatusCode());
		System.out.println(method.getURI());
		System.out.println(method.getRequestHeader("Host").getValue());
		System.out.println(method.getPath());
		System.out.println(method.getHostAuthState().toString());
		
		System.out.println(method.getQueryString());
		//System.out.println(method.getResponseBodyAsString());
		HttpMethodParams m = method.getParams();
		System.out.println();
		System.out.println();
		Header[] hs1 = method.getRequestHeaders();
		for (Header h : hs1) {
			System.out.println(h.getName());
		}
		System.out.println();
		Header[] hs2 = method.getResponseHeaders();
		for (Header h : hs2) {
			System.out.println(h.getName());
		}
		// 打印结果页面
		//String response = new String(method.getResponseBodyAsString().getBytes(
		//		"8859_1"));
		// 打印返回的信息
		//System.out.println(response);
		method.releaseConnection();
	}

	private static HttpMethod getGetMethod() {
		return new GetMethod("http://xzheg.com:8080/ps.html?catId=3");
	}

	private static HttpMethod getPostMethod() {
		PostMethod post = new PostMethod("/simcard.php");
		NameValuePair simcard = new NameValuePair("simcard", "1330227");
		post.setRequestBody(new NameValuePair[] { simcard });
		return post;
	}
}
