package cn.yt4j.generate.entity.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author gyv12345@163.com
 */
@Data
@ToString
public class QueryTablesDatasourceDTO implements Serializable {

	private static final long serialVersionUID = 2991819666482682671L;

	private Long datasourceId;

	private String datasourceName;

}
