package ru.gavrilovds.moscowclubs.model;

import ru.gavrilovds.moscowclubs.entity.CommentEntity;

public class Comment {

    private String text;

    public Comment() {
    }

    public static Comment toModel(CommentEntity entity){
        Comment model = new Comment();
        model.setText(entity.getText());
        return model;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
