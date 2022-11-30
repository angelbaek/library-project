package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.service.libraryService;
import com.example.library.vo.BooksVO;
import com.example.library.vo.DurationbookVO;
import com.example.library.vo.UserInfoVO;

@RestController
@RequestMapping("/library")
@CrossOrigin
public class MainController {
	@Autowired
	libraryService service;
	
	@GetMapping("/test/{name}")
	public List<BooksVO> callSearch(@PathVariable String name) {
		return service.test(name);
	}
	
	@GetMapping("/test/booksAll")
	public List<BooksVO> callAllBooks(){
		return service.getAllBooks();
	}
	
	@PostMapping("/test")
	public int callInsertUserInfo(@RequestBody UserInfoVO user) {
		return service.insertUserInfo(user);
	}
	
	@GetMapping("/test/login/{id}")
	public List<UserInfoVO> callUserLogin(@PathVariable String id){
		return service.getUserLogin(id);	
	}
	
	@GetMapping("/test/book/{uniqueNumber}")
	public List<BooksVO> callBookInfo(@PathVariable int uniqueNumber){
		return service.getBookInfo(uniqueNumber);
	}
	
	@PostMapping("/test/retalservice")
	public int callRentalService(@RequestBody DurationbookVO vo) {
		return service.setRentalService(vo);
	}
	
}