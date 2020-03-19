package com.nongxin.terminal.dao.address;

import com.nongxin.terminal.entity.address.Address;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer relateId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer relateId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    int deleteAddress(@Param("relateId") Integer relateId, @Param("relateType") String relateType);

    Address getBaseAddress(Integer relateId);

    Address getLotAddress(Integer relateId);

    String getStreetAddress(Integer relateId);
}