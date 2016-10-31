package kr.co.rscamper.service;

import kr.co.rscamper.domain.UserVO;

public interface UserService {
	public UserVO selectMainByUidComment(String userUid) throws Exception;
	
	/** 회원 정보 입력 */
	public void insertUser(UserVO user) throws Exception;
	
	/** 회원정보 변경 */
	public void updateUser(UserVO user)throws Exception;
}
