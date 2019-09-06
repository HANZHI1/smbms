package com.githup.mybatis.dao;

import com.githup.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findUser();

    /**
     * 根据用户姓名进行模糊查询
     * @param name
     * @return
     */
    User findUserByUserName(String name);

    /**
     * 根据角色id用户名进行查询用户
     * @param user
     * @return
     */
    User findUserByUserNameAndUserRole(User user);

    /**
     * 根据map集合来查询用户信息
     * @param map
     * @return
     */
    User findUserByMap(HashMap<String, Object> map);

    /**
     * 注解param就可以将参数注入到UserMapper.xml文件中
     * 根据姓名和角色id来查询用户信息
     * @param name
     * @param role
     * @return
     */
    User findUserByUserNameAndUserRole1(@Param("userName") String name ,@Param ("userRole")int role);

    /**
     * 根据用户名和角色id查询用户
     * @param name
     * @param roleId
     * @return
     */
    User findUserByUserNameAndUserRole2(@Param("userName") String name, @Param("userRole") int roleId);

    /**
     * 增加用户信息
     * @return
     */
    int addUser();

    /**
     * 修改用户信息
     * @param user
     * @return
     */

    int updateUserNameAndUserCode(User user);

    /**
     * 根据姓名删除用户
     * @param name
     * @return
     */
    int deleteUserByUserName(@Param("userName") String name);
}
