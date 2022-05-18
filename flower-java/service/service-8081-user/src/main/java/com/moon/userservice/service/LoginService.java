package com.moon.userservice.service;

import com.moon.commonutils.R;
import com.moon.userservice.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author MoonLeaves
 * @create 2022-05-11 17:56
 * @describe:
 */
@Service
public interface LoginService {
    R login(User user);

    R logout();

    R register(User user);
}
