/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sys.test;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SysTest {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	StringEncryptor stringEncryptor;

	public static void main(String[] args) {

	}

	@Test
	public void elDemo() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end)");
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("end", "!");
		Assertions.assertEquals("Hello World!", expression.getValue(context));
	}

	/**
	 * 配置文件中数据库密码加密
	 */
	@Test
	public void encode() {
		System.out.println(stringEncryptor.encrypt("1234232123"));
	}

	/**
	 * 数据库里的用户密码家加密
	 */
	@Test
	public void password() {
		System.out.println(encoder.encode(""));
	}

	/**
	 * 前端登录时用户密码加密
	 */
	@Test
	public void rsa() {

		RSA rsa = new RSA();

		// 获得私钥
		rsa.getPrivateKeyBase64();
		System.out.println(rsa.getPrivateKeyBase64());
		// 获得公钥
		System.out.println(rsa.getPublicKeyBase64());
		rsa.getPublicKeyBase64();

		RSA rsa1 = new RSA(null,
				"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCaM2N1vMupralzJItx3Y4AftJVh78I8LNuUGuKqMF1YHiwYBHrvZXpzEuRmtTArSaPOlywVt2obC2Ft8ruIDw7Xfpt5SiY1Y7aCONT/DRGGsUEal6jGgTzxiUKTyfyF4wr+0vd7IeiTD/iqg4Oqm3+WsKm7ZWozUG6scG5798YqwIDAQAB");
		String mima = rsa1.encryptBcd("123456", KeyType.PublicKey);
		System.out.println(mima);

		//// 公钥加密，私钥解密
		// byte[] encrypt = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa",
		//// CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
		// byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);
		//
		//// Junit单元测试
		//// Assert.assertEquals("我是一段测试aaaa", StrUtil.str(decrypt,
		//// CharsetUtil.CHARSET_UTF_8));
		//
		//// 私钥加密，公钥解密
		// byte[] encrypt2 = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa",
		//// CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
		// byte[] decrypt2 = rsa.decrypt(encrypt2, KeyType.PublicKey);

		// Assertions.assertEquals("我是一段测试aaaa", StrUtil.str(decrypt2,
		// CharsetUtil.CHARSET_UTF_8));
		// Junit单元测试
		// Assert.assertEquals("我是一段测试aaaa", StrUtil.str(decrypt2,
		// CharsetUtil.CHARSET_UTF_8));

	}

}
