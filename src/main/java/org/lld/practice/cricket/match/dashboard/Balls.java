package org.lld.practice.cricket.match.dashboard;

public class Balls {
    BallType ballType;
    int speed;
    int run;

    enum BallType {
        WD, W, NO, RIGHT
    }

    public Balls(BallType ballType, int run) {
        this.ballType = ballType;
        this.run = run;
        this.speed = 0;
    }
}
