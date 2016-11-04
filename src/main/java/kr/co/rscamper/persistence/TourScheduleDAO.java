package kr.co.rscamper.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.RecordCoverVO;
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
	
}
