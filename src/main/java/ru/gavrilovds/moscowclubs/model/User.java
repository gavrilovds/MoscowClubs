package ru.gavrilovds.moscowclubs.model;

import ru.gavrilovds.moscowclubs.entity.CommentEntity;
import ru.gavrilovds.moscowclubs.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private long id;
    private String email;
    private String name;
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public static User toModel(UserEntity entity){
        User model = new User();
        model.setEmail(entity.getEmail());
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setComments(entity.getComments().stream().map(Comment::toModel).collect(Collectors.toList()));
        return model;
    }


    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
