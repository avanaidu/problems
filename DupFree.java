import java.util.ArrayList;

public class DupFree {
    public static ArrayList<Integer> removeDuplicates(int[] nums) {
        ArrayList<Integer> dupsFree = new ArrayList<Integer>();
        for (int num : nums) {
            int dups = 0;
            for (int i : nums) {
                if (num == i) {
                    dups++;
                }
            }
            if (dups > 1 && !dupsFree.contains(num)) {
                dupsFree.add(num);
            } else if (dups <= 1 && !dupsFree.contains(num)) {
                dupsFree.add(num);
            }
        }

        return dupsFree;

    }

public static void main(String[] args) {
    int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
    System.out.println( DupFree.removeDuplicates(nums) );
}

}

