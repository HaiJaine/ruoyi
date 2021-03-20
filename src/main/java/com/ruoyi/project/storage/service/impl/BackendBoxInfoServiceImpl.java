package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.storage.domain.BoxInfoVO;
import com.ruoyi.project.storage.mapper.BoxInfoMapper;
import com.ruoyi.project.storage.service.BackendBoxInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String boxCode = simpleDateFormat.format(new Date());
        boxInfoVO.setBoxCode(Long.valueOf(boxCode));
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
    public int deleteBoxInfos(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("updateBy", SecurityUtils.getLoginUser().getUser().getUserId());
        return boxInfoMapper.deleteBoxStandards(map);
    }


}
