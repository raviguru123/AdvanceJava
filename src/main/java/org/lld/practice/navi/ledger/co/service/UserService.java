package org.lld.practice.navi.ledger.co.service;

import org.lld.practice.navi.ledger.co.Borrower;
import org.lld.practice.navi.ledger.co.User;
import org.lld.practice.navi.ledger.co.exception.UserNotFoundException;
import org.lld.practice.navi.ledger.co.exception.UserTypeNotExist;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static UserService userService;
    Map<String, User> userMap;

    private UserService() {
        this.userMap = new HashMap<>();
    }

    public static UserService getInstance() {
        if (userService == null) {
            synchronized (UserService.class) {
                if (userService == null) {
                    userService = new UserService();
                }
            }
        }
        return userService;
    }

    public void upsertUser(String name, UserType userType) throws UserTypeNotExist {
        switch (userType) {
            case BORROWER:
                if (!this.userMap.containsKey(name)) {
                    this.userMap.put(name, new Borrower(name));
                }
                break;
            default:
                throw new UserTypeNotExist("user type not exist");
        }

    }

    public User getUser(String name) throws UserNotFoundException {
        if (!this.userMap.containsKey(name)) {
            throw new UserNotFoundException("user not exist with the name : " + name);
        }
        return this.userMap.get(name);
    }
}
