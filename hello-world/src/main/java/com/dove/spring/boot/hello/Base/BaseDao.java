package com.dove.spring.boot.hello.Base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDao {
	protected static Logger log = LoggerFactory.getLogger(BaseDao.class);
	
	protected void getName() {
		System.out.println("调用数据库持久层");
		
	}
	
}