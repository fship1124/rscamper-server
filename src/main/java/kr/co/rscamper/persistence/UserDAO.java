package kr.co.rscamper.persistence;

import kr.co.rscamper.domain.UserVO;

public interface UserDAO {

	public UserVO selectMainByUidComment(String userUid);
	
	/** 회원정보 입력 */
	public void insertUser(UserVO user);

}
