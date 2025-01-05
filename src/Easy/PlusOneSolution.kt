/*
 * Problem: Plus One
 * 
 * You are given a large integer represented as an integer array `digits`, where each `digits[i]` is the ith digit of the integer.
 * The digits are ordered from most significant to least significant. Increment the large integer by one and return the resulting array of digits.
 * 
 * Approach:
 * We simulate the addition of 1 to the number represented by the array:
 * 1. Starting from the last digit, add 1.
 * 2. If the sum results in a carry (greater than 9), set the current digit to 0 and propagate the carry to the next digit to the left.
 * 3. If there's still a carry after processing all digits, prepend 1 to the array.
 * 
 * Functional Approach:
 * Use foldRight to iterate over the array in reverse and propagate the carry.
 * 
 * Time Complexity:
 * O(n), where n is the length of the array. Each digit is processed once.
 * 
 * Space Complexity:
 * O(1) extra space (output array is considered the result, not additional memory).
 */

fun plusOne(digits: IntArray): IntArray {
    // Simulate adding one using foldRight
    val result = digits.foldRight(emptyList<Int>() to 1) { digit, (res, carry) ->
        val sum = digit + carry
        (listOf(sum % 10) + res) to (sum / 10)
    }
    // Add carry to the result if it still exists
    return (if (result.second > 0) listOf(1) + result.first else result.first).toIntArray()
}

/*
 * Main Function for Testing
 */
fun main() {
    val testCases = listOf(
        intArrayOf(1, 2, 3),  // Increment 123 -> 124
        intArrayOf(4, 3, 2, 1),  // Increment 4321 -> 4322
        intArrayOf(9),  // Increment 9 -> 10
        intArrayOf(9, 9, 9)  // Increment 999 -> 1000
    )
    testCases.forEach { digits ->
        println("Input: ${digits.joinToString(", ")}")
        println("Output: ${plusOne(digits).joinToString(", ")}")
        println()
    }
}