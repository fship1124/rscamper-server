package kr.co.rscamper.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rscamper.domain.MainVO;

@RestController
@RequestMapping("/main")
public class MainController {
	
//	@RequestMapping(value = "/{uid} /{content}", method = RequestMethod.PUT)
//	public void insert(@PathVariable("uid") String uid, @PathVariable("content") String content, HttpServletResponse res) throws IOException {
//		res.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html; charset=UTF-8");
//		
//		System.out.println("/main");
//		
//		
//		System.out.println("uid : " + uid);
//		System.out.println("content : " + content);
//		
//		
//		MainVO vo = new MainVO();
//		vo.setUserUid(uid);
//		vo.setMainContent(content);
//		
//		PrintWriter out = res.getWriter();
//		
//		out.print("aa");
//	}
	@RequestMapping(value = "/{uid} /{content}", method = RequestMethod.PUT)
	public @ResponseBody MainVO insert(@PathVariable("uid") String uid, @PathVariable("content") String content, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		System.out.println("/main");
		
		
		System.out.println("uid : " + uid);
		System.out.println("content : " + content);
		
		
		MainVO vo = new MainVO();
		vo.setUserUid(uid);
		vo.setMainContent(content);
		
//		PrintWriter out = res.getWriter();
//		out.print("aa");
		return vo;
	}
}
