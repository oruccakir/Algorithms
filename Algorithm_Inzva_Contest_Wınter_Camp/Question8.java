import java.util.Arrays;

import javax.management.ValueExp;

public class Question8 {

    public static void main(String[] args) {

        int given[] = {1,2};

        solve(given);
        solve1(given);

        
    }

    public static void solve(int given[]){
        int original[] = new int[given.length];
        original[0] = given[0];
        for(int i=1; i<given.length; i++){

            for(int value = given.length; value >=1; value--){
                if(isSafe1(given,original,i, value)){
                    original[i] = value;
                    break;
                }
            }

        }

        System.out.println(Arrays.toString(original));
    }

    public static void solve1(int given[]){
        int original[] = new int[given.length];
        original[0] = given[0];
        for(int i=1; i<given.length; i++){

            for(int value = 1; value <= given.length; value++){
                if(isSafe1(given,original,i, value)){
                    original[i] = value;
                    break;
                }
            }

        }

        System.out.println(Arrays.toString(original));
    }

    public static boolean isSafe1(int given[],int original[],int index,int value){
        for(int i=index; i<given.length; i++){
            if(value > given[i] || isThere(original, value) == false)
                return false;
        }
        return true;
    }

    public static boolean isThere(int original[],int value){
        for(int i=0; i<original.length; i++)
            if(original[i] == value)
                return false;
        return true;
    }
    
}
