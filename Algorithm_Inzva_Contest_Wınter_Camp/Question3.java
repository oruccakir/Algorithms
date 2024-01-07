import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Track;

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long ages[] = new long[n];
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextLong();
        }

        int berat = 0;
        int sura = n;

        for(int k=0; k<n; k++){

            if(ages[k] != -1){

                for(int i=1; i<=m; i++){

                    if(isPrime(ages[k]+i)){
                        ages[k] = -1;
                        berat++;
                        sura--;
                    }
            
                }

            }
                
        }

        if(berat > sura){
            System.out.println("Berat");
            System.out.println(berat);
        }
        else{
            System.out.println("Sura");
            System.out.println(sura);
        }

        


        
    }

    public static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

   
}

    

