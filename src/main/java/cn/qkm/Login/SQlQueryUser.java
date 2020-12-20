package cn.qkm.Login;


import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SQlQueryUser {
    //利用druid数据库连接池工具类来创建jdbcTemplate对象，传入数据库连接池对象
    private  JdbcTemplate jdbcTemplate = new JdbcTemplate(druidJDBCUtils.getDataSource());
    @Test
    public  User isUser(User user){
        try{
            String sql = "select * from user where NAME = ? and PASSWORD = ?";
            //没有找到对应的名字的密码就会抛出异常，不会返回空，所以利用异常来返回一个空
            //查询返回一个User对象
            User user1 = jdbcTemplate.queryForObject(sql,
                  new BeanPropertyRowMapper<User>(User.class), user.getNAME(), user.getPASSWORD());
            return user1;
        }catch(DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
