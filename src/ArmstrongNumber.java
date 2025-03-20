/**
 * An Armstrong number (also known as a narcissistic number or plenary number) is
 * a number that is equal to the sum of its own digits each raised to the power of the number of digits.
 * For example, 153 is an Armstrong number because 1^3 + 5^3 + 3^3 = 153.
 */
public class ArmstrongNumber {
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    public static void main(String[] args) {
        int num = 153;
        System.out.println(num + " is Armstrong: " + isArmstrong(num));
    }
}