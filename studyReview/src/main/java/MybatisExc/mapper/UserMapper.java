package MybatisExc.mapper;

import MybatisExc.entity.SysUser;

import java.util.List;

public interface UserMapper {

    /**
     * 通过用户id查找用户主信息
     */
    SysUser getSysUserById(Long id);

    /**
     * 查询所用用户信息
     */
    List<SysUser> getAllsysUserList();

    /**
     * 查询用户基本信息及其详细信息(一对一 使用 resultMap 配置一对一映射)
     */
    SysUser getSysUserInfoById(Long id);

    /**
     * 查询用户基本信息及其详细信息(使用 resultMap 的association 标签配置一对一映射)
     */
    SysUser getSysUserInfoByIdAssociation(Long id);

    /**
     * 查询用户基本信息及其详细信息(使用 association 标签的嵌套查询方式)
     */
    SysUser getSysUserInfoByIdAssocaion_Select(Long id);


    /**
     * 添加新的用户数据 返回创建后的主键
     */
     Long insertNewSysUser(SysUser sysUser);



























    /**
     * 通过用户id查询用户的基本信息及其所具有的所用角色信息
     */
    SysUser getSysuserInfoAndRolelistInfo(Long id);


}
