package com.myspring.pro27.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro27.member.service.MemberService;
import com.myspring.pro27.member.vo.MemberVO;


//컨트롤러를 이용해 memberControllrt 클래스에 대해 id가 memberController인 빈 자동생성
@Controller("memberController")
public class MemberControllerImpl extends MultiActionController implements MemberController {

    @Autowired
    private MemberService memberService; //Autowired를 이용해 id가 memberservice인 빈을 주입
    
    @Autowired
    private MemberVO memberVO; // id가 memberVO인 빈을 자동 주입

    @Override
    @RequestMapping(value="/member/listMembers.do", method=RequestMethod.GET)
    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 세션에서 로그인 상태를 확인
        HttpSession session = request.getSession();
        Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");

        // 로그인되지 않았다면 로그인 폼으로 리디렉션
        if (isLogOn == null || !isLogOn) {
            return new ModelAndView("redirect:/member/loginForm.do");
        }

        // 로그인 상태라면 회원 목록을 불러옴
        String viewName = getViewName(request);
        List membersList = memberService.listMembers();
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("membersList", membersList);
        return mav;
    }

    @Override
    @RequestMapping(value="/member/addMember.do", method=RequestMethod.GET)
    public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response) throws Exception {//가입창에서 전송된 회원정보 바로 memberVO에 설정
        request.setCharacterEncoding("utf-8"); 
        int result = memberService.addMember(member); //설정된 memberVO객체를 sql문으로 전달 회원등록
        ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
        return mav;
    }

    @Override
    @RequestMapping(value="/member/removeMember.do", method=RequestMethod.GET)
    public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception { //전송된 id를 변수 id에 저장
        request.setCharacterEncoding("utf-8");
        memberService.removeMember(id);
        ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
        return mav;
    }

    // 회원 정보 수정 페이지
    @RequestMapping(value="/member/modMember.do", method=RequestMethod.GET) // 정규식을 이용해 요청명이 Form.do로 끝나면 메서드 호출
    public ModelAndView modMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        // ID에 해당하는 회원 정보 조회
        MemberVO member = memberService.modMember(id);
        ModelAndView mav = new ModelAndView("/member/modMember"); // modMember.jsp (수정 폼 페이지)
        mav.addObject("member", member);
        return mav;
    }

    // 회원 정보 수정 처리
    @RequestMapping(value="/member/updateMember.do", method=RequestMethod.POST)
    public ModelAndView updateMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        memberService.updateMember(member);
        ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do"); // 수정 후 목록으로 리디렉션
        return mav;
    }

    @RequestMapping(value="/member/*Form.do", method=RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String viewName = getViewName(request);
        ModelAndView mav = new ModelAndView();
        mav.setViewName(viewName);
        return mav;
    }

    @RequestMapping(value="/member/main.do", method=RequestMethod.GET) //두 단계로 요청 시 바로 해당 메서드를 호출 하도록 매핑
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String viewName = getViewName(request);
      
        ModelAndView mav = new ModelAndView(viewName);

        return mav;
    }
    
    
    
    @Override
    @RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	memberVO = memberService.login(member);
    	if(memberVO != null) {
    		HttpSession session = request.getSession();
    		session.setAttribute("member", memberVO);
    		session.setAttribute("isLogOn",true);
    		mav.setViewName("redirect:/member/listMembers.do");
    	} else {
    		
    		mav.setViewName("redirect:/member/loginForm.do?error=true");
    	}
		return mav;
	}

    
    
    
	@Override
	 @RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/member/main.do");
	
		return mav;
	}

	private String getViewName(HttpServletRequest request) throws Exception {
        String contextPath = request.getContextPath();
        String uri = (String) request.getAttribute("javax.servlet.include.request.uri");
        if (uri == null || uri.trim().equals("")) {
            uri = request.getRequestURI();
        }

        int begin = 0;
        if (!((contextPath == null) || ("".equals(contextPath)))) {
            begin = contextPath.length();
        }
        int end;
        if (uri.indexOf(";") != -1) {
            end = uri.indexOf(";");
        } else if (uri.indexOf("?") != -1) {
            end = uri.indexOf("?");
        } else {
            end = uri.length();
        }

        String fileName = uri.substring(begin, end);
        if (fileName.indexOf(".") != -1) {
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        }
        if (fileName.lastIndexOf("/") != -1) {
            fileName = fileName.substring(fileName.lastIndexOf("/",1), fileName.length());
        }
        return fileName;
    }
}
