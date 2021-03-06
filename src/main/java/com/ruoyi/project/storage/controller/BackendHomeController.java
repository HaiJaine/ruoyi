package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.storage.service.BackendUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @author LongHaiJiang
 * @date 2021/3/13 8:09
 */
@RestController
@RequestMapping("/backend/home")
public class BackendHomeController extends BaseController {

    @Resource
    private BackendUserService backendUserService;

    /**
     * 修改密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 结果
     */
    @PutMapping("/updatePassword/{oldPassword}/{newPassword}")
    public AjaxResult updatePassword(@PathVariable String oldPassword, @PathVariable String newPassword) {
        int result = backendUserService.updatePassword(oldPassword, newPassword);
        return toAjax(result);
    }
}
