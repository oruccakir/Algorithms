import java.util.HashMap;

import javax.print.DocFlavor.INPUT_STREAM;

public class MazeSolving{


    static int N; 
  
    static void printSolution(int sol[][]) 
    { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print( " " + sol[i][j] + " "); 
            System.out.println(); 
        } 

        System.out.println();
    } 
  
    static boolean isSafe( int maze[][], int i, int j) 
    { 
        return (i < N && j < N && i>=0 && j >=0 && maze[i][j] == 1); 
    } 

    public static int countTheWay(int sol[][]){

        int count = 0;

        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                if (sol[i][j] == 1)
                    count++;
        }

        return count;

    }

    public static int[][] copyTheMatrix(int sol[][]){
        int copy[][] = new int [N][N];
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                copy[i][j] = sol[i][j];
        }

        return copy;
    }
  
    static boolean solveMaze(int maze[][]) 
    { 
        int sol[][] = new int[N][N]; 

        HashMap<int [][],Integer> map = new HashMap<>();
  
        solveMazeRec(maze, 0, 0, sol,map);
        
        if (map.size() == 0) { 
            System.out.print("Solution doesn't exist"); 
            return false; 
        } 

        int min = Integer.MAX_VALUE;

        for (int arr[][] : map.keySet()){
            printSolution(arr);
            if (map.get(arr) <= min){
                min = map.get(arr);
                sol = arr;
            }
                
        }
            
        System.out.println("Final");
        printSolution(sol);
        
        return true; 
    } 
  
    static boolean solveMazeRec(int maze[][], int i, int j, int sol[][], HashMap<int[][],Integer> map) 
    {  
        if (i == N - 1 && j == N - 1 && maze[i][j] == 1) { 
            sol[i][j] = 1; 
            return true; 
        } 
  
        if (isSafe(maze, i, j) == true) {  
            sol[i][j] = 1; 
  
            if (solveMazeRec(maze, i + 1, j, sol,map)){
                map.put(copyTheMatrix(sol) ,countTheWay(sol));
            }
        
            
            if (solveMazeRec(maze, i, j + 1, sol,map)) {
                map.put(copyTheMatrix(sol),countTheWay(sol));
            }

            
            
            sol[i][j] = 0; 
                
        } 
  
        return false; 
    } 
    
    public static void main(String args[])
    {

        

        int maze[][] = { { 1, 1, 1, 1 }, 
                         { 1, 1, 0, 1 }, 
                         { 1, 1, 1, 1 }, 
                         { 1, 1, 1, 1 } }; 
  
        N = maze.length; 
        solveMaze(maze); 
    }

}