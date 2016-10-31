package kr.co.rscamper.service;

import java.util.List;

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

	@Override
	public void insertUser(UserVO user) throws Exception {
		dao.insertUser(user);
	}

	@Override
	public void deleteUserByUid(String userUid) {
		System.out.println(userUid);
		dao.deleteUserByUid(userUid);
	}

	@Override
	public UserVO selectUserByUid(String userUid) {
		System.out.println(userUid);
		return dao.selectUserByUid(userUid);
	}

	@Override
	public List<UserVO> selectUserList() {
		// TODO Auto-generated method stub
		return null;
	}
}
