package org.lld.practice.event.calendar;

import org.lld.practice.event.calendar.models.Timeslot;

import java.text.SimpleDateFormat;
import java.util.Arrays;


public class Driver {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        EventCalendar eventCalendar = EventCalendar.getInstance();
        eventCalendar.createUser("A",
                new Timeslot(dateFormat.parse("2021-07-07 10:00:00"), dateFormat.parse("2021-07-07 19:00:00")));

        eventCalendar.createUser("B",
                new Timeslot(dateFormat.parse("2021-07-07 9:30:00"), dateFormat.parse("2021-07-07 17:30:00")));

        eventCalendar.createUser("C",
                new Timeslot(dateFormat.parse("2021-07-07 11:30:00"), dateFormat.parse("2021-07-07 18:30:00")));

        eventCalendar.createUser("D",
                new Timeslot(dateFormat.parse("2021-07-07 10:00:00"), dateFormat.parse("2021-07-07 18:00:00")));

        eventCalendar.createUser("E",
                new Timeslot(dateFormat.parse("2021-07-07 11:00:00"), dateFormat.parse("2021-07-07 19:30:00")));

        eventCalendar.createUser("F",
                new Timeslot(dateFormat.parse("2021-07-07 11:00:00"), dateFormat.parse("2021-07-07 18:30:00")));


        eventCalendar.createTeam("T1", Arrays.asList("C", "E"));
        eventCalendar.createTeam("T2", Arrays.asList("B", "D", "F"));

        eventCalendar.getUserEvent("A", new Timeslot(dateFormat.parse("2021-07-07 9:30:00"), dateFormat.parse("2021-07-07 17:30:00")));

        eventCalendar.createEvent("Event1", Arrays.asList("A"), Arrays.asList("T1"), 2,
                new Timeslot(dateFormat.parse("2021-07-07 14:00:00"), dateFormat.parse("2021-07-07 15:00:00")));


        eventCalendar.createEvent("Event2", Arrays.asList("C"), Arrays.asList(), 1,
                new Timeslot(dateFormat.parse("2021-07-07 14:00:00"), dateFormat.parse("2021-07-07 15:00:00")));


        eventCalendar.createEvent("Event3", Arrays.asList(), Arrays.asList("T2"), 2,
                new Timeslot(dateFormat.parse("2021-07-07 15:00:00"), dateFormat.parse("2021-07-07 16:00:00")));

        eventCalendar.createEvent("Event4", Arrays.asList("A"), Arrays.asList("T1", "T2"), 1,
                new Timeslot(dateFormat.parse("2021-07-07 15:00:00"), dateFormat.parse("2021-07-07 16:00:00")));


        eventCalendar.createEvent("Event5", Arrays.asList("A", "F"), Arrays.asList(), 2,
                new Timeslot(dateFormat.parse("2021-07-07 10:00:00"), dateFormat.parse("2021-07-07 11:00:00")));


        eventCalendar.getUserEvent("A", new Timeslot(dateFormat.parse("2021-07-07 9:30:00"), dateFormat.parse("2021-07-07 17:30:00")));

        eventCalendar.getUserEvent("B", new Timeslot(dateFormat.parse("2021-07-07 9:30:00"), dateFormat.parse("2021-07-07 17:30:00")));


        eventCalendar.getUserEvent("C", new Timeslot(dateFormat.parse("2021-07-07 9:30:00"), dateFormat.parse("2021-07-07 17:30:00")));

        eventCalendar.getUserEvent("D", new Timeslot(dateFormat.parse("2021-07-07 9:30:00"), dateFormat.parse("2021-07-07 17:30:00")));


        eventCalendar.getUserEvent("E", new Timeslot(dateFormat.parse("2021-07-07 9:30:00"), dateFormat.parse("2021-07-07 17:30:00")));

        eventCalendar.getUserEvent("F", new Timeslot(dateFormat.parse("2021-07-07 9:30:00"), dateFormat.parse("2021-07-07 17:30:00")));

    }
}
