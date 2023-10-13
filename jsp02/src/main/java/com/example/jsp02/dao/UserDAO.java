package com.example.jsp02.dao;

import com.example.jsp02.dto.UserDTO;
import com.example.jsp02.entity.User;
import com.example.jsp02.entity.User.Builder;
import com.example.jsp02.mapper.MybatisConnectionFactory;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public int saveUser(UserDTO userDTo) {
		
		connSql();
		User user = new User.Builder().id(userDTo.getId()).password(userDTo.getPassword())
				.name(userDTo.getName()).email(userDTo.getEmail()).tel(userDTo.getTel())
				.postcode(userDTo.getPostcode()).address(userDTo.getAddress())
				.addressDetail(userDTo.getAddressDetail()).profile(userDTo.getProfile()).build();
		
		int result = sqlSession.insert("saveUser", user);
		
		sqlSession.close();
		return result;
	}
	
	public int idCheck(String id) {
		connSql();
		
		int result = sqlSession.selectOne("idCheck", id);
		
		sqlSession.close();
		return result;
	}
	
	public int removeUser(String id, String password) {
		connSql();
		
		User user = new Builder().id(id).password(password).build();
		int result = sqlSession.delete("removeUser", user);
		
		sqlSession.close();
		return result;
	}
	
	public boolean removeProfileImg(String filePath) {
		boolean isRemove = false;
		
		String uploadDirectory = "C:\\upload";
		
		File file = new File(uploadDirectory + File.separator + filePath);
		if (file.exists()) {
			isRemove = file.delete();
		}
		
		return isRemove;
	}
	
	private void connSql() {
		sqlSession = MybatisConnectionFactory.getSqlSession();
	}
	
	public String urlParsing(Part profile, String realUploadPath) throws IOException {
		File dir = new File(realUploadPath);
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		String partHeader = profile.getHeader("Content-disposition");
		
		String[] partHeaderArr = partHeader.split("filename=");
		
		String originalFileName = partHeaderArr[1].trim().replace("\"", "");
		System.out.println(realUploadPath);
		if (!originalFileName.isEmpty()) {
			//물리경로
			profile.write(realUploadPath + File.separator + originalFileName);
			//운영체제에 따라 separator 가 달라지므로 삽입해주어야함.
		}
		
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		String firstFileName = originalFileName.substring(0, originalFileName.indexOf("."));
		
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String strNow = simpleDateFormat.format(now);
		String newFileName = firstFileName + strNow + ext;
		System.out.println(newFileName);
		
		File oldFile = new File(realUploadPath + File.separator + originalFileName);
		File newFile = new File(realUploadPath + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
		return newFileName;
	}
}
