package kr.co.rscamper.persistence;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.SubwayVO;
import kr.co.rscamper.domain.TourPlanSpotVO;
import kr.co.rscamper.domain.TrainVO;

@Repository
public class MainDAOImpl implements MainDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.MainMapper";
	
	private static final String Bnamespace = "kr.co.rscamper.BenefitMapper";
	
	private static final String Tnamespace = "kr.co.rscamper.TourPlanMapper";
	
	private static final String Trnamespace = "kr.co.rscamper.TrainMapper";
	
	private static final String TTnamespace = "kr.co.rscamper.SubwayMapper";
	
	@Override
	public void insertMainComment(MainVO vo) {
		sqlSessionTemplate.insert(namespace + ".insertMainComment", vo);
	}

	@Override
	public List<MainVO> selectMainComment() {
		System.out.println("in selectMainComment");
		List<MainVO> list = new ArrayList<>(); 
		list = sqlSessionTemplate.selectList(namespace + ".selectMainComment");
	
		return list;
	}

	@Override
	public List<BenefitVO> list() throws Exception {
		return sqlSessionTemplate.selectList(Bnamespace +".selectBenefit");
	}

	@Override
	public List<TourPlanSpotVO> tourlist() throws Exception {
		return sqlSessionTemplate.selectList(Tnamespace + ".tourList");
	}

	@Override
	public List<TrainVO> maintrainList() throws Exception {
		return sqlSessionTemplate.selectList(Trnamespace + ".trainselectList");
	}

	@Override
	public void mainTimeList(SubwayVO sub) throws Exception {
		sqlSessionTemplate.selectList(TTnamespace + ".mainTimeList", sub);
	}

}
