package com.example.jsp02.dao;

import com.example.jsp02.dto.NewBoardDTO;
import com.example.jsp02.dto.PageDTO;
import com.example.jsp02.mapper.MybatisConnectionFactory;
import java.util.ArrayList;
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
	
	public List<NewBoardDTO> getPagingPost(PageDTO pageDTO) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		List<NewBoardDTO> board = sqlSession.selectList("getPagingBoard", pageDTO);
		sqlSession.close();
		return board;
	}
	
	public int getBoardCount() {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		int result = sqlSession.selectOne("getBoardCount");
		sqlSession.close();
		return result;
	}
	
	public int getMaxRegroup() {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		int maxReGroup = sqlSession.selectOne("getMaxRegroup");
		sqlSession.close();
		return maxReGroup;
	}
	
	public int writeBoard(NewBoardDTO newBoardDTO) {
		int result;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("writeBoard", newBoardDTO);
		sqlSession.close();
		return result;
	}
	
	public int deleteBoard(int no) {
		int result;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteBoard", no);
		sqlSession.close();
		return result;
	}
	
	public int updateBoard(NewBoardDTO newBoardDTO) {
		int result;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateBoard", newBoardDTO);
		sqlSession.close();
		return result;
	}
	
	public void updateReLevel(NewBoardDTO newBoardDTO) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		sqlSession.update("updateReLevel", newBoardDTO);
		sqlSession.close();
	}
	
	public int writeReply(NewBoardDTO newBoardDTO) {
		int result;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("saveReply", newBoardDTO);
		sqlSession.close();
		return result;
		
	}
	
	
	public int deleteAllBoard(ArrayList<Integer> list) {
		int result;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteAllBoard", list);
		sqlSession.close();
		return result;
	}
}
