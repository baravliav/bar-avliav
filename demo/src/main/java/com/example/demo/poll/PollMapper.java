package com.example.demo.poll;

//import com.example.demo.Poll.Poll;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PollMapper implements RowMapper<Poll> {
    @Override
    public Poll mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Poll(
                rs.getInt("question_id"),
                rs.getString("title"),
                rs.getString("first_ans"),
                rs.getString("second_ans"),
                rs.getString("third_ans"),
                rs.getString("fourth_ans")
        );
    }
}
