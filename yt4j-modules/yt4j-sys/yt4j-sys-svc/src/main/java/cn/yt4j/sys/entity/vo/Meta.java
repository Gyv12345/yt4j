
package cn.yt4j.sys.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 元数据
 *
 * @author gyv12345@163.com
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta implements Serializable {

	@Serial
	private static final long serialVersionUID = -872474557893915444L;

	private String title;

	private String icon;

	private String extraIcon;

	private Boolean showLink;

	private Boolean showParent;

	private List<String> roles;

	private List<String> auths;

	private Boolean keepAlive;

	private String frameSrc;

	private Boolean frameLoading;

	private Boolean hiddenTag;

	private String activePath;

	private Integer rank;

}
