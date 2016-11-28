package kr.co.rscamper.persistence;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.BoardBookMarkVO;

@Repository
public class AppMypageDAO implements AppMainDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.AppMypageMapper";
	
//	public BoardBookMarkVO selectMyBookMark(BoardBookMarkVO boardBookMark) {
//		return sqlSessionTemplate.selectList(namespace + ".selectMyBookMark", boardBookMark);
//	}
	
}
