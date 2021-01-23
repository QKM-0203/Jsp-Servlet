package com.qkm.DAO;

import com.qkm.user.Boss;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class bossQueueImp  implements bossQueue{
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(druidJDBCUtils.getDataSource());
        @Override
        public Boss findUser(Boss boss) {
            try{
                String sql = "select * from boss where name = ? and password = ?";
                //没有找到对应的名字的密码就会抛出异常，不会返回空，所以利用异常来返回一个空
                //查询返回一个User对象
                Boss boss1 = jdbcTemplate.queryForObject(sql,
                        new BeanPropertyRowMapper<Boss>(Boss.class),boss.getName(), boss.getPassword());
                return boss1;
            }catch(DataAccessException e){
                e.printStackTrace();
                return null;
            }
        }
}
