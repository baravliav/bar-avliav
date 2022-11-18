package com.example.demo.poll;

import com.example.demo.User.User;

import java.util.List;

public interface PollRepository {
    void createPoll(Poll poll);
    void updatePollById(Long pollId, Poll poll);
    void deletePollById(Long id);
    Poll getPollById(Long id);
    List<Poll> getPollsByTitle(String title);
    List<Poll> getAllPolls();
    List<Long> getPollIdsByTitle(String title);
}
