import java.util.HashSet;

public class SudokuNaive {

    public int [][] board;
    public int dim;
    public int box_dim;

    public SudokuNaive(int board[][],int n){
        this.board = board;
        this.dim = n;
        this.box_dim = (int)Math.sqrt(dim);
    }

    public boolean isSafe(int row,int col,int num){

        for(int i=0; i<dim; i++)
            if(board[row][i] == num)
                return false;
        
        for(int i=0; i<dim; i++)
            if(board[i][col] == num)
                return false;
            
        int start_row = row - row % box_dim, start_col = col - col % box_dim;

        for(int i=0; i<box_dim; i++){
            for(int j=0; j<box_dim; j++){
                if(board[i+start_row][j+start_col] == num)
                    return false;
            }
        }
        
        return true;

    }

    public boolean solveUtil(int row,int col,HashSet<String> solutions){

        if(row == dim -1 && col == dim)
            return true;
        
        if(col == dim ){
            row++;
            col = 0;
        }

        if(board[row][col] != 0)
            return solveUtil(row, col+1,solutions);
        
        for(int num = 1; num<= dim; num++){

            if(isSafe(row, col, num)){

                board[row][col] = num;

                if(solveUtil(row, col+1, solutions))
                    solutions.add(giveSolutionAsString(board));

            }

            board[row][col] = 0;

        }

        return false;

    }

    public HashSet<String> solveSudoku(){
        HashSet<String> solutions = new HashSet<>();
        solveUtil(0,0, solutions);
        return solutions;
    }


    public String giveSolutionAsString(int sol[][]){

        StringBuilder str = new StringBuilder();

        for(int i=0; i<dim; i++){
            for(int k=0; k<dim; k++){
                if(k != dim-1)
                    str.append(sol[i][k]+" ");
                else
                    str.append(sol[i][k]);
            }
            str.append("\n");
        }

        return str.toString();

    }

    public void printSolutions(HashSet<String> solutions){
        for (String sol : solutions)
            System.out.println(sol);
    }

    public static void main(String[] args) {
        
        int [][]sudoku = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
        { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
        { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
        { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
        { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
        { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
        { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        SudokuNaive sd = new SudokuNaive(sudoku, sudoku.length);
        sd.printSolutions(sd.solveSudoku());

        int [][]sudoku1 = {{3, 6, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        System.out.println();

        SudokuNaive sd1 = new SudokuNaive(sudoku1, sudoku1.length);
        sd1.printSolutions(sd1.solveSudoku());



    }


    
}
