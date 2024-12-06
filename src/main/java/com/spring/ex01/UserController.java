package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController{
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String userID="";
		String userPW="";
		ModelAndView mav=new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID=request.getParameter("userID");
		userPW=request.getParameter("userPW");
		mav.addObject("userID",userID);
		mav.addObject("userPW",userPW);
		mav.setViewName("result");
		return mav;
	}
}