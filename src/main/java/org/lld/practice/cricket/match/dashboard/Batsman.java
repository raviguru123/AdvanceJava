package org.lld.practice.cricket.match.dashboard;

import lombok.NonNull;

public class Batsman implements Player{
    int total_runs;
    final String name;
    int total_fours;
    int total_six;

    int total_balls;

    public Batsman(@NonNull String name) {
        this.name = name;
        this.total_runs = 0;
        this.total_fours = 0;
        this.total_six = 0;
        this.total_balls = 0;
    }

    public void addRun(int run) {
        this.total_runs += run;
        this.total_balls += 1;
        if (run == 4)
            this.total_fours += 1;
        if (run == 6)
            this.total_six += 1;
    }


    public void print() {
        System.out.println(this.name + "* " + this.total_runs + " " + this.total_fours + " " + this.total_six + " " + this.total_balls);
    }
}
