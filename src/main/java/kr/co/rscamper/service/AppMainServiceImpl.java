package kr.co.rscamper.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.persistence.AppMainDAO;

@Service
public class AppMainServiceImpl implements AppMainService {

	@Inject
	private AppMainDAO dao;
	
	
}
