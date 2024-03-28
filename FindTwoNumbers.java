import java.util.Arrays;

public class FindTwoNumbers {
    public static void main(String[] args) {
      int[] numbers = {2, 7, 11, 15};
      int target = 9;
      int[] result = findTwoNumbersInArrayForTheGivenTarget(numbers, target);
      System.out.println("Output: [" + result[0] + ", " + result[1] + "]"); // Output: [1, 2]
    }

    public static int[] findTwoNumbersInArrayForTheGivenTarget(int[] numbers, int target) {
      if (numbers.length < 2 || numbers.length > 30000) {
        throw new IllegalArgumentException("Array length must be between 2 and 30,000.");
      }

      for (int num : numbers) {
        if (num < -1000 || num > 1000) {
          throw new IllegalArgumentException("Array elements must be between -1000 and 1000.");
        }
      }

      int left = 0; // Initialize left pointer at the beginning of the array
      int right = numbers.length - 1; // Initialize right pointer at the end of the array

      // Continue until the left pointer is less than the right pointer
      while (left < right) {
        int currentSum = numbers[left] + numbers[right]; // Calculate the sum of the two numbers

        // If the sum equals the target, return the indices of the two numbers
        if (currentSum == target) {
          return new int[]{left + 1, right + 1}; // Adding 1 to convert to 1-indexed array
        }
        // If the sum is less than the target, move the left pointer to the right to increase the sum
        else if (currentSum < target) {
          left++;
        }
        // If the sum is greater than the target, move the right pointer to the left to decrease the sum
        else {
          right--;
        }
      }

      // If no solution is found, return [-1, -1]
      return new int[]{-1, -1};
    }
  }

