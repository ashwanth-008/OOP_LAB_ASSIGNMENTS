//package OOP_CASE_BASED.CaseBased;

import java.util.*;

public class TwoRectangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter r1's center x-, y-coordinates, width and height:");
        float x1 = sc.nextFloat();
        float y1 = sc.nextFloat();
        float width1 = sc.nextFloat();
        float height1 = sc.nextFloat();

        System.out.println("Enter r2's center x-, y-coordinates, width and height:");
        float x2 = sc.nextFloat();
        float y2 = sc.nextFloat();
        float width2 = sc.nextFloat();
        float height2 = sc.nextFloat();

        float h_width1 = width1 / 2;
        float h_width2 = width2 / 2;
        float h_height1 = height1 / 2;
        float h_height2 = height2 / 2;

        float dist_x = Math.abs(x1 - x2);
        float dist_y = Math.abs(y1 - y2);

        // For r2 inside r1
        if (dist_x + h_width2 <= h_width1 && dist_y + h_height2 <= h_height1) {
            System.out.println("r2 is inside of r1");
        }
        // For r1 inside r2
        else if (dist_x + h_width1 <= h_width2 && dist_y + h_height1 <= h_height2) {
            System.out.println("r1 is inside of r2");
        }
        // For overlapping
        else if (dist_x < h_width1 + h_width2 && dist_y < h_height1 + h_height2) {
            System.out.println("r2 overlaps r1");
        }
        // For not overlapping
        else {
            System.out.println("r2 does not overlap r1");
        }
        sc.close();
    }
}