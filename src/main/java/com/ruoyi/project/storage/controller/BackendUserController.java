package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.vo.UserVO;
import com.ruoyi.project.storage.service.BackendUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/backend/user")
public class BackendUserController extends BaseController {
    @Resource
    private BackendUserService backendUserService;

    /**
     * 用户查询（分页，多条件）
     *
     * @param params 查询条件
     * @return 结果
     */
    @GetMapping("/list")
    public TableDataInfo getUser(Params params) {
        startPage();
        List<UserVO> users = backendUserService.findUsers(params);
        return getDataTable(users);
    }

    /**
     * 新增用户
     *
     * @param userVO 用户
     * @return 结果
     */
    @PostMapping("/create")
    public AjaxResult createUser(@RequestBody UserVO userVO) {
        int result = backendUserService.createUser(userVO);
        return toAjax(result);
    }

    /**
     * 编辑用户
     *
     * @param userVO 用户
     * @return 结果
     */
    @PutMapping("/update")
    public AjaxResult updateUser(@RequestBody UserVO userVO) {
        int result = backendUserService.updateUser(userVO);
        return toAjax(result);
    }

    /**
     * 操作用户
     *
     * @param operate 操作
     * @param ids     ids
     * @return 结果
     */
    @PutMapping("/{operate}/{ids}")
    public AjaxResult operate(@PathVariable String operate, @PathVariable Long[] ids) {
        int result = backendUserService.operate(operate, ids);
        return toAjax(result);
    }

    @DeleteMapping("/delete/{ids}")
    public AjaxResult deleteUsers(@PathVariable Long[] ids) {
        int result = backendUserService.deleteUsers(ids);
        return toAjax(result);
    }

    /**
     * 重置密码
     *
     * @param ids ids
     * @return 结果
     */
    @PutMapping("/reset/{ids}")
    public AjaxResult resetPassword(@PathVariable Long[] ids) {
        int result = backendUserService.resetPassword(ids);
        return toAjax(result);
    }
}
