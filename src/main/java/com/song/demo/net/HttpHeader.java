/*
 * Copyright (c) 2016, zhangsong <songm.cn>.
 *
 */

package com.song.demo.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * HTTP头信息
 *
 * @author  zhangsong
 * @since   1.0, 2016-7-4
 * @version 1.0
 * 
 */
public class HttpHeader {

    private static void run() throws IOException {
        URL url = new URL("http://www.so.com");
        HttpURLConnection conn = 
                (HttpURLConnection) url.openConnection();
        String k, v;
        for (int i = 0;; i++) {
            k = conn.getHeaderFieldKey(i);
            v = conn.getHeaderField(i);
            if (k == null || v == null)
                break;
            System.out.printf("%s is: %s %n", k, v);
        }
    }

    public static void main(String[] args) {
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
