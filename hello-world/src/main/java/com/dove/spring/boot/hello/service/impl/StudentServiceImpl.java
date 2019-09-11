package com.dove.spring.boot.hello.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dove.spring.boot.hello.dao.StudentDao;
import com.dove.spring.boot.hello.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao dao;

	@Override
	public String findById(String str) {
		return dao.findById(str);
	}
	
	
	

}
