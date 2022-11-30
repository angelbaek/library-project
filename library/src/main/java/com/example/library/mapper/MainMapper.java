package com.example.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.library.vo.BooksVO;
import com.example.library.vo.DurationbookVO;
import com.example.library.vo.UserInfoVO;

@Mapper
public interface MainMapper {
	//검색 엔진
	public List<BooksVO> Test(String name);
	
	//전체 책 리스트 보여주기
	public List<BooksVO> selectAllBooks();
	
	//회원 등록
	public int insertUserInfo(UserInfoVO user);
	
	//회원 로그인
	public List<UserInfoVO> getUserLogin(String id);
	
	//선택한 책 정보 가져오기
	public List<BooksVO> getBookInfo(int uniqueNumber);
	
	//렌탈 서비스
	public int insertRental(DurationbookVO vo);
	
	//렌탈 서비스 책 업데이트
	public int updateRentalService(int uniqueNumber);
	
}