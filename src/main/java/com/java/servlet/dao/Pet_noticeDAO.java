package com.java.servlet.dao;

import java.util.List;



import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.Pet_noticeVO;

public interface Pet_noticeDAO {
	List<Pet_noticeVO> selectAllBoard();
	int seletCountAllBoard();
	List<Pet_noticeVO> selectAllBoardByPage(PageMaker pageMaker);
}
