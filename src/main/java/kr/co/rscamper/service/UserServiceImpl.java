package kr.co.rscamper.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO dao;

	@Override
	public UserVO selectMainByUidComment(String userUid) throws Exception {
		System.out.println("in selectMainByUidComment");
		System.out.println("userUid : " + userUid);
		return dao.selectMainByUidComment(userUid);
	}
}
