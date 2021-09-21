package cn.muses.shardingsphere;/*
								Copyright 2019 All rights reserved.
								*/

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.muses.shardingsphere.repository.dao.DaoImpl;

/**
 * @author jervis
 * @date 2021/9/21.
 */
@SpringBootTest
@EnableTransactionManagement
public class TestDao {

	@Autowired
	private DaoImpl dao;

	@Test
	public void test() {
		dao.test();
	}

}
