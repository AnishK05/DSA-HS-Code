# Lesson plan
  
The method slowFindSubstring should return the largest substring that does not contain duplicate characters. For example.
```
optimizedFindSubstring("abcdabcdefgbca") returns "abcdefg"
```
However, the method is very slow. It's time complexity is O(n^2). You are to write an optimized version called optimizedFindSubstring. Your code should use a time and space complexity of O(n).

In this problem, you're using a HashMap to keep track of the last occurrence of each character in the current substring, and two pointers (start and end) to represent the current substring. As you iterate through the string, if the current character has already occurred in the current substring, you move the start pointer to the next position after the last occurrence of the current character. With this approach you're updating the maxLength of the substring without repeating characters.

You need to be careful to handle edge cases like empty string or one-char string, also you have to test the function with multiple test cases to make sure that is working as expected.

The time complexity of this solution is still O(n) and the space complexity is O(n) as well, since it's using a HashMap to store the last occurrence of each character and it's keeping track of the substring itself.

The time complexity of the solution should be O(n).

The reason for this is that the solution uses a single pass through the string to track the last occurrence of each character in the current substring using a HashMap. The HashMap operations (get and put) have an average time complexity of O(1), so the overall time complexity of the solution is O(n) where n is the number of characters in the input string.

In terms of space complexity, the solution uses a HashMap to store the last occurrence of each character, so the space complexity is also O(n) where n is the number of unique characters in the input string.

It's important to note that this solution is an optimized version of a sliding window, by using the HashMap you can achieve O(1) time complexity for checking if a character is in the current substring or not, instead of using a brute force O(n) approach.

Hint: Use two variables (startIdx and endIdx) to represent the current substring and use a Map to keep track of the last occurrence of each character. As you iterate through the string using endIdx for the loop variable, check the Map to see if the current character has already occurred. If so, move the startIdx to the next position after the last occurrence of the current character then update the Map.
```python

```
  