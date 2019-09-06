package Test;


import com.githup.mybatis.dao.UserMapper;
import com.githup.mybatis.pojo.User;
import com.githup.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

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
			User user = userMapper.findUserByUserNameAndUserRole1("敏",2);
			System.out.println(user);
			//4.迭代userList
//			for (User user : userList) {
//				System.out.println(user);
//			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
