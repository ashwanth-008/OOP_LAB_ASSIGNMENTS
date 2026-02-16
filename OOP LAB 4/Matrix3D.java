import java.util.Scanner;
public class Matrix3D {
    int sizeX, sizeY, sizeZ;
    int[] arr;

    public Matrix3D(int x, int y, int z) {
        sizeX = x;
        sizeY = y;
        sizeZ = z;
        arr = new int[x * y * z];
    }

    // Map 3D (x,y,z) to 1D index
    private int index(int x, int y, int z) {
        return x * sizeY * sizeZ + y * sizeZ + z;
    }

    public void set(int value, int indexX, int indexY, int indexZ) {
        arr[index(indexX, indexY, indexZ)] = value;
    }

    public int get(int indexX, int indexY, int indexZ) {
        return arr[index(indexX, indexY, indexZ)];
    }

    // Demo
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix3D m = new Matrix3D(3, 3, 3);
        System.out.println("Enter element, and the x,y,z coordinates of the element.");
        int value = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        m.set(value, x, y, z);
        System.out.println("Value at the specified coordinates set as: " + m.get(x, y, z));  // Should print value
    }
}
