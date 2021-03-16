package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.domain.UserVO;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> findUsers(Params params);

    int createUser(UserVO userVO);

    int updateUser(UserVO userVO);

    int isStatus(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int resetPassword(Map<String, Object> user);

    int updatePassword(User user);
}
