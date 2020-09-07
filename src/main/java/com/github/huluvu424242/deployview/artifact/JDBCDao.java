package com.github.huluvu424242.deployview.artifact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long getDefaultNextVal() {
        return (Long) jdbcTemplate.queryForObject("select next_val from hibernate_sequences where sequence_name ='default'", Long.class);
    }

    public int updateDefaultNextVal(final long nextVal) {
        return jdbcTemplate.update("update hibernate_sequences set next_val = ? where sequence_name ='default'", nextVal);
    }

}
