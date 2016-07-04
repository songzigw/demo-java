/*
 * Copyright (c) 2016, zhangsong <songm.cn>.
 *
 */

package com.song.demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 请求发送Json格式的数据
 * 
 * @author zhangsong
 * @since 1.0, 2016-7-4
 * @version 1.0
 *
 */
public class HttpJson {

    private static final String SPEC = "http://127.0.0.1:8080/server";
    private static String map = "{\"Content\":\""
            + "68:96:7B:73:05:B1,"
            + "5C:59:48:FE:E4:57,"
            + "58:55:CA:96:44:CB,"
            + "58:55:CA:01:FE:9E,"
            + "58:1F:AA:A3:60:79,"
            + "58:1F:AA:CA:CC:BF,"
            + "58:1F:AA:48:4B:06\","
            + "\"Type\":1,"
            + "\"StartDate\":\"2013-04-03\","
            + "\"EndDate\":\"2013-04-03\"}";

    private static void doGet() throws IOException {
        URL url = new URL(SPEC);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setUseCaches(true);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Connect-Length", String.valueOf(map.length()));
        conn.setRequestMethod("GET");

        conn.getOutputStream();

        OutputStreamWriter output = new OutputStreamWriter(
                conn.getOutputStream());
        output.write(map);
        output.flush();
        output.close();

        conn.connect();

        int code = conn.getResponseCode();
        if (code == 200) {
            conn.getInputStream();
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(
                    conn.getInputStream(), "utf-8"));
            StringBuffer data = new StringBuffer();
            String line = null;
            while ((line = input.readLine()) != null) {
                data.append(line);
            }
            input.close();
            System.out.printf("Response code: %d, Content: %s %n", code, data);
        } else {
            System.out.printf("Response code: %d %n", code);
        }

        conn.disconnect();
    }

    public static void main(String[] args) {
        try {
            doGet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
