import java.util.Arrays;

public class LookUpTable {

    final int MAX = 100;
    final int NULL = -1;

    int lookup[] = new int[MAX];

    public void initializeTheTable(){
        Arrays.fill(lookup,NULL);
    }

    public int fib(int n){

        if(lookup[n] == NULL){
            if(n<=1)
                lookup[n] = n;
            else
                lookup[n] = fib(n-1) + fib(n-2);
        }
        
        return lookup[n];

    }

    public static void main(String[] args) {
        LookUpTable l = new LookUpTable();
        l.initializeTheTable();
        System.out.println(l.fib(7));
    }
    
}
