/*
 * Copyright 2019 All rights reserved.
 */

package cn.muses.shardingsphere.repository.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author jervis
 * @date 2021/9/21.
 */
@Repository
public class DaoImpl implements InitializingBean {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ObjectMapper objectMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.objectMapper = new ObjectMapper();
    }

    @Transactional
    public void test() {
        // 增
        // jdbcTemplate.execute("insert into ins.spring_test(id, content) values (11, 'test')");

        // 查询
        RowMapper<Map> rowMapper = new RowMapper<Map>() {
            @Override
            public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
                final int cc = rs.getMetaData().getColumnCount();
                Map<String, Object> ret = new HashMap<>(cc);
                for (int i = 1; i <= cc; i++) {
                    ret.put(rs.getMetaData().getColumnLabel(i), rs.getObject(i));
                }

                return ret;
            }
        };
        System.out.println(jdbcTemplate.query("select * from ins.spring_test", rowMapper));
    }
}
