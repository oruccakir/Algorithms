import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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



    // Time Complexity : O(len(str) * len(x))
    // Auxiliary Space : O(1)

    public static int strIncludeX(String str, String x){

        int index = -1,k=1;

        boolean isFound = true,isFinished = false;

        for(int i=0; i<str.length() - x.length() && !isFinished; i++){

            isFound = true;

            if(x.charAt(0) == str.charAt(i)){

                k = 1;

                while(isFound && k<x.length()){

                    if(x.charAt(k) != str.charAt(i+k))
                        isFound = false;
                    
                    k++;

                }

                if(isFound){
                    index = i;
                    isFinished = true;
                }
                

            }

        }

        return index;

    }



    // Time Complexity : O(N)
    // Auxiliary Space : O(the number of characters)


    public static char getMaxOcurringCharacter(String str){

        int count[] = new int[52];

        int index = 0, max = Integer.MIN_VALUE;

        char maxChar = ' ';

        for(int i=0; i<str.length(); i++){

            index = str.charAt(i) - 'a';

            count[index]++;

        }

        for(int i=0; i<count.length; i++){

            if(count[i] > max){

                max = count[i];

                maxChar = (char)(i + 'a');

            }

        }

        return maxChar;

    }



    // Time Complexity : O(N)
    // Auxiliary Space : O(N) 



    public static char nonRepeatingCharacter(String str){

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<str.length(); i++)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
        
        for(Character key : map.keySet())
            if(map.get(key) == 1)
                return key;
        
        return '$';

    }



    // Time Complexity : O(N)
    // Auxiliary Space : O(N) 



    public static char repeatingCharacter(String str){

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<str.length(); i++)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
        
        for(Character key : map.keySet())
            if(map.get(key) > 1)
                return key;
        
        return '$';

    }



    // Time Complexity : O(N)
    // Auxiliary Space : O(N) 


    public static String reverseWords(String str){

        String arr[] = str.split("\\."), s = "";

        for(int i=arr.length - 1; i>=0; i--)
            s += arr[i];
        
        s = str.substring(0,str.length());

        return s;
    }



    
    // Time Complexity : O(N)
    // Auxiliary Space : O(1)
    
    
    public static long findSum(String str){

        long sum = 0;

        String num = "";

        for(int i=0; i<str.length(); i++){

            if(str.charAt(i) >= '1' && str.charAt(i) <= '9')
                num += str.charAt(i);
            else if(!num.equals("")){

                sum += Long.parseLong(num);

                num = "";

            }

        }

        if(!num.equals(""))
            sum += Long.parseLong(num);

        return sum;

    }




    // Time Complexity : O(N)
    // Auxiliary Space : O(N)



    public static String concatenated(String str1, String str2){

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        int len1 = str1.length(), len2 = str2.length();

        for(int i=0; i<len1; i++)
            set1.add(str1.charAt(i));
        
        for(int i=0; i<len2; i++)
            set2.add(str2.charAt(i));

        String str = "";

        for(int i=0; i<len1; i++)
            if(!set2.contains(str1.charAt(i)))
                str += str1.charAt(i);
        
        for(int i=0; i<len2; i++)
            if(!set1.contains(str2.charAt(i)))
                str += str2.charAt(i);
        
        if(str.equals(""))
            str = "-1";
        
        return str;

    }




    // Time Complexity : O(N)
    // Auxiliary Space : O(N)



    public static boolean areRotations(String str1, String str2){

        if(str1.length() != str2.length())
            return false;
        
        return (str1 + str1).contains(str2);

    }




    // Time Complexity : O(N)
    // Auxiliary Space : O(N)



    public static boolean checkPangram(String str){

        str = str.toLowerCase();

        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<str.length(); i++)
            set.add(str.charAt(i));

        boolean isTrue = true;

        char chr = 'a';

        while(isTrue && chr != 'z'){

            if(!set.contains(chr))
                isTrue = false;
            
            chr++;

        }

        return isTrue;

    }



    // Time Complexity : O(|a| + |b|)
    // Auxiliary Space : O(N)



    public static boolean isAnagram(String a, String b){

        int count1[] = new int[52], count2[] = new int[52];

        for(int i=0; i<a.length(); i++)
            count1[a.charAt(i) - 'a']++;
        
        for(int i=0; i<b.length(); i++)
            count2[b.charAt(i) - 'a']++;

        for(int i=0; i<52; i++)
            if(count1[i] != count2[i])
                return false;
            
        return true;

    }


    















        


    










    public static void main(String[] args) {
        
        System.out.println(nonRepeatingCharacter("aaabbbbbccdddeeeeeeeeeeeeeeeee"));

    }

}