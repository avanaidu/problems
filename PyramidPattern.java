public class PyramidPattern {
    public static void main(String[] args) {
        pyramidPattern(10);
    }

    private static void pyramidPattern(int size) {
        for (int i =0; i<= size-1; i++){
            for(int j=0; j < size-i; j++){
                System.out.print(" ");
            }
            for (int k=0; k<i; k++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
