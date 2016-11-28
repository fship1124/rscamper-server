package kr.co.rscamper.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.persistence.AppMypageDAO;

@Service
public class AppMypageServiceImpl implements AppMainService {

	@Inject
	private AppMypageDAO dao;
	
	
}
