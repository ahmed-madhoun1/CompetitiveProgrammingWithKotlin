/*
 * Problem: Length of Last Word
 *
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Approach:
 * - Reverse the string.
 * - Drop the leading spaces using dropWhile.
 * - Take characters until we encounter the next space using takeWhile.
 * - Calculate the length of the resulting substring.
 *
 * Time Complexity:
 * - O(n), where n is the length of the string. We process each character once.
 *
 * Space Complexity:
 * - O(1), since we are using constant space (we reverse the string in-place).
 */

fun lengthOfLastWord(s: String): Int {
    // Reverse the string, drop leading spaces, and take characters until the next space
    return s.reversed()
        .dropWhile { it == ' ' } // Skip leading spaces after reversing
        .takeWhile { it != ' ' } // Take characters until the next space
        .length // Return the length of the last word
}

// Main function to test the code with multiple examples
fun main() {
    // Test cases
    val testCases = listOf(
        "Hello World" to 5,
        "   fly me   to   the moon  " to 4,
        "luffy is still joyboy" to 6,
        "  singleWord  " to 10,
        "  " to 0
    )
    
    // Running the test cases
    testCases.forEach { (input, expected) ->
        val result = lengthOfLastWord(input)
        println("Input: '$input' -> Output: $result (Expected: $expected)")
    }
}