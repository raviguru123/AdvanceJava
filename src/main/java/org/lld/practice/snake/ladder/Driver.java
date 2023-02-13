package org.lld.practice.snake.ladder;

import java.util.LinkedList;
import java.util.Queue;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        SpecialEntity snake1 = new Snake(12, 28);
        SpecialEntity snake2 = new Snake(34, 78);
        SpecialEntity snake3 = new Snake(6, 69);
        SpecialEntity snake4 = new Snake(65, 84);

        SpecialEntity ladder1 = new Ladder(24, 56);
        SpecialEntity ladder2 = new Ladder(43, 83);
        SpecialEntity ladder3 = new Ladder(3, 31);
        SpecialEntity ladder4 = new Ladder(72, 91);

        Board board = new Board(10);
        board.addSpecialEntity(snake1);
        board.addSpecialEntity(snake2);
        board.addSpecialEntity(snake3);
        board.addSpecialEntity(snake4);

        board.addSpecialEntity(ladder1);
        board.addSpecialEntity(ladder2);
        board.addSpecialEntity(ladder3);
        board.addSpecialEntity(ladder4);

        Dice dice = new Dice(6);
        Player player1 = new Player("p1");
        Player player2 = new Player("p2");
        Player player3 = new Player("p3");

        Queue<Player> playerQueue = new LinkedList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);

        Game game = new Game(playerQueue, board, dice);

        game.start();
    }
}
