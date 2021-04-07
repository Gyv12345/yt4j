/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 元数据
 *
 * @author gyv12345@163.com
 */
@Data
public class Meta implements Serializable {

	private static final long serialVersionUID = -872474557893915444L;

	private String title;

	private String icon;

	private String target;

	private List<String> permission;

	private Boolean hiddenHeaderContent;

	private Boolean hideChildren;

	private Boolean show;

}