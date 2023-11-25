import java.util.HashSet;

public class Nqueen {

    public int n=0;
    public int[][] board;

    public Nqueen(int n){
        this.n = n;
        this.board = new int[n][n];
    }

    public boolean isSafe(int row,int col){

        for(int i=0; i<col; i++)
            if(board[row][i] == 1)
                return false;
        
        for(int i=row, j=col; i>=0 && j>=0; i--,j--)
            if(board[i][j] == 1)
                return false;
        
        for(int i=row, j=col; j>=0 &&  i<n; i++, j--)
            if(board[i][j] == 1)
                return false;
        
        return true;

    }

    public HashSet<String> solve(){
        HashSet<String> solutions = new HashSet<>();
        solveUtil(0, solutions);
        return solutions;
    }

    public boolean solveUtil(int col,HashSet<String> solutions){

        if(col == n)
            return true;
        
        for(int i=0; i<n; i++){

            if(isSafe(i, col)){

                board[i][col] = 1;

                if(solveUtil(col+1, solutions))
                    solutions.add(giveSolutionAsString(board));
                
                board[i][col] = 0;
                    
            }

        }

        return false;

    }

    public String giveSolutionAsString(int sol[][]){

        StringBuilder str = new StringBuilder();

        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++){
                if(k != n-1)
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
        
        Nqueen queen = new Nqueen(6);
        queen.printSolutions(queen.solve());
        
    }
    
}
