package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.ChatRoomVO;
import kr.co.rscamper.domain.ChatUserVO;
import kr.co.rscamper.domain.CodeVO;

public interface ChatService {

	public List<ChatRoomVO> list() throws Exception;

	public String selectAreaNameBycode(CodeVO cVo) throws Exception;

	public List<ChatUserVO> selectRoomUserList(int chatRoomInfoNo) throws Exception;

	public void insertChatRoomUser(ChatUserVO uVo) throws Exception;

	public void deleteRoomUser(ChatUserVO vo) throws Exception;

	public ChatRoomVO insertRoomInfo(ChatRoomVO crVo) throws Exception;

	public void deleteChatRoom(int roomNo) throws Exception;

}
