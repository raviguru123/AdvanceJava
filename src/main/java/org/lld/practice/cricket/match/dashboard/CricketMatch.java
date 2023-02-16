package org.lld.practice.cricket.match.dashboard;

import org.lld.practice.cricket.match.dashboard.exception.AlloutException;

public class CricketMatch {
    int num_overs;
    int total_overs;
    int total_players;

    BattingTeam battingTeam;

    BattingTeam bowlingTeam;

    public CricketMatch(final int num_overs, final int total_players, BattingTeam battingTeam, BattingTeam bowlingTeam) {
        this.num_overs = num_overs;
        this.total_players = total_players;
        this.total_overs = 0;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
    }

    public void addOver(Over overs) {
        try {
            this.battingTeam.faceBalls(overs);
        } catch (Exception alloutException) {
//            System.out.println(" Batting Changed" + alloutException.getMessage());
            changeStrikeTeam();
        }
        this.total_overs += 1;
        this.print();
        isOverfinished();
    }

    private void isOverfinished() {
        if (this.total_overs == this.num_overs) {
            this.changeStrikeTeam();
        }
    }

    public void start() {
        this.battingTeam.play();
    }

    private void print() {
        this.battingTeam.print();
    }

    private void changeStrikeTeam() {
        BattingTeam temp = battingTeam;
        this.battingTeam = bowlingTeam;
        this.bowlingTeam = temp;
        this.total_overs = 0;
        start();
    }


}
