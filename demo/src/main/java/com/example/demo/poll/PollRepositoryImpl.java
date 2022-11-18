package com.example.demo.poll;

import com.example.demo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PollRepositoryImpl implements PollRepository {

    private static final String POLL_TABLE_NAME = "Polls";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createPoll(Poll poll) {
        String sql = "INSERT INTO " + POLL_TABLE_NAME + " (title, first_ans, second_ans, third_ans, fourth_ans) VALUES (?, ?, ?, ?,?)";
        jdbcTemplate.update(sql, poll.getTitle(), poll.getFirst_ans(), poll.getSecond_ans(), poll.getThird_ans(), poll.getFourth_ans());
    }

    @Override
    public void updatePollById(Long pollId, Poll poll) {
        String sql = "UPDATE " + POLL_TABLE_NAME + " SET title=?, first_ans=?, seconds_ans=?, third_ans=?, fourth_ans=?," +
                "WHERE id=?";
        jdbcTemplate.update(sql, poll.getTitle(), poll.getFirst_ans(), poll.getSecond_ans(), poll.getThird_ans(), poll.getFourth_ans());
    }

    @Override
    public void deletePollById(Long id) {
        String sql = "DELETE FROM " + POLL_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Poll getPollById(Long id) {
        String sql = "SELECT * FROM " + POLL_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new PollMapper(), id);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<Poll> getPollsByTitle(String title) {
        String sql = "SELECT * FROM " + POLL_TABLE_NAME + " WHERE title=?";
        try {
            return jdbcTemplate.query(sql, new PollMapper(), title);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Poll> getAllPolls() {
            String sql = "SELECT * FROM " + POLL_TABLE_NAME;
            try {
                return jdbcTemplate.query(sql, new PollMapper());
            } catch (EmptyResultDataAccessException error){
                return null;
            }
    }

    @Override
    public List<Long> getPollIdsByTitle(String title) {
        String sql = "SELECT c.id FROM " + POLL_TABLE_NAME + " AS c WHERE c.title= ?";
        try {
            return jdbcTemplate.queryForList(sql, Long.class, title);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }
}
