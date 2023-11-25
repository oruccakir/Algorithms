import java.util.ArrayList;

public class AllSubset {

    public static void subsets(String s, String str, int i,ArrayList <ArrayList <Integer>> list){

        if(i == s.length()){
            ArrayList<Integer> l = new ArrayList<>();
            for(int k=0; k<str.length(); k++){
                l.add(((int) str.charAt(k) -'0'));
            }
            if(list.contains(l) == false)
                list.add(l);
            

            return;
        }

        subsets(s, str, i+1,list);  
        subsets(s, str+s.charAt(i), i+1,list); 
                                 
    }

    public static void main(String[] args) {

        ArrayList <ArrayList <Integer>> list = new ArrayList<>();
        
        subsets("212", "", 0,list);

        System.out.println(list);

    }
    
}
