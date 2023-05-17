import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix{

    /*
     * Auxiliary Space : O(1)
     * 
     * Time Complexity : O(N*N)
     */

    public static void printSnake(int matrix[][]){

        for(int i=0; i<matrix.length; i++){

            if(i%2 == 0){

                for(int j=0; j<matrix[i].length; j++) System.out.print(matrix[i][j]+" ");

            }
            else{

                for(int j= matrix[i].length-1; j>=0; j--) System.out.print(matrix[i][j]+" ");

            }

            System.out.println();

        }

    }



    /*
     * Auxiliary Space : O(1)
     * 
     * Time Complexity : O(N)
     */

    public static void boundryTraversel(int matrix[][]){

        if(matrix.length == 1) for(int i=0; i<matrix[0].length; i++) System.out.print(matrix[0][i]);

        else if(matrix[0].length == 1) for(int i=0; i<matrix.length; i++) System.out.print(matrix[i][0]);

        else{

            for(int i=0; i<matrix[0].length; i++) System.out.print(matrix[0][i]);

            for(int i=1; i<matrix.length; i++) System.out.print(matrix[i][matrix[0].length-1]);

            for(int i=matrix[0].length-2; i>=0; i--) System.out.print(matrix[matrix.length-1][i]);

            for(int i=matrix.length-2; i>=1; i--) System.out.print(matrix[i][0]);

        }
            
    }



    /*
     * Auxiliary Space : O(N*N)
     * 
     * Time Complexity : O(N*N)
     */

    public static void transpose(int matrix[][],int n){

        int temp[][] = new int[n][n];

        for(int i=0; i<n; i++){

            for(int k=0; k<n; k++){

                temp[i][k] = matrix[k][i];

            }

        }

        for(int i=0; i<n; i++){

            for(int k=0; k<n; k++){

                matrix[i][k] = temp[i][k];

            }
            
        }

    }



    /*
     * Auxiliary Space : O(1)
     * 
     * Time Complexity : O(N*N)
     */

    public static void efficientTranspose(int matrix[][],int n){

        for(int i=0; i<n; i++){

            for(int k=i+1; k<n; k++){

                int temp = matrix[i][k];

                matrix[i][k] = matrix[k][i];

                matrix[k][i] = temp;

            }

        }

    }



    /*
     * Auxiliary Space : O(N*N)
     * 
     * Time Complexity : O(N*N)
     */

    public static void transpose90(int matrix[][],int n){

        int temp[][] = new int[n][n];

        for(int i=0; i<n; i++){

            for(int k=0; k<n; k++){

                temp[n-k-1][i] = matrix[i][k];

            }

        }

        for(int i=0; i<n; i++){

            for(int k=0; k<n; k++){

                matrix[i][k] = temp[i][k];

            }

        }

    }



    /*
     * Auxiliary Space : O(1)
     * 
     * Time Complexity : O(N)
     */

    public static void reverse(int arr[]){

        for(int i=0; i<arr.length/2; i++){

            int temp = arr[i];

            arr[i] = arr[arr.length-1-i];

            arr[arr.length-1-i] = temp;

        }

    }



    /*
     * Auxiliary Space : O(1)
     * 
     * Time Complexity : O(N*N)
     */

    public static void transpose90(int matrix[][]){

        for(int i=0; i<matrix.length; i++) reverse(matrix[i]);

        efficientTranspose(matrix, matrix.length);

    }



    /*
     * Auxiliary Space : O(1)
     * 
     * Time Complexity : O(N*N)
     */

    public static void efficientTranspose90(int matrix[][],int n){

        for(int i=0; i<n/2; i++){

            for(int k=i; k<n-i-1; k++){

                int temp = matrix[i][k];

                matrix[i][k] = matrix[k][n-1-i];

                matrix[k][n-1-i] = matrix[n-1-i][n-1-k];

                matrix[n-1-i][n-1-k] = matrix[n-1-k][i];

                matrix[n-1-k][i] = temp;

            }

        }

    }



    /*
     * Auxiliary Space : O(1)
     * 
     * Time Complexity : O(N*N)
     */

    public static void interchangeRows(int matrix[][]){

        for(int i=0; i<matrix[0].length; i++){

            int high = 0, below = matrix.length-1;

            while(high <= below){

                int temp = matrix[high][i];
                
                matrix[high][i] = matrix[below][i];

                matrix[below][i] = temp;

            }

        }

    }



    /*
     * Auxiliary Space : O(1)
     * 
     * Time Complexity : O(N*logM)
     */

    public static boolean matrixSearch(int matrix[][],int x){

        for(int i=0; i<matrix.length; i++){

            if(Arrays.binarySearch(matrix[i],x) != -1) return true;

        }

        return false;

    }



    /*
     * Auxiliary Space : O(1)
     * 
     * Time Complexity : O(N + M)
     * 
     * this is valid for sorted matrix
     */

    public static boolean efficientMatrixSearch(int matrix[][],int x){

        int i= matrix.length-1, k=0;

        while(i>=0 && k<matrix[0].length){

            if(matrix[i][k] == x) return true;

            if(matrix[i][k]>x) i--;

            else k++;

        }

        return false;

    }



    /*
     * Auxiliary Space : O(1)
     * 
     * Time Complexity : O(N *N )
     */

    public static void sumTriangles(int arr[][],int n){

        int upper = 0, below = 0;

        for(int i=0; i<n; i++){

            for(int k=i; k<n; k++){

                upper += arr[i][k];

            }

        }

        for(int k=0; k<n; k++){

            for(int i=k; i<n; i++){

                below += arr[i][k];

            }

        }

        System.out.println("Upper : "+upper+" Below : "+below);

    }



    /*
     * Auxiliary Space : O(R + c)
     * 
     * Time Complexity : O(R*C)
     */

    public static void booleanMatrix(int matrix[][]){

        int r = matrix.length, c = matrix[0].length;

        int rows[] = new int[r], cols[] = new int[c];

        for(int i=0; i<r; i++){

            for(int k=0; k<c; k++){

                rows[i] = 1;

                cols[k] = 1;

            }

        }

        for(int i=0; i<r; i++){

            for(int k=0; k<c; k++){

                if(rows[i] == 1 || cols[k] == 1) matrix[i][k] = 1;

            }

        }

    }



    /*
     * Auxiliary Space : O(N)
     * 
     * Time Complexity : O(N*N)
     */

    public static int findMınOperation(int matrix[][],int n){

        int[] rowSum = new int[n];

        int maxRowSum = Integer.MIN_VALUE, maxColSum = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){

            int sumRow =0, sumCol = 0;

            for(int k=0; k<n; k++){

                sumRow += matrix[i][k];

                sumCol += matrix[k][i];

            }

            rowSum[i] = sumRow;

            maxRowSum = Math.max(maxRowSum, sumRow);

            maxColSum = Math.max(maxColSum, sumCol);

        }

        int maxSum = Math.max(maxRowSum, maxColSum);

        int operation = 0;

        for(int i=0; i<n; i++) operation +=maxSum-rowSum[i];

        return operation;

    }



    /*
     * Auxiliary Space : O(R*c)
     * 
     * Time Complexity : O(R*C)
     */

    public static ArrayList<Integer> spiralTraverse(int arr[][],int r,int c){

        ArrayList<Integer> output = new ArrayList<>();

        int row = 0, col = 0;

        while(row < r && col <c){

            for(int i=col; i<c; i++) output.add(arr[row][i]);

            row++;

            for(int i=row; i<r; i++) output.add(arr[i][c-1]);

            c--;

            if(row < r) { for(int i=c-1; i>=col; i--) output.add(arr[r-1][i]);  r--; }
            
            if(col < c) {for(int i=r-1; i>=row; i--) output.add(arr[i][col]);  col++; }

        }

        return output;

    }



    /*
     * Auxiliary Space : O(N)
     * 
     * Time Complexity : O(N)
     */

    public static List<Integer> spiralOrder(int matrix[][]){

        List<Integer> ans = new ArrayList<>();

        if(matrix.length == 0) return ans;

        int m = matrix.length, n= matrix[0].length;

        int dr[] = {0,1,0,-1}, dc []= {1,0,-1,0};

        int x = 0, y=0, di = 0;

        boolean[][] seen = new boolean[m][n];

        for(int i=0; i<m*n; i++){

            ans.add(matrix[x][y]);

            seen[x][y] = true;

            int cr = x + dr[di];

            int cc = y + dc[di];

            if(cr>=0 && cr<m && cc>=0 && cc<n && !seen[cr][cc]){

                x = cr;
                y = cc;

            }
            else{

                di = (di+1)%4;
                x += dr[di];
                y += dc[di];

            }

        }

        return ans;
        
    }



    /*
     * Auxiliary Space : O(N + M)
     * 
     * Time Complexity : O(N + M)
     */

    public static void search(int arr[][],int row,int col,int goal){

        if(row < arr.length && col >=0){

            if(arr[row][col] == goal) System.out.println(row+" "+col);

            else if(arr[row][col] > goal) search(arr,row,col-1,goal);

            else search(arr, row+1, col, goal);

        }

        else System.out.println("Not found");

    }



    /*
     * Auxiliary Space : O(N + M)
     * 
     * Time Complexity : O(N + M)
     */

    public static int[] merge(int left[], int right[]){

        int n1 = left.length, n2 = right.length, i=0, j=0, k=0;

        int arr[] = new int[n1+n2];

        while(i < n1 && j < n2){

            if(left[i]<=right[j]) { arr[k] = left[i]; i++; k++;}

            else { arr[k] = right[j]; j++; k++; }

        }

        while(i<n1) { arr[k] = left[i]; i++; k++; }

        while(j<n2) { arr[k] = right[j]; j++; k++; }

        return arr;

    }



    /*
     * Auxiliary Space : O(N * M)
     * 
     * Time Complexity : O(M)
     * 
     * N : number of columns M : number of rows
     */

    public static int medRowSorted(int matrix[][],int row, int arr[]){

        if(row == arr.length) return arr[arr.length/2];

        arr = merge(arr, matrix[row]);

        return medRowSorted(matrix, row+1, arr);

    }



    /*
     * Auxiliary Space : O(1)
     * 
     * Time Complexity : O(r * log(max - min) * logc)
     */

    public static int matrixMedian(int matrix[][], int r,int c){

        int min = matrix[0][0], max = matrix[0][c-1];

        for(int i=1; i<r; i++){

            max = Math.max(max, matrix[i][c-1]);

            min = Math.min(min,matrix[i][0]);

        }

        int medianPosition = (r*c +1)/2;

        while(min < max){

            int mid = (max + min) / 2, midPosition = 0;

            for(int i=0; i<r; i++) midPosition = upperBound(matrix[i],mid);

            if(midPosition < medianPosition) min = mid+1;

            else max = mid;

        }

        return min;

    }



    /*
     * Auxiliary Space : O(logN)
     * 
     * Time Complexity : O(1)
     */

    public static int upperBound(int arr[], int goal){

        int left =0, right = arr.length-1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(arr[mid] == goal) return mid;

            else if(arr[mid] < goal){

                if(mid == arr.length -1) return mid;

                if(arr[mid + 1] >= goal) return mid+1;

                left = mid+1;

            }

            else{

                if(mid == 0) return mid;

                if(arr[mid - 1] <= goal) return mid+1;

                right = mid-1;

            }

        }

        return -1;
    }



    

    

    







    




    
    

    

    

    

































    public static void main(String[] args) {
        
    }

}