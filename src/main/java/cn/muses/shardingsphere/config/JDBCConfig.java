/*
Copyright 2019 All rights reserved.
 */

package cn.muses.shardingsphere.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author jervis
 * @date 2021/9/21.
 */
@Configuration
public class JDBCConfig {

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
