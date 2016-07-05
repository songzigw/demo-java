/*
 * Copyright (c) 2016, zhangsong <songm.cn>.
 *
 */

package com.song.demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

/**
 * HTTP Client
 * 
 * @author zhangsong
 * @since 1.0, 2016-7-4
 * @version 1.0
 *
 */
public class HttpClient {

    private static final int CONNECT_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 10000;
    private static final String ENCODING = "utf-8";

    public static String doPost(String reqUrl, Map<String, String> params,
            String encoding) throws IOException {
        StringBuffer reply = new StringBuffer();
        if (encoding == null || encoding.trim().equals("")) {
            encoding = ENCODING;
        }

        StringBuffer paramsStr = new StringBuffer();
        for (Entry<String, String> element : params.entrySet()) {
            paramsStr.append(element.getKey()).append("=")
                    .append(URLEncoder.encode(element.getValue(), encoding))
                    .append("&");
        }
        if (paramsStr.length() > 0) {
            paramsStr.deleteCharAt(paramsStr.length() - 1);
        }

        // 开始创建连接
        URL url = new URL(reqUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");

        // （单位：毫秒）jdk1.4换成这个,连接超时
        System.setProperty("sun.net.client.defaultConnectTimeout",
                String.valueOf(CONNECT_TIMEOUT));
        // （单位：毫秒）jdk1.4换成这个,读操作超时
        System.setProperty("sun.net.client.defaultReadTimeout",
                String.valueOf(READ_TIMEOUT));

        // （单位：毫秒）jdk1.5换成这个,连接超时
        // conn.setConnectTimeout(5000);
        // （单位：毫秒）jdk1.5换成这个,读操作超时
        // conn.setReadTimeout(5000);

        conn.setDoInput(true);
        conn.setDoOutput(true);
        byte[] b = paramsStr.toString().getBytes();
        OutputStream out = conn.getOutputStream();
        out.write(b);
        out.flush();
        out.close();

        BufferedReader rd = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), encoding));
        String crlf = System.getProperty("line.separator");
        String line = rd.readLine();
        while (line != null) {
            reply.append(line).append(crlf);
            line = rd.readLine();
        }
        rd.close();

        conn.disconnect();
        return reply.toString();
    }
    
    public static String doGet(String reqUrl, Map<String, String> params,
            String encoding) throws IOException {
        StringBuffer reply = new StringBuffer();
        if (encoding == null || encoding.trim().equals("")) {
            encoding = ENCODING;
        }

        StringBuffer paramsStr = new StringBuffer();
        for (Entry<String, String> element : params.entrySet()) {
            paramsStr.append(element.getKey()).append("=")
                    .append(URLEncoder.encode(element.getValue(), encoding))
                    .append("&");
        }
        if (paramsStr.length() > 0) {
            paramsStr.deleteCharAt(paramsStr.length() - 1);
        }

        // 开始创建连接
        URL url = new URL(reqUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // （单位：毫秒）jdk1.4换成这个,连接超时
        System.setProperty("sun.net.client.defaultConnectTimeout",
                String.valueOf(CONNECT_TIMEOUT));
        // （单位：毫秒）jdk1.4换成这个,读操作超时
        System.setProperty("sun.net.client.defaultReadTimeout",
                String.valueOf(READ_TIMEOUT));

        // （单位：毫秒）jdk1.5换成这个,连接超时
        // conn.setConnectTimeout(5000);
        // （单位：毫秒）jdk1.5换成这个,读操作超时
        // conn.setReadTimeout(5000);

        conn.setDoInput(true);
        conn.setDoOutput(true);
        byte[] b = paramsStr.toString().getBytes();
        OutputStream out = conn.getOutputStream();
        out.write(b);
        out.flush();
        out.close();

        BufferedReader rd = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), encoding));
        String crlf = System.getProperty("line.separator");
        String line = rd.readLine();
        while (line != null) {
            reply.append(line).append(crlf);
            line = rd.readLine();
        }
        rd.close();

        conn.disconnect();
        return reply.toString();
    }

    public static String doGet(String reqUrl, String encoding)
            throws IOException {
        StringBuffer reply = new StringBuffer();
        if (encoding == null || encoding.trim().equals("")) {
            encoding = ENCODING;
        }

        StringBuffer params = new StringBuffer();
        String query = reqUrl;
        int markIndex = reqUrl.indexOf("?");

        if (markIndex > 0) {
            query = reqUrl.substring(0, markIndex);
            String conditions = reqUrl
                    .substring(markIndex + 1, reqUrl.length());
            String[] paramArr = conditions.split("&");
            for (int i = 0; i < paramArr.length; i++) {
                String string = paramArr[i];
                int index = string.indexOf("=");
                if (index > 0) {
                    String param = string.substring(0, index);
                    String value = string.substring(index + 1, string.length());
                    params.append(param);
                    params.append("=");
                    params.append(URLEncoder.encode(value, encoding));
                    params.append("&");
                }
            }
            params.deleteCharAt(params.length() - 1);
        }

        // 开始创建连接
        URL url = new URL(query);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // （单位：毫秒）jdk1.4换成这个,连接超时
        System.setProperty("sun.net.client.defaultConnectTimeout",
                String.valueOf(CONNECT_TIMEOUT));
        // （单位：毫秒）jdk1.4换成这个,读操作超时
        System.setProperty("sun.net.client.defaultReadTimeout",
                String.valueOf(READ_TIMEOUT));

        // （单位：毫秒）jdk1.5换成这个,连接超时
        // conn.setConnectTimeout(5000);
        // （单位：毫秒）jdk1.5换成这个,读操作超时
        // conn.setReadTimeout(5000);

        conn.setDoInput(true);
        conn.setDoOutput(true);
        byte[] b = params.toString().getBytes();
        OutputStream out = conn.getOutputStream();
        out.write(b);
        out.flush();
        out.close();

        BufferedReader rd = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), encoding));
        String crlf = System.getProperty("line.separator");
        String line = rd.readLine();
        while (line != null) {
            reply.append(line).append(crlf);
            line = rd.readLine();
        }
        rd.close();

        conn.disconnect();
        return reply.toString();
    }
}
