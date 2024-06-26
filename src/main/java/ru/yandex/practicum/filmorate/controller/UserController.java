package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.User;

import jakarta.validation.Valid;
import ru.yandex.practicum.filmorate.service.UserService;

import java.util.Collection;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Collection<User> findAll() {
        log.info("findAll - Started");
        Collection<User> allUsers = userService.findAll();
        log.info("findAll: {} - Finished", allUsers);
        return allUsers;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        log.info("create: {} - Started", user);
        user = userService.create(user);
        log.info("create: {} - Finished", user);
        return user;
    }

    @PutMapping
    public User update(@Valid @RequestBody User user) {
        log.info("update: {} - Started", user);
        user = userService.update(user);
        log.info("update: {} - Finished", user);
        return user;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Integer id) {
        log.info("getUser: {} - Started", id);
        User user = userService.getUser(id);
        log.info("getUser: {} - Finished", user);
        return user;
    }

    @PutMapping("/{id}/friends/{friendId}")
    public User addFriend(@PathVariable("id") Integer userId,
                          @PathVariable("friendId") Integer friendId) {
        log.info("addFriend: {} - userId, {} - friendId", userId, friendId);
        User user = userService.addFriend(userId, friendId);
        log.info("addFriend: {} - Finished", user);
        return user;
    }

    @DeleteMapping("/{id}/friends/{friendId}")
    public User deleteFriend(@PathVariable("id") Integer userId,
                             @PathVariable("friendId") Integer friendId) {
        log.info("deleteFriend: {} - userId, {} - friendId", userId, friendId);
        User user = userService.deleteFriend(userId, friendId);
        log.info("deleteFriend: {} - Finished", user);
        return user;
    }

    @GetMapping("/{id}/friends")
    public List<User> getFriends(@PathVariable("id") Integer userId) {
        log.info("getFriends: {} - userId", userId);
        List<User> userFriends = userService.getFriends(userId);
        log.info("getFriends: {} - Finished", userFriends);
        return userFriends;
    }

    @GetMapping("/{id}/friends/common/{otherId}")
    public List<User> getCommonFriends(@PathVariable("id") Integer userId,
                                       @PathVariable("otherId") Integer otherId) {
        log.info("getCommonFriends: {} - userId, {} - otherUserId", userId, otherId);
        List<User> commonFriends = userService.getCommonFriends(userId, otherId);
        log.info("getCommonFriends: {} - Finished", commonFriends);
        return commonFriends;
    }
}