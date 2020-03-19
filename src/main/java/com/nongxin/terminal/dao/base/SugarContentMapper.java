package com.nongxin.terminal.dao.base;

import com.nongxin.terminal.entity.base.SugarContent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nongxin
 * @since 2019-10-29
 */
public interface SugarContentMapper extends BaseMapper<SugarContent> {

    List<SugarContent> selectByBaseId(Integer baseId);

    boolean addSugarContent(@Param("sugarContents")List<SugarContent> sugarContents,@Param("baseId")Integer baseId);

    List<Map<String,Double>> getBoardSugarContent(@Param("baseId")Integer baseId);

}
