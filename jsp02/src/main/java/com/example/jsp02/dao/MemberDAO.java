package com.example.jsp02.dao;

import com.example.jsp02.dto.UserDTO;
import com.example.jsp02.entity.User;
import com.example.jsp02.mapper.MybatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
	
	public boolean loginCheck(UserDTO userDto){
		boolean check = false;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		User user = new User.Builder().id(userDto.getId()).password(userDto.getPassword()).build();
		
		int result = sqlSession.selectOne("loginUser",user);
		if(result != 0){
			check = true;
		}
		
		return check;
	}
	
}
