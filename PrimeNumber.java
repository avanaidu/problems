import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args) {
        int[] numbers = {2, 6, 7, 9, 13, 17, 15, 19, 4};
        System.out.println(getPrimeNumbers(numbers));
    }

    private static List<Integer> getPrimeNumbers(int[] numbers) {
        return IntStream.range(1,100).boxed().filter(num -> validatePrime(num)).collect(Collectors.toList());
    }

    private static boolean validatePrime(Integer num) {
        if (num == 1 || num ==0){
            return false;
        }
        for (int i = 2; i<= num/2; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
