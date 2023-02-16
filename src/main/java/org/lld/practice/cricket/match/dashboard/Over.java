package org.lld.practice.cricket.match.dashboard;

import org.lld.practice.cricket.match.dashboard.exception.InvalidOverException;

import java.util.ArrayList;
import java.util.List;

public class Over {
    List<Balls> ballsList;
    Bowler bowler;
    int total_balls = 6;

    public Over(Bowler bowler) {
        this.bowler = bowler;
        this.ballsList = new ArrayList<>();
    }

    public void addBalls(Balls balls) throws Exception {
//        if (this.ballsList.size() == total_balls) {
//            throw new InvalidOverException("Over is full");
//        }
        this.ballsList.add(balls);
    }
}
