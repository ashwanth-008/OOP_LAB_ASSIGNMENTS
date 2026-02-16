//package OOP_CASE_BASED.CaseBased;
// We do this assuming a square of [-1,1] x [-1,1] (square of side 2 units).
public class MonteCarlo {

    public static void main(String[] args) {

        final int THROWS = 1000000; //huge no of throws for more precise probability
        int count = 0;
        double x, y;

        for (int i = 0; i < THROWS; i++) 
        {

            // Random point in square 
            x = Math.random() * 2 - 1;
            y = Math.random() * 2 - 1;

            // CONDITIONS FOR Odd-numbered regions: 1 and 3
            if (x < 0) 
            {
                count++;
            }
            else if (x > 0 && y > 0 && (x + y) < 1) //the equation of diagonal line seperating 2 and 3 is x+y=1
            {
                count++;
            }
        }

        double probability = (count / (double) THROWS)*100;
        System.out.println("Percentage of hitting odd-numbered region = " + probability+"%");
    }
}

