package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import java.util.Map;

public interface Controller {
	
	ModelView process(Map<String, String> paramMap);
}
