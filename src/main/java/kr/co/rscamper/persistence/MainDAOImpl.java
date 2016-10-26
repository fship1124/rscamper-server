package kr.co.rscamper.persistence;


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
		int cnt = sqlSessionTemplate.insert("namespace.insertMainComment", vo);
		System.out.println("cnt : " + cnt);
	}



}
