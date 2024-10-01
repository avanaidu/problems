public class PersistentInt {

    private void a(){
        b();
        System.out.println("a");
    }

    private void b(){
        System.out.println("b");
    }


    public static void main(String[] args) {
        new PersistentInt().a();
    }
}
