import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveLessCountNumbersArraySizeBecomesLessThanEqualHalf {

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};

        System.out.println(leastSizeWithoutRepeated(arr));
    }

    private static Integer leastSizeWithoutRepeated(int[] arr) {

        Map<Integer, Long> intReps;

        int reqLength = arr.length/2;
        intReps = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new ));

        System.out.println(intReps);

        int count = arr.length;
        int cnt =0;
        for(Map.Entry<Integer, Long> map: intReps.entrySet()){
            System.out.println(map.getValue().toString());
            count = count - Integer.parseInt(map.getValue().toString());
            cnt++;
            System.out.println("count :: "+count);
            if(count <= reqLength){
                return cnt;
            }

        }

        return 0;
    }
}
