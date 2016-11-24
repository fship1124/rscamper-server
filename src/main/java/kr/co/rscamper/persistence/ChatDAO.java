package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.ChatRoomVO;
import kr.co.rscamper.domain.ChatUserInfoVO;
import kr.co.rscamper.domain.ChatUserVO;
import kr.co.rscamper.domain.CodeVO;

public interface ChatDAO {
	
	public List<CodeVO> getCodeName(String codeName) throws Exception;

	public List<ChatRoomVO> listRoom() throws Exception;

	public String selectAreaNameBycode(CodeVO vo) throws Exception;

	public List<ChatUserVO> selectRoomUserList(int chatRoomInfoNo) throws Exception;

	public void insertChatRoomUser(ChatUserVO vo) throws Exception;
	
	public List<ChatRoomVO> getChatRoom(int no) throws Exception;
	
	public ChatRoomVO getChatRoomInfo(int roomNo) throws Exception;
	
	public List<ChatUserInfoVO> getRoomUserList(int chatRoomInfoNo) throws Exception;

}
