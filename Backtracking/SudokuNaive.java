
import java.util.HashSet;

// Class to solve a Sudoku puzzle using a naive backtracking approach
public class SudokuNaive {

    public int[][] board; // The Sudoku board
    public int dim; // Dimension of the board (usually 9 for a 9x9 grid)
    public int box_dim; // Dimension of each small box (3 for a 9x9 grid, as it's 3x3)

    // Constructor for initializing the Sudoku solver with the Sudoku grid and its dimension
    public SudokuNaive(int board[][], int n) {
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
    public boolean solveUtil(int row, int col, HashSet<String> solutions) {
        // Check if we've reached the end of the board
        if (row == dim - 1 && col == dim)
            return true;

        // Move to the next row if we've reached the end of the current row
        if (col == dim) {
            row++;
            col = 0;
        }

        // If the current cell is not empty, move to the next cell
        if (board[row][col] != 0)
            return solveUtil(row, col + 1, solutions);

        // Try placing numbers 1 to dim in the current cell
        for (int num = 1; num <= dim; num++) {
            if (isSafe(row, col, num)) { // Check if it's safe to place the number
                board[row][col] = num;
                // Recursively proceed to fill in the rest of the board
                if (solveUtil(row, col + 1, solutions))
                    solutions.add(giveSolutionAsString(board)); // If solved, add to solution list
            }
            // Reset the current cell for backtracking
            board[row][col] = 0;
        }

        // Trigger backtracking
        return false;
    }

    // Method to solve the Sudoku puzzle and return all valid solutions
    public HashSet<String> solveSudoku() {
        HashSet<String> solutions = new HashSet<>();
        solveUtil(0, 0, solutions);
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

    // Main method for testing the solver
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
        SudokuNaive sd = new SudokuNaive(sudoku, sudoku.length);
        sd.printSolutions(sd.solveSudoku());
    }
}