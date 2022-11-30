package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.mapper.MainMapper;
import com.example.library.vo.BooksVO;
import com.example.library.vo.DurationbookVO;
import com.example.library.vo.UserInfoVO;

@Service
public class libraryService {
	
	@Autowired
	MainMapper mainMapper;
	
	public List<BooksVO> test(String name) {
		return mainMapper.Test(name);
	}	
	
	// 전체 책 리스트 보여주기
	public List<BooksVO> getAllBooks() {
		return mainMapper.selectAllBooks();
	}	
	
	// 회원 등록
	public int insertUserInfo(UserInfoVO user) {
		return mainMapper.insertUserInfo(user);
	}
	
	// 회원 로그인
	public List<UserInfoVO> getUserLogin(String id){
		return mainMapper.getUserLogin(id);
	}
	
	// 선택한 책 정보 가져오기
	public List<BooksVO> getBookInfo(int uniqueNumber){
		return mainMapper.getBookInfo(uniqueNumber);
	}
	
	public int setRentalService(DurationbookVO vo) {
		mainMapper.updateRentalService(vo.getUniqueNumber());
		return mainMapper.insertRental(vo);
	}
}