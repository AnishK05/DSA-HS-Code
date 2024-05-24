# Instructions  

Complete the topWords methods.

```java
public static Map<Integer, List<String>> topWords(List<String> lines, int num) 
```

The topWords method will receive a List of strings and an int num. Each String will consist of a line of words. Convert each line to lowercase and remove all formatting except for hyphens and apostrophes. The topWords methods should return a Map containing of words occuring more than num times in the given list. You will need to implement more than one Map.

The map returned should be in sorted order by key as shown below.

```
103 - [is]
106 - [came]
112 - [upon, into, so, one]
114 - [not, little]
116 - [all]
119 - [he]
122 - [have, they, there, from]
129 - [his]
132 - [then, you]
137 - [on]
151 - [this]
157 - [were]
202 - [time, but]
216 - [for, with]
243 - [at]
266 - [as]
280 - [me]
352 - [had]
416 - [it]
436 - [that]
439 - [my]
543 - [in]
548 - [was]
678 - [to]
806 - [a]
1156 - [of]
1234 - [and]
1241 - [i]
2270 - [the]
```

  