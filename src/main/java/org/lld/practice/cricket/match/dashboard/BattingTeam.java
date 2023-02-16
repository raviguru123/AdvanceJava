package org.lld.practice.cricket.match.dashboard;

import org.lld.practice.cricket.match.dashboard.exception.AlloutException;

import java.util.ArrayList;
import java.util.List;

public class BattingTeam implements Team {
    private List<Batsman> batsmanList;

    private final String name;
    private Batsman strikeBatsMan;
    private Batsman nonStrikeBatsman;

    private int total_run;
    private int extra_run;
    private int total_wicket;
    private int total_overs;

    private int nextPlayer;
    List<Over> overList;


    public BattingTeam(final String name) {
        this.name = name;
        this.batsmanList = new ArrayList<>();
        this.total_run = 0;
        this.extra_run = 0;
        this.total_wicket = 0;
        this.total_overs = 0;
        this.nextPlayer = 0;
        this.overList = new ArrayList<>();
    }

    public void play() {
        this.strikeBatsMan = this.batsmanList.get(nextPlayer);
        nextPlayer += 1;
        this.nonStrikeBatsman = this.batsmanList.get(nextPlayer);
        nextPlayer += 1;
    }

    public void addPlayer(Batsman batsman) {
        this.batsmanList.add(batsman);
    }

    public void faceBalls(Over over) throws Exception {
        overList.add(over);
        try {
            for (Balls balls : over.ballsList) {
                total_run += balls.run;
                if (balls.ballType.equals(Balls.BallType.RIGHT)) {
                    this.strikeBatsMan.addRun(balls.run);
                } else if (balls.ballType.equals(Balls.BallType.NO) || balls.ballType.equals(Balls.BallType.WD)) {
                    this.extra_run += balls.run;
                } else if (balls.ballType.equals(Balls.BallType.W)) {
                    this.strikeBatsMan.addRun(0);
                    this.total_wicket += 1;
                    this.strikeBatsMan = getNextBarsMan();

                }

                if (balls.ballType.equals(Balls.BallType.RIGHT) && (balls.run == 1 || balls.run == 3)) {
                    changeStrike();
                }
            }

            changeStrike();

            if(over.ballsList.size() == over.total_balls) {
                this.total_overs += 1;
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public Batsman getNextBarsMan() throws Exception {
        if (this.nextPlayer == this.batsmanList.size()) {
            throw new AlloutException("team All out");
        }
        Batsman batsman = this.batsmanList.get(this.nextPlayer);
        this.nextPlayer += 1;
        return batsman;
    }

    public void print() {
        System.out.println("Scorecard for " + this.name + " :");
        for (Batsman batsman : this.batsmanList) {
            batsman.print();
        }
        System.out.println("Total:" + total_run + "/" + this.total_wicket);
        Over lastOver = this.overList.get(this.overList.size()-1);
        if(lastOver.total_balls != lastOver.ballsList.size()) {
            System.out.println("Overs: " + this.total_overs + "." + lastOver.ballsList.size());
        }
        else {
            System.out.println("Overs: " + this.total_overs);
        }
    }

    public void changeStrike() {
        Batsman temp = strikeBatsMan;
        strikeBatsMan = nonStrikeBatsman;
        nonStrikeBatsman = temp;
    }
}
