package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.vo.UserVO;

import java.util.List;
/**
 * @author LongHaijiang
 * @date 2021/3/13 21:12
 */
public interface BackendUserService {
    List<UserVO> findUsers(Params params);

    int createUser(UserVO userVO);

    int updateUser(UserVO userVO);

    int operate(String operate, Long[] ids);

    int resetPassword(Long[] ids);

    int updatePassword(String oldPassword, String newPassword);

    int deleteUsers(Long[] ids);
}
