package cn.yt4j.web.jackson;

import cn.yt4j.web.handler.BigNumberSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.PackageVersion;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 序列化
 *
 * @author gyv12345@163.com
 */
public class BigNumberModule extends SimpleModule {

	public BigNumberModule() {
		super(PackageVersion.VERSION);
		this.addSerializer(Long.class, BigNumberSerializer.INSTANCE);
		this.addSerializer(Long.TYPE, BigNumberSerializer.INSTANCE);
		this.addSerializer(BigInteger.class, BigNumberSerializer.INSTANCE);
		this.addSerializer(BigDecimal.class, ToStringSerializer.instance);
	}

}
