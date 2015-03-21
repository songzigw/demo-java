package com.song.demo.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Utils {
	public static String encode64(String str) {
		String s = str;
		if (s == null) {
			return "";
		} else {
			String value = null;
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException ex) {
			}
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder();
			try {
				value = baseEncoder.encode(md5.digest(s.getBytes("utf-8")));
			} catch (Exception ex) {
			}
			return value;
		}
	}

	public static String encode32(String str) {
		String s = str;
		if (s == null) {
			return "";
		} else {
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException ex) {
			}
			StringBuilder hexValue = new StringBuilder();
			try {
				byte[] md5Bytes = md5.digest(s.getBytes("utf-8"));
				for (int i = 0; i < md5Bytes.length; i++) {
					int val = ((int) md5Bytes[i]) & 0xff;
					if (val < 16)
						hexValue.append("0");
					hexValue.append(Integer.toHexString(val));
				}
			} catch (Exception e) {
			}
			return hexValue.toString();
		}
	}

}
