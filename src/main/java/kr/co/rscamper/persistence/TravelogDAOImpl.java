package kr.co.rscamper.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.CommentVO;
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
	public List<TravelogVO> listTravelog(PageVO page) throws Exception {
		List<TravelogVO> list = new ArrayList<>(); 
		return sqlSessionTemplate.selectList(namespace + ".listAll", page);
	}
	
	@Override
	public int totalCount() throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".totalCount");
	}

	@Override
	public void insertTravelog(TravelogVO travelog) throws Exception {
		sqlSessionTemplate.insert(namespace + ".insert", travelog);
	}

	@Override
	public TravelogVO selectByNo(int bNo) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".selectByNo", bNo);
	}

	@Override
	public List<CommentVO> listComment(Integer boardNo) throws Exception {
		return sqlSessionTemplate.selectList(namespace + ".listComment", boardNo);
	}

	@Override
	public void insertComment(CommentVO comment) throws Exception {
		sqlSessionTemplate.selectList(namespace + ".insertComment", comment);
	}

	@Override
	public void updateComment(CommentVO comment) throws Exception {
		sqlSessionTemplate.selectList(namespace + ".updateComment", comment);
	}

	@Override
	public void delteteComment(Integer commentNo) throws Exception {
		sqlSessionTemplate.selectList(namespace + ".delteteComment", commentNo);
	}
	
	
	
	
}
