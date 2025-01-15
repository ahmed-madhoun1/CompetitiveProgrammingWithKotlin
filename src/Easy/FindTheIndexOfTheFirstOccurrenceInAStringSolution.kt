/*
 * Problem: Find the Index of the First Occurrence in a String
 *
 * Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or -1 if `needle` is not part of `haystack`.
 *
 * Approach:
 * Use the Knuth-Morris-Pratt (KMP) algorithm:
 * 1. Preprocess the `needle` to create an `lps` (longest prefix suffix) array.
 * 2. Traverse the `haystack` and use the `lps` array to skip unnecessary comparisons.
 *
 * Time Complexity: O(n + m), where n is the length of `haystack` and m is the length of `needle`.
 * Space Complexity: O(m), due to the `lps` array.
 */

fun strStr(haystack: String, needle: String): Int {
    // Edge case: If needle is empty, return 0
    if (needle.isEmpty()) return 0

    val lps = IntArray(needle.length) // Longest Prefix Suffix array
    var j = 0 // Pointer for needle

    // Build the LPS array
    for (i in 1 until needle.length) {
        while (j > 0 && needle[i] != needle[j]) {
            j = lps[j - 1]
        }
        if (needle[i] == needle[j]) {
            j++
        }
        lps[i] = j
    }

    // Search in haystack
    j = 0
    for (i in haystack.indices) {
        while (j > 0 && haystack[i] != needle[j]) {
            j = lps[j - 1]
        }
        if (haystack[i] == needle[j]) {
            j++
        }
        if (j == needle.length) {
            return i - j + 1 // Found match
        }
    }

    return -1 // No match found
}

/*
 * Main Function for Testing
 */
fun main() {
    val testCases = listOf(
        "sadbutsad" to "sad",      // Output: 0
        "leetcode" to "leeto",    // Output: -1
        "a" to "a",               // Output: 0
        "mississippi" to "issip", // Output: 4
        "hello" to "ll"           // Output: 2
    )

    testCases.forEach { (haystack, needle) ->
        println("Input: haystack = \"$haystack\", needle = \"$needle\"")
        println("Output: ${strStr(haystack, needle)}")
        println()
    }
}