package org.lld.practice.event.calendar;

import org.lld.practice.event.calendar.models.Event;
import org.lld.practice.event.calendar.models.Team;
import org.lld.practice.event.calendar.models.Timeslot;
import org.lld.practice.event.calendar.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventCalendar {
    private static EventCalendar eventCalendar;
    Map<String, User> userMap;
    Map<String, Event> eventMap;
    Map<String, Team> teamMap;

    private EventCalendar() {
        this.userMap = new HashMap<>();
        this.eventMap = new HashMap<>();
        this.teamMap = new HashMap<>();
    }

    public static EventCalendar getInstance() {
        if (eventCalendar == null) {

            if (eventCalendar == null) {
                eventCalendar = new EventCalendar();
            }
        }
        return eventCalendar;
    }

    public boolean createUser(final String name, Timeslot timeslot) {
        User user = new User(name, timeslot);
        if (!this.userMap.containsKey(name)) {
            this.userMap.put(name, user);
            return true;
        }
        return false;
    }

    public boolean createTeam(final String name, List<String> users) {
        if (!this.teamMap.containsKey(name)) {
            Team team = new Team(name);
            for (String user : users) {
                if (!this.userMap.containsKey(user)) {
                    System.out.println("User not exist in the system to add into the team");
                    return false;
                }
                team.addUser(this.userMap.get(user));
            }
            this.teamMap.put(team.getName(), team);
            return true;
        }
        System.out.println("Team already exist with the given name " + name);
        return false;
    }

    public boolean createEvent(String name, List<String> users, List<String> teams, int minimumParticipants, Timeslot timeslot) {
        int count = 0;
        for (String user : users) {
            User user1 = this.userMap.get(user);
            if (user1.checkAvailability(timeslot)) {
                count += 1;
            }
        }
        for (String team : teams) {
            Team team1 = this.teamMap.get(team);
            count += team1.numberOfUserAvailable(timeslot);
        }
        if (count > minimumParticipants) {

            Event event = new Event(name, timeslot);
            for (String user : users) {

                User user1 = this.userMap.get(user);

                if (user1.checkAvailability(timeslot)) {
                    user1.addEvent(event);
                }
            }

            for (String team : teams) {
                Team team1 = this.teamMap.get(team);
                team1.addEvent(event);
            }

            this.eventMap.put(event.getName(), event);

        } else {
            System.out.println("<======== Event is not possible to create minimum participants Number not available :" + name);
        }
        return false;
    }

    public List<Event> getUserEvent(String username, Timeslot timeslot) {
        if (!this.userMap.containsKey(username)) {
            System.out.println("<===== user not present in the system =======>");
            return null;
        }

        User user = this.userMap.get(username);
        user.printAvailabilityTime();
        return user.getEventsList();
    }
}
