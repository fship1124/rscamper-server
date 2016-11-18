package kr.co.rscamper.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.ChatRoomVO;
import kr.co.rscamper.domain.ChatUserVO;
import kr.co.rscamper.domain.CodeVO;

@Repository
public class ChatDAOImpl implements ChatDAO {
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.ChatMapper";
	
	
	@Override
	public List<ChatRoomVO> listRoom() throws Exception {
		List<ChatRoomVO> list = new ArrayList<>();
		list = sqlSessionTemplate.selectList(namespace + ".listRoom");
		System.out.println(list.size());
		return list;
	}

	@Override
	public String selectAreaNameBycode(CodeVO vo) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".selectAreaNameBycode", vo);
	}


	@Override
	public List<ChatUserVO> selectRoomUserList(int no) throws Exception {
		return sqlSessionTemplate.selectList(namespace + ".selectRoomUserList", no);
	}

	@Override
	public void insertChatRoomUser(ChatUserVO vo) throws Exception {
		System.out.println("in insertChatRoomUser");
		int result = sqlSessionTemplate.insert(namespace + ".insertChatRoomUser", vo);
		System.out.println(result);
	}

	@Override
	public void deleteRoomUser(ChatUserVO vo) throws Exception {
		System.out.println("in deleteRoomUser");
		int result = sqlSessionTemplate.delete(namespace + ".deleteRoomUser", vo);
		System.out.println(result);
	}

}
