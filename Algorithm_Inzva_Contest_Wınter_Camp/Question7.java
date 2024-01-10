public class Question7 {

    public static void main(String[] args) {

        int []given = {5,5,5,5,5};
        int [] original = new int[given.length];
        original[0] = given[0];

        
    }

    public static void solve(int given[],int original[]){


        for(int i=1; i<original.length; i++){

            if(given[i] > given[i-1]){
                original[i] = given[i];
            }
            else{
                original[i] = given[i-1];
            }


        }

    }
    
}
