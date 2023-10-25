package org.developx.clean_code.part2_의미_있는_이름;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BoardGame {

    private final List<Cell> gameBoard;
    public BoardGame(int maxX, int maxY, int bombCount) {
        gameBoard = new ArrayList<>();
        IntStream.of(maxX).forEach(x -> {
            IntStream.of(maxY).forEach(y -> {
                gameBoard.add(new Cell(x, y, CellState.BOMB));
            });
        });

    }

    public List<Cell> getFlaggedCell() {
        List<Cell> flaggedCells = new ArrayList<>();
        for (Cell cell : gameBoard) {
            if (cell.isFlag()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }


    private static class Cell {

        private final int x;
        private final int y;
        private CellState state;

        public Cell(int x, int y, CellState state) {
            this.x = x;
            this.y = y;
            this.state = state;
        }

        public boolean isFlag() {
            return state == CellState.BOMB;
        }
    }

    private static enum CellState{
        NONE, OPEN, BOMB
    }
}
