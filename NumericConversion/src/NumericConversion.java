//I've added this comment to make a change as per the GitHub lab protocol!

import java.util.Scanner;

public class NumericConversion {

    //method prints menu later to avoid redundant calls in main
    public static void printMenu()
    {
        System.out.println("\nDecoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit\n");
        System.out.println("Please enter an option: ");
    }

    //Decodes an entire hexadecimal string and returns its value
    public static Long hexStringDecode (String hex)
    {
        /*total is return statement and current holds the
        short returned by hexCharDecode
         */
        Long total = 0L;
        short current = 0;
        /*starts at end of string to get value and then
        multiplies by 16 to the respective power
         */
        for (int n = hex.length(); n > 0; n--)
        {
            char digit = hex.charAt(n-1);
            current = hexCharDecode(digit);
            total += (current * (long)(Math.pow(16, hex.length() - n)));
        }
        return total;
    }
    //Decodes a single hexadecimal digit and returns its value
    public static short hexCharDecode (char digit)
    {
        short num = 0;
        /*
        if the character is a digit it returns the digit
        by converting char to the short value
         */
        if (Character.isDigit(digit))
        {
            num = (short) ((short)digit - 48);
        }
        else if (digit == 'A' || digit == 'a')
        {
            num = 10;
        }
        else if (digit == 'B' || digit == 'b')
        {
            num = 11;
        }
        else if (digit == 'C' || digit == 'c')
        {
            num = 12;
        }
        else if (digit == 'D' || digit == 'd')
        {
            num = 13;
        }
        else if (digit == 'E' || digit == 'e')
        {
            num = 14;
        }
        else if (digit == 'F' || digit == 'f')
        {
            num = 15;
        }
        return num;
    }

    //Decodes a binary string and returns its value
    public static short binaryStringDecode (String binary)
    {
        short num = 0;
        short total = 0;
        for (int n = binary.length(); n > 0; n--)
        {
            /*only adds a value of 2 to the respective power
            if there is a 1 in place
             */
            if (binary.substring(n-1, n).equals("1"))
            {
                num = 1;
                total += Math.pow(2, (binary.length() - n));
            }
        }
        return total;
    }

    //Converts binary to decimal to hex value
    public static String binaryToHex (String binary)
    {
        //method converts entered string to decimal
        short dec = binaryStringDecode(binary);
        //used to create hex string
        String digits = "0123456789ABCDEF";
        int rem = 0;
        String product = "";
        char append;
        /*while the decimal is still greater than 0, run
        the while loop that divides the value by 16 after
        each finding of the remainder to put in the hex string
         */
        while (dec > 0)
        {
            rem = (short) (dec % 16);
            append = digits.charAt(rem );
            product = append + product;
            dec /= 16;
        }
        return product;
    }

    public static void main (String[] args)
    {
        //initialize variables and set up menu / user choice
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String user = "";
        printMenu();
        choice = scanner.nextInt();
        int loop = 0;
        //run until something other than choices are called
        while (loop == 0)
        {
            //runs methods corresponding to the user menu choice
            if (choice == 1)
            {
                System.out.println("Please enter the numeric string to convert: ");
                user = scanner.next();
                System.out.println("Result: " + hexStringDecode(user));
                printMenu();
                choice = scanner.nextInt();
            }
            else if (choice == 2) {
                System.out.println("Please enter the numeric string to convert: ");
                user = scanner.next();
                System.out.println("Result: " + binaryStringDecode(user));
                printMenu();
                choice = scanner.nextInt();
            }
            else if (choice == 3) {
                System.out.println("Please enter the numeric string to convert: ");
                user = scanner.next();
                System.out.println("Result: " + binaryToHex(user));
                printMenu();
                choice = scanner.nextInt();
            }
            else
            {
                System.out.println("Goodbye!");
                loop++;
            }
        }
    }
}
