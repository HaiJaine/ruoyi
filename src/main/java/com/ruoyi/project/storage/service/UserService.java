package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.domain.UserVO;

import java.util.List;

public interface UserService {
    List<User> findUsers(Params params);

    int createUser(UserVO userVO);

    int updateUser(UserVO userVO);

    int operate(String operate, Long[] ids);

    int resetPassword(Long[] ids);

    int updatePassword(String oldPassword, String newPassword);
}
