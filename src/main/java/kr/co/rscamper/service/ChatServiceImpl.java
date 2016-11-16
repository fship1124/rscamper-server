package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.ChatRoomVO;
import kr.co.rscamper.domain.ChatUserVO;
import kr.co.rscamper.domain.CodeVO;
import kr.co.rscamper.persistence.ChatDAO;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Inject
	private ChatDAO dao;
	

	@Override
	public List<ChatRoomVO> list() throws Exception {
		return dao.listRoom();
	}


	@Override
	public String selectAreaNameBycode(CodeVO vo) throws Exception {
		return dao.selectAreaNameBycode(vo);
	}


	@Override
	public List<ChatUserVO> selectRoomUserList(int chatRoomInfoNo) throws Exception {
		return dao.selectRoomUserList(chatRoomInfoNo);
	}


	@Override
	public void insertChatRoomUser(ChatUserVO vo) throws Exception {
		dao.insertChatRoomUser(vo);
	}

}
