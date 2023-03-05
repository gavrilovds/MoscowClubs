package ru.gavrilovds.moscowclubs.entity;


import jakarta.persistence.*;

@Entity
public class ClubImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageId;

    @ManyToOne
    @JoinColumn(name = "club_name")
    private ClubEntity club;

    public ClubImagesEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public ClubEntity getClub() {
        return club;
    }

    public void setClub(ClubEntity club) {
        this.club = club;
    }
}
