package kr.co.rscamper.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.LocationLikedVO;
import kr.co.rscamper.domain.RecordCoverVO;
import kr.co.rscamper.domain.RecordLocationVO;
import kr.co.rscamper.domain.ScheduleLikeVO;
import kr.co.rscamper.domain.ScheduleListCommentVO;
import kr.co.rscamper.domain.ScheduleMemoVO;
import kr.co.rscamper.domain.TourPlanVO;
import kr.co.rscamper.domain.TourScheduleVO;

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
	
	public List<TourPlanVO> allScheduleList(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.allScheduleList",pageMap);
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
	
	public BoardBookMarkVO checkScheduleBookMark(BoardBookMarkVO bbv) {
		return sqlSessionTemplate.selectOne("kr.co.rscamper.TourSchedule.checkScheduleBookMark", bbv);
	}
	
	public TourPlanVO scheduleListDetail(int no) {
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
	
	public List<ScheduleMemoVO> getScheduleMemo(int recordNo) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getScheduleMemo", recordNo);
	}
	
	public List<ScheduleMemoVO> getMyPost(String userUid) {
		return sqlSessionTemplate.selectList("kr.co.rscamper.TourSchedule.getMyPost", userUid);
	}
}
