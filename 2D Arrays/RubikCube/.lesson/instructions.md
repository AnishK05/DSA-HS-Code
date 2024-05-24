# Instructions  

Complete the method rotateCube that will rotate a given side of a Rubik's Cube 90 degrees to the right. Instead of colors the cube is represented by numbers. The tens place will instead represent the colors. The cube is a 3D integer array with [side][row][col]. 
  
    0n - top (white)
    1n - left side (orange)
    2n - front (green)
    3n - right side (red)
    4n - back (blue)
    5n - bottom (yellow)

  For example;

```
            01 02 03 
            04 05 06 
            07 08 09 

11 12 13    21 22 23    31 32 33    41 42 43 
14 15 16    24 25 26    34 35 36    44 45 46 
17 18 19    27 28 29    37 38 39    47 48 49 

            51 52 53 
            54 55 56 
            57 58 59 
```

Rotating side 2 will result in the following.


```
            01 02 03
            04 05 06
            19 16 13

11 12 51    27 24 21    07 32 33    41 42 43 
14 15 52    28 25 22    08 35 36    44 45 46 
17 18 53    29 26 23    09 38 39    47 48 49 

            37 34 31 
            54 55 56 
            57 58 59 
```

Test your algorithm to make sure all sides can be rotated correctly.
