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
import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.entity.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class SysUserTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mvc;

	@Test
	public void login() throws Exception {
		UserDTO dto = new UserDTO();
		RSA rsa1 = new RSA(null,
				"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCaM2N1vMupralzJItx3Y4AftJVh78I8LNuUGuKqMF1YHiwYBHrvZXpzEuRmtTArSaPOlywVt2obC2Ft8ruIDw7Xfpt5SiY1Y7aCONT/DRGGsUEal6jGgTzxiUKTyfyF4wr+0vd7IeiTD/iqg4Oqm3+WsKm7ZWozUG6scG5798YqwIDAQAB");
		String password = rsa1.encryptBase64("123456", KeyType.PublicKey);
		dto.setUsername("admin");
		dto.setPassword(password);
		MvcResult result = mvc
				.perform(post("/sys/user/login").content(objectMapper.writeValueAsString(dto))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.status").value("200")).andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void add() throws Exception {
		SysUser user = new SysUser();

		user.setUsername("test1989");
		user.setPassword("123456");
		String url = "/sys/user/insert";
		mvc.perform(post(url).header("Access-Token",
				"eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJ5dDRqLmNuIiwic3ViIjoiYWRtaW4iLCJhdWQiOiJ2aXAiLCJleHAiOjE2MDc3OTI1MTksIm5iZiI6MTYwNjg5MDQ0MSwiaWF0IjoxNjA2ODkxMzQxfQ.oQosW7f0AovH5MDDQBi2xn6FxJJkYxsODKSJglvs4gW0l0PXaEBBkCQJfFUfnYwGbQOCXzvU4rUO4tTPO0DMKQ")
				.content(objectMapper.writeValueAsString(user)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.status").value("200"));
	}

}
