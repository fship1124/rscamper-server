package kr.co.rscamper.persistence;

import kr.co.rscamper.domain.UserVO;

public interface UserDAO {

	public UserVO selectMainByUidComment(String userUid);
	
	/** 회원정보 입력 */
	public void insertUser(UserVO user);

	/** UID로 회원정보 삭제 */
	public void deleteUserByUid(String userUid);

	/** UID로 회원정보 조회 */
	public UserVO selectUserByUid(String userUid);

}
