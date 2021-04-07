/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.plumelog.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author : pdl
 * @date : 2020/8/4 17:48
 */

public class HttpClient {

	public static String doPost(String httpUrl, String param) {

		HttpURLConnection connection = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedReader br = null;
		String result = null;
		try {
			URL url = new URL(httpUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(1000);
			connection.setReadTimeout(1000);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			os = connection.getOutputStream();
			os.write(param.getBytes());
			if (connection.getResponseCode() == 200) {
				return result;
			}
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			// 关闭资源
			if (null != br) {
				try {
					br.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != os) {
				try {
					os.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != connection) {
				connection.disconnect();
			}
		}
		return result;
	}

}
