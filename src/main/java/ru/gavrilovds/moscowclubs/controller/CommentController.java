package ru.gavrilovds.moscowclubs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gavrilovds.moscowclubs.entity.CommentEntity;
import ru.gavrilovds.moscowclubs.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity addComment(@RequestBody CommentEntity comment,
                                     @RequestParam String email,
                                     @RequestParam String clubName){
        try{
            return ResponseEntity.ok(commentService.addComment(comment, email, clubName));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error.");
        }
    }

}
