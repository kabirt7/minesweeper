package minesweeper;

import java.util.Random;

public class Grid {

    private int length;
    private int width;
    private Cell[][] grid;
    public boolean game_over;
    private int[][] tmp;

    public Grid(int length, int width) {
        this.length = length;
        this.width = width;
        this.grid = new Cell[this.length][this.width];
        this.game_over = false;
        this.tmp = new int[10][2];
        initializeGridWithCells();
        initializeTmpCoordinates();
        addMines();
        initializeMineVicinityNumbers();
    }

    public void initializeGridWithCells() {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                this.grid[i][j] = new Cell();
            }
        }
    }

    public void initializeTmpCoordinates() {
        for (int i = 0; i < this.tmp.length; i++) {
            this.tmp[i][0] = -1;  
            this.tmp[i][1] = -1;
        }
    }

    public void addMines() {
        Random random = new Random();
        int counter = 0;

        while (counter < 10) {
            int randomRow = random.nextInt(10);
            int randomColumn = random.nextInt(10);

            // check if coordinates are already present
            boolean found = false;
            for (int i = 0; i < counter; i++) {
                if (tmp[i][0] == randomRow && tmp[i][1] == randomColumn) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                tmp[counter][0] = randomRow;
                tmp[counter][1] = randomColumn;
                counter++;
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            int row = tmp[i][0];
            int column = tmp[i][1];

            this.grid[row][column].makeMine();
        }
    }

    
    public void initializeMineVicinityNumbers() {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                int totalMines = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    if (k < 0 || k >= this.length) continue;
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (l < 0 || l >= this.width) continue;
                        if (k == i && l == j) continue;  // skip the center cell
                        if (this.grid[k][l].checkIfMine()) {
                            totalMines++;
                        }
                    }
                }

                this.grid[i][j].setMinesInVicinity(totalMines);
            }
        }
    }



    public Cell getCell(int row, int column) {
        return this.grid[row][column];
    }

    public void printGrid() {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                this.grid[i][j].printCell();
            }
            System.out.println();
        }
    }
    
    public void revealVicinity(int a, int b) {
        for (int i = a - 1; i <= a + 1; i++) {
            if (i < 0 || i > 9) continue;

            for (int j = b - 1; j <= b + 1; j++) {
                if (j < 0 || j > 9) continue;

                this.grid[i][j].revealCell();
            }
        }
    }

//    public void recursiveFunction(int a, int b) {
//
//
//        if (this.grid[a][b].getMinesInVicinity() == 0) {
//
//            revealVicinity(a, b);
//
//
//            for (int i = a - 1; i <= a + 1; i++) {
//                for (int j = b - 1; j <= b + 1; j++) {
//                    if (i == a && j == b) {
//                        continue;
//                    }
//                    recursiveFunction(i, j);
//                }
//            }
//        }
//    }



}