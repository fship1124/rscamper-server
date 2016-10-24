package kr.co.rscamper;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	public String doA(Locale locale, Model model) {
		System.out.println("doA............");
		return "home";
	}
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public ModelAndView doB(Locale locale, Model model) {
		System.out.println("doB............");
		ModelAndView mav = new ModelAndView("http://127.0.0.1:80/rscamper-test2/board/home2");
		mav.addObject("asd", "aaa");
		return mav;
	}
	@RequestMapping(value = "/doC", method = {RequestMethod.GET, RequestMethod.POST})
	public void doC(HttpServletResponse resp) throws Exception {
		System.out.println("doC............");
		PrintWriter out = resp.getWriter();
		out.print("SUCCESS");
	}
	
	@RequestMapping(value = "/doD", method = {RequestMethod.GET, RequestMethod.POST})
	public String doD(RedirectAttributes rttr) throws Exception {
		System.out.println("doD............");
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:http://127.0.0.1:80/rscamper-test2/board/ex02.jsp";
	}
	@RequestMapping(value = "/doE", method = {RequestMethod.GET, RequestMethod.POST})
	public String doE(Model model) throws Exception {
		System.out.println("doE............");
		return "forward:http://127.0.0.1:80/rscamper-test2/board/ex02.jsp";
	}
}
