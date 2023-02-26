package org.lld.practice.event.calendar.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Timeslot implements Comparable<Timeslot> {
    private final Date startTime;
    private final Date endTime;

    @Override
    public int compareTo(Timeslot o1) {
        return this.startTime.compareTo(o1.startTime);
    }

    @Override
    public String toString() {
        return this.startTime + "   " + this.endTime;
    }
}
