package cn.yt4j.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gyv12345@163.com
 */
@Data
public class ActionEntitySet implements Serializable {

	private static final long serialVersionUID = -252746105353599918L;

	private String action;

	private String describe;

	private boolean defaultCheck = false;

}
