// Valid Sudoku

// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.

// My code: check row, col, boxes in N^2

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[][] checkSub = new HashSet[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                checkSub[i][j] = new HashSet<Character>();
            }
        }

        for(int i = 0; i < 9; i++){
            HashSet<Character> checkR = new HashSet<>();
            HashSet<Character> checkC = new HashSet<>();
            
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(!checkR.contains(board[i][j])){
                        checkR.add(board[i][j]);
                    }else{
                        return false;
                    }
                }

                if(board[j][i] != '.'){
                    if(!checkC.contains(board[j][i])){
                        checkC.add(board[j][i]);
                    }else{
                        return false;
                    }
                }

                if(board[i][j] != '.'){
                    if(!checkSub[i/3][j/3].contains(board[i][j])){
                        checkSub[i/3][j/3].add(board[i][j]);
                    }else{
                        return false;
                    }
                }
            }
        }

        return true;
    }
}


// Better way: set boxes into 1-dimensional and box[j/3 + (i/3)*3][curNumber] = 1;