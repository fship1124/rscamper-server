package kr.co.rscamper.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TogetherVO;
import kr.co.rscamper.domain.TravelogVO;

@Repository
public class TravelogDAOImpl implements TravelogDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.TravelogMapper";

	@Override
	public String getTime() throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".getTime");
	}

	@Override
	public List<TravelogVO> listTravelog(PageVO vo) throws Exception {
		List<TravelogVO> list = new ArrayList<>(); 
		return sqlSessionTemplate.selectList(namespace + ".listAll", vo);
	}
	
	@Override
	public int totalCount() throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".totalCount");
	}

	@Override
	public void insertTravelog(TravelogVO travelog) throws Exception {
		sqlSessionTemplate.insert(namespace + ".insert", travelog);
	}
	
	
	
	
}
