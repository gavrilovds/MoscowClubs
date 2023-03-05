package ru.gavrilovds.moscowclubs.service;


import ru.gavrilovds.moscowclubs.entity.UserEntity;
import ru.gavrilovds.moscowclubs.exception.NoUserWithSuchEmailException;
import ru.gavrilovds.moscowclubs.exception.UserAlreadyExistsException;
import ru.gavrilovds.moscowclubs.model.User;
import ru.gavrilovds.moscowclubs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("User already exists.");
        }
        return userRepository.save(user);
    }

    public User getUser(String email) throws NoUserWithSuchEmailException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new NoUserWithSuchEmailException("No user with such email.");
        }
        return User.toModel(user);
    }

    public String removeUser(String email) throws NoUserWithSuchEmailException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new NoUserWithSuchEmailException("No user with such email.");
        }
        userRepository.delete(user);
        return email;
    }

}
