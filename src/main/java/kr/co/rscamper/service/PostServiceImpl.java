package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import kr.co.rscamper.domain.PageVO;
>>>>>>> 0a968fdbefaac34e3858dcc592a6908b660fb5ce
import kr.co.rscamper.domain.PostVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.persistence.PostDAO;


<<<<<<< HEAD
=======

>>>>>>> 0a968fdbefaac34e3858dcc592a6908b660fb5ce
@Service
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
	public List<PostVO> listAll(PageVO vo, String userUid) throws Exception {
		return dao.listAllMyPost(vo, userUid);
	}

}
