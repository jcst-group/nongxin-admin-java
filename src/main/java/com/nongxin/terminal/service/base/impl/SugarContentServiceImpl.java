package com.nongxin.terminal.service.base.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.entity.base.SugarContent;
import com.nongxin.terminal.dao.base.SugarContentMapper;
import com.nongxin.terminal.service.base.SugarContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nongxin
 * @since 2019-10-29
 */
@Service
public class SugarContentServiceImpl extends ServiceImpl<SugarContentMapper, SugarContent> implements SugarContentService {

    @Autowired(required = false)
    private SugarContentMapper sugarContentMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;

    @Override
    public Map<String, Object> getBoardSugarContent(Integer baseId) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String,Double>> list = sugarContentMapper.getBoardSugarContent(baseId);
        Collections.reverse(list);
        map.put("sugarContent",list);
        map.put("pictureInfo",pictureInfoMapper.getSugarContentPic(baseId));
        return map;
    }
}
