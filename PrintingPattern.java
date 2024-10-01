public class PrintingPattern {
    public static void main(String[] args) {
        printPattern(5);
    }

    private static void printPattern(int size) {

        for (int i = 1; i<= size; i++){
            for (int j=size-i; j>=1 ;j--){
                System.out.print(" ");
            }
            for (int j=1; j< i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
