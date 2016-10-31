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
		return dao.selectMainByUidComment(userUid);
	}

	@Override
	public void insertUser(UserVO user) throws Exception {
		dao.insertUser(user);
	}

	@Override
	public void updateUser(UserVO user) throws Exception {
		dao.updateUser(user);
		
	}
}
