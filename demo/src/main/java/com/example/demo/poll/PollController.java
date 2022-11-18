package com.example.demo.poll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PollController {

    @Autowired
    private PollRepository pollRepository;

    @PostMapping(value = "/poll/create")
    public void createPoll(@RequestBody Poll poll){
        pollRepository.createPoll(poll);
    }

    @PutMapping(value = "/poll/{pollId}/update")
    public void updatePollById(@PathVariable Long pollId,
                                   @RequestBody Poll poll){
        pollRepository.updatePollById(pollId, poll);
    }

    @DeleteMapping(value = "/poll/{pollId}/delete")
    public void deletePollById(@PathVariable Long pollId){
        pollRepository.deletePollById(pollId);
    }

    @GetMapping(value = "/poll/{pollId}")
    public Poll getPollById(@PathVariable Long pollId){
        return pollRepository.getPollById(pollId);
    }

    @GetMapping(value = "/poll/{title}/all")
    public List<Poll> getPollsByTitle(@PathVariable String title){
        return pollRepository.getPollsByTitle(title);
    }

    @GetMapping(value = "/poll/all")
    public List<Poll> getAllPolls(){
        return pollRepository.getAllPolls();
    }

    @GetMapping(value = "/pollId/{title}/all")
    public List<Long> getPollIdsByFirstName(@PathVariable String title){
        return pollRepository.getPollIdsByTitle(title);
    }
}
