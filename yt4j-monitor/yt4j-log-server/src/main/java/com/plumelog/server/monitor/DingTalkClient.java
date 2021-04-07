/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.plumelog.server.monitor;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.slf4j.LoggerFactory;

public class DingTalkClient {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(DingTalkClient.class);

	public static void sendToDingTalk(PlumeLogMonitorTextMessage plumeLogMonitorTextMessage, String URL) {
		com.dingtalk.api.DingTalkClient client = new DefaultDingTalkClient(URL);
		OapiRobotSendRequest request = new OapiRobotSendRequest();
		request.setMsgtype("markdown");
		OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
		markdown.setTitle("报警通知");
		markdown.setText(plumeLogMonitorTextMessage.getText());
		request.setMarkdown(markdown);
		OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
		at.setAtMobiles(plumeLogMonitorTextMessage.getAtMobiles());
		at.setIsAtAll(plumeLogMonitorTextMessage.isAtAll());
		request.setAt(at);
		OapiRobotSendResponse response = null;
		try {
			response = client.execute(request);
		}
		catch (ApiException e) {
			e.printStackTrace();
			logger.error(response.getErrmsg());
		}
	}

}
