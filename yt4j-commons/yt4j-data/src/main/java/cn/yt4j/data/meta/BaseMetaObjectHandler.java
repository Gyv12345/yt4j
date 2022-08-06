package cn.yt4j.data.meta;

import cn.yt4j.sa.util.AuthUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author gyv12345@163.com
 */
@Component
public class BaseMetaObjectHandler implements MetaObjectHandler {

	/**
	 * 创建时间
	 */
	public static final String FIELD_CREATE_TIME = "createTime";

	/**
	 * 修改时间
	 */
	public static final String FIELD_UPDATE_TIME = "updateTime";

	/**
	 * 创建人
	 */
	public static final String FIELD_CREATE_USER = "createUserId";

	/**
	 * 修改人
	 */
	public static final String FIELD_UPDATE_USER = "updateUserId";

	@Override
	public void insertFill(MetaObject metaObject) {
		LocalDateTime localDateTime = LocalDateTime.now();
		this.strictInsertFill(metaObject, FIELD_CREATE_TIME, LocalDateTime.class, localDateTime);
		this.strictInsertFill(metaObject, FIELD_CREATE_USER, Long.class, AuthUtil.getUserId());
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		LocalDateTime localDateTime = LocalDateTime.now();
		this.strictUpdateFill(metaObject, FIELD_UPDATE_TIME, LocalDateTime.class, localDateTime);
		this.strictUpdateFill(metaObject, FIELD_UPDATE_USER, Long.class, AuthUtil.getUserId());
	}

}
