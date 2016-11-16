package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.ChatRoomVO;
import kr.co.rscamper.domain.ChatUserVO;
import kr.co.rscamper.domain.CodeVO;

public interface ChatDAO {

	public List<ChatRoomVO> listRoom() throws Exception;

	public String selectAreaNameBycode(CodeVO vo) throws Exception;

	public List<ChatUserVO> selectRoomUserList(int chatRoomInfoNo) throws Exception;

	public void insertChatRoomUser(ChatUserVO vo) throws Exception;

}
