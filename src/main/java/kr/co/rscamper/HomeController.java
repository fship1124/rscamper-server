package kr.co.rscamper;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**-----------------------------------------------------------------------
 * rscamper Project
 * ------------------------------------------------------------------------
 * @Class HomeController.java
 * @Description 홈페이지 요청에 대한 처리를 위한 Handler 클래스  
 * @author 김호동
 * @since 2016. 10. 15.
 */


@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	/**
	 * @Description 홈페이지 요청에 대한 메인 페이지 호출
	 * @param none
	 * @return String 메인 페이지 호출
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "redirect:http://localhost:80/rscamper-web/views/main.jsp";
	}
}
