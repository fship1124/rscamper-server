package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.PostVO;

public interface PostService {

	public String getTime() throws Exception;
	
//	post 등록
//	public void regist(PostVO post) throws Exception;
//	post 상세 조회
	public PostVO read(Integer boardNo) throws Exception;
//	post 수정
	public void modify(PostVO post) throws Exception;
//	post 삭제
	public void remove(Integer boardNo) throws Exception;
//	전체 post list 
	public List<PostVO> listAll() throws Exception;
	
	
}
