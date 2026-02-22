import java.util.Scanner;
class WashingMachine {
    void switchOn() {
        System.out.println("Machine turned ON");
    }
    int acceptClothes(int noOfClothes) {
        System.out.println(noOfClothes + " clothes accepted.");
        return noOfClothes;
    }
    void acceptDetergent() {
        System.out.println("Detergent added.");
    }
    void switchOff() {
        System.out.println("Machine turned OFF");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WashingMachine wm = new WashingMachine();
        wm.switchOn();
        System.out.print("Enter number of clothes: ");
        int clothes = sc.nextInt();
        wm.acceptClothes(clothes);
        wm.acceptDetergent();
        wm.switchOff();
    }
}
