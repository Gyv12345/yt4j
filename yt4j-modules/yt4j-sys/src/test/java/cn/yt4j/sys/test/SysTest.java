package cn.yt4j.sys.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SysTest {

	@Autowired
	private PasswordEncoder encoder;

	@Test
	public void password() {
		System.out.println(encoder.encode("123456"));
	}

}
