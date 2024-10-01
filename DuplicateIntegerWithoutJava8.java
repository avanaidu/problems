import java.util.HashMap;

public class DuplicateIntegerWithoutJava8 {

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 2, 3, 3, 3, 5, 6, 2, 1, 9, 4, 7, 3, 2, 1, 9, 0};
        System.out.println(eachIntRepeat(arr));
    }

    private static HashMap<Integer, Integer> eachIntRepeat(int[] arr) {

        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            if(!result.containsKey(arr[i])){
                result.put(arr[i], 1);
            }
            else {
                Integer value = result.get(arr[i]);
                result.put(arr[i], value+1);
            }
        }
        return result;
    }

}
