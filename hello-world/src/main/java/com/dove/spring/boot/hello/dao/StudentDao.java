package com.dove.spring.boot.hello.dao;

import org.springframework.stereotype.Repository;

import com.dove.spring.boot.hello.Base.BaseDao;

@Repository
public class StudentDao extends BaseDao {

	public String findById(String str){
		return "hello";
	}
	

}
