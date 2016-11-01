package kr.co.rscamper.service;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.UserPhotoVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO dao;
	
	@Inject
	ServletContext servletContext;

	@Override
	public UserVO selectMainByUidComment(String userUid) throws Exception {
		System.out.println("in selectMainByUidComment");
		System.out.println("userUid : " + userUid);
		return dao.selectMainByUidComment(userUid);
	}

	@Override
	public void insertUser(UserVO user) throws Exception {
		System.out.println("회원가입 : " + user.toString());
		dao.insertUser(user);
	}

	@Override
	public void deleteUserByUid(String userUid) {
		System.out.println("회원탈퇴 : " + userUid);
		dao.deleteUserByUid(userUid);
	}

	@Override
	public UserVO selectUserByUid(String userUid) {
		System.out.println("회원조회 : " + userUid);
		return dao.selectUserByUid(userUid);
	}

	@Override
	public List<UserVO> selectUserList() {
		return null;
	}

	@Override
	public void updateProfileImage(UserPhotoVO userPhoto) {
		// 1. 기존 매칭되는 사진 정보 경로 가져오기(userUid, type)
		UserPhotoVO oldUserPhoto = dao.selectUserPhotoPath(userPhoto);
		if (oldUserPhoto != null) {
			String oldPath = oldUserPhoto.getPath();
			
			// 2. 가져온 경로에 있는 파일 삭제
			File f = new File(oldPath);
			f.delete();
			// 3. 기존에 매칭되는 사진 정보 있으면 삭제(photoNo)
			dao.deleteUserPhotoByNo(oldUserPhoto.getPhotoNo());
		}
		
		// 4. 이미지 파일 업로드 정보 입력
		dao.insertUserPhoto(userPhoto);
		
		// 5. USER_TB에 USER_UID에 PHOTO_URL수정
		String path = userPhoto.getPath();
		String photoUrl = "http://192.168.1.13:3001" + servletContext.getContextPath() + "/images?path=" + path.substring(path.lastIndexOf("upload"));
		
		UserVO user = new UserVO();
		user.setUserUid(userPhoto.getUserUid());
		user.setPhotoUrl(photoUrl);
		dao.updateUserPhotoUrl(user);
		
		// /images/profile/profile-c71ffbe1-0cb3-4c92-b72a-00d55653428f.jpg
		
	}
}
