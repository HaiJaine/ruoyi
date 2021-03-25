package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.vo.BoxInfoVO;

import java.util.List;
/**
 * @author LongHaijiang
 * @date 2021/3/13 21:12
 */
public interface BackendBoxInfoService {
    List<BoxInfoVO> getBoxInfoList(BoxInfoVO params);

    int createBoxInfo(BoxInfoVO boxInfoVO);

    int deleteBoxInfos(Long[] ids);
}
