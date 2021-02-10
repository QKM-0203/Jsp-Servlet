package com.qkm.Service;

import com.qkm.DAO.druidJDBCUtils;
import com.qkm.Service.UserService;
import com.qkm.user.PageBean;
import com.qkm.user.user;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserServiceImp implements UserService {
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

    @Override
    public void deleteUser(String id) {
         String sql = "delete from user where ID = ?";
         jdbcTemplate.update(sql,Integer.parseInt(id));
    }

    @Override
    public void deleteUsers(String[] ids) {
        for (String id : ids) {
            deleteUser(id);
        }
    }

    @Override
    public void updateUser(user User) {
        String sql = "update user set NAME = ?,SEX = ?,AGE = ?,BIRTH = ?,QQ = ?,MAIL = ? where ID = ?";
        jdbcTemplate.update(sql,User.getName(),User.getSex(),User.getAge(),User.getBirth(),User.getQq(),User.getMail(),User.getId());

    }
    @Override
    public user findUser(String id) {
        try{
            String sql = "select * from user where ID = ?";
            //没有找到对应的名字的密码就会抛出异常，不会返回空，所以利用异常来返回一个空
            //查询返回一个User对象
            user User = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<user>(user.class),Integer.parseInt(id));
            return User;
        }catch(DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PageBean<user> findUserByPage(int currentPage, int rows) {
        PageBean<user> userPageBean = new PageBean<>();
        userPageBean.setRows(rows);

        int start = (currentPage-1)*rows;
        List<user> usersPage = findUsersPage(start, rows);
        userPageBean.setList(usersPage);
        int total = totalUsers();
        userPageBean.setTotal(total);
        int pages = total % rows == 0 ? total/rows : (total/rows)+1;
        userPageBean.setPages(pages);
        if(currentPage >= pages){
            currentPage = pages-1;
        }
        userPageBean.setCurrentPage(currentPage);

        return userPageBean;
    }

    private int totalUsers() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    private List<user> findUsersPage(int start,int rows) {
        String sql = "select * from user limit ?,?";
        List<user> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<user>(user.class),start,rows);
        return query;
    }


}
