package kr.co.rscamper.persistence;

import kr.co.rscamper.domain.UserVO;

public interface UserDAO {

	public UserVO selectMainByUidComment(String userUid);

}
