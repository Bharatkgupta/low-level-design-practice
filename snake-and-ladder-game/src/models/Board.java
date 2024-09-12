package models;

import java.util.List;

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

    public void insertSnake(int start, int end) {
        Snake newSnake = new Snake(start, end);
        snakes.add(newSnake);
    }

    public void insertLadder(int start, int end) {
        Ladder newLadder = new Ladder(start, end);
        ladders.add(newLadder);
    }

    public int getFinalLocation(int location) {
        int finalLocation = location;
        for (int i = 0; i < snakes.size(); i++) {
            if (snakes.get(i).getStart() == location) {
                finalLocation = this.getFinalLocation(snakes.get(i).getEnd());
            }
        }
        for (int i = 0; i < ladders.size(); i++) {
            if (ladders.get(i).getStart() == location) {
                finalLocation = this.getFinalLocation(ladders.get(i).getEnd());
            }
        }
        return finalLocation;
    }
}
