package org.lld.practice.splitwise.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Group {
    String name;
    List<User> userList;

    public Group(String name) {
        this.name = name;
    }

    public void addUser(User user) {
        this.userList.add(user);
        user.addGroup(this);
    }
}
