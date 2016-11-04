package kr.co.rscamper.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.MenuVO;
import kr.co.rscamper.domain.TrainVO;

@Repository
public class TrainDAOImpl implements TrainDAO{

	@Inject
	private SqlSession session;
	
	private static final String namespace = "kr.co.rscamper.TrainMapper";
	
	@Override
	public List<TrainVO> list() throws Exception {
		List<TrainVO> list = session.selectList(namespace + ".list");
		for (TrainVO vo : list) {
			System.out.println(vo.getStationTitle());
		}
		return list;
	}
}
