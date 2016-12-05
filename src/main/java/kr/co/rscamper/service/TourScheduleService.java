package kr.co.rscamper.service;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.LocationLikedVO;
import kr.co.rscamper.domain.RecordCoverVO;
import kr.co.rscamper.domain.RecordLocationVO;
import kr.co.rscamper.domain.ScheduleLikeVO;
import kr.co.rscamper.domain.ScheduleListCommentVO;
import kr.co.rscamper.domain.ScheduleMemoVO;
import kr.co.rscamper.domain.TourPlanVO;
import kr.co.rscamper.domain.TourScheduleVO;

public interface TourScheduleService {
	public List<TourScheduleVO> getSchedule(String uid) throws Exception;
	
	public void insertSchedule(TourScheduleVO tv) throws Exception;
	
	public void delSchedule(int no) throws Exception;
	
	public void changeCover(RecordCoverVO rc) throws Exception;
	
	public void insertCover(RecordCoverVO rc) throws Exception;
	
	public RecordCoverVO getCover(int no) throws Exception;
	
	public TourScheduleVO getDetailTourSchedule(int no) throws Exception;
	
	public void updateStrapline(TourScheduleVO tv) throws Exception;
	
	public void addScheduleLocation(RecordLocationVO rl) throws Exception;
	
	public List<RecordLocationVO> getScheduleLocation(int no) throws Exception;
	
	public int locationLikeCount(int code) throws Exception;
	
	public int isLike() throws Exception;
	
	public void insertLikePlus(LocationLikedVO ll) throws Exception;
	
	public LocationLikedVO checkedIsLike(LocationLikedVO ll) throws Exception;
	
	public void removeLiked(LocationLikedVO ll) throws Exception;
	
	public void delLocation(int locationNo) throws Exception;
	
	public Map<String, Object> allScheduleList(int page, int count) throws Exception;
	
	public int addScheduleLike(ScheduleLikeVO sl) throws Exception;
	
	public boolean checkScheduleLike(ScheduleLikeVO sl) throws Exception;
	
	public int cancelScheduleLike(ScheduleLikeVO sl) throws Exception;
	
	public int addCustomizing(TourScheduleVO tv) throws Exception;
	
	public boolean checkCustomizing(ScheduleLikeVO sl) throws Exception;
	
	public int cancelCustomizing(ScheduleLikeVO sl) throws Exception;
	
	public int addScheduleBookmark(BoardBookMarkVO bbv) throws Exception;
	
	public int cancelScheduleBookMark(BoardBookMarkVO bbv) throws Exception;
	
	public Map<String, Boolean> checkScheduleSet(ScheduleLikeVO sl, int targetType) throws Exception;
	
	public TourPlanVO scheduleListDetail(int no) throws Exception;
	
	public List<ScheduleListCommentVO> insertScheduleListComment(ScheduleListCommentVO slc) throws Exception;
	
	public List<ScheduleListCommentVO> getScheduleListComment(int recordNo) throws Exception;
	
	public List<ScheduleListCommentVO> delScheduleListComment(int commentNo, int recordNo) throws Exception;
	
	public List<ScheduleMemoVO> addScheduleMemo(ScheduleMemoVO sm) throws Exception;
	
	public List<ScheduleMemoVO> getScheduleMemo(int recordNo) throws Exception;
	
	public List<ScheduleMemoVO> getMyPost(String userUid) throws Exception;
}
