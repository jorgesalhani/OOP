public class Methods {
    static void myStaticMethod() {
        System.out.println("Static method. No need initialization");
    }

    public void myPublicMethod() {
        System.out.println("Public method. Needs initialization");
    }

    public static void main(String[] args) {
        myStaticMethod();
        
        Methods myMethods = new Methods();
        myMethods.myPublicMethod();
    }
}