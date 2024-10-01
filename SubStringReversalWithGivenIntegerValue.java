public class SubStringReversalWithGivenIntegerValue {

    public static void main(String[] args) {

        String str = "abcdefghijkl";
        //sub

        System.out.println(reverseStringBasedonInput(str, 3));
    }

    private static String reverseStringBasedonInput(String str, int val) {


        StringBuilder builder = new StringBuilder();
        int cnt = 0;
        for (int i=0; i< str.length(); i++){

            if(cnt == 0) {
                StringBuilder temp = new StringBuilder(str.substring(i, val+i));

                builder.append(temp.reverse());
            }
            cnt++;

            if(cnt == val){
                cnt =0;
            }
        }

       return builder.toString();
    }
}
