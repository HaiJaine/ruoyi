package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.BoxStandardVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;

public interface BackendBoxStandardService {
    List<BoxStandardVO> getBoxStandardList(Params params);
}
