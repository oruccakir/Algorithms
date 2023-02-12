package Mathematics;

public class Mathematic {

    public static int iterativeCountDigits(int n){
        int num=0;                                 
        while( n > 0){                            // Time Complexity : O(log(n))
            n/=10;                                // Auxiliary Space : O(1)
            num++;
        }
        return num;
    }


    public static int recursiveCountDigits(int n){

        if(n < 10)
           return 1;                               // Time Complexity : O(log(n))  // Auxiliary Space : O(log(n))

        return recursiveCountDigits(n / 10)+1;
    }


    public static boolean checkPalindrome(int n){
        int reverse=0, temp=n;
        while(temp != 0){                        // Time Complexity : O(log(n)) 
            reverse=(reverse * 10)+temp % 10;    // Auxiliary Space : O(1)
            temp/=10;
        }
        return reverse==n;
    }


    public static boolean isPalindrome(int n){

        if(n<0 || (n%10 == 0 && n !=0))
           return false;

        int sample=0;                         // Time Complexity : O(log(n))  // Actually O(log(n)/2)                                           
        while(n > sample){                    // Auxiliary Space : O(1)
            sample = sample*10+n%10;
            n/=10;
        }

        if(n == sample) return true;
        if(sample / 10 == n) return true;

        return false;
    }


    public static int makeInteger(String str){

        int num=0, divisor=1;

        divisor=(int)Math.pow(10,str.length()-1);

        for(int i=0; i<str.length(); i++){             //  Time Complexity : O(str.length())
            num+=((int)str.charAt(i)-48)*divisor;      // Auxiliary Space : O(1)
            divisor/=10;
        }
        return num;
    }


    public static String makeString(int n){

        String str="";
        int numberOfdigit=0, divisor=1;

        numberOfdigit=(int)Math.log10(n);                // Time Complexity : O(log(n))   
        divisor=(int)Math.pow(10, numberOfdigit-1);   // Auxiliary Space : O(1)

        for(int i=0; i<numberOfdigit; i++){
            str+=n/divisor;
            n%=divisor;
            divisor/=10;
        }
        return str;
    }


    public static int iterativeFact(int n){
        int result=1;
        for(int i=2; i<=n; i++) result*=i;      // Time Complexity : O(n)
        return result;                          // Auxiliary Space : O(1)
    }


    public static int recursiveFact(int n){
        if(n==0) return 1;                     // Time Complexity : O(n)   
        return n*recursiveFact(n-1);           // Auxiliary Space : O(n)
    }


    public static int findTrailingZeros(int n){
        int count=0;
        for(int i=5; i<=n; i*=5) count+=n/i;    // Time Complexity : O(log(n))  
        return count;                           // Auxiliary Space : O(1)
    }


    public static int iterativeGcd(int a, int b){
        int result = Math.min(a, b);
        while(result>0){                                   // Time Complexity : O(min(a,b))
            if(a%result == 0 && b% result == 0) break;     // Auxiliary Space : O(1)
            result--;
        }
        return result;
    }


    public static int recursiveGcd(int a, int b){
        while(a != b){
            if(a > b) a=a-b;                            // Time Complexity : O(min(a,b))
            else b=b-a;                                 // Auxiliary Space : O(min(a,b))
        }
        return b;
    }


    public static int efficientGcd(int a, int b){
        if(b==0) return a;                           // Time Complexity : O(log(min(a,b)))
        return efficientGcd(b,a%b);                  // Auxiliary Space : O(log(min(a,b)))
    }


    public static void  main(String[] args) {
        
        System.out.println(efficientGcd(24, 8));

    }
    
}
