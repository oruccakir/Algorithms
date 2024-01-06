import java.util.Scanner;

public class Question1{

     public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Read input
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        short[][] image = new short[N][M];
        
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                image[i][j] = scanner.nextShort();
            }
        }
        
        
        // Process the image
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (image[i][j] % 256 == 23) {
                    if(isValid(image,i,j,23))
                        image[i][j] = 35 * 256 + 23;
                        
                } else if (image[i][j] % 256 == 35) {
                    if(isValid(image,i,j,35))
                        image[i][j] = 23 * 256 + 35;
                }
                
                if(image[i][j] / 256 == 0)
                    System.out.print((image[i][j]) + " ");
                else
                    System.out.print((image[i][j] / 256 ) + " ");
                
            }
            System.out.println();
        }
        
    }
    
    public static boolean isValid(short [][]board,int row,int col,int target){

        int count = 0;

        // Check in the 8 neighboring cells
        for (int i = -1; i <= 1; i++) {
            int newRow = row + i;
            for (int j = -1; j <= 1; j++) {
                int newCol = col + j;
                
                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {

                    if (board[newRow][newCol] % 256 == target) {
                        count++;
                    }

                }
            }
        }

        return count == 1;
        
    }
    

}