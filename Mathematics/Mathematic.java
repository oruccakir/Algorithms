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


    public static int lcm(int a, int b){
        int result=Math.max(a, b);
        boolean is=false;
        while(!is){
            if(result % a == 0 && result % b ==0){       // Time Complexity : O(a*b-max(a,b))
                is=true;                                 // Auxiliary Space : O(1)
                break;
            } 
            result++;
        }
        return result;
    }


    public static int efficientLcm(int a, int b){       // Time Complexity : O(log(min(a,b)))
        return a*b/efficientGcd(a, b);                  // Auxiliary Space : O(log(min(a,b)))              
    }


    public static int exactly3Divisors(int n){
        int count=0;
        for(int i=2; i*i<=n; i++){
            boolean is=true;
            
            for(int k=2; k*k<i && is; k++)              // Time Complexity : O(n**1/2 * n**1/4)
                if(i % k == 0) is = false;              // Auxiliary Space : O(1) 
            
            if(is) count++;    
        }
        return count;
    }


    public static int digitsInFactorial(int n){
        double num=0;
        for(int i=2; i<=n; i++){                        // Time Complexity : O(n)
            num+=Math.log10(i);                         // Auxiliary Space : O(1)
        }
        return (int)num+1;
    }


    public static boolean isPrime(int n){
        if(n == 1 || n == 0) return false;
        if(n == 2 || n == 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;                // Time Complexity : O(n**1/2)
        for(int i=5; i*i<=n; i+=6)                                // Auxiliary Space : O(1)
           if(n % i == 0 || n % (i + 2 ) == 0) return false;
        return true;
    }


    public static void primeFactors(int n){
        for(int i=2; i<n; i++){
            if(isPrime(i)){                                 // Time Complexity : O(n**2 * log(n))
                int x=i;                                    // Auxiliary Space : O(1)
                while(n % x == 0){
                    System.out.println(i+" ");
                    x*=i;
                }
            }
        }
    }


    public static void efficientPrimeFactors(int n){        
        for(int i=2; i*i<=n; i++){
            while(n % i == 0){                              // Time Complexity : O(n**1/2)
                System.out.println(i+" ");                  // Auxiliary Space : O(1)
                n/=i;
            }
        }
        if(n > 1) System.out.println(n+" ");
    }


    public static void printPrimeFactors(int n){
        while(n % 2 == 0){
            System.out.println(2+" ");
            n/=2;
        }

        while(n % 3 == 0){                                 // Time Complexity : O(n**1/2)
            System.out.println(3+" ");                     // Auxiliary Space : O(1)                                     
            n/=3;
        }

        for(int i=5; i*i<=n; i+=6){
            while(n % i == 0){
                System.out.println(i+" ");
                n/=i;
            }

            while(n % (i+2) == 0){
                System.out.println((i+2)+" ");
                n/=(i+2);
            }
        }
        if(n > 3) System.out.println(n+" ");
    }


    public static void allDivisor(int n){

        int i=1;
        while(i*i <= n){                     // Time Complexity : O(n**1/2)
            if(n % i ==0)                    // Auxiliary Space : O(1)   
            System.out.println(i+" ");
        }

        while(i >= 1){
            if(n % i == 0){
                if(n!=i*i)
                   System.out.println(i+" ");      
            }
        }
    }


    public static void sieveOfEratosthenes(int n){

        for(int i=2; i<=n; i++){
            if(isPrime(i))                         // Time Complexity : O(n**1/2 * n)                
               System.out.print(i+" ");            // Auxiliary Space : O(1)   
        }
    }


    public static void sieve(int n){

        boolean prime[] =new boolean [n+1];
        for(int i=0; i<n+1; i++)
           prime[i]=true;
        
        for(int i=2; i*i<=n; i++){                 // Time Complexity : O(n * log(log(n)))          
            if(isPrime(i)){                        // Auxiliary Space : O(n)   
                for(int k=i*i; k<=n; k+=i){
                    prime[i]=false;
                }
            }
        }

        for(int i=2; i<=n; i++){
            if(prime[i])
               System.out.print(i+" ");
        }
    }


    public static int power(int x, int n){
        int result=1;
        while(n>0){                         // Time Complexity : O(log(n))
            if(n % 2 == 1) result*=x;       // Auxiliary Space : O(1)
            x=x*x;
            n/=2;
        }
        return result;
    }

    
}
