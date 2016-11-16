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
	public TravelogVO selectByNo(int boardNo) throws Exception;
	
	// 여행기 게시물 삭제
	public void deleteBoardByBoardNo(int boardNo) throws Exception;
	
	// comment *******************************************
	public void addCommnet(CommentVO cVo) throws Exception;
	
	public List<CommentVO> listComment(Integer boardNo, PageVO page) throws Exception;
	
	public void modifyComment(CommentVO comment) throws Exception;
	
	public void removeComment(Integer commentNo) throws Exception;
	
	public int count(Integer boardNo) throws Exception;
	
	public int totalCountComment(Integer boardNo) throws Exception;
}
