package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TravelogVO;

public interface TravelogService {
	
	public String getTime() throws Exception;
	// 여행기 list 조회
	public List<TravelogVO> listTravelog(PageVO page) throws Exception;
	
	public int totalCount() throws Exception;
	
	// 여행기 게시물 등록
	public void regist(TravelogVO travelog) throws Exception;
	
	// 여행기 게시물 조회
	public TravelogVO selectByNo(int bNo) throws Exception;
	
	// comment *******************************************
	public void addCommnet(CommentVO comment) throws Exception;
	
	public List<CommentVO> listComment(Integer boardNo) throws Exception;
	
	public void modifyComment(CommentVO comment) throws Exception;
	
	public void removeComment(Integer boardNo) throws Exception;
	
}
