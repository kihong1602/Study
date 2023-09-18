package com.example.jsp02.day04.controller;

import com.example.jsp02.day04.view.ModelView;
import java.util.Map;

public interface Controller {
	
	ModelView process(Map<String, String> paramMap);
}
