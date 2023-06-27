package com.java.servlet.dao;

import java.util.List;





import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.Favorite_W_VO;

public interface Favorite_W_DAO {

	List<Favorite_W_VO> selectWithPetBoard();
	int seletCountWithPetBoard();	
	List<Favorite_W_VO> selectWithPetBoardByPage(PageMaker pageMaker);

}
