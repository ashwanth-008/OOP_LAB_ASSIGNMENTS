class Teacher {
    String name;
    String subject;

    Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }
    void displayTeacher() {
        System.out.println("Name: " + name);
        System.out.println("Subject: " + subject);
    }
}

class Student extends Teacher {
    int rollNo;   

    
    Student(String name, String subject, int rollNo) {
        super(name, subject);   // reusing Teacher constructor
        this.rollNo = rollNo;
    }

    void displayStudent() {
        displayTeacher();   // reusing Teacher method
        System.out.println("Roll No: " + rollNo);
    }

    public static void main(String[] args) {
        Student s = new Student("Rahul", "Mathematics", 101);
        s.displayStudent();
    }
}
