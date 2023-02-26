package org.lld.practice.event.calendar.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Event {
    private final String name;
    private final Timeslot timeslot;
    private List<Participants> userParticipants;

    public Event(final String name, final Timeslot timeslot) {
        this.name = name;
        this.timeslot = timeslot;
        this.userParticipants = new ArrayList<>();
    }

    public void addParticipants(Participants participants) {
        this.userParticipants.add(participants);
    }

    @Override
    public String toString() {
        return this.name + ": " + this.getTimeslot().getStartTime() + "     " + this.getTimeslot().getEndTime();
    }
}
