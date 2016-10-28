package kr.co.rscamper.service;

import kr.co.rscamper.domain.UserVO;

public interface UserService {
	public UserVO selectMainByUidComment(String userUid) throws Exception;
	
	/** [App] 회원 가입 */
	public void insertUser(UserVO user) throws Exception;
	
	/** TODO: [App] UID로 회원 정보 가져오기 */
	
	/** TODO: [App] 회원 리스트 가져오기 */
	
	/** TODO: [App] 회원 정보 수정 */
	
	/** TODO: [App] 회원 탈퇴 */
	
	
}
