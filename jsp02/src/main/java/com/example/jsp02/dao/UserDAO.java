package com.example.jsp02.dao;

import com.example.jsp02.dto.UserDTO;
import com.example.jsp02.entity.User;
import com.example.jsp02.mapper.MybatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;

public class UserDAO {
	
	private static SqlSession sqlSession;
	
	public UserDTO loginCheck(UserDTO userDto) {
		
		connSql();
		User user = new User.Builder().id(userDto.getId()).password(userDto.getPassword()).build();
		
		UserDTO userResponseDTO = sqlSession.selectOne("loginUser", user);
		
		sqlSession.close();
		
		return userResponseDTO;
	}
	
	private void connSql() {
		sqlSession = MybatisConnectionFactory.getSqlSession();
	}
}
