class X {
    int i, j;

    X(int i, int j) {
        this.i = i;
        this.j = j;
    }

    final int sum() {
        return i + j;
    }
}

class Y extends X {

    Y(int i, int j) {
        super(i, j); //calls constructor of parent class X
    }

    int findProduct() {
        return i * j;
    }
}

class Z extends Y {

    Z(int i, int j) {
        super(i, j); //calls constructor of class Y
    }
}

public class MultiLevelDemo {
    public static void main(String[] args) {

        Z obj = new Z(10, 5);

        System.out.println("Sum = " + obj.sum());
        System.out.println("Product = " + obj.findProduct());
    }
}

