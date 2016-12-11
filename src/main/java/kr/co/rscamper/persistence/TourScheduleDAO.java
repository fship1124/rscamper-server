package kr.co.rscamper.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.LocationCommentVO;
import kr.co.rscamper.domain.LocationLikedVO;
import kr.co.rscamper.domain.RecordCoverVO;
import kr.co.rscamper.domain.RecordLocationVO;
import kr.co.rscamper.domain.ScheduleLikeVO;
import kr.co.rscamper.domain.ScheduleListCommentVO;
import kr.co.rscamper.domain.ScheduleMemoCommentVO;
import kr.co.rscamper.domain.ScheduleMemoLikeVO;
import kr.co.rscamper.domain.ScheduleMemoVO;
import kr.co.rscamper.domain.TourSchedulePlanVO;
import kr.co.rscamper.domain.TourScheduleVO;
import kr.co.rscamper.domain.TravelPriceVO;

@Repository
public class TourScheduleDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<TourScheduleVO> getSchedule(String uid) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getSchedule", uid);
	}
	
	public void insertSchedule(TourScheduleVO tv) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.insertSchedule", tv);
	}
	
	public void delSchedule(int no) {
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.delSchedule", no);
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.delCover", no);
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.delScheduleLocation", no);
	}
	
	public void changeCover(RecordCoverVO rc) {
		sqlSessionTemplate.update("kr.co.rscamper.TourSchedule.changeCover", rc);
	}
	
	public void insertCover(RecordCoverVO rc) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.insertCover",rc);
		int no = rc.getRecordNo();
		System.out.println(no);
		sqlSessionTemplate.update("kr.co.rscamper.TourSchedule.updateCover", no);
	}
	
	public RecordCoverVO getCover(int no) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getCover", no);
	}
	
	public TourScheduleVO getDetailTourSchedule(int no) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getDetailTourSchedule", no);
	}
	
	public void updateStrapline(TourScheduleVO tv) {
		sqlSessionTemplate.update("kr.co.rscamper.TourSchedule.updateStrapline", tv);
	}
	
	public void addScheduleLocation(RecordLocationVO rl) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.addScheduleLocation", rl);
	}
	
	public List<RecordLocationVO> getScheduleLocation(int no) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getScheduleLocation", no);
	}
	
	public int locationLikeCount(int code) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.locationLikeCount", code);
	}
	
	public void insertLikePlus(LocationLikedVO ll) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.insertLikePlus", ll);
	}
	
	public LocationLikedVO checkedIsLike(LocationLikedVO ll) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.checkedIsLike", ll);
	}
	
	public void removeLiked(LocationLikedVO ll) {
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.removeLiked", ll);
	}
	
	public void delLocation(int locationNo) {
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.delLocation",locationNo);
	}
	
	public List<TourSchedulePlanVO> allScheduleList(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.allScheduleList",pageMap);
	}
	
	public List<TourSchedulePlanVO> allScheduleListDate(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.allScheduleListDate",pageMap);
	}
	
	public List<TourSchedulePlanVO> allScheduleListDay(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.allScheduleListDay",pageMap);
	}
	
	public int selectScheduleCount() {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.selectScheduleCount");
	}
	
	public void addScheduleLike(ScheduleLikeVO sl) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.addScheduleLike", sl);
	}
	
	public int getScheduleLikeCount(int recordNo) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getScheduleLikeCount", recordNo);
	}
	
	public ScheduleLikeVO checkScheduleLike(ScheduleLikeVO sl) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.checkScheduleLike", sl);
	}
	
	public void cancelScheduleLike(ScheduleLikeVO sl) {
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.cancelScheduleLike", sl);
	}
	
	public int addCustomizing(TourScheduleVO tv) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.addCustomizing", tv);
		return tv.getRecordNo(); 
	}
	
	public int getCustomizingCnt(int recordNo) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getCustomizingLikeCount", recordNo);
	}
	
	public int addCustomizingLike(ScheduleLikeVO sl) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.addCustomizingLike", sl);
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getCustomizingLikeCount", sl);
	}
	
	public ScheduleLikeVO checkCustomizing(ScheduleLikeVO sl) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.checkCustomizingLike", sl);
	}
	
	public int cancelCustomizingLike(ScheduleLikeVO sl) {
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.cancelCustomizingLike", sl);
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getCustomizingLikeCount", sl);
	}
	
	public int addScheduleBookmark(BoardBookMarkVO bbv) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.addScheduleBookmark", bbv);
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getScheduleBookMarkCount", bbv);
	}
	
	public int cancelScheduleBookMark(BoardBookMarkVO bbv) {
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.cancelScheduleBookMark", bbv);
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getScheduleBookMarkCount", bbv);
	}
	
	public int getScheduleBookMark (BoardBookMarkVO bbv) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getScheduleBookMarkCount", bbv);
	}
	
	public BoardBookMarkVO checkScheduleBookMark(BoardBookMarkVO bbv) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.checkScheduleBookMark", bbv);
	}
	
	public TourSchedulePlanVO scheduleListDetail(int no) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.scheduleListDetail", no);
	}
	
	public void insertScheduleListComment(ScheduleListCommentVO slc) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.insertScheduleListComment", slc);
	}
	
	public List<ScheduleListCommentVO> getScheduleListComment(int recordNo) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getScheduleListComment", recordNo);
	}
	
	public void delScheduleListComment(int commentNo) {
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.delScheduleListComment", commentNo);
	}
	
	public void addScheduleMemo(ScheduleMemoVO sm) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.addScheduleMemo", sm);
	}
	
	public List<ScheduleMemoVO> getScheduleMemo(ScheduleMemoVO sm) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getScheduleMemo", sm);
	}
	
	public List<ScheduleMemoVO> getMyPost(String userUid) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getMyPost", userUid);
	}
	
	public ScheduleMemoVO getDetailPost(ScheduleMemoVO sm) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getDetailPost", sm);
	}
	
	public void insertMemoComment(ScheduleMemoCommentVO smv) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.insertMemoComment", smv);
	}
	
	public List<ScheduleMemoCommentVO> getMemoComment(int postNo) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getMemoComment", postNo);
	}
	
	public void addScheduleMemoLike(ScheduleMemoLikeVO sml) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.addScheduleMemoLike", sml);
	}
	
	public void cancelScheduleMemoLike(ScheduleMemoLikeVO sml) {
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.cancelScheduleMemoLike", sml);
	}
	
	public int getScheduleMemoLikeCnt(int commentNo) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getScheduleMemoLikeCnt", commentNo);
	}
	
	public void delMemoComment(int commentNo) {
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.delMemoComment", commentNo);
	}
	
	public void delScheduleMemo(int scheduleMemoNo) {
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.delScheduleMemo", scheduleMemoNo);
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.delScheduleMemoComment", scheduleMemoNo);
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.delScheduleMemolike", scheduleMemoNo);
	}
	
	public List<LocationLikedVO> getWishBoardList(String userUid) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getWishBoardList", userUid);
	}
	
	public int getBackLocationLikeCnt(int contentId) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getBackLocationLikeCnt", contentId);
	}
	
	public List<ScheduleMemoVO> getLocationMemo(int contentId) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getLocationMemo", contentId);
	}
	
	public int getLocationMemoCnt(int contentId) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.getLocationMemoCnt", contentId);
	}
	
	public void addBackLocationLike(LocationLikedVO ll) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.addBackLocationLike", ll);
	}
	
	public void delBackLocationLike(LocationLikedVO ll) {
		sqlSessionTemplate.delete("kr.co.rscamper.TourSchedule.delBackLocationLike", ll);
	}
	
	public LocationLikedVO checkBackLocationLike(LocationLikedVO ll) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.checkBackLocationLike", ll);
	}
	
	public List<LocationCommentVO> getLocationComment(int contentId) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getLocationComment", contentId);
	}
	
	public void addLocationComment(LocationCommentVO lc) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.addLocationComment", lc);
	}
	
	public void addTravelPrice(TravelPriceVO tp) {
		sqlSessionTemplate.insert("kr.co.rscamper.TourSchedule.addTravelPrice", tp);
	}
	
	public List<TravelPriceVO> getLocationTravelPrice(int locationNo) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getLocationTravelPrice", locationNo);
	}
	
	public List<TravelPriceVO> getScheduleTravelPrice(int recordNo) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getScheduleTravelPrice", recordNo);
	}
}
