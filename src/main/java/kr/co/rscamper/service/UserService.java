package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.UserVO;

public interface UserService {
	public UserVO selectMainByUidComment(String userUid) throws Exception;
	
	/** [App] 회원 가입 */
	public void insertUser(UserVO user) throws Exception;

	/** TODO: [App] 회원 탈퇴 */
	public void deleteUserByUid(String userUid);
	
	/** TODO: [App] UID로 회원 정보 가져오기 */
	public UserVO selectUserByUid(String userUid);
		
	/** TODO: [App] 회원 리스트 가져오기 */
	public List<UserVO> selectUserList();
	
	/** TODO: [App] 회원 정보 수정 (프로필사진) */
	/** TODO: [App] 회원 정보 수정 (프로필 배경 사진) */
	/** TODO: [App] 회원 정보 수정 (회원정보) */
	
}
