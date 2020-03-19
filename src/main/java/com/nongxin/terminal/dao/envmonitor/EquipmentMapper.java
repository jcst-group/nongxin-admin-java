package com.nongxin.terminal.dao.envmonitor;

import com.nongxin.terminal.entity.envmonitor.Equipment;
import io.swagger.models.auth.In;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

    Equipment selectByEquipmentId(String equipmentId);

    Equipment selectByEquipmentIdAndFactoryId(@Param("equipmentId") String equipmentId, @Param("factoryId") Integer factoryId);

    List<Equipment> getEquipmentList(Equipment equipment);

    Integer getFactoryId(Integer id);

    List<Equipment> getEquipmentIdAndNameList();

    Equipment checkId(String equipmentId,String equipmentName);

    String getEquipmentName(Integer id);

    String getBaseName(Integer id);

    List<Equipment> getEquipmentByBaseId(Integer baseId);
}