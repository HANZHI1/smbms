package Test;


import com.githup.mybatis.dao.UserMapper;
import com.githup.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		SqlSession sqlSession = null;

		try {
			//1.获取sqlSession对象
			sqlSession = SqlSessionUtil.getSqlSession();
			//2.通过sqlSession获取userMapper的对象
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//3.通过userMapper来执行各种操作
//			List<User> userList= userMapper.findUser();
			//通过名字来模糊查询用户
//			User user = userMapper.findUserByUserName("敏");
			//1.使用对象来传递参数
//			User user = new User();
//			user.setUserName("敏");
//			user.setUserRole(2);
//			user = userMapper.findUserByUserNameAndUserRole(user);
			//多个参数使用Map集合传递参数
//			HashMap<String,Object> map = new HashMap<>();
//			map.put("userName","敏");
//			map.put("userRole",2);
//			User user = userMapper.findUserByMap(map);
//			System.out.println(user);
			//多个参数
//			User user = userMapper.findUserByUserNameAndUserRole1("敏",2);
//			System.out.println(user);
			//使用resultMap进行字段映射
//			User user = userMapper.findUserByUserNameAndUserRole2("敏",2);
//			System.out.println(user);
			//增加一条用户信息
			//只要涉及到增删改操作 mybatis都会开启事务
			Logger logger = Logger.getLogger(Test.class);
//			int row = userMapper.addUser();
//			if (row > 0){
//				System.out.println("增加成功");
//			}
			//修改用户信息
//			User user = new User();
//			user.setUserName("权大庆");
//			user.setUserCode("qdq");
//			user.setId(19);
//			int row = userMapper.updateUserNameAndUserCode(user);
//			if (row > 0){
//				System.out.println("修改成功");
//			}
			//删除用户信息
			int row = userMapper.deleteUserByUserName("小明");
			if (row > 0){
				System.out.println("删除成功");
			}

			logger.debug("追踪状态信息======》"+row);
			//提交事务
			sqlSession.commit();
			//4.迭代userList
//			for (User user : userList) {
//				System.out.println(user);
//			}

		} catch (IOException e) {
			e.printStackTrace();
			//发生异常 回滚事务
			sqlSession.rollback();
		}

	}
}
