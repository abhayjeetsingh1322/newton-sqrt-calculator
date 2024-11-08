import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program calculates the square roots of number using Newton iteration.
 * The user is asked if they want to enter a square root and based on the
 * response, the program proceeds or quits. The user also gets to decide the
 * relative error percentage for the estimate of all the square roots. This
 * program is designed to handle positive numbers and zeros. The program runs
 * until user quits by entering a negative number to calculate.
 *
 * @author A. Singh
 *
 */
public final class Newton4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @param epsilonPercent
     *            relative error percentage entered by the user used for
     *            precision
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilonPercent) {

        //Declared variables
        final double percentToDecimal = 100.0;
        final double epsilon = epsilonPercent / percentToDecimal;
        double num = x;
        double estimate = x;

        //If statement to check if estimate is bigger than 0.0 to avoid division by
        //zero, hence if argument is 0.0 the estimate is unchanged and return is 0.0
        if (estimate > 0.0) {

            //Using while loop to check for relative error
            while ((Math.abs((estimate * estimate) - num) / num) > (epsilon
                    * epsilon)) {

                //Estimate (r) calculation update based on the number of iterations
                estimate = (estimate + (num / estimate)) / 2;
            }
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

        //If statement to check if initial response is "y"
        if (response.equals("y")) {

            //Prompting user to get the relative error percentage (epsilon)
            out.println();
            out.print("Enter the relative error in percentage form "
                    + "(Do not use % sign): ");
            double epsilonPercentage = in.nextDouble();

            //Prompting user to enter the number
            out.println();
            out.print("Enter a number to calulate "
                    + "(to stop enter a negative number): ");
            double num = in.nextDouble();

            //Using while loop to check for user response ("y" or not)
            while (num >= 0.0) {

                //Calling sqrt method and storing return in a variable
                double ans = sqrt(num, epsilonPercentage);

                //Showing user the output
                out.println();
                out.println("Answer: " + ans);
                out.println();

                //Prompting user again if they want to enter number
                out.print("Enter another number only to calulate "
                        + "(to stop enter a negative number): ");
                num = in.nextDouble();
            }
        }

        //Showing user that the program has stopped
        out.println();
        out.println("The Program Quit");

        //Close input and output streams
        in.close();
        out.close();
    }

}
