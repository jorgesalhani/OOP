public class Teacher {
    private String name;
    private String subject;

    Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void printTeacher() {
        System.out.println(this.name);
        System.out.println(this.subject);
    }

    public static void main(String[] args) {
        Teacher myTeacher = new Teacher("Ana", "Maths");
        myTeacher.printTeacher();
        
        System.out.println(myTeacher.name);
    }
}
