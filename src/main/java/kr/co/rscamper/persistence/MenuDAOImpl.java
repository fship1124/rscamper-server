package kr.co.rscamper.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.MenuVO;

@Repository
public class MenuDAOImpl implements MenuDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "kr.co.rscamper.mapper.MenuMapper";

	@Override
	public List<MenuVO> list() throws Exception {
		List<MenuVO> list = session.selectList(namespace + ".list");
		for (MenuVO vo : list) {
			System.out.println(vo.getTitle());
		}
		return list;
	}
}
