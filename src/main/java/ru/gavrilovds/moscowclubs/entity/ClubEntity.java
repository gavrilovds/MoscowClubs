package ru.gavrilovds.moscowclubs.entity;


import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
public class ClubEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "club")
    private List<ClubImagesEntity> clubImages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "club")
    private List<CommentEntity> clubComments;

    public List<CommentEntity> getClubComments() {
        return clubComments;
    }

    public void setClubComments(List<CommentEntity> clubComments) {
        this.clubComments = clubComments;
    }

    public ClubEntity() {
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

    public List<ClubImagesEntity> getClubImages() {
        return clubImages;
    }

    public void setClubImages(List<ClubImagesEntity> clubImages) {
        this.clubImages = clubImages;
    }
}
