import java.io.FileWriter;

public class string{

    // Time Complexity : O(N)
    // Auxiliary Space : O(N)

    public static void printFreqOfString(String str){

        int []freq = new int[26];

        int index = 0;

        for(int i=0; i<str.length(); i++){

            index = (int) (str.charAt(i) - 'a');

            freq[index]++;
            
        }

        for(int i=0; i<26; i++)
            if(freq[i] > 0)
                System.out.println((char)(i + 'a') +" : "+freq[i]);

    }



    // Time Complexity : O(N)
    // Auxiliary Space : O(N)


    public static int binarySubStringStart1End1(String str){

        int count = 0;

        for(int i=0; i<str.length(); i++)
            if(str.charAt(i) == '1')
                count++;
        
        return count * (count - 1) / 2;

    }


    










    public static void main(String[] args) {
        
        printFreqOfString("aaabbbbbccdddeeeeeeeeeeeeeeeee");

    }

}