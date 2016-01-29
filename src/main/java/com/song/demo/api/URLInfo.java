package com.song.demo.api;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class URLInfo {

	/** 请求URL */
	private URL url;

	/** 请求的服务名称 */
	private String hostName;

	/** 访问资源路径名称 */
	private String pathName;

	/** 请求的协议 */
	private String protocol;

	/** 参数键值对 */
	private Map<String, String> paramMap;

	public URLInfo(URL url) {
		this.url = url;
		this.hostName = url.getHost();
		this.pathName = url.getPath();
		this.protocol = url.getProtocol();
		this.paramMap = this.urlParams(url.getQuery());
	}

	public URL getUrl() {
		return url;
	}

	public String getHostName() {
		return hostName;
	}

	public String getPathName() {
		return pathName;
	}

	public String getProtocol() {
		return protocol;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	/**
	 * 解析出url参数中的键值对 如 "index.jsp?action=del&id=123"，解析出action:del,id:123存入map中
	 * 
	 * @param query
	 *            URL地址附带参数
	 * @return URL请求参数部分
	 */
	private Map<String, String> urlParams(String query) {
		Map<String, String> mapRequest = new HashMap<String, String>();

		String strUrlParam = query;
		if (strUrlParam == null) {
			return mapRequest;
		}
		// 每个键值为一组 www.2cto.com
		String[] arrSplit = strUrlParam.split("[&]");
		for (String strSplit : arrSplit) {
			String[] arrSplitEqual = null;
			arrSplitEqual = strSplit.split("[=]");

			// 解析出键值
			if (arrSplitEqual.length > 1) {
				// 正确解析
				mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

			} else {
				if (arrSplitEqual[0] != "") {
					// 只有参数没有值，不加入
					mapRequest.put(arrSplitEqual[0], "");
				}
			}
		}
		return mapRequest;
	}

}
