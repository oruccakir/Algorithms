public class Counting {

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4};
        int n = 5;
        int dpMem[] = new int[n+1];
        boolean control[] = new boolean[n+1];
        for(int i=0; i<=n; i++)
            dpMem[i] = -1;
        System.out.println(countWays(arr, arr.length, 5));
        System.out.println(countWaysDp(arr, arr.length, 5));
        //System.out.println(count_solve(n));

    }

    public static int solve(int n,int arr[],int dpMem[],boolean control[]){

        if(n<0)
            return 0;
        if(n==0)
            return 1;
        
        
        if(control[n])
            return 0;
        else{
            int res = 0;
            for(int i=0; i<arr.length; i++){
                res+= solve(n-arr[i], arr,dpMem,control);
            }   
            control[n] = true;
            dpMem[n] = res;
        }

        
        return dpMem[n];
        }

    public static int count_solve(int n){

        if(n<0)
            return 0;
        if(n==0)
            return 1;
        
        int res = 0;
        for(int i=1; i<n; i++)
            res += count_solve(n-i);

        return res;
    }

    public static int countWays(int coins[],int n,int sum){

        if(sum < 0 || n == 0)
            return 0;
        else if(sum == 0)
            return 1;
        
        return countWays(coins, n, sum-coins[n-1]) + countWays(coins, n-1, sum);

    }

    public static int countWaysDp(int coins[],int n,int sum){

        int DP[][] = new int[n+1][sum+1];

        for(int i=0; i<=n; i++)
            DP[i][0] = 1;
        
        for(int i=1; i<=sum; i++)
            DP[0][i] = 0;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                DP[i][j] = DP[i-1][j];
                if(j >= coins[i-1])
                    DP[i][j] += DP[i][j-coins[i-1]];
            }
        }

        return DP[n][sum];
    }
        
}
