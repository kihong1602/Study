package com.example.jsp02;

import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/profile-upload")
public class FileUpload extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part profile = request.getPart("profile");
		
		String id = request.getParameter("userID");
		
		String uploadDirectory = "upload";
		
		String partHeader = profile.getHeader("Content-disposition");
		System.out.println("partHeader : " + partHeader);
		
		String[] partHeaderArr = partHeader.split("filename=");
		System.out.println("partHeaderArr[0] : " + partHeaderArr[0]);
		System.out.println("partHeaderArr[1] : " + partHeaderArr[1]);
		
		String originalFileName = partHeaderArr[1].trim().replace("\"", "");
		System.out.println("originalFileName : " + originalFileName);
		
		String realUploadPath = getServletContext().getRealPath(uploadDirectory);
		System.out.println("realUploadPath===" + realUploadPath);
		
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
		
		UserService userService = new UserService();
		
		User resultUser = userService.userProfileUpdate(id, newFileName);
		
		request.setAttribute("selectUser", resultUser);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(
				"/join/process/user-select.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
}
