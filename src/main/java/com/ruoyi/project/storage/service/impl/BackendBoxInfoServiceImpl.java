package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.common.util.SeqGeneratorUtil;
import com.ruoyi.project.storage.domain.vo.BoxInfoVO;
import com.ruoyi.project.storage.mapper.BoxInfoMapper;
import com.ruoyi.project.storage.service.BackendBoxInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
/**
 * @author LongHaiJiang
 * @date 2021/3/13 8:46
 */
@Service
public class BackendBoxInfoServiceImpl implements BackendBoxInfoService {
    @Resource
    private BoxInfoMapper boxInfoMapper;

    @Override
    public List<BoxInfoVO> getBoxInfoList(BoxInfoVO boxInfoVO) {
        return boxInfoMapper.findBoxInfoList(boxInfoVO);
    }

    @Override
    public int createBoxInfo(BoxInfoVO boxInfoVO) {
        List<BoxInfoVO> boxInfoVOList = new ArrayList<>();
        boxInfoVO.setBoxCode(Long.valueOf(SeqGeneratorUtil.seqGenerator(DateUtils.getNowDateStr(), 6)));
        boxInfoVO.setIsUsed("0");
        boxInfoVO.setSortNo(0L);
        boxInfoVO.setCreateBy(String.valueOf(SecurityUtils.getLoginUser().getUser().getUserId()));
        boxInfoVO.setCreateTime(new Date());
        boxInfoVO.setUpdateBy(String.valueOf(SecurityUtils.getLoginUser().getUser().getUserId()));
        boxInfoVO.setUpdateTime(new Date());
        boxInfoVO.setVersion(0L);
        boxInfoVO.setDelFlag("0");
        boxInfoVOList.add(boxInfoVO);
        return boxInfoMapper.createBoxInfo(boxInfoVOList);
    }

    @Override
    @Transactional(rollbackFor = CustomException.class)
    public int deleteBoxInfos(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("updateBy", SecurityUtils.getLoginUser().getUser().getUserId());
        List<Integer> boxInfoStatusList = boxInfoMapper.findBoxInfoStatusList(map);
        if (boxInfoStatusList.contains(1)) {
            throw new CustomException("?????????????????????????????????????????????");
        }
        final int result = boxInfoMapper.deleteBoxInfo(map);
        if (result > 0) {
            boxInfoMapper.deleteBoxStandard();
        }
        return result;
    }

}
