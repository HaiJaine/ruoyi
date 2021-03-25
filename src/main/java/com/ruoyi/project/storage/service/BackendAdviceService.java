package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.vo.AdviceVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;

/**
 * @author LongHaijiang
 * @date 2021/3/12 10:33
 */
public interface BackendAdviceService {
    List<AdviceVO> findAdviceList(Params params);
}
