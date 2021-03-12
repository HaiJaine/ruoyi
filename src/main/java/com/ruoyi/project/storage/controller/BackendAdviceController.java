package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.AdviceVO;
import com.ruoyi.project.storage.service.BackendAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 意见管理
 *
 * @author HaiJaine
 * @date 2021/3/12 8:09
 */
@RestController
@RequestMapping("/backend/advice")
public class BackendAdviceController extends BaseController {
    @Autowired
    private BackendAdviceService backendAdviceService;

    /*
    查询意见建议（使用分页）
     */
    @GetMapping("list")
    public TableDataInfo getAdviceList() {
        startPage();
        List<AdviceVO> adviceVOList = backendAdviceService.findAdviceList();
        return getDataTable(adviceVOList);
    }
}
