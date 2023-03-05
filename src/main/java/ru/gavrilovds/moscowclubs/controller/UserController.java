package ru.gavrilovds.moscowclubs.controller;

import ru.gavrilovds.moscowclubs.entity.UserEntity;
import ru.gavrilovds.moscowclubs.exception.NoUserWithSuchEmailException;
import ru.gavrilovds.moscowclubs.exception.UserAlreadyExistsException;
import ru.gavrilovds.moscowclubs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {

        try {
            userService.registration(user);
            return ResponseEntity.ok("New user has added.");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error.");
        }
    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam String email){
        try {
           return ResponseEntity.ok(userService.getUser(email));
        }
        catch (NoUserWithSuchEmailException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error.");
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity deleteUser(@PathVariable String email){
        try {
            return ResponseEntity.ok(userService.removeUser(email));
        }
         catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
