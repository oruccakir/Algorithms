package Recursion;
import java.util.ArrayList;
public class Recursion {

    public static int power (int x, int n){

        if(n==0) return 1;

        int temp = power(x,n/2);               // Time Complexity : O(log(n))
        temp*=temp;                            // Auxiliary Space : O(log2(n))
        if(n % 2 == 0) return temp;
        else return temp*x;
    }



    public static double myPower(int x, int n){

        if(n==0) return 1;                               // Time Complexity : O(log(n))

        if(n % 2 == 0) return myPower(x*x,n/2);          // Auxiliary Space : O(log2(n))

        else return (n > 0) ? x*myPower(x,n-1) : 1/(x*myPower(x,-n-1));
    }



    public static int log(int n){

        if(n==1) return 0;              // Time Complexity : O(log2(n)) 
        return 1+log(n/2);              // Auxiliary Space : O(log2(n))
    }



    public static void binary(int n){
        
        if(n==0) return;

        binary(n/2);                 // Time Complexity : O(log2(n))
        System.out.print(n%2);       // Auxiliary Space : O(log2(n))
    }



    public static int tailFact(int n, int k){

        if(n==0 || n==1) return k;           // Time Complexity : O(n)
        return tailFact(n-1,n*k);            // Auxiliary Space : O(n) 
    }



    public static boolean isPalindromeString(String str, int l, int r){

        if(l >= r) return true;                                       // Time Complexity : O(n)

        if(str.charAt(l) != str.charAt(r)) return false;              // Auxiliary Space : O(n) 

        return isPalindromeString(str, l+1, r-1);

    }



    public static boolean isPalindromeNumber(int n){

        if(n< 10) return true;

        if(n < 100){
            if(n/10 == n%10) return true;
            else return false;
        } 

        int first = n/((int)Math.pow(10,(int)Math.log10(n)));    // Time Complexity : O(log(n)) 
        int last = n%10;                                           // Auxiliary Space : O(log(n)) 

        if(first !=last) return false;

        n = n%((int)Math.pow(10,(int)Math.log10(n)))-(n%10);
        n/=10;
        return isPalindromeNumber(n);
    }



    public static int getSum(int n){

        if(n < 10) return n;             // Time Complexity : O(log(n)) 
        return n%10 + getSum(n/10);      // Auxiliary Space : O(log(n))
    }



    public static int max(int a, int b, int c){
        int max=0;
        if(a>=b && a>=c) max=a;
        else if (b>=a && b>=c) max=b;
        else max =c;
        return max;
    }




    public static int maxPieces(int n, int a, int b, int c){
        
        if(n==0) return 1;                                        // Time Complexity : O(3**n)
        if(n<0) return -1;                                        // Auxiliary Space : O(3**n)

        int sum=max(maxPieces(n-a, a, b, c),
        maxPieces(n-b, a, b, c),maxPieces(n-c, a, b, c));

        if(sum==-1) return -1;

        return sum+1;
    }



    public static void subsets(String s, String str, int i){

        if(i == s.length()){
            System.out.print(str+" ");
            return;
        }

        subsets(s, str, i+1);                             // Time Complexity : O(2**n)
        subsets(s, str+s.charAt(i), i+1);                 // Auxiliary Space : O(2**n)
    }



    public static void hanoi(int n, ArrayList<Integer> from, ArrayList<Integer> middle,ArrayList<Integer> to){

        if(n == 0) return;

        hanoi(n-1, from, to,middle);                         // Time Complexity : O(2**n)
        to.add(from.get(from.size()-1));                     // Auxiliary Space : O(n)                                                
        from.remove(from.size()-1);
        hanoi(n-1, middle,from,to);

    }



    public static void possibleWords(String []arr,String curr,ArrayList<String> set,int i, int k){
        
        if(i == arr.length){                                // Time Complexity : O(4**n * n)
            set.add(curr);                                  //  Auxiliary Space : O(n)
            return;
        }

        for(int m=k; m<arr[i].length(); m++)
           possibleWords(arr, curr+arr[i].charAt(m),set,i+1,k);

    }



    public static int josephus(int n, int k){

        if(n == 1) return 0;                              // Time Complexity : O(n)                              
        return (josephus(n-1, k)+k)%n;                    // Auxiliary Space : O(n)

    }



    public static int arraySubSum(int []arr,int n,int sum,int arrSum){

        if(n==0)
           return sum==arrSum ? 1 : 0;                                                          // Time Complexity : O(2**n) 
        return arraySubSum(arr, n-1,sum,arrSum)+arraySubSum(arr, n-1, sum, arrSum+arr[n-1]);    // Auxiliary Space : O(n)
    }



    public static void combination(String str, String curr, int n, String con){

        if(n==con.length()){                                                     // Time Complexity : O(n**n)
            System.out.print(curr+" ");                                          // Auxiliary Space : O(n)                                         
            return;
        }

        for(int i=0; i<str.length(); i++){
            combination(str.substring(0,i)+str.substring(i+1, str.length()),curr+str.charAt(i),n+1,con);
        }
    }



    public static boolean isLucky(int n, int divisor){

        if(divisor > n) return true;                               // Time Complexity : O(n**1/2)
        if(n % divisor == 0) return false;                         // Auxiliary Space : O(n**1/2) 

        return isLucky(n-n/divisor, divisor+1);
    }

}
