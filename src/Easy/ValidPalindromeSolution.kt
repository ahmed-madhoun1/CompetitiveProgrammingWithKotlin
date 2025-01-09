/*
 * Problem: Valid Palindrome
 *
 * Optimized Two-Pointer Approach:
 * - We'll use a two-pointer technique to check if the string is a palindrome.
 * - The string is cleaned by removing non-alphanumeric characters and converting the characters to lowercase.
 * - We compare the characters from both ends, moving towards the center, ensuring that they match.
 *
 * Time Complexity:
 * O(n), as we iterate through the string once to filter and compare characters.
 *
 * Space Complexity:
 * O(1), since no additional space is used beyond the two pointers.
 */

fun isPalindrome(s: String): Boolean {
    // Initialize two pointers: left starting at the beginning and right at the end
    var left = 0
    var right = s.length - 1

    while (left < right) {
        // Skip non-alphanumeric characters from the left side
        if (!s[left].isLetterOrDigit()) {
            left++
        }
        // Skip non-alphanumeric characters from the right side
        else if (!s[right].isLetterOrDigit()) {
            right--
        }
        // Compare characters at the left and right pointers
        else {
            // Check if the characters match, ignoring case
            if (s[left].lowercaseChar() != s[right].lowercaseChar()) {
                return false
            }
            // Move both pointers towards the center
            left++
            right--
        }
    }

    // If the loop completes without mismatches, the string is a palindrome
    return true
}

// Main function to test the code
fun main() {
    val testCases = listOf(
        "A man, a plan, a canal: Panama" to true,
        "race a car" to false,
        " " to true,
        "No lemon, no melon" to true
    )

    // Test and print results
    testCases.forEach { (input, expected) ->
        val result = isPalindrome(input)
        println("Input: \"$input\" | Output: $result | Expected: $expected")
    }
}