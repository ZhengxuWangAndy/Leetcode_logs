
// Sudoku Solver

// Write a program to solve a Sudoku puzzle by filling the empty cells.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.
// It is guaranteed that the input board has only one solution.



// DFS - recursion + back tracking
class Solution {
    boolean[][] line = new boolean[9][9]; //record every row's number, if 2 showed in line 1, set line[0][1] = true;
    boolean[][] column = new boolean[9][9]; // same as line, records column
    boolean[][][] block = new boolean[3][3][9]; //records 9 sub-matrix
    boolean valid = false; // whether a valid sudoku
    List<int[]> spaces = new ArrayList<>(); // save all empty spaces

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.'){
                    spaces.add(new int[]{i,j});
                } 
                else{
                    int digit = board[i][j] - '0'; // convert character to number
                    line[i][digit - 1] = column[j][digit - 1] = block[i/3][j/3][digit - 1] = true; // record this number in 3 boolean variables
                }
            }
        }

        // recursion + back tracking
        dfs(board, 0);

    }

    public void dfs(char[][] board, int pos) {

        // if until the last pos is still avaliable, return;
        if (pos == spaces.size()){
            valid = true;
            return;
        }

        int[] space = spaces.get(pos); // get the coordinates i,j
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; digit++) {
            // if never showed in records
            if (!line[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]){
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1); // fill in the number
                dfs(board, pos + 1); // recursion from next space
                // if not valid change it back to false, dfs will end beacuse there is no number can be filled, so set back to previous state, and search from next valid number
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = false;
            }
        }
    }
}


// optime solution: 

// use binary code to record true/false in one integer like 011000000 means 7th 8th are true
// expression 1 << digit creates an integer with only the digit-th bit set to 1, while all other bits are 0.
// ^= is a bitwise XOR assignment operator.
// line[i] ^= (1 << digit); use this to change the true/false

// if the space have only one avaliable value, it can be filled before recursion.