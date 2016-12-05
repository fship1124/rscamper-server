package kr.co.rscamper.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.BookMarkPageVO;
import kr.co.rscamper.domain.BookMarkVO;

@Repository
public class AppMypageDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.AppMypageMapper";
	
	public List<BookMarkVO> selectBookMarkList(BookMarkPageVO bookMarkPage) {
		return sqlSessionTemplate.selectList(namespace + ".selectBookMarkList", bookMarkPage);
	}
	
	public int countBookMark(String userUid) {
		return sqlSessionTemplate.selectOne(namespace + ".countBookMark", userUid);
	}
	
}
