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
