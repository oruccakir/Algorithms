import java.util.ArrayList;

public class Question4 {


    public static void main(String[] args) {

        int A[] = new int[]{0,3 ,6 ,8 ,11 ,15 ,18};
        int B[] = new int[]{0,5 ,8 ,13, 15, 16};
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(0, 0));
        for(int i=0; i<B.length; i++){
            int index = binarySearch(A,B[i]);
            if( index != -1){
                pairs.add(new Pair(index,i));
            }
        }
        pairs.add(new Pair(A.length-1, B.length-1));

        int result = 0;

        for(int i=0; i<pairs.size()-1; i++){
            result += giveSum(A, B, pairs.get(i), pairs.get(i+1));
        }

        for(int i=1; i< pairs.size()-1; i++)
            result-= A[pairs.get(i).first];

        System.out.println(result);
        
    }

    public static int giveSum(int A[],int B[],Pair p1,Pair p2){
        int res1 = 0,res2=0;
        for(int i=p1.first; i<= p2.first; i++)
            res1 += A[i];
        for(int i=p1.second; i<= p2.second; i++)
            res2 += B[i];
        
        return Math.max(res1, res2);
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;  // Target found, return the index
            } else if (arr[mid] < target) {
                low = mid + 1;  // Target is in the right half
            } else {
                high = mid - 1;  // Target is in the left half
            }
        }

        return -1;  // Target not found in the array
    }
    
}
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}