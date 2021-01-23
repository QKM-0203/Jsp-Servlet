package com.qkm.DAO;

import cn.qkm.Login.User;
import com.qkm.user.Boss;
import com.qkm.user.user;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserServiceImp implements UserService{
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(druidJDBCUtils.getDataSource());
    @Override
    public List<user> findAll() {
        String sql = "select * from user";
        List<user> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<user>(user.class));
        return query;
    }

    @Override
    public void addUser(user User) {
       String sql = "insert into user value(null,?,?,?,?,?,?)";
       jdbcTemplate.update(sql,User.getName(),User.getSex(),User.getAge(),User.getBirth(),User.getQq(),User.getMail());
    }


}
