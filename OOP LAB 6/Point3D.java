import java.util.Scanner;
class Point3D {
    int x, y, z;
    // Constructor for origin
    Point3D() {
        x = y = z = 0;
    }
    // Constructor for arbitrary point
    Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x, y, z: ");
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
    }
    void output() {
        System.out.println("Point: (" + x + ", " + y + ", " + z + ")");
    }

    double distance(Point3D p) {
        return Math.sqrt(
                Math.pow(p.x - x, 2) +
                Math.pow(p.y - y, 2) +
                Math.pow(p.z - z, 2)
        );
    }
    public static void main(String[] args) {
        Point3D p1 = new Point3D();
        Point3D p2 = new Point3D();
        System.out.println("POINT 1 COORDINATES");
        p1.input();
        p1.output();
        System.out.println("POINT 2 COORDINATES");
        p2.input();
        p2.output();
        System.out.println("Distance between point 1 and 2: " + p1.distance(p2));
    }
}
