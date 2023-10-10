package com.example.jsp02.dao;

import com.example.jsp02.dto.NewBoardDTO;
import com.example.jsp02.mapper.MybatisConnectionFactory;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class NewBoardDAO {
	
	public List<NewBoardDTO> getAllPost() {
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		List<NewBoardDTO> board = sqlSession.selectList("getAllReplyBoard");
		sqlSession.close();
		return board;
	}
	
	public NewBoardDTO getPost(int no) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		NewBoardDTO newBoardDTO = sqlSession.selectOne("getOneBoard", no);
		sqlSession.close();
		return newBoardDTO;
	}
}
