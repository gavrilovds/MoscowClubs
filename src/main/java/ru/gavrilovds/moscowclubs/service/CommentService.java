package ru.gavrilovds.moscowclubs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gavrilovds.moscowclubs.entity.ClubEntity;
import ru.gavrilovds.moscowclubs.entity.CommentEntity;
import ru.gavrilovds.moscowclubs.entity.UserEntity;
import ru.gavrilovds.moscowclubs.model.Comment;
import ru.gavrilovds.moscowclubs.repository.ClubRepository;
import ru.gavrilovds.moscowclubs.repository.CommentRepository;
import ru.gavrilovds.moscowclubs.repository.UserRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClubRepository clubRepository;

    public Comment addComment(CommentEntity comment, String email, String clubName){
        UserEntity user = userRepository.findByEmail(email);
        ClubEntity club = clubRepository.findByName(clubName);
        comment.setUser(user);
        comment.setClub(club);
        return Comment.toModel(commentRepository.save(comment));
    }

}
