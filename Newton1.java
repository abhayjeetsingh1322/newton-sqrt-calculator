import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program calculates the square roots of number using Newton iteration.
 * The user is asked if they want to enter a square root and based on the
 * response, the program proceeds or quits. This program is designed to only
 * handle positive numbers. The program runs until user quits when the response
 * is not equal to "y".
 *
 * @author A. Singh
 *
 */
public final class Newton1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {

        //Declared variables
        final double epsilon = 0.0001;
        double num = x;
        double estimate = x;

        //NOTE: Newton1 assumes user enters positive double hence I have not
        //created an if statement for 0.0, but it is included in Newton2

        //Using while loop to check for relative error of 0.01%
        while ((Math.abs((estimate * estimate) - num) / num) > (epsilon
                * epsilon)) {

            //Estimate (r) calculation update based on the number of iterations
            estimate = (estimate + (num / estimate)) / 2;
        }

        //Returning estimated square root value
        return estimate;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        //Declared objects of class SimpleReader and SimpleWriter
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //Prompting user to get initial response
        out.print("Would you like to calculate a square root? "
                + "Enter \"y\" to proceed or anything else to quit: ");
        String response = in.nextLine();

        //Using while loop to check for user response ("y" or not)
        while (response.equals("y")) {

            //Prompting user to enter the number
            out.println();
            out.print("Enter a number to calulate: ");
            double num = in.nextDouble();

            //Calling sqrt method and storing return in a variable
            double ans = sqrt(num);

            //Showing user the output
            out.println();
            out.println("Answer: " + ans);
            out.println();

            //Prompting user again if they want to enter number
            out.print("Would you like to calculate another square root? "
                    + "Enter \"y\" to proceed or anything else to quit: ");
            response = in.nextLine();
        }

        //Showing user that the program has stopped
        out.println();
        out.println("The Program Quit");

        //Close input and output streams
        in.close();
        out.close();
    }

}
