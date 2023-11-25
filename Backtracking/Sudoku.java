import java.util.HashSet;

public class Sudoku {
    
    public int[][] board; // The Sudoku board
    public int dim; // Dimension of the board (usually 9 for a 9x9 grid)
    public int box_dim; // Dimension of each small box (3 for a 9x9 grid, as it's 3x3)

    // Constructor for initializing the Sudoku solver with the Sudoku grid and its dimension
    public Sudoku(int board[][], int n) {
        this.board = board;
        this.dim = n;
        this.box_dim = (int) Math.sqrt(dim); // Calculate box dimension based on the dimension of the board
    }

    // Method to check if it's safe to place 'num' at position (row, col)
    public boolean isSafe(int row, int col, int num) {
        // Check the row for the same number
        for (int i = 0; i < dim; i++)
            if (board[row][i] == num)
                return false;

        // Check the column for the same number
        for (int i = 0; i < dim; i++)
            if (board[i][col] == num)
                return false;

        // Calculate the starting row and column for the 3x3 sub-grid
        int start_row = row - row % box_dim, start_col = col - col % box_dim;

        // Check the 3x3 box for the same number
        for (int i = 0; i < box_dim; i++) {
            for (int j = 0; j < box_dim; j++) {
                if (board[i + start_row][j + start_col] == num)
                    return false;
            }
        }

        // If no conflicts are found, it's safe to place the number
        return true;
    }


    // Utility recursive method used by 'solveSudoku' to find a solution
    public boolean solveUtil(HashSet<String> solutions) {

        // Initialize variables to store the row and column of the empty cell.
        // An empty cell will be marked as '0'.
        int row = -1;
        int col = -1;
        // Flag to check if the board still has any empty cells left.
        boolean isEmpty = true;

        // Loop through the board to find an empty cell.
        for(int i = 0; i < dim && isEmpty; i++){
            for(int k = 0; k < dim && isEmpty; k++){
                // If an empty cell is found, update row and col variables.
                if(board[i][k] == 0){
                    row = i;
                    col = k;
                    // Since we found an empty cell, set isEmpty to false.
                    isEmpty = false;
                }
            }
        }

        // If there are no empty cells left, sudoku is solved; return true.
        if(isEmpty) {
            return true;
        }
        
        // Try placing numbers 1 to dim (dimension of the board) in the found empty cell.
        for(int num = 1; num <= dim; num++){

            // Check if placing num in cell [row, col] is a safe move.
            if(isSafe(row, col, num)){

                // Place the number in the cell since it's safe.
                board[row][col] = num;

                // Continue with this setup to see if a solution can be reached.
                if(solveUtil(solutions)) {
                    // If a solution is found, add it to the set of solutions.
                    solutions.add(giveSolutionAsString(board));
                }
                
                // Reset the cell for backtracking since we need to
                // explore other possibilities or the previous placement
                // did not lead to a solution.
                board[row][col] = 0;
            }
        }

        // No solution is found; return false to trigger backtracking.
        return false;
    }


    // Method to solve the Sudoku puzzle and return all valid solutions
    public HashSet<String> solveSudoku() {
        HashSet<String> solutions = new HashSet<>();
        solveUtil(solutions);
        return solutions;
    }

    // Helper method to convert the current board state to a string representation
    public String giveSolutionAsString(int sol[][]) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < dim; i++) {
            for (int k = 0; k < dim; k++) {
                str.append(sol[i][k]).append((k != dim - 1) ? " " : "");
            }
            str.append("\n");
        }
        return str.toString();
    }

    // Prints all the solutions
    public void printSolutions(HashSet<String> solutions) {
        for (String sol : solutions)
            System.out.println(sol);
    }

    public static void main(String[] args) {

        // Define a Sudoku puzzle with some pre-filled values
        int[][] sudoku = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
        { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
        { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
        { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
        { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
        { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
        { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        // Initialize the Sudoku solver with the grid and its size, and print the solutions
        Sudoku sd = new Sudoku(sudoku, sudoku.length);
        sd.printSolutions(sd.solveSudoku());

        // Define a Sudoku puzzle with some pre-filled values
        int[][] sudoku1 = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        // Initialize the Sudoku solver with the grid and its size, and print the solutions
        Sudoku sd1 = new Sudoku(sudoku1, sudoku1.length);
        sd1.printSolutions(sd1.solveSudoku());
        
    }

}
