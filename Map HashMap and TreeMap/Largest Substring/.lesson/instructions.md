# Instructions  

The method slowFindSubstring receives a string and returns the largest substring that does not contain duplicate characters. However, the method is very inefficient. The slow solution has exponential O(N^2) time complexity. You are to write an optimized version called fastFindSubstring. Your code should use linear O(n) time complexity. 
```
Example output

Example String: abcdabcdef
Slow: abcdef
Fast: abcdef

Example String: data.txt file
Performance results with a 2,000 character string.
Slow: Kse9ALxv`7gZW2R:hO'HCGpoVIt   Time: 2680751487 nanoseconds
Fast: Kse9ALxv`7gZW2R:hO'HCGpoVIt   Time:    1986451 nanoseconds

Fast method is 1349 times faster.
```
Hint: Use two variables (startIdx and endIdx) to represent the current substring and use a Map to keep track of the last occurrence of each character.


  