package com.song.demo.net;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class NetTest {

	public static void a() throws HttpException, IOException {
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(
				"http://192.168.1.5:8080/song-account-web/api/user/getUser.json");
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
		// System.out.println(method.getResponseBodyAsString());
		// HttpMethodParams m = method.getParams();
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
		String response = new String(method.getResponseBodyAsString().getBytes(
				"UTF-8"));
		// 打印返回的信息
		System.out.println(response);
		method.releaseConnection();
	}

	public static void main(String[] args) throws IOException {
		a();
	}

	private static HttpMethod getPostMethod() {
		PostMethod post = new PostMethod("/simcard.php");
		NameValuePair simcard = new NameValuePair("simcard", "1330227");
		post.setRequestBody(new NameValuePair[] { simcard });
		return post;
	}
}
