package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.PostVO;

public interface PostDAO {

	public String getTime();

	public PostVO detailMyPost(Integer boardNo);

	public void updateMyPost(PostVO post);

	public List<PostVO> listAllMyPost();

	public void deleteMyPost(Integer boardNo);
	
	

}
