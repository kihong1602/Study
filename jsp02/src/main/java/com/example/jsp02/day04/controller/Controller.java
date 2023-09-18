package com.example.jsp02.day04.controller;

import com.example.jsp02.day04.View.ModelView;
import java.util.Map;

public interface Controller {
	
	ModelView process(Map<String, String> paramMap);
}
