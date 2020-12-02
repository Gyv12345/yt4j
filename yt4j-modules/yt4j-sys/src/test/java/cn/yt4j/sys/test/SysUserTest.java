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
    public void login()throws Exception{
        UserDTO dto=new UserDTO();
        RSA rsa1=new RSA(null,"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCaM2N1vMupralzJItx3Y4AftJVh78I8LNuUGuKqMF1YHiwYBHrvZXpzEuRmtTArSaPOlywVt2obC2Ft8ruIDw7Xfpt5SiY1Y7aCONT/DRGGsUEal6jGgTzxiUKTyfyF4wr+0vd7IeiTD/iqg4Oqm3+WsKm7ZWozUG6scG5798YqwIDAQAB");
        String password=  rsa1.encryptStr("123456", KeyType.PublicKey);
        dto.setUsername("admin");
        dto.setPassword(password);
        MvcResult result= mvc.perform(post("/sys/user/login").content(objectMapper.writeValueAsString(dto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("200"))
                .andReturn();
        String content= result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void add() throws Exception {
        SysUser user = new SysUser();

        user.setUsername("test1989");
        user.setPassword("123456");
        String url = "/sys/user/insert";
         mvc.perform(post(url).header("Access-Token","eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJ5dDRqLmNuIiwic3ViIjoiYWRtaW4iLCJhdWQiOiJ2aXAiLCJleHAiOjE2MDc3Njk2MjQsIm5iZiI6MTYwNjg2NzU0NywiaWF0IjoxNjA2ODY4NDQ3fQ.7S8iTqKxObnMTqQzd0mqkznI1aOyhsQz9If_tlnAfPpHtGBgS2quttxy2BiMTDj0vA0Cc9-5Cin3Uejo9pne4A").content(objectMapper.writeValueAsString(user)).contentType(MediaType.APPLICATION_JSON))
                 .andExpect(jsonPath("$.status").value("200"));
    }

}
