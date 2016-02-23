/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amicablenumbers_v2;

import java.util.Arrays;

/**
 *
 * @author lefty
 */
public class AmicableNumbers_v2 {

    /**
     * Returns the list of divisors a number has. Does NOT return the
     * number itself in the list.
     * <p>
     * @param number the number whose divisor you need
     * @return an array of all divisors
     */
    public static int[] GetListOfDivisors(int number) {
        int number_of_divisors = 0;
        int index_limit = (int) number / 2 + 1;
        for (int i = 1; i < index_limit; i++) {
            if (number % i == 0) {
                number_of_divisors++;
            }

        }
        int[] divisors = new int[number_of_divisors];
        int index = 0;
        for (int i = 1; i < index_limit; i++) {

            if (number % i == 0) {
                divisors[index] = i;
                index++;
            }
        }
        return divisors;
    }

    /**
     * Returns the sum of the divisors a number has. Includes 1 as a divisor in
     * the sum; Does NOT the number itself.
     * <p>
     * @param number the number whose divisor you need
     * @return integer
     */
    public static int GetSumOfDivisors(int number) {
        if (number == 0) {
            return -1;
        }
        if (number == 1) {
            return 1;
        }

        int[] list_of_divisors = GetListOfDivisors(number);
        int sum = Arrays.stream(list_of_divisors).sum();
        

        return sum;
    }

    /**
     * Returns TRUE if the number is perfect. Perfect number: the sum of its
     * divisors equals the number itself.
     * <p>
     * @param number
     * @return boolean it_it_perfect
     */
    public static boolean IsPerfectNumber(int number) {
        boolean is_it_perfect = false;
        int sum_of_divisors = GetSumOfDivisors(number);
        if (sum_of_divisors == number) {
            is_it_perfect = true;
        }
        return is_it_perfect;
    }

    /**
     * Returns TRUE if the numbers are amicable. Amicable numbers: the sum of
     * the divisors of each number equals the other number. For example 220 and
     * 284.
     * <p>
     * @param first_number and second_number
     * @return boolean are_they_amicable
     */
    public static boolean AreNumbersAmicable(int first_number, int second_number) {
        boolean are_they_amicable = false;

        int first_sum = GetSumOfDivisors(first_number);
        int second_sum = GetSumOfDivisors(second_number);

        if (first_sum == second_number && second_sum == first_number) {
            are_they_amicable = true;
        }

        return are_they_amicable;
    }

    public static void PrintArray(int _array[]) {
        System.out.println(ArrayToString(_array));
    }

    public static String ArrayToString(int _array[]) {
        String output="";
        for (int i = 0; i < _array.length - 2; i++) {
            output=output+_array[i] + ", ";

        }
        output=output+_array[_array.length - 1];
        
        return output;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = GetListOfDivisors(1222);
        PrintArray(a);
        
        System.out.println("sum: 284: " + GetSumOfDivisors(284));
        System.out.println("sum 220:" + GetSumOfDivisors(220));
        
        System.out.println(AreNumbersAmicable(220, 284));
    }

}
