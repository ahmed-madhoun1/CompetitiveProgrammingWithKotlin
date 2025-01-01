/*
 * Problem: Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 *
 * Approach:
 * We can use a functional programming approach to solve this problem by utilizing a stack-like structure.
 * The solution uses the fold function to iterate through the string, keeping track of unmatched opening brackets.
 * 
 * Steps:
 * 1. We iterate through the string character by character.
 * 2. If the character is an opening bracket ('(', '{', '['), we add it to the stack.
 * 3. If it's a closing bracket (')', '}', ']'), we check if the stack is non-empty and if the last element matches the expected opening bracket.
 * 4. If the stack is empty or there is no match, the string is invalid.
 * 5. At the end of the iteration, the stack should be empty for the string to be valid. If the stack is empty, the string is valid, otherwise it is not.
 *
 * Time Complexity:
 * O(n), where n is the length of the string. We process each character once.
 * 
 * Space Complexity:
 * O(n), in the worst case, where all characters are opening brackets, the stack will store them.
 */

fun isValid(s: String): Boolean {
    // A map to match the closing parentheses with their corresponding opening parentheses
    val matchingParentheses = mapOf(')' to '(', '}' to '{', ']' to '[')

    // Use fold to process the string characters and maintain a stack-like structure
    return s.fold(emptyList<Char>()) { stack, char ->
        when {
            char in matchingParentheses.values -> stack + char  // If it's an opening bracket, add to stack
            char in matchingParentheses.keys -> 
                if (stack.isNotEmpty() && stack.last() == matchingParentheses[char]) 
                    stack.dropLast(1)  // If it's a closing bracket and matches, pop from stack
                else 
                    return false  // If no match or stack is empty, return false
            else -> stack  // If it's an invalid character, just return the stack as is
        }
    }.isEmpty()  // After processing all characters, check if the stack is empty (valid)
}

// Main function to run examples and test the solution
fun main() {
    // Test cases to check the solution
    val testCases = listOf(
        "()" to true,
        "()[]{}" to true,
        "(]" to false,
        "([])" to true,
        "([)]" to false,
        "{[]}" to true,
        "{[}" to false,
        "" to true  // An empty string is considered valid
    )

    // Iterate through the test cases and print the result for each
    for ((input, expectedResult) in testCases) {
        val result = isValid(input)
        println("Input: $input\nExpected: $expectedResult\nOutput: $result\n")
    }
}
