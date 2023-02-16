package org.lld.practice.cricket.match.dashboard;

import lombok.Setter;

@Setter
public class Scoreboard {
    BowlingTeam bowlingTeam;
    BattingTeam battingTeam;

    public Scoreboard(BowlingTeam bowlingTeam, BattingTeam battingTeam) {
        this.bowlingTeam = bowlingTeam;
        this.battingTeam = battingTeam;
    }

    public void print() {

    }
}
