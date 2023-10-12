package com.example.jsp02.alert;

import com.example.jsp02.View.ModelView;

public class SendModal {
	
	public static void writeMsg(ModelView modelView, String header, String body, String url) {
		modelView.getModel().put("state", "show");
		modelView.getModel().put("topMsg", header);
		modelView.getModel().put("bodyMsg", body);
		modelView.getModel().put("url", url);
	}
}
