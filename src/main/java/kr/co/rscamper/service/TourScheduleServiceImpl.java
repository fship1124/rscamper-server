package kr.co.rscamper.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.LocationLikedVO;
import kr.co.rscamper.domain.RecordCoverVO;
import kr.co.rscamper.domain.RecordLocationVO;
import kr.co.rscamper.domain.ScheduleLikeVO;
import kr.co.rscamper.domain.ScheduleListCommentVO;
import kr.co.rscamper.domain.ScheduleMemoVO;
import kr.co.rscamper.domain.TourPlanVO;
import kr.co.rscamper.domain.TourScheduleVO;
import kr.co.rscamper.persistence.TourScheduleDAO;

@Service
public class TourScheduleServiceImpl implements TourScheduleService {
	
	@Inject
	private TourScheduleDAO dao;

	@Override
	public List<TourScheduleVO> getSchedule(String uid) throws Exception {
		return dao.getSchedule(uid);
	}

	@Override
	public void insertSchedule(TourScheduleVO tv) throws Exception {
		dao.insertSchedule(tv);
	}

	@Override
	public void delSchedule(int no) throws Exception {
		dao.delSchedule(no);
	}

	@Override
	public void changeCover(RecordCoverVO rc) throws Exception {
		dao.changeCover(rc);
		
	}

	@Override
	public void insertCover(RecordCoverVO rc) throws Exception {
		dao.insertCover(rc);
	}

	@Override
	public RecordCoverVO getCover(int no) throws Exception {
		
		return dao.getCover(no);
	}

	@Override
	public TourScheduleVO getDetailTourSchedule(int no) throws Exception {
		return dao.getDetailTourSchedule(no);
	}

	@Override
	public void updateStrapline(TourScheduleVO tv) throws Exception {
		dao.updateStrapline(tv);
	}

	@Override
	public void addScheduleLocation(RecordLocationVO rl) throws Exception {
		dao.addScheduleLocation(rl);
	}

	@Override
	public List<RecordLocationVO> getScheduleLocation(int no) throws Exception {
		return dao.getScheduleLocation(no);
	}

	@Override
	public int locationLikeCount(int code) throws Exception {
		return dao.locationLikeCount(code);
	}

	@Override
	public int isLike() throws Exception {
		return 0;
	}

	@Override
	public void insertLikePlus(LocationLikedVO ll) throws Exception {
		dao.insertLikePlus(ll);
	}

	@Override
	public LocationLikedVO checkedIsLike(LocationLikedVO ll) throws Exception {
		return dao.checkedIsLike(ll);
	}

	@Override
	public void removeLiked(LocationLikedVO ll) throws Exception {
		dao.removeLiked(ll);
	}

	@Override
	public void delLocation(int locationNo) throws Exception {
		dao.delLocation(locationNo);
	}

	@Override
	public Map<String, Object> allScheduleList(int page, int count) throws Exception {
		page = (page - 1) * count;
		int totalCount = dao.selectScheduleCount();
		int totalPages = (int) Math.ceil((double) totalCount / (double) count);
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("count", count);
		pageMap.put("page", page);
		List<TourPlanVO> tourList = dao.allScheduleList(pageMap);
		for (TourPlanVO ts : tourList) {
			if (ts.getPicture() == 1) {
//				ts.setCover(dao.getCover(ts.getRecordNo()));
			}
		}
		Map<String, Object> boardMap = new HashMap<>();
		boardMap.put("tourList", tourList);
		boardMap.put("totalPages", totalPages);
		boardMap.put("totalCount", totalCount);
		return boardMap;
	}

	@Override
	public int addScheduleLike(ScheduleLikeVO sl) throws Exception {
		dao.addScheduleLike(sl);
		return dao.getScheduleLikeCount(sl.getRecordNo());
	}

	@Override
	public boolean checkScheduleLike(ScheduleLikeVO sl) throws Exception {
		ScheduleLikeVO slv = dao.checkScheduleLike(sl);
		if (slv == null) {
			return true;
		}
		return false;
	}

	@Override
	public int cancelScheduleLike(ScheduleLikeVO sl) throws Exception {
		dao.cancelScheduleLike(sl);
		return dao.getScheduleLikeCount(sl.getRecordNo());
	}

