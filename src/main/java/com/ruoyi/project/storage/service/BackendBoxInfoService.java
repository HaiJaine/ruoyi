package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.vo.BoxInfoVO;

import java.util.List;

public interface BackendBoxInfoService {
    List<BoxInfoVO> getBoxInfoList(BoxInfoVO params);

    int createBoxInfo(BoxInfoVO boxInfoVO);

    int deleteBoxInfos(Long[] ids);
}
