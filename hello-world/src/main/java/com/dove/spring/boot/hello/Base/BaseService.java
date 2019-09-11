package com.dove.spring.boot.hello.Base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class BaseService {
	protected static Logger log = LoggerFactory.getLogger(BaseDao.class);

	public BaseService() {
		System.out.println("构造自己");
	}
	
}