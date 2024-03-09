package com.elgin.loginBackend.data;

import com.elgin.loginBackend.entity.UserInfo;
import com.elgin.loginBackend.service.UserInfoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("loader")
@Transactional
public class DataLoader implements CommandLineRunner {

    private final UserInfoService userInfoService;

    public DataLoader(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Override
    public void run(String... args) throws Exception {
        UserInfo newUser = new UserInfo("John", "user1", "password", "USER");
        UserInfo newManager = new UserInfo("James", "user2", "password", "MANAGER");
        userInfoService.addUser(newUser);
        userInfoService.addUser(newManager);
    }
}
