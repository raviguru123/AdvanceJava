package org.lld.practice.event.calendar.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
public class User extends Participants {
    private Optional<Team> team;
    private List<Event> eventsList;

    private Timeslot workingHours;

    public User(final String name, Timeslot workingHours) {
        super(name);
        this.eventsList = new ArrayList<>();
        this.workingHours = workingHours;
        this.team = Optional.empty();
    }

    public void setTeam(Team team) {
        this.team = Optional.of(team);
    }

    public boolean addEvent(Event event) {
        if (!checkAvailability(event.getTimeslot())) {
            return false;
        }
        this.eventsList.add(event);

        this.eventsList.sort(Comparator.comparing(event1 -> event1.getTimeslot().getStartTime()));

        event.addParticipants(this);
        return true;
    }


    public boolean checkAvailability(Timeslot timeslot) {
        for (Event event : eventsList) {
            Timeslot timeslot1 = event.getTimeslot();
            long startTimeStamp = timeslot.getStartTime().getTime();
            long endTimeStamp = timeslot.getEndTime().getTime();

            long startTimeStamp1 = timeslot1.getStartTime().getTime();
            long endTimeStamp1 = timeslot1.getEndTime().getTime();
            if ((startTimeStamp1 <= startTimeStamp && startTimeStamp < endTimeStamp1) || (startTimeStamp1 < endTimeStamp && endTimeStamp <= endTimeStamp1)) {
                return false;
            }
        }
        return true;
    }

    public void printAvailabilityTime() {
        System.out.print("Name :" + this.getName() + " ");
        for (Event event : eventsList) {
            System.out.print(event + "   ");
        }
        System.out.println();
    }
}
