package kr.co.rscamper.persistence;

import kr.co.rscamper.domain.UserVO;

public interface UserDAO {

	public UserVO selectMainByUidComment(String userUid);
	
	public void insertUser(UserVO user);
	
	// 회원정보 변경
	public void updateUser(UserVO user)throws Exception;

}
