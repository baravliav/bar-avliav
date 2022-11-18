package com.example.demo.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String USER_TABLE_NAME = "Users";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(User customer) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name, last_name, email, age, address, joining_data) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getFirst_name(), customer.getLast_name(), customer.getEmail(), customer.getAge(), customer.getAddress(), customer.getJoining_date());
    }

    @Override
    public void updateUserById(Long customerId, User customer) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, age=?, address=?, joining_date=?" +
                "WHERE id=?";
        jdbcTemplate.update(sql, customer.getFirst_name(), customer.getLast_name(), customer.getEmail(),customer.getAge(), customer.getAddress(), customer.getJoining_date(), customerId);
    }

    @Override
    public void deleteUserById(Long id) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }


    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<User> getUsersByFirstName(String firstName) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE first_name=?";
        try {
            return jdbcTemplate.query(sql, new UserMapper(), firstName);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM " + USER_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, new UserMapper());
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Long> getUserIdsByFirstName(String firstName) {
        String sql = "SELECT c.id FROM " + USER_TABLE_NAME + " AS c WHERE c.first_name = ?";
        try {
            return jdbcTemplate.queryForList(sql, Long.class, firstName);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
}
