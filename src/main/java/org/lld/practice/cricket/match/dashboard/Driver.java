package org.lld.practice.cricket.match.dashboard;

import java.util.Map;

public class Driver {
    public static void main(String[] args) throws Exception {
        BattingTeam team1 = new BattingTeam("team1");
        team1.addPlayer(new Batsman("p1"));
        team1.addPlayer(new Batsman("p2"));
        team1.addPlayer(new Batsman("p3"));
        team1.addPlayer(new Batsman("p4"));
        team1.addPlayer(new Batsman("p5"));

        BattingTeam team2 = new BattingTeam("team2");
        team2.addPlayer(new Batsman("p6"));
        team2.addPlayer(new Batsman("p7"));
        team2.addPlayer(new Batsman("p8"));
        team2.addPlayer(new Batsman("p9"));
        team2.addPlayer(new Batsman("p10"));

        CricketMatch cricketMatch = new CricketMatch(2, 5, team1, team2);
        cricketMatch.start();


        Over over1 = new Over(new Bowler());
        over1.addBalls(new Balls(Balls.BallType.RIGHT, 1));
        over1.addBalls(new Balls(Balls.BallType.RIGHT, 1));
        over1.addBalls(new Balls(Balls.BallType.RIGHT, 1));
        over1.addBalls(new Balls(Balls.BallType.RIGHT, 1));
        over1.addBalls(new Balls(Balls.BallType.RIGHT, 1));
        over1.addBalls(new Balls(Balls.BallType.RIGHT, 2));

        cricketMatch.addOver(over1);

        Over over2 = new Over(new Bowler());
        over2.addBalls(new Balls(Balls.BallType.W, 0));
        over2.addBalls(new Balls(Balls.BallType.RIGHT, 4));
        over2.addBalls(new Balls(Balls.BallType.RIGHT, 4));
        over2.addBalls(new Balls(Balls.BallType.WD, 1));
        over2.addBalls(new Balls(Balls.BallType.W, 0));
        over2.addBalls(new Balls(Balls.BallType.RIGHT, 1));
        over2.addBalls(new Balls(Balls.BallType.RIGHT, 6));

        cricketMatch.addOver(over2);


        Over over3 = new Over(new Bowler());
        over3.addBalls(new Balls(Balls.BallType.RIGHT, 4));
        over3.addBalls(new Balls(Balls.BallType.RIGHT, 6));
        over3.addBalls(new Balls(Balls.BallType.W, 0));
        over3.addBalls(new Balls(Balls.BallType.W, 0));
        over3.addBalls(new Balls(Balls.BallType.RIGHT, 1));
        over3.addBalls(new Balls(Balls.BallType.RIGHT, 1));

        cricketMatch.addOver(over3);

        Over over4 = new Over(new Bowler());

        over4.addBalls(new Balls(Balls.BallType.RIGHT, 6));
        over4.addBalls(new Balls(Balls.BallType.RIGHT, 1));
        over4.addBalls(new Balls(Balls.BallType.W, 0));
        over4.addBalls(new Balls(Balls.BallType.W, 0));
//        over4.addBalls(new Balls(Balls.BallType.RIGHT, 4));
//        over4.addBalls(new Balls(Balls.BallType.RIGHT, 4));
//        over4.addBalls(new Balls(Balls.BallType.WD, 1));
//        over4.addBalls(new Balls(Balls.BallType.W, 0));
//        over4.addBalls(new Balls(Balls.BallType.RIGHT, 1));
//        over4.addBalls(new Balls(Balls.BallType.RIGHT, 6));

        cricketMatch.addOver(over4);

        System.out.println("<====== end =======>");
        System.out.println("<====== end =======>");
        System.out.println("<====== end =======>");
    }
}