	@Override
	public int addCustomizing(TourScheduleVO tv) throws Exception {
		int beforeRecordNo = tv.getRecordNo();
		int recordNo = dao.addCustomizing(tv);
		System.out.println("recordNo : " + recordNo);
		System.out.println("before : " + beforeRecordNo);
		List<RecordLocationVO> list = dao.getScheduleLocation(beforeRecordNo);
		System.out.println(list.toString());
		for (RecordLocationVO rv : list) {
			rv.setRecordNo(recordNo);
			dao.addScheduleLocation(rv);
		}
		ScheduleLikeVO sl = new ScheduleLikeVO();
		sl.setRecordNo(beforeRecordNo);
		sl.setUserUid(tv.getUserUid());
		sl.setAfterRecordNo(recordNo);
		return dao.addCustomizingLike(sl);
	}

	@Override
	public boolean checkCustomizing(ScheduleLikeVO sl) throws Exception {
		ScheduleLikeVO slv = dao.checkCustomizing(sl);
		if (slv == null) {
			return true;
		}
		return false;
	}

	@Override
	public int cancelCustomizing(ScheduleLikeVO sl) throws Exception {
		ScheduleLikeVO slv = dao.checkCustomizing(sl);
		dao.delSchedule(slv.getAfterRecordNo());
		return dao.cancelCustomizingLike(sl);
	}

	@Override
	public int addScheduleBookmark(BoardBookMarkVO bbv) throws Exception {
		return dao.addScheduleBookmark(bbv);
	}

	@Override
	public int cancelScheduleBookMark(BoardBookMarkVO bbv) throws Exception {
		return dao.cancelScheduleBookMark(bbv);
	}

	@Override
	public Map<String, Boolean> checkScheduleSet(ScheduleLikeVO sl, int targetType) throws Exception {
		Map<String, Boolean> map = new HashMap<>();
		BoardBookMarkVO bbv = new BoardBookMarkVO();
		bbv.setUserUid(sl.getUserUid());
		bbv.setTargetNo(sl.getRecordNo());
		bbv.setTargetType(targetType);
		
		ScheduleLikeVO slv = dao.checkScheduleLike(sl);
		if (slv == null) {
			map.put("scheduleLike", true);
		} else {
			map.put("scheduleLike", false);			
		}
		
		ScheduleLikeVO slv2 = dao.checkCustomizing(sl);
		if (slv2 == null) {
			map.put("customizing", true);
		} else {
			map.put("customizing", false);			
		}
		
		BoardBookMarkVO bbv2 = dao.checkScheduleBookMark(bbv);
		if (bbv2 == null) {
			map.put("bookMark", true);
		} else {
			map.put("bookMark", false);			
		}
		return map;
	}

	@Override
	public TourPlanVO scheduleListDetail(int no) throws Exception {
		TourPlanVO tv = dao.scheduleListDetail(no);
		if (tv.getPicture() == 1) {
//			tv.setCover(dao.getCover(no));
		}
		return tv;
	}

	@Override
	public List<ScheduleListCommentVO> insertScheduleListComment(ScheduleListCommentVO slc) throws Exception {
		dao.insertScheduleListComment(slc);
		return dao.getScheduleListComment(slc.getRecordNo());
	}

	@Override
	public List<ScheduleListCommentVO> getScheduleListComment(int recordNo) throws Exception {
		return dao.getScheduleListComment(recordNo);
	}

	@Override
	public List<ScheduleListCommentVO> delScheduleListComment(int commentNo, int recordNo) throws Exception {
		dao.delScheduleListComment(commentNo);
		return dao.getScheduleListComment(recordNo);
	}

	@Override
	public List<ScheduleMemoVO> addScheduleMemo(ScheduleMemoVO sm) throws Exception {
		dao.addScheduleMemo(sm);
		return dao.getScheduleMemo(sm.getRecordNo());
	}

	@Override
	public List<ScheduleMemoVO> getScheduleMemo(int recordNo) throws Exception {
		return dao.getScheduleMemo(recordNo);
	}

	@Override
	public List<ScheduleMemoVO> getMyPost(String userUid) throws Exception {
		return dao.getMyPost(userUid);
	}

}
