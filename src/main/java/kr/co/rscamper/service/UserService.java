package kr.co.rscamper.service;

import kr.co.rscamper.domain.UserVO;

public interface UserService {
	public UserVO selectMainByUidComment(String userUid) throws Exception;
}
