package ru.gavrilovds.moscowclubs.model;

import ru.gavrilovds.moscowclubs.entity.ClubEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Club {
    private Long id;
    private String name;
    private String description;

    private List<Comment> comments;


    public Club() {
    }

    public static Club toModel(ClubEntity entity){
        Club model = new Club();
        model.setDescription(entity.getDescription());
        model.setId(entity.getId());
        model.setName(entity.getName());
        if (entity.getClubComments()!=null)
            model.setComments(entity.getClubComments().stream().map(Comment::toModel).collect(Collectors.toList()));
        return model;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
