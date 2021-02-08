package com.qkm.DAO;

import com.qkm.user.Boss;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class bossServiceImp implements bossService {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(druidJDBCUtils.getDataSource());

    @Override
    public Boss findBoss(Boss boss) {
        try {
            String sql = "select * from boss where name = ? and password = ?";
            //没有找到对应的名字的密码就会抛出异常，不会返回空，所以利用异常来返回一个空
            //查询返回一个Boss对象
            Boss boss1 = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<Boss>(Boss.class), boss.getName(), boss.getPassword());
            return boss1;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void addBoss(Boss boss) {
        String sql = "insert into boss value(?,?,?)";
        jdbcTemplate.update(sql, null,boss.getName(), boss.getPassword());
    }
}

/*
s=a;
if(a->data==b->data){
     if(a==S){
        a=a->next;
        S=a;
     }else{
        d=a->next;
        a->next=d->next;
        free(d);
     }
}

 */


