package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.domain.vo.UserVO;

import java.util.List;
import java.util.Map;
/**
 * @author LongHaiJiang
 * @date 2021/3/12 10:37
 */
public interface UserMapper {
    List<UserVO> findUsers(Params params);

    int createUser(UserVO userVO);

    int updateUser(UserVO userVO);

    int isStatus(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int resetPassword(Map<String, Object> user);

    int updatePassword(User user);

    Map<String, Object> findUserByUsername(String username);

    Map<String, Object> findUserByEmail(String email);

    Map<String, Object> findUserByPhoneNumber(String phoneNumber);

    List<String> findUserByIds(Map<String, Object> map);

    UserVO findUserById(Long userId);
}
