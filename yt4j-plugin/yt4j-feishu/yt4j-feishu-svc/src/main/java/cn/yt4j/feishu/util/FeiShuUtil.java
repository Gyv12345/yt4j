package cn.yt4j.feishu.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.yt4j.core.domain.Result;
import cn.yt4j.core.exception.Yt4jException;
import cn.yt4j.feishu.common.FeiShuCodeEnum;
import cn.yt4j.sys.api.entity.vo.SysConfigByKeyVO;
import cn.yt4j.sys.api.service.SysConfigClient;
import com.lark.oapi.Client;
import lombok.experimental.UtilityClass;

/**
 * @author gyv12345@163.com
 */
@UtilityClass
public class FeiShuUtil {

	private final static String APP_ID_KEY = "feishu.appId";

	private final static String APP_SECRET_KEY = "feishu.appSecret";

	private Client client;

	public Client getClient() {
		SysConfigClient sysConfigClient = SpringUtil.getBean(SysConfigClient.class);
		if (ObjectUtil.isEmpty(client)) {
			Result<SysConfigByKeyVO> appIdResult = sysConfigClient.getSysConfigByKey(APP_ID_KEY);
			if (ObjectUtil.isEmpty(appIdResult.getData())) {
				throw new Yt4jException(FeiShuCodeEnum.NO_APP_ID);
			}
			Result<SysConfigByKeyVO> appSecretResult = sysConfigClient.getSysConfigByKey(APP_SECRET_KEY);
			if (ObjectUtil.isEmpty(appSecretResult.getData())) {
				throw new Yt4jException(FeiShuCodeEnum.NO_APP_SECRET);
			}
			client = Client.newBuilder(appIdResult.getData().getValue(), appSecretResult.getData().getValue()).build();
		}
		return client;
	}

}
