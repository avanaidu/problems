public class DupliateRemovalFromAString {

    public static void main(String[] args) {
        String input = "Java articles are Awesome";
        StringBuilder sb = new StringBuilder(input);
        System.out.println("input sb :: "+sb);

        for(int i = 0; i< sb.length(); i++){
            int cnt =0;
            for(int j=0; j<sb.length(); j++){
                if(i!=j && sb.charAt(i) == sb.charAt(j)){
                    cnt++;
                    sb.deleteCharAt(j);

                }
            }

            if(cnt > 0){
                sb.deleteCharAt(i);
                i--;
            }
        }

        System.out.println("output sb :: "+sb);
    }
}
