package models;

import java.util.List;

import services.CLI;

public class Board {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int size) {
        this.size = size;
    }

    public boolean isWinner(int location) {
        return location == this.size;
    }

    public boolean isOutOfBound(int location) {
        return location > this.size;
    }

    public boolean insertSnake(int start, int end) {
        if(start <= end || isOutOfBound(start) || isOutOfBound(end)) {
            return false;
        }
        Snake newSnake = new Snake(start, end);
        snakes.add(newSnake);
        return true;
    }

    public boolean insertLadder(int start, int end) {
        if(start >= end || isOutOfBound(start) || isOutOfBound(end)) {
            return false;
        }
        Ladder newLadder = new Ladder(start, end);
        ladders.add(newLadder);
        return true;
    }

    public int getFinalLocation(int location) {
        CLI cli = CLI.getCli();
        int finalLocation = location;
        for (int i = 0; i < snakes.size(); i++) {
            if (snakes.get(i).getStart() == location) {
                cli.display("Oh no! You hit a snake. You will be moved to final location: " + snakes.get(i).getEnd());
                cli.display(null);
                finalLocation = this.getFinalLocation(snakes.get(i).getEnd());
            }
        }
        for (int i = 0; i < ladders.size(); i++) {
            if (ladders.get(i).getStart() == location) {
                cli.display("Wow! You got a ladder. You will be moved to final location: " + ladders.get(i).getEnd());
                cli.display(null);
                finalLocation = this.getFinalLocation(ladders.get(i).getEnd());
            }
        }
        return finalLocation;
    }
}
