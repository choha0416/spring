package com.spring.ex03;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class MemberServlet
 */
@WebServlet(name = "MemberServlet3", urlPatterns = { "/mem3.do" })
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
	    MemberDAO3 dao = new MemberDAO3();
	    MemberVO3 memberVO = new MemberVO3();
	    String action=request.getParameter("action");
	    String nextPage="";
	    if(action==null || action.equals("listMembers")) {
	    	List membersList=dao.selectAllMemberList();
	    	request.setAttribute("membersList", membersList);
	    	nextPage="test01/listMembers.jsp";
	    } else if(action.equals("selectMemberById")) {
	    	String id=request.getParameter("value");
	    	System.out.println(id);
	    	memberVO=dao.selectMemberById(id);
	    	request.setAttribute("member", memberVO);
	    	nextPage="test02/memberInfo.jsp";
	    } else if(action.equals("selectMemberByPwd")) {
	    	String pwd=request.getParameter("value");
	    	List<MemberVO3> membersList=dao.selectMemberByPwd(pwd);
	    	request.setAttribute("membersList", membersList);
	    	nextPage="test01/listMembers.jsp";
	    }
	    RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
	    dispatch.forward(request, response);
	}


}