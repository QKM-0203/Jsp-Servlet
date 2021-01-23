package com.qkm.DAO;

import cn.qkm.Login.User;
import com.qkm.user.Boss;
import com.qkm.user.user;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserQueueImp implements UserQueue{
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(druidJDBCUtils.getDataSource());
    @Override
    public List<user> findAll() {
        String sql = "select * from user";
        List<user> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<user>(user.class));
        return query;
    }


}
