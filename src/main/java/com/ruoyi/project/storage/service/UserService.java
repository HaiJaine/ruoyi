package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;

import java.util.List;

public interface UserService {
    List<User> findUsers(Params params);

    int createUser(User user);

    int updateUser(User user);

    int operate(String operate, Long[] ids);
}
