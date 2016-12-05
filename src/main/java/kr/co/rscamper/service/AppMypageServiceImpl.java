package kr.co.rscamper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.BookMarkPageVO;
import kr.co.rscamper.domain.BookMarkVO;
import kr.co.rscamper.persistence.AppMypageDAO;
import kr.co.rscamper.persistence.TourScheduleDAO;

@Service
public class AppMypageServiceImpl implements AppMypageService {

	@Inject
	private AppMypageDAO dao;
	@Inject
	private TourScheduleDAO tdao;
	
	@Override
	public Map<String, Object> selectBookMarkList(int page, int count, String userUid) {
		page = (page - 1) * count;

		int totalPages = (int) Math.ceil((double) dao.countBookMark(userUid) / (double) count);
		BookMarkPageVO bookMarkPage = new BookMarkPageVO();
		bookMarkPage.setCount(count);
		bookMarkPage.setPage(page);
		bookMarkPage.setUserUid(userUid);
		List<BookMarkVO> bookMarkList = dao.selectBookMarkList(bookMarkPage);
		
		for (BookMarkVO bookMarkVO : bookMarkList) {
			System.out.println(bookMarkVO.getTitle());
			if (bookMarkVO.getTargetType().equals("3") && bookMarkVO.getPicture() == 1) {
				System.out.println(bookMarkVO.getTitle());
				bookMarkVO.setCoverImgUrl(tdao.getCover(bookMarkVO.getNo()).getFilePath());
			}
		}

		Map<String, Object> bookMarkMap = new HashMap<>();
		bookMarkMap.put("bookMarkList", bookMarkList);
		bookMarkMap.put("totalPages", totalPages);
		return bookMarkMap;
	}
	
}
