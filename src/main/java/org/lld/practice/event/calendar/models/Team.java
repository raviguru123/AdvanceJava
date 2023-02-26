package org.lld.practice.event.calendar.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Team extends Participants {
    private List<User> usersList;

    private List<Event> eventList;

    public Team(final String name) {
        super(name);
        this.eventList = new ArrayList<>();
        this.usersList = new ArrayList<>();
    }

    public boolean addUser(User user) {
        Optional<Team> teamOptional = user.getTeam();
        if (!teamOptional.isPresent()) {
            this.usersList.add(user);
            user.setTeam(this);
            return true;
        }
        return false;
    }

    public void addEvent(Event event) {
        for (User user : usersList) {
            user.addEvent(event);
        }
        event.addParticipants(this);
        this.eventList.add(event);
    }

    public int numberOfUserAvailable(Timeslot timeslot) {
        int count = 0;
        for (User user : usersList) {
            if (user.checkAvailability(timeslot)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean checkUserAvailability(Event event, int numberOfUserAvailable) {
        int count = 0;
        for (User user : usersList) {
            if (user.checkAvailability(event.getTimeslot())) {
                count += 1;
            }
            if (count >= numberOfUserAvailable) {
                return true;
            }
        }
        return false;
    }
}
