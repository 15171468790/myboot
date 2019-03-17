package com.example.myboot.repositoty.impl;

import com.example.myboot.mysqlModel.User;
import com.example.myboot.repositoty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Service
public class UserRepositoryImpl implements UserRepository {

    //注入jdbc处理类
    @Resource(name="secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Resource(name="primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate;

    @Override
    public int save(User user) {
        jdbcTemplate.update("insert into users(name,password,age) value (?,?,?)"
        ,user.getName(),user.getPassword(),user.getAge());
        return 0;
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE users SET name = ? , password = ? , age = ? WHERE id=?",
                user.getName(), user.getPassword(), user.getAge(), user.getId());
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("DELETE FROM users where id = ? ",id);
    }


    @Override
    public User findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public List<User> findALL() {
        return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
    }

    public class UserRowMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(resultSet.getInt("age"));
            System.out.println("第i行："+i);
            return user;
        }
    }
}
