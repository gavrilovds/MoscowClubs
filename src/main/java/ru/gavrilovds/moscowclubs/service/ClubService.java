package ru.gavrilovds.moscowclubs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gavrilovds.moscowclubs.entity.ClubEntity;
import ru.gavrilovds.moscowclubs.exception.ClubAlreadyExistsException;
import ru.gavrilovds.moscowclubs.exception.NoClubWithSuchNameException;
import ru.gavrilovds.moscowclubs.model.Club;
import ru.gavrilovds.moscowclubs.repository.ClubRepository;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public Club addClub(ClubEntity club) throws ClubAlreadyExistsException {
        if (clubRepository.findByName(club.getName()) != null) {
            throw new ClubAlreadyExistsException("Club already exists.");
        }
        return Club.toModel(clubRepository.save(club));
    }

    public Club getClub(String name) throws NoClubWithSuchNameException {
        ClubEntity club = clubRepository.findByName(name);
        if (club == null) {
            throw new NoClubWithSuchNameException("No club with such name.");
        }
        return Club.toModel(club);
    }

    public String deleteClub(String name) throws NoClubWithSuchNameException {
        ClubEntity club = clubRepository.findByName(name);
        if (club == null) {
            throw new NoClubWithSuchNameException("No club with such name.");
        }
        clubRepository.delete(club);
        return String.format("Клуб %s был удален.", name);
    }

    public String changeDescription(String newDescription, String clubName) throws NoClubWithSuchNameException {
        ClubEntity club = clubRepository.findByName(clubName);
        if (club == null) {
            throw new NoClubWithSuchNameException("No club with such name.");
        }
        club.setDescription(newDescription);
        clubRepository.save(club);
        return "Описание обновлено.";
    }



}
