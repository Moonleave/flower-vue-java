package com.moon.userservice;

import com.moon.userservice.entity.User;
import com.moon.userservice.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author MoonLeaves
 * @create 2022-05-11 17:52
 * @describe:
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUserMapper(){
        List<User> list = userMapper.selectList(null);
        System.out.println(list);

    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void TestBCryptPasswordEncoder(){

//        $2a$10$npv5JSeFR6/wLz8BBMmSBOMb8byg2eyfK4/vvoBk3RKtTLBhIhcpy
//        $2a$10$agN9gJf45dRUL7VHUIeGj./yWdr5rheLrNFsmeYDBeJZ9zhEHEUT2
//        输入的是1234，但是数据库里的是$2a$10$npv5JSeFR6/wLz8BBMmSBOMb8byg2eyfK4/vvoBk3RKtTLBhIhcpy
//        System.out.println(passwordEncoder.
//                matches("123456",
//                        "$2a$10$cdE.IScIxCZ1ZIPzuDlY/.pV00qDvMPv3NCTPApMDWsO9tNu1YP3S"));
        String encode = passwordEncoder.encode("djq");
//        String encode2 = passwordEncoder.encode("1234");
        System.out.println(encode);
//        System.out.println(encode2);

    }


}
