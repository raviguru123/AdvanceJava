package org.lld.practice.snake.ladder;

import java.util.Queue;

public class Game {
    Queue<Player> playerQueue;
    Board board;
    Dice dice;
    GameStatus gameStatus;

    public Game(Queue playerQueue, Board board, Dice dice) {
        this.playerQueue = playerQueue;
        this.board = board;
        this.dice = dice;
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public void start() throws InterruptedException {
        while (playerQueue.size() > 1) {
            Player player = playerQueue.poll();
            System.out.print("Player Rolling the Dice : " + player.getName());
            int number = this.dice.roll();
            setPlayerPosition(player, number);
            if (!isWinner(player)) {
                playerQueue.add(player);
            }
            System.out.println("           Position : " + player.getPosition());
            Thread.sleep(1000);
        }
    }

    public void setPlayerPosition(Player player, int position) {
        if (player.getPosition() + position <= this.board.getTotalCells()) {
            player.setPosition(player.getPosition() + position);
            if (this.board.hasSpecialEntity(player.getPosition())) {
                SpecialEntity specialEntity = this.board.getSpecialEntity(player.getPosition());
                player.setPosition(specialEntity.getEnd());
            }
        }
    }

    public boolean isWinner(Player player) {
        if (player.getPosition() == this.board.getTotalCells()) {
            return true;
        }
        return false;
    }


}
