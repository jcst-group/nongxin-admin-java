package com.nongxin.terminal.service.base;

import com.nongxin.terminal.entity.base.SugarContent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nongxin
 * @since 2019-10-29
 */
public interface SugarContentService extends IService<SugarContent> {

    Map<String,Object> getBoardSugarContent(Integer baseId);

}
