package kr.co.rscamper.persistence;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.MainVO;

@Repository
public class MainDAOImpl implements MainDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.MainMapper";
	
	
	@Override
	public String getTime() {
		return sqlSessionTemplate.selectOne(namespace + ".getTime");
	}
	
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
}
