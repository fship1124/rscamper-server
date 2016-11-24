package kr.co.rscamper.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.TourPlanParamVO;
import kr.co.rscamper.domain.TourPlanSpotParamVO;
import kr.co.rscamper.domain.TourPlanVO;
import kr.co.rscamper.domain.TourPlanSpotVO;

@Repository
public class TourPlanDAOImpl implements TourPlanDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.TourPlanMapper";

	@Override
	public List<TourPlanVO> selectTourPlanList(TourPlanParamVO tourPlanParam) {
		return sqlSessionTemplate.selectList(namespace + ".selectTourPlanList", tourPlanParam);
	}

	@Override
	public int selectTourPlanTotalPages(TourPlanParamVO tourPlanParam) {
		return sqlSessionTemplate.selectOne(namespace + ".selectTourPlanTotalPages", tourPlanParam);
	}

	@Override
	public int insertTourPlan(TourPlanVO tourPlan) {
		sqlSessionTemplate.insert(namespace + ".insertTourPlan", tourPlan);
		return tourPlan.getRecordNo();
	}

	@Override
	public int selectSpotTotalPages(TourPlanSpotParamVO tourPlanSpotParam) {
		return sqlSessionTemplate.selectOne(namespace + ".selectTourPlanSpotTotalPages", tourPlanSpotParam);
	}

	@Override
	public List<TourPlanSpotVO> selectTourSpotList(TourPlanSpotParamVO tourPlanSpotParam) {
		return sqlSessionTemplate.selectList(namespace + ".selectTourPlanSpotList", tourPlanSpotParam);
	}

	@Override
	public TourPlanVO selectTourPlan(int recordNo) {
		return sqlSessionTemplate.selectOne(namespace + ".selectTourPlan", recordNo);
	}
	
	
	

}
