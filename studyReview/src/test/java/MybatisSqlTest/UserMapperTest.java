package MybatisSqlTest;

import MybatisExc.Util.SqlsessionUtil;
import MybatisExc.entity.SysUser;
import MybatisExc.entity.SysUserInfo;
import MybatisExc.mapper.UserMapper;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description 用户信息sql测试类
 * @Author pengrj
 * @CreateDate 2018-05-15 下午 2:31
 * @Version 1.0
 */
public class UserMapperTest {

    private static  UserMapper userMapper;

    static {
        try {
             userMapper= SqlsessionUtil.getMapperByClass(UserMapper.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过用户id查找用户主信息
     */
    @Test
    public void testSelectUserById(){
        SysUser sysUser=userMapper.getSysUserById((long) 1);
        System.out.println(sysUser.getUserName());
        System.out.println(sysUser.getCreateTime());
        SqlsessionUtil.closeSession();
    }

    /**
     * 查询所用用户信息
     */
    @Test
    public void selectAllsysUser(){
        List<SysUser> userList=userMapper.getAllsysUserList();
        SqlsessionUtil.closeSession();
    }


    /**
     * 查询用户基本信息及其详细信息(一对一 使用 resultMap 配置一对一映射)
     */
    @Test
    public void getSysUserInfoById(){
        SysUser sysUser=userMapper.getSysUserInfoById((long) 1);
        System.out.println(JSONObject.toJSONString(sysUser.getSysUserInfo()));
        SqlsessionUtil.closeSession();
    }

    /**
     * 查询用户基本信息及其详细信息(使用 resultMap 的association 标签配置一对一映射)
     */
    @Test
    public void getSysUserInfoByIdAssociation(){
        SysUser sysUser=userMapper.getSysUserInfoByIdAssociation((long) 1);
        SqlsessionUtil.closeSession();
    }

    /**
     * 查询用户基本信息及其详细信息(使用 association 标签的嵌套查询方式)
     */
    @Test
    public void getSysUserInfoByIdAssocaion_Select(){
        SysUser sysUser=userMapper.getSysUserInfoByIdAssocaion_Select((long) 1);

        //按需延迟加载用户的详细信息(触发某些方法或者调用get方法可以启动延迟加载)
        sysUser.toString();
        SysUserInfo sysUserInfo=sysUser.getSysUserInfo();
        SqlsessionUtil.closeSession();

    }

    /**
     * 新增用户信息并且返回自增主键
     */
    @Test
    public void insertNewSysUser(){
        SysUser sysUser=new SysUser();
        sysUser.setUserName("xiaogang");
        sysUser.setCreateTime(new Date());
        sysUser.setUserEmail("adf@qq.com");
        sysUser.setUserPassword("134523452");
        Long id=userMapper.insertNewSysUser(sysUser);
        SqlsessionUtil.commit();
        SqlsessionUtil.closeSession();
    }


    /**
     * 通过用户id查询用户的基本信息及其所具有的所用角色信息
     * TODO 待测试
     */
    @Test
    public void getSysuserInfoAndRolelistInfo(){
        SysUser sysUser=userMapper.getSysuserInfoAndRolelistInfo((long) 1);
        SqlsessionUtil.closeSession();
    }
}
