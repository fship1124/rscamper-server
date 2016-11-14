select *
from board_category_tb;

select * from board_tb b, board_category_tb c where b.category_no = 2;
select * from board_tb b, board_category_tb c where b.category_no = 4;

select * from board_tb



show tables;

select * from board_image_tb;





















-- 모든 게시판
SELECT *, 
	(SELECT COUNT(*) FROM BOARD_LIKE_TB LIKETB WHERE LIKETB.TARGET_NO=B.BOARD_NO AND LIKETB.TARGET_TYPE=1) LIKE_CNT
FROM BOARD_TB B, BOARD_CATEGORY_TB C, USER_TB U, LOCATION_TB L
WHERE C.CATEGORY_NO = B.CATEGORY_NO 
	AND B.USER_UID = U.USER_UID 
	AND U.LOCATION_NO = L.LOCATION_NO
ORDER BY LIKE_CNT DESC
LIMIT 1, 10;

-- 카테고리별 
SELECT *, 
	(SELECT COUNT(*) FROM BOARD_LIKE_TB LIKETB WHERE LIKETB.TARGET_NO=B.BOARD_NO AND LIKETB.TARGET_TYPE=1) LIKE_CNT
FROM BOARD_TB B, BOARD_CATEGORY_TB C, USER_TB U, LOCATION_TB L
WHERE C.CATEGORY_NO = B.CATEGORY_NO 
	AND B.USER_UID = U.USER_UID 
	AND U.LOCATION_NO = L.LOCATION_NO
	AND B.CATEGORY_NO = #{categoryNo}
ORDER BY LIKE_CNT DESC
LIMIT #{page}, #{count}

-- 