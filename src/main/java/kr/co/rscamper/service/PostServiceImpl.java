package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import kr.co.rscamper.domain.PostVO;
import kr.co.rscamper.persistence.PostDAO;

public class PostServiceImpl implements PostService {

	@Inject
	public PostDAO dao;
	
	@Override
	public String getTime() throws Exception {
		return dao.getTime();
	}

	@Override
	public PostVO read(Integer boardNo) throws Exception {
		return dao.detailMyPost(boardNo);
	}

	@Override
	public void modify(PostVO post) throws Exception {
		dao.updateMyPost(post);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		dao.deleteMyPost(boardNo);
	}

	@Override
	public List<PostVO> listAll() throws Exception {
		return dao.listAllMyPost();
	}

}
