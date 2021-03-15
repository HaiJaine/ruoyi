package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findUsers(Params params);
}
