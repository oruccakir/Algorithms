import java.util.HashSet;

public class MazeSolvingMultipleJump{

    public int [][] maze;
    public int dimension;
    public MazeSolvingMultipleJump(int maze[][],int dimension){
        this.maze = maze;
        this.dimension = dimension;
    }

    public boolean isSafe(int i,int j){
        return i>= 0 && i<dimension && j>=0 && j < dimension && maze[i][j] >= 1;
    }

    public HashSet<String> solveTheMaze(){
        HashSet<String> solutions = new HashSet<>();
        int sol[][] = new int[dimension][dimension];
        solveMazeUtil(0, 0, sol, solutions);
        return solutions;
    }

    public void printSolutions(HashSet<String> solutions){
        for (String sol : solutions)
            System.out.println(sol);
    }

    public boolean solveMazeUtil(int i,int j, int sol[][],HashSet<String> solutions){

        if(i == dimension -1 && j == dimension -1 && maze[i][j] >=0 ){
            sol[i][j] = 1;
            return true;
        }

        else if (isSafe(i, j)){

            sol[i][j] = 1;

            for(int k=1; k<= maze[i][j]; k++){

                if(solveMazeUtil(i, j+k, sol,solutions)){
                    solutions.add(giveSolutionAsString(sol));
                }
                if(solveMazeUtil(i+k, j, sol, solutions)){
                    solutions.add(giveSolutionAsString(sol));
                }

            }

            sol[i][j] = 0;
            
        }

        return false;

    }

    public String giveSolutionAsString(int sol[][]){

        StringBuilder str = new StringBuilder();

        for(int i=0; i<dimension; i++){
            for(int k=0; k<dimension; k++){
                if(k != dimension-1)
                    str.append(sol[i][k]+" ");
                else
                    str.append(sol[i][k]);
            }
            str.append("\n");
        }

        return str.toString();

    }



    public static void main(String[] args) {
        
        int maze[][] = {{2,1,0,0},{3,0,0,1},
        {0,1,0,1},{0,0,0,1}};

        MazeSolvingMultipleJump mz = new MazeSolvingMultipleJump(maze, maze.length);
        mz.printSolutions(mz.solveTheMaze());
        System.out.println(mz.solveTheMaze().size());


    }

}