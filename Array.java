import java.util.Arrays;
public class Array {
    static boolean isFind(int[] arr,int value){
        for ( int i : arr){
            if ( i == value){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] list = {3, 7, 4, 4, 2, 9, 10, 20, 33, 10, 2, 9, 10};
        int[] duplicate =  new int[list.length];

        // Calculate the number of occurrences of each number;

        for (int i = 0; i < list.length ; i++){
            int count =0;
            for (int j = 0 ; j < list.length ; j++){
                if (list[i] == list[j]){
                    count++;
                }
            }
            duplicate[i] = count;
        }

        //Print repeating even numbers;
        System.out.println("Repeating even numbers :");
        for (int i = 0; i < list.length; i++){
            if ( list[i] % 2 == 0 && duplicate[i] > 1 && !isFind(Arrays.copyOfRange(list, 0, i), list[i])){
                System.out.println(list[i] + " repeats " + duplicate[i] + " times.");
            }
        }
    }
}
