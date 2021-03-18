package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.BoxInfoVO;

import java.util.List;

public interface BackendBoxInfoService {
    List<BoxInfoVO> getBoxInfoList(BoxInfoVO params);
}
