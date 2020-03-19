package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    //获取用户后台权限
    List<Resource> getResourceByUid(Integer uid, Integer type);

    //获取角色后台权限
    List<Resource> getResourceByRoleId(@Param("roleId") String roleId,@Param("roleType")String roleType);

    //获取后台权限
    List<Resource> getResourceList(@Param("type") Integer type);

    //获取菜单action
    List<Resource> getAction(Integer parentId,Integer uid);

}