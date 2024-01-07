public class Question5 {

    public static void main(String[] args) {

        int arr[] = {2, 4 ,6 ,8};
        int max = findMax(arr);
        int count = 0;
        while(max != 0){
            max/=2;
            count++;
        }
        System.out.println(count-2);

        
        
    }

    public static int findMax(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
            max = Math.max(max, arr[i]);
        return max;
    }
    
}
