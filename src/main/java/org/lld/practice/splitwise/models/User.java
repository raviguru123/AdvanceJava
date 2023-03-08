package org.lld.practice.splitwise.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {
    String id;
    String name;
    String email;
    String phone;

    public User(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    List<Group> groupList = new ArrayList<>();

    public void addGroup(Group group) {
        this.groupList.add(group);
    }
}
