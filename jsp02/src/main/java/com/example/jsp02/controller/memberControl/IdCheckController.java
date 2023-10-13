package com.example.jsp02.controller.memberControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.UserDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IdCheckController implements Controller {
	
	UserDAO userDAO;
	
	public IdCheckController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "id-check";
		Map<String, Integer> map = new HashMap<>();
		
		String id = (String) paramMap.get("id");
		int result = userDAO.idCheck(id);
		
		map.put("count", result);
		String json = new Gson().toJson(map);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("count", json);
		
		return modelView;
	}
}
