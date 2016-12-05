package kr.co.rscamper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.NoteVO;
import kr.co.rscamper.service.NoteService;

@Controller
@RequestMapping("/note/*")
public class NoteController {
	
	@Inject
	private NoteService service;
	
	private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
	
	@RequestMapping(value = "/list_note", method = RequestMethod.GET)
	public @ResponseBody List<NoteVO> ajaxNoteList() throws Exception {
		logger.info("/note > note list");
		
		List<NoteVO> list = new ArrayList<>();
		
		
		
		
		return list;
	}
}
