package kr.co.rscamper.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.PostVO;

@Repository
public class PostDAOImpl implements PostDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.PostMapper";

	@Override
	public String getTime() {
		return sqlSessionTemplate.selectOne(namespace + ".getTime");
	}

	@Override
	public PostVO detailMyPost(Integer boardNo) {
		return sqlSessionTemplate.selectOne(namespace + ".detailMyPost", boardNo);
	}

	@Override
	public void updateMyPost(PostVO post) {
		sqlSessionTemplate.update(namespace + ".updateMyPost", post);
	}

	@Override
	public List<PostVO> listAllMyPost() {
		return sqlSessionTemplate.selectList(namespace + ".list");
	}

	@Override
	public void deleteMyPost(Integer boardNo) {
		sqlSessionTemplate.delete(namespace + ".delete", boardNo);
	}

}
