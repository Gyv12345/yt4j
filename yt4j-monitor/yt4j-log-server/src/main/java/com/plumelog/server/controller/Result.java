/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.plumelog.server.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * className：Result description： time：2020/6/10 19:20
 *
 * @author Frank.chen
 * @version 1.0.0
 */
public class Result {

	private Integer code;

	private String message;

	private List<String> logs = new ArrayList<>();

	public static Result UN_LOGIN = new Result(401);

	public static Result INVALID_LOGIN = new Result(402);

	public Result() {
	}

	public Result(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getLogs() {
		return logs;
	}

	public void setLogs(List<String> logs) {
		this.logs = logs;
	}

}
