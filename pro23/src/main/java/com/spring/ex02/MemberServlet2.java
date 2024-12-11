package com.spring.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberDAO;
import com.spring.ex01.MemberVO;

/**
 * Servlet implementation class MemberServlet2
 */
@WebServlet("/mem2.do")
public class MemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request,response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8");
	    MemberDAO2 dao = new MemberDAO2();
	    String name = dao.selectName();
	    int pwd = dao.selectPwd();
	    PrintWriter pw = response.getWriter();
	    pw.write("<script>");
	    pw.write("alert(' 이름: "+name+"');");
	    pw.write("alert(' 비밀번호: "+pwd+"');");
	    pw.write("alert(' 이름: " + name + "\\n비밀번호: " + pwd + "');");
	    pw.write("</script>");
	}


}