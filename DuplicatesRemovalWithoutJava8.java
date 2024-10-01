import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DuplicatesRemovalWithoutJava8 {


    public static void main(String[] args) {
        //int[] arr = {3, 5, 6, 2, 3, 3, 3, 5, 6, 2, 1, 9, 4, 7, 3, 2, 1, 9, 0};
        int[] arr = {1, 1, 2};
        int[] result = dupfreeArray(arr);
        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()) );
    }

    private static int[] dupfreeArray(int[] arr) {

//        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
//        Arrays.sort(arr);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int j : arr) {
//            if (!map.containsKey(j)) {
//                map.put(j, 0);
//            }
            map.put(j,0);
        }
        int[] result = new int[map.size()];
        int k=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            result[k++] = entry.getKey();
        }

        return result;
    }
}
