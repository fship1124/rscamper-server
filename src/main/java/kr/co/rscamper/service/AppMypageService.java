package kr.co.rscamper.service;

import java.util.Map;

public interface AppMypageService {
	
	/**내 북마크 리스트 가져오기*/
	public Map<String, Object> selectBookMarkList(int page, int count, String userUid);
	
}
