class Course {

    int id;
    String description;
    int duration;   // in months
    double fees;

    Course(int id, String description, int duration, double fees) {
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.fees = fees;
    }

    void GetData() {
        System.out.println("Course ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fees: " + fees);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Course[] courses = new Course[5];
        courses[0] = new Course(1, "Java", 6, 15000);
        courses[1] = new Course(2, "Python", 4, 12000);
        courses[2] = new Course(3, "C++", 5, 13000);
        courses[3] = new Course(4, "Web Development", 3, 10000);
        courses[4] = new Course(5, "Data Science", 6, 20000);

        for (Course c : courses) //iterates through each element of courses array
        {
            c.GetData(); //implements method getdata
        }
    }
}
