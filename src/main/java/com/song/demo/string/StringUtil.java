package com.song.demo.string;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StringUtil {

	public static String inputStream2String(InputStream is) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuffer buffer = new StringBuffer();
		String line = null;
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		return buffer.toString();
	}

	public static Date string2Date(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getUdidFormat(String udid) {
		udid = udid.toUpperCase();
		StringBuffer str = new StringBuffer();
		String[] strs = udid.split(":");
		for (String s : strs) {
			str.append(s);
		}
		return str.toString();
	}

	public static String encodeLimeiSourceUdid(String sourceUdid) {
		String rt = null;
		// add ':'
		char[] strcs = new char[sourceUdid.length()];
		sourceUdid.getChars(0, sourceUdid.length(), strcs, 0);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (char c : strcs) {
			sb.append(c);
			i++;
			if (i % 2 == 0)
				sb.append(':');
		}
		String added = sb.deleteCharAt(sb.length() - 1).toString();
		// md5 32
		rt = MD5Utils.encode32(added);

		return rt;
	}

	/**
	 * 解析出url请求的路径
	 * 
	 * @param strURL
	 *            url地址
	 * @return url路径
	 */
	public static String urlPath(String strURL) {
		String strPage = null;
		String[] arrSplit = null;

		strURL = strURL.trim().toLowerCase();

		arrSplit = strURL.split("[?]");
		if (strURL.length() > 0) {
			if (arrSplit.length > 1) {
				if (arrSplit[0] != null) {
					strPage = arrSplit[0];
				}
			}
		}

		return strPage;
	}

	/**
	 * 去掉url中的路径，留下请求参数部分
	 * 
	 * @param strURL
	 *            url地址
	 * @return url请求参数部分
	 */
	private static String truncateUrl(String strURL) {
		String strAllParam = null;
		String[] arrSplit = null;

		strURL = strURL.trim().toLowerCase();

		arrSplit = strURL.split("[?]");
		if (strURL.length() > 1) {
			if (arrSplit.length > 1) {
				if (arrSplit[1] != null) {
					strAllParam = arrSplit[1];
				}
			}
		}

		return strAllParam;
	}

	/**
	 * 解析出url参数中的键值对 如 "index.jsp?action=del&id=123"，解析出action:del,id:123存入map中
	 * 
	 * @param strURL
	 *            url地址
	 * @return url请求参数部分
	 */
	public static Map<String, String> urlParams(String strURL) {
		Map<String, String> mapRequest = new HashMap<String, String>();

		String[] arrSplit = null;

		String strUrlParam = truncateUrl(strURL);
		if (strUrlParam == null) {
			return mapRequest;
		}
		// 每个键值为一组 www.2cto.com
		arrSplit = strUrlParam.split("[&]");
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

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String str = "18秒[扣鼻屎]胖子的悲哀";
		String target = sha1(str);
		
		if (str != null && str.indexOf("#萤石C2#")==-1) {
			System.out.println(str);
		}
		
		//System.out.println(target);
	}

	public static String sha1(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(str.getBytes());
		return bytes2Hex(md.digest());
	}

	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

}
