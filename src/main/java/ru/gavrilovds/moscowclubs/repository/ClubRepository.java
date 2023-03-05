package ru.gavrilovds.moscowclubs.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gavrilovds.moscowclubs.entity.ClubEntity;

public interface ClubRepository extends CrudRepository<ClubEntity, Long> {
    ClubEntity findByName(String name);
}
