# LeetCode — All Problems by Pattern

> ~2500+ problems. Every problem assigned to exactly one primary pattern. Ordered easy → hard within each section.

---

## Table of Contents

1. [Arrays & Hashing](#1-arrays--hashing)
2. [Prefix Sum](#2-prefix-sum)
3. [Two Pointers](#3-two-pointers)
4. [Fast & Slow Pointers](#4-fast--slow-pointers)
5. [Sliding Window — Fixed Size](#5-sliding-window--fixed-size)
6. [Sliding Window — Variable Size](#6-sliding-window--variable-size)
7. [Stack](#7-stack)
8. [Monotonic Stack](#8-monotonic-stack)
9. [Monotonic Deque](#9-monotonic-deque)
10. [Binary Search — Classic](#10-binary-search--classic)
11. [Binary Search — On Answer](#11-binary-search--on-answer)
12. [Binary Search — 2D & Advanced](#12-binary-search--2d--advanced)
13. [Linked List — Basic Operations](#13-linked-list--basic-operations)
14. [Linked List — Reversal Patterns](#14-linked-list--reversal-patterns)
15. [Linked List — Two Pointers](#15-linked-list--two-pointers)
16. [Trees — DFS Traversal](#16-trees--dfs-traversal)
17. [Trees — Path Problems](#17-trees--path-problems)
18. [Trees — Construction & Serialization](#18-trees--construction--serialization)
19. [Trees — BFS / Level Order](#19-trees--bfs--level-order)
20. [BST — Operations](#20-bst--operations)
21. [BST — Validation & Properties](#21-bst--validation--properties)
22. [Trie](#22-trie)
23. [Segment Tree](#23-segment-tree)
24. [Fenwick Tree / BIT](#24-fenwick-tree--bit)
25. [Sparse Table / RMQ](#25-sparse-table--rmq)
26. [Heap / Priority Queue](#26-heap--priority-queue)
27. [Two Heaps](#27-two-heaps)
28. [K-way Merge](#28-k-way-merge)
29. [Backtracking — Subsets & Combinations](#29-backtracking--subsets--combinations)
30. [Backtracking — Permutations](#30-backtracking--permutations)
31. [Backtracking — Grid & String](#31-backtracking--grid--string)
32. [Backtracking — Hard Constraint](#32-backtracking--hard-constraint)
33. [Graph — Grid BFS](#33-graph--grid-bfs)
34. [Graph — Grid DFS](#34-graph--grid-dfs)
35. [Graph — General BFS](#35-graph--general-bfs)
36. [Graph — General DFS](#36-graph--general-dfs)
37. [Union Find (DSU)](#37-union-find-dsu)
38. [Topological Sort](#38-topological-sort)
39. [Shortest Path — Dijkstra](#39-shortest-path--dijkstra)
40. [Shortest Path — Bellman-Ford / SPFA](#40-shortest-path--bellman-ford--spfa)
41. [Shortest Path — Floyd-Warshall](#41-shortest-path--floyd-warshall)
42. [Minimum Spanning Tree](#42-minimum-spanning-tree)
43. [Strongly Connected Components / Bridges](#43-strongly-connected-components--bridges)
44. [Bipartite Graph](#44-bipartite-graph)
45. [Eulerian Path](#45-eulerian-path)
46. [1D DP — Linear / Index-based](#46-1d-dp--linear--index-based)
47. [1D DP — Kadane (Max Subarray)](#47-1d-dp--kadane-max-subarray)
48. [1D DP — LIS & Variants](#48-1d-dp--lis--variants)
49. [1D DP — Stock Problems](#49-1d-dp--stock-problems)
50. [1D DP — State Machine](#50-1d-dp--state-machine)
51. [1D DP — Knapsack 0/1](#51-1d-dp--knapsack-01)
52. [1D DP — Knapsack Unbounded](#52-1d-dp--knapsack-unbounded)
53. [2D DP — Grid](#53-2d-dp--grid)
54. [2D DP — Two Strings (LCS / Edit Distance)](#54-2d-dp--two-strings-lcs--edit-distance)
55. [DP — Palindrome](#55-dp--palindrome)
56. [DP — Interval (Range DP)](#56-dp--interval-range-dp)
57. [DP — Partition](#57-dp--partition)
58. [DP — Digit DP](#58-dp--digit-dp)
59. [DP — Bitmask DP](#59-dp--bitmask-dp)
60. [DP — Tree DP](#60-dp--tree-dp)
61. [Greedy — Intervals & Scheduling](#61-greedy--intervals--scheduling)
62. [Greedy — Sorting-based](#62-greedy--sorting-based)
63. [Greedy — String](#63-greedy--string)
64. [Greedy — Array / Number](#64-greedy--array--number)
65. [Intervals](#65-intervals)
66. [Sorting — Merge Sort Applications](#66-sorting--merge-sort-applications)
67. [Sorting — Quick Select](#67-sorting--quick-select)
68. [Sorting — Custom Comparator](#68-sorting--custom-comparator)
69. [Sorting — Counting / Bucket / Radix](#69-sorting--counting--bucket--radix)
70. [Divide & Conquer](#70-divide--conquer)
71. [Math — Number Theory](#71-math--number-theory)
72. [Math — Combinatorics & Probability](#72-math--combinatorics--probability)
73. [Math — Modular Arithmetic](#73-math--modular-arithmetic)
74. [Math — Geometry](#74-math--geometry)
75. [Math — Simulation](#75-math--simulation)
76. [Bit Manipulation — XOR Tricks](#76-bit-manipulation--xor-tricks)
77. [Bit Manipulation — Masking & Counting](#77-bit-manipulation--masking--counting)
78. [String — KMP / Z-Algorithm](#78-string--kmp--z-algorithm)
79. [String — Rolling Hash / Rabin-Karp](#79-string--rolling-hash--rabin-karp)
80. [String — Manacher's Algorithm](#80-string--manachers-algorithm)
81. [Randomized Algorithms / Reservoir Sampling](#81-randomized-algorithms--reservoir-sampling)
82. [Design — Cache & Memory](#82-design--cache--memory)
83. [Design — Data Structure](#83-design--data-structure)
84. [Design — Iterator](#84-design--iterator)
85. [Design — System / Miscellaneous](#85-design--system--miscellaneous)

---

## 1. Arrays & Hashing

| # | Problem | Difficulty |
|---|---------|------------|
| 1 | Two Sum | Easy |
| 217 | Contains Duplicate | Easy |
| 242 | Valid Anagram | Easy |
| 349 | Intersection of Two Arrays | Easy |
| 350 | Intersection of Two Arrays II | Easy |
| 205 | Isomorphic Strings | Easy |
| 290 | Word Pattern | Easy |
| 1207 | Unique Number of Occurrences | Easy |
| 169 | Majority Element | Easy |
| 1346 | Check If N and Its Double Exist | Easy |
| 1002 | Find Common Characters | Easy |
| 1365 | How Many Numbers Are Smaller Than the Current Number | Easy |
| 1460 | Make Two Arrays Equal by Reversing Subarrays | Easy |
| 1491 | Average Salary Excluding the Minimum and Maximum Salary | Easy |
| 1539 | Kth Missing Positive Number | Easy |
| 1640 | Check Array Formation Through Concatenation | Easy |
| 1748 | Sum of Unique Elements | Easy |
| 1684 | Count the Number of Consistent Strings | Easy |
| 1832 | Check if the Sentence Is Pangram | Easy |
| 1941 | Check if All Characters Have Equal Number of Occurrences | Easy |
| 2006 | Count Number of Pairs With Absolute Difference K | Easy |
| 2053 | Kth Distinct String in an Array | Easy |
| 2085 | Count Common Words With One Occurrence | Easy |
| 2215 | Find the Difference of Two Arrays | Easy |
| 2351 | First Letter to Appear Twice | Easy |
| 2395 | Find Subarrays With Equal Sum | Easy |
| 2404 | Most Frequent Even Element | Easy |
| 2441 | Largest Positive Integer That Exists With Its Negative | Easy |
| 2465 | Number of Distinct Averages | Easy |
| 2496 | Maximum Value of a String in an Array | Easy |
| 2540 | Minimum Common Value | Easy |
| 49 | Group Anagrams | Medium |
| 347 | Top K Frequent Elements | Medium |
| 238 | Product of Array Except Self | Medium |
| 36 | Valid Sudoku | Medium |
| 128 | Longest Consecutive Sequence | Medium |
| 229 | Majority Element II | Medium |
| 560 | Subarray Sum Equals K | Medium |
| 525 | Contiguous Array | Medium |
| 974 | Subarray Sums Divisible by K | Medium |
| 523 | Continuous Subarray Sum | Medium |
| 554 | Brick Wall | Medium |
| 1010 | Pairs of Songs With Total Durations Divisible by 60 | Medium |
| 1679 | Max Number of K-Sum Pairs | Medium |
| 2260 | Minimum Consecutive Cards to Pick Up | Medium |
| 2342 | Max Sum of a Pair With Equal Sum of Digits | Medium |
| 2364 | Count Number of Bad Pairs | Medium |
| 2352 | Equal Row and Column Pairs | Medium |
| 2453 | Destroy Sequential Targets | Medium |
| 2488 | Count Subarrays With Median K | Hard |
| 2501 | Longest Square Streak in an Array | Medium |
| 2554 | Maximum Number of Integers to Choose From a Range I | Medium |
| 2610 | Convert an Array Into a 2D Array With Conditions | Medium |
| 380 | Insert Delete GetRandom O(1) | Medium |
| 41 | First Missing Positive | Hard |
| 381 | Insert Delete GetRandom O(1) - Duplicates Allowed | Hard |
| 271 | Encode and Decode Strings | Medium |

---

## 2. Prefix Sum

| # | Problem | Difficulty |
|---|---------|------------|
| 1480 | Running Sum of 1d Array | Easy |
| 1732 | Find the Highest Altitude | Easy |
| 303 | Range Sum Query - Immutable | Easy |
| 1588 | Sum of All Odd Length Subarrays | Easy |
| 724 | Find Pivot Index | Easy |
| 1991 | Find the Middle Index in Array | Easy |
| 2090 | K Radius Subarray Averages | Medium |
| 1314 | Matrix Block Sum | Medium |
| 304 | Range Sum Query 2D - Immutable | Medium |
| 325 | Maximum Size Subarray Sum Equals k | Medium |
| 528 | Random Pick with Weight | Medium |
| 2055 | Plates Between Candles | Medium |
| 1094 | Car Pooling | Medium |
| 1109 | Corporate Flight Bookings | Medium |
| 2406 | Divide Intervals Into Minimum Number of Groups | Medium |
| 1477 | Find Two Non-overlapping Sub-arrays Each With Target Sum | Medium |
| 1664 | Ways to Make a Fair Array | Medium |
| 1685 | Sum of Absolute Differences in a Sorted Array | Medium |
| 1769 | Minimum Number of Operations to Move All Balls to Each Box | Medium |
| 1893 | Check if All the Integers in a Range Are Covered | Easy |
| 2017 | Grid Game | Medium |
| 2146 | K Highest Ranked Items Within a Price Range | Medium |
| 2256 | Minimum Average Difference | Medium |
| 2281 | Sum of Total Strength of Wizards | Hard |
| 862 | Shortest Subarray with Sum at Least K | Hard |
| 2389 | Longest Subsequence With Limited Sum | Easy |
| 2438 | Range Product Queries of Powers | Medium |
| 2483 | Minimum Penalty for a Shop | Medium |
| 2559 | Count Vowel Strings in Ranges | Medium |
| 2615 | Sum of Distances | Medium |

---

## 3. Two Pointers

| # | Problem | Difficulty |
|---|---------|------------|
| 125 | Valid Palindrome | Easy |
| 680 | Valid Palindrome II | Easy |
| 283 | Move Zeroes | Easy |
| 26 | Remove Duplicates from Sorted Array | Easy |
| 27 | Remove Element | Easy |
| 88 | Merge Sorted Array | Easy |
| 977 | Squares of a Sorted Array | Easy |
| 844 | Backspace String Compare | Easy |
| 392 | Is Subsequence | Easy |
| 2540 | Minimum Common Value | Easy |
| 1768 | Merge Strings Alternately | Easy |
| 1750 | Minimum Length of String After Deleting Similar Ends | Medium |
| 2000 | Reverse Prefix of Word | Easy |
| 2108 | Find First Palindromic String in the Array | Easy |
| 167 | Two Sum II | Medium |
| 15 | 3Sum | Medium |
| 16 | 3Sum Closest | Medium |
| 18 | 4Sum | Medium |
| 11 | Container With Most Water | Medium |
| 75 | Sort Colors | Medium |
| 80 | Remove Duplicates from Sorted Array II | Medium |
| 287 | Find the Duplicate Number | Medium |
| 443 | String Compression | Medium |
| 905 | Sort Array By Parity | Easy |
| 922 | Sort Array By Parity II | Easy |
| 1047 | Remove All Adjacent Duplicates In String | Easy |
| 1099 | Two Sum Less Than K | Easy |
| 1213 | Intersection of Three Sorted Arrays | Easy |
| 1229 | Meeting Scheduler | Medium |
| 1577 | Number of Ways Where Square of Number Is Equal to Product of Two Numbers | Medium |
| 1855 | Maximum Distance Between a Pair of Values | Medium |
| 1877 | Minimize Maximum Pair Sum in Array | Medium |
| 1984 | Minimum Difference Between Highest and Lowest of K Scores | Easy |
| 2105 | Watering Plants II | Medium |
| 2337 | Move Pieces to Obtain a String | Medium |
| 2422 | Merge Operations to Turn Array Into a Palindrome | Medium |
| 42 | Trapping Rain Water | Hard |
| 2461 | Maximum Sum of Distinct Subarrays With Length K | Medium |

---

## 4. Fast & Slow Pointers

| # | Problem | Difficulty |
|---|---------|------------|
| 141 | Linked List Cycle | Easy |
| 876 | Middle of the Linked List | Easy |
| 234 | Palindrome Linked List | Easy |
| 202 | Happy Number | Easy |
| 142 | Linked List Cycle II | Medium |
| 457 | Circular Array Loop | Medium |
| 287 | Find the Duplicate Number | Medium |

---

## 5. Sliding Window — Fixed Size

| # | Problem | Difficulty |
|---|---------|------------|
| 643 | Maximum Average Subarray I | Easy |
| 1343 | Number of Sub-arrays of Size K and Average ≥ Threshold | Medium |
| 567 | Permutation in String | Medium |
| 438 | Find All Anagrams in a String | Medium |
| 2090 | K Radius Subarray Averages | Medium |
| 1052 | Grumpy Bookstore Owner | Medium |
| 1423 | Maximum Points You Can Obtain from Cards | Medium |
| 2269 | Find the K-Beauty of a Number | Easy |
| 2379 | Minimum Recolors to Get K Consecutive Black Blocks | Easy |
| 2461 | Maximum Sum of Distinct Subarrays With Length K | Medium |
| 2653 | Sliding Subarray Beauty | Medium |
| 239 | Sliding Window Maximum | Hard |
| 480 | Sliding Window Median | Hard |
| 1703 | Minimum Adjacent Swaps for K Consecutive Ones | Hard |

---

## 6. Sliding Window — Variable Size

| # | Problem | Difficulty |
|---|---------|------------|
| 121 | Best Time to Buy and Sell Stock | Easy |
| 3 | Longest Substring Without Repeating Characters | Medium |
| 1004 | Max Consecutive Ones III | Medium |
| 424 | Longest Repeating Character Replacement | Medium |
| 713 | Subarray Product Less Than K | Medium |
| 209 | Minimum Size Subarray Sum | Medium |
| 1838 | Frequency of the Most Frequent Element | Medium |
| 2024 | Maximize the Confusion of an Exam | Medium |
| 2401 | Longest Nice Subarray | Medium |
| 2411 | Smallest Subarrays With Maximum Bitwise OR | Medium |
| 2516 | Take K of Each Character From Left and Right | Medium |
| 2537 | Count the Number of Good Subarrays | Medium |
| 2555 | Maximize Win From Two Segments | Medium |
| 2730 | Find the Longest Semi-Repetitive Substring | Medium |
| 2747 | Count Zero Request Servers | Medium |
| 2779 | Maximum Beauty of an Array After Applying Operation | Medium |
| 2831 | Find the Longest Equal Subarray | Medium |
| 2875 | Minimum Size Subarray in Infinite Array | Medium |
| 76 | Minimum Window Substring | Hard |
| 30 | Substring with Concatenation of All Words | Hard |
| 992 | Subarrays with K Different Integers | Hard |
| 1425 | Constrained Subsequence Sum | Hard |
| 2271 | Maximum White Tiles Covered by a Carpet | Medium |
| 2009 | Minimum Number of Operations to Make Array Continuous | Hard |

---

## 7. Stack

| # | Problem | Difficulty |
|---|---------|------------|
| 20 | Valid Parentheses | Easy |
| 155 | Min Stack | Medium |
| 232 | Implement Queue using Stacks | Easy |
| 225 | Implement Stack using Queues | Easy |
| 1047 | Remove All Adjacent Duplicates In String | Easy |
| 1544 | Make The String Great | Easy |
| 1598 | Crawler Log Folder | Easy |
| 2390 | Removing Stars From a String | Medium |
| 150 | Evaluate Reverse Polish Notation | Medium |
| 394 | Decode String | Medium |
| 22 | Generate Parentheses | Medium |
| 71 | Simplify Path | Medium |
| 636 | Exclusive Time of Functions | Medium |
| 856 | Score of Parentheses | Medium |
| 1190 | Reverse Substrings Between Each Pair of Parentheses | Medium |
| 1209 | Remove All Adjacent Duplicates in String II | Medium |
| 739 | Daily Temperatures | Medium |
| 853 | Car Fleet | Medium |
| 316 | Remove Duplicate Letters | Medium |
| 402 | Remove K Digits | Medium |
| 456 | 132 Pattern | Medium |
| 1003 | Check If Word Is Valid After Substitutions | Medium |
| 1441 | Build an Array With Stack Operations | Easy |
| 2116 | Check if a Parentheses String Can Be Valid | Medium |
| 2130 | Maximum Twin Sum of a Linked List | Medium |
| 2197 | Replace Non-Coprime Numbers in Array | Hard |
| 2434 | Using a Robot to Print the Lexicographically Smallest String | Medium |
| 2696 | Minimum String Length After Removing Substrings | Easy |
| 2751 | Robot Collisions | Hard |
| 224 | Basic Calculator | Hard |
| 227 | Basic Calculator II | Medium |
| 772 | Basic Calculator III | Hard |
| 84 | Largest Rectangle in Histogram | Hard |
| 85 | Maximal Rectangle | Hard |

---

## 8. Monotonic Stack

| # | Problem | Difficulty |
|---|---------|------------|
| 496 | Next Greater Element I | Easy |
| 503 | Next Greater Element II | Medium |
| 556 | Next Greater Element III | Medium |
| 901 | Online Stock Span | Medium |
| 1019 | Next Greater Node In Linked List | Medium |
| 907 | Sum of Subarray Minimums | Medium |
| 2104 | Sum of Subarray Ranges | Medium |
| 1856 | Maximum Subarray Min-Product | Medium |
| 2281 | Sum of Total Strength of Wizards | Hard |
| 1944 | Number of Visible People in a Queue | Hard |
| 2355 | Maximum Number of Books You Can Take | Hard |
| 1762 | Buildings With an Ocean View | Medium |
| 2030 | Smallest K-Length Subsequence With Occurrences of a Letter | Hard |
| 2263 | Make Array Non-decreasing or Non-increasing | Hard |
| 2454 | Next Greater Element IV | Hard |
| 2487 | Remove Nodes From Linked List | Medium |
| 2832 | Maximal Range That Each Element Is Maximum in It | Medium |
| 42 | Trapping Rain Water | Hard |
| 84 | Largest Rectangle in Histogram | Hard |

---

## 9. Monotonic Deque

| # | Problem | Difficulty |
|---|---------|------------|
| 239 | Sliding Window Maximum | Hard |
| 862 | Shortest Subarray with Sum at Least K | Hard |
| 1438 | Longest Continuous Subarray With Absolute Diff ≤ Limit | Medium |
| 1696 | Jump Game VI | Medium |
| 2398 | Maximum Number of Robots Within Budget | Hard |
| 2762 | Continuous Subarrays | Medium |
| 2865 | Beautiful Towers I | Medium |
| 2866 | Beautiful Towers II | Medium |

---

## 10. Binary Search — Classic

| # | Problem | Difficulty |
|---|---------|------------|
| 704 | Binary Search | Easy |
| 35 | Search Insert Position | Easy |
| 374 | Guess Number Higher or Lower | Easy |
| 278 | First Bad Version | Easy |
| 69 | Sqrt(x) | Easy |
| 367 | Valid Perfect Square | Easy |
| 744 | Find Smallest Letter Greater Than Target | Easy |
| 1351 | Count Negative Numbers in a Sorted Matrix | Easy |
| 2389 | Longest Subsequence With Limited Sum | Easy |
| 34 | Find First and Last Position of Element in Sorted Array | Medium |
| 33 | Search in Rotated Sorted Array | Medium |
| 81 | Search in Rotated Sorted Array II | Medium |
| 153 | Find Minimum in Rotated Sorted Array | Medium |
| 162 | Find Peak Element | Medium |
| 852 | Peak Index in a Mountain Array | Medium |
| 658 | Find K Closest Elements | Medium |
| 1095 | Find in Mountain Array | Hard |
| 154 | Find Minimum in Rotated Sorted Array II | Hard |
| 4 | Median of Two Sorted Arrays | Hard |

---

## 11. Binary Search — On Answer

| # | Problem | Difficulty |
|---|---------|------------|
| 875 | Koko Eating Bananas | Medium |
| 1011 | Capacity To Ship Packages Within D Days | Medium |
| 1482 | Minimum Number of Days to Make m Bouquets | Medium |
| 1552 | Magnetic Force Between Two Balls | Medium |
| 1870 | Minimum Speed to Arrive on Time | Medium |
| 2064 | Minimized Maximum of Products Distributed to Any Store | Medium |
| 2187 | Minimum Time to Complete Trips | Medium |
| 2226 | Maximum Candies Allocated to K Children | Medium |
| 2439 | Minimize Maximum of Array | Medium |
| 2517 | Maximum Tastiness of Candy Basket | Medium |
| 2594 | Minimum Time to Repair Cars | Medium |
| 2616 | Minimize the Maximum Difference of Pairs | Medium |
| 2702 | Minimum Operations to Make Numbers Non-positive | Medium |
| 2812 | Find the Safest Path in a Grid | Medium |
| 410 | Split Array Largest Sum | Hard |
| 774 | Minimize Max Distance to Gas Station | Hard |
| 1231 | Divide Chocolate | Hard |
| 2071 | Maximum Number of Tasks You Can Assign | Hard |
| 2141 | Maximum Running Time of N Computers | Hard |
| 2258 | Escape the Spreading Fire | Hard |
| 2560 | House Robber IV | Medium |
| 2564 | Substring XOR Queries | Medium |
| 2576 | Find the Maximum Number of Marked Indices | Medium |
| 2779 | Maximum Beauty of an Array After Applying Operation | Medium |
| 2861 | Maximum Number of Alloys | Medium |

---

## 12. Binary Search — 2D & Advanced

| # | Problem | Difficulty |
|---|---------|------------|
| 74 | Search a 2D Matrix | Medium |
| 240 | Search a 2D Matrix II | Medium |
| 378 | Kth Smallest Element in a Sorted Matrix | Medium |
| 668 | Kth Smallest Number in Multiplication Table | Hard |
| 719 | Find K-th Smallest Pair Distance | Hard |
| 786 | K-th Smallest Prime Fraction | Medium |
| 981 | Time Based Key-Value Store | Medium |
| 729 | My Calendar I | Medium |
| 731 | My Calendar II | Medium |
| 732 | My Calendar III | Hard |

---

## 13. Linked List — Basic Operations

| # | Problem | Difficulty |
|---|---------|------------|
| 237 | Delete Node in a Linked List | Medium |
| 83 | Remove Duplicates from Sorted List | Easy |
| 203 | Remove Linked List Elements | Easy |
| 21 | Merge Two Sorted Lists | Easy |
| 160 | Intersection of Two Linked Lists | Easy |
| 206 | Reverse Linked List | Easy |
| 2 | Add Two Numbers | Medium |
| 445 | Add Two Numbers II | Medium |
| 82 | Remove Duplicates from Sorted List II | Medium |
| 19 | Remove Nth Node From End of List | Medium |
| 24 | Swap Nodes in Pairs | Medium |
| 328 | Odd Even Linked List | Medium |
| 138 | Copy List with Random Pointer | Medium |
| 430 | Flatten a Multilevel Doubly Linked List | Medium |
| 708 | Insert into a Sorted Circular Linked List | Medium |
| 61 | Rotate List | Medium |
| 86 | Partition List | Medium |
| 148 | Sort List | Medium |
| 1721 | Swapping Nodes in a Linked List | Medium |
| 2074 | Reverse Nodes in Even Length Groups | Medium |
| 2095 | Delete the Middle Node of a Linked List | Medium |
| 2181 | Merge Nodes in Between Zeros | Medium |
| 2326 | Spiral Matrix IV | Medium |
| 2487 | Remove Nodes From Linked List | Medium |
| 2807 | Insert Greatest Common Divisors in Linked List | Medium |

---

## 14. Linked List — Reversal Patterns

| # | Problem | Difficulty |
|---|---------|------------|
| 206 | Reverse Linked List | Easy |
| 92 | Reverse Linked List II | Medium |
| 25 | Reverse Nodes in k-Group | Hard |
| 143 | Reorder List | Medium |
| 2816 | Double a Number Represented as a Linked List | Medium |

---

## 15. Linked List — Two Pointers

| # | Problem | Difficulty |
|---|---------|------------|
| 141 | Linked List Cycle | Easy |
| 876 | Middle of the Linked List | Easy |
| 234 | Palindrome Linked List | Easy |
| 142 | Linked List Cycle II | Medium |
| 19 | Remove Nth Node From End of List | Medium |
| 23 | Merge k Sorted Lists | Hard |
| 146 | LRU Cache | Medium |

---

## 16. Trees — DFS Traversal

| # | Problem | Difficulty |
|---|---------|------------|
| 104 | Maximum Depth of Binary Tree | Easy |
| 111 | Minimum Depth of Binary Tree | Easy |
| 226 | Invert Binary Tree | Easy |
| 100 | Same Tree | Easy |
| 572 | Subtree of Another Tree | Easy |
| 110 | Balanced Binary Tree | Easy |
| 112 | Path Sum | Easy |
| 257 | Binary Tree Paths | Easy |
| 404 | Sum of Left Leaves | Easy |
| 671 | Second Minimum Node In a Binary Tree | Easy |
| 606 | Construct String from Binary Tree | Easy |
| 1022 | Sum of Root To Leaf Binary Numbers | Easy |
| 1379 | Find a Corresponding Node of a Binary Tree in a Clone of That Tree | Easy |
| 1469 | Find All The Lonely Nodes | Easy |
| 1608 | Special Array With X Elements Greater Than or Equal X | Easy |
| 222 | Count Complete Tree Nodes | Medium |
| 1448 | Count Good Nodes in Binary Tree | Medium |
| 623 | Add One Row to Tree | Medium |
| 814 | Binary Tree Pruning | Medium |
| 1325 | Delete Leaves With a Given Value | Medium |
| 894 | All Possible Full Binary Trees | Medium |
| 951 | Flip Equivalent Binary Trees | Medium |
| 1026 | Maximum Difference Between Node and Ancestor | Medium |
| 1372 | Longest ZigZag Path in a Binary Tree | Medium |
| 988 | Smallest String Starting From Leaf | Medium |
| 2265 | Count Nodes Equal to Average of Subtree | Medium |
| 2331 | Evaluate Boolean Binary Tree | Easy |
| 2458 | Height of Binary Tree After Subtree Removal Queries | Hard |
| 2641 | Cousins in Binary Tree II | Medium |
| 144 | Binary Tree Preorder Traversal | Easy |
| 94 | Binary Tree Inorder Traversal | Easy |
| 145 | Binary Tree Postorder Traversal | Easy |
| 589 | N-ary Tree Preorder Traversal | Easy |
| 590 | N-ary Tree Postorder Traversal | Easy |

---

## 17. Trees — Path Problems

| # | Problem | Difficulty |
|---|---------|------------|
| 543 | Diameter of Binary Tree | Easy |
| 129 | Sum Root to Leaf Numbers | Medium |
| 113 | Path Sum II | Medium |
| 437 | Path Sum III | Medium |
| 687 | Longest Univalue Path | Medium |
| 1123 | Lowest Common Ancestor of Deepest Leaves | Medium |
| 236 | Lowest Common Ancestor of a Binary Tree | Medium |
| 2096 | Step-By-Step Directions From a Binary Tree Node to Another | Medium |
| 1245 | Tree Diameter | Medium |
| 2246 | Longest Path With Different Adjacent Characters | Medium |
| 2538 | Difference Between Maximum and Minimum Price Sum | Hard |
| 124 | Binary Tree Maximum Path Sum | Hard |
| 1740 | Find Distance in a Binary Tree | Medium |
| 863 | All Nodes Distance K in Binary Tree | Medium |

---

## 18. Trees — Construction & Serialization

| # | Problem | Difficulty |
|---|---------|------------|
| 108 | Convert Sorted Array to Binary Search Tree | Easy |
| 105 | Construct Binary Tree from Preorder and Inorder Traversal | Medium |
| 106 | Construct Binary Tree from Inorder and Postorder Traversal | Medium |
| 889 | Construct Binary Tree from Preorder and Postorder Traversal | Medium |
| 654 | Maximum Binary Tree | Medium |
| 998 | Maximum Binary Tree II | Medium |
| 1008 | Construct Binary Search Tree from Preorder Traversal | Medium |
| 114 | Flatten Binary Tree to Linked List | Medium |
| 116 | Populating Next Right Pointers in Each Node | Medium |
| 117 | Populating Next Right Pointers in Each Node II | Medium |
| 297 | Serialize and Deserialize Binary Tree | Hard |
| 428 | Serialize and Deserialize N-ary Tree | Hard |
| 449 | Serialize and Deserialize BST | Medium |

---

## 19. Trees — BFS / Level Order

| # | Problem | Difficulty |
|---|---------|------------|
| 637 | Average of Levels in Binary Tree | Easy |
| 102 | Binary Tree Level Order Traversal | Medium |
| 107 | Binary Tree Level Order Traversal II | Medium |
| 103 | Binary Tree Zigzag Level Order Traversal | Medium |
| 199 | Binary Tree Right Side View | Medium |
| 515 | Find Largest Value in Each Tree Row | Medium |
| 1161 | Maximum Level Sum of a Binary Tree | Medium |
| 662 | Maximum Width of Binary Tree | Medium |
| 1302 | Deepest Leaves Sum | Medium |
| 958 | Check Completeness of a Binary Tree | Medium |
| 1609 | Even Odd Tree | Medium |
| 2415 | Reverse Odd Levels of Binary Tree | Medium |
| 429 | N-ary Tree Level Order Traversal | Medium |
| 2583 | Kth Largest Sum in a Binary Tree | Medium |
| 2641 | Cousins in Binary Tree II | Medium |

---

## 20. BST — Operations

| # | Problem | Difficulty |
|---|---------|------------|
| 700 | Search in a Binary Search Tree | Easy |
| 701 | Insert into a Binary Search Tree | Medium |
| 450 | Delete Node in a BST | Medium |
| 173 | Binary Search Tree Iterator | Medium |
| 538 | Convert BST to Greater Tree | Medium |
| 1038 | Binary Search Tree to Greater Sum Tree | Medium |
| 669 | Trim a Binary Search Tree | Medium |
| 109 | Convert Sorted List to Binary Search Tree | Medium |
| 1382 | Balance a Binary Search Tree | Medium |

---

## 21. BST — Validation & Properties

| # | Problem | Difficulty |
|---|---------|------------|
| 530 | Minimum Absolute Difference in BST | Easy |
| 783 | Minimum Distance Between BST Nodes | Easy |
| 501 | Find Mode in Binary Search Tree | Easy |
| 235 | Lowest Common Ancestor of a Binary Search Tree | Medium |
| 230 | Kth Smallest Element in a BST | Medium |
| 98 | Validate Binary Search Tree | Medium |
| 99 | Recover Binary Search Tree | Medium |
| 96 | Unique Binary Search Trees | Medium |
| 95 | Unique Binary Search Trees II | Medium |
| 285 | Inorder Successor in BST | Medium |
| 510 | Inorder Successor in BST II | Medium |

---

## 22. Trie

| # | Problem | Difficulty |
|---|---------|------------|
| 14 | Longest Common Prefix | Easy |
| 208 | Implement Trie (Prefix Tree) | Medium |
| 648 | Replace Words | Medium |
| 211 | Design Add and Search Words Data Structure | Medium |
| 677 | Map Sum Pairs | Medium |
| 820 | Short Encoding of Words | Medium |
| 1023 | Camelcase Matching | Medium |
| 1268 | Search Suggestions System | Medium |
| 2185 | Counting Words With a Given Prefix | Easy |
| 2416 | Sum of Prefix Scores of Strings | Hard |
| 745 | Prefix and Suffix Search | Hard |
| 336 | Palindrome Pairs | Hard |
| 212 | Word Search II | Hard |
| 421 | Maximum XOR of Two Numbers in an Array | Medium |
| 1707 | Maximum XOR With an Element From Array | Hard |
| 2935 | Maximum Strong Pair XOR II | Hard |

---

## 23. Segment Tree

| # | Problem | Difficulty |
|---|---------|------------|
| 307 | Range Sum Query - Mutable | Medium |
| 308 | Range Sum Query 2D - Mutable | Hard |
| 715 | Range Module | Hard |
| 699 | Falling Squares | Hard |
| 732 | My Calendar III | Hard |
| 1157 | Online Majority Element In Subarray | Hard |
| 1622 | Fancy Sequence | Hard |
| 1649 | Create Sorted Array through Instructions | Hard |
| 2213 | Longest Substring of One Repeating Character | Hard |
| 2276 | Count Integers in Intervals | Hard |
| 2286 | Booking Concert Tickets in Groups | Hard |
| 2407 | Longest Increasing Subsequence II | Hard |
| 2612 | Minimum Reverse Operations | Hard |
| 2916 | Subarrays Distinct Element Sum of Squares II | Hard |

---

## 24. Fenwick Tree / BIT

| # | Problem | Difficulty |
|---|---------|------------|
| 307 | Range Sum Query - Mutable | Medium |
| 315 | Count of Smaller Numbers After Self | Hard |
| 493 | Reverse Pairs | Hard |
| 327 | Count of Range Sum | Hard |
| 1649 | Create Sorted Array through Instructions | Hard |
| 2179 | Count Good Triplets in an Array | Hard |
| 2426 | Number of Pairs Satisfying Inequality | Hard |
| 2519 | Count the Number of K-Big Indices | Hard |

---

## 25. Sparse Table / RMQ

| # | Problem | Difficulty |
|---|---------|------------|
| 1096 | Brace Expansion II | Hard |
| 2736 | Maximum Sum Queries | Hard |

---

## 26. Heap / Priority Queue

| # | Problem | Difficulty |
|---|---------|------------|
| 703 | Kth Largest Element in a Stream | Easy |
| 1046 | Last Stone Weight | Easy |
| 1337 | The K Weakest Rows in a Matrix | Easy |
| 2558 | Take Gifts From the Richest Pile | Easy |
| 2336 | Smallest Number in Infinite Set | Medium |
| 973 | K Closest Points to Origin | Medium |
| 215 | Kth Largest Element in an Array | Medium |
| 347 | Top K Frequent Elements | Medium |
| 692 | Top K Frequent Words | Medium |
| 621 | Task Scheduler | Medium |
| 1642 | Furthest Building You Can Reach | Medium |
| 1845 | Seat Reservation Manager | Medium |
| 2208 | Minimum Operations to Halve Array Sum | Medium |
| 2530 | Maximal Score After Applying K Operations | Medium |
| 1353 | Maximum Number of Events That Can Be Attended | Medium |
| 2402 | Meeting Rooms III | Hard |
| 2542 | Maximum Subsequence Score | Medium |
| 2554 | Maximum Number of Integers to Choose From a Range I | Medium |
| 2558 | Take Gifts From the Richest Pile | Easy |
| 2593 | Find Score of an Array After Marking All Elements | Medium |
| 2631 | Group By | Easy |
| 2762 | Continuous Subarrays | Medium |
| 2944 | Minimum Number of Coins for Fruits | Medium |
| 3035 | Maximum Palindromes After Operations | Medium |
| 355 | Design Twitter | Medium |
| 502 | IPO | Hard |
| 1675 | Minimize Deviation in Array | Hard |
| 632 | Smallest Range Covering Elements from K Lists | Hard |
| 407 | Trapping Rain Water II | Hard |
| 1383 | Maximum Performance of a Team | Hard |
| 2163 | Minimum Difference in Sums After Removal of Elements | Hard |
| 2386 | Find the K-Sum of an Array | Hard |
| 2973 | Find Number of Coins to Place in Tree Nodes | Medium |

---

## 27. Two Heaps

| # | Problem | Difficulty |
|---|---------|------------|
| 295 | Find Median from Data Stream | Hard |
| 480 | Sliding Window Median | Hard |
| 1438 | Longest Continuous Subarray With Absolute Diff ≤ Limit | Medium |

---

## 28. K-way Merge

| # | Problem | Difficulty |
|---|---------|------------|
| 23 | Merge k Sorted Lists | Hard |
| 378 | Kth Smallest Element in a Sorted Matrix | Medium |
| 632 | Smallest Range Covering Elements from K Lists | Hard |
| 786 | K-th Smallest Prime Fraction | Medium |
| 373 | Find K Pairs with Smallest Sums | Medium |

---

## 29. Backtracking — Subsets & Combinations

| # | Problem | Difficulty |
|---|---------|------------|
| 78 | Subsets | Medium |
| 90 | Subsets II (with duplicates) | Medium |
| 77 | Combinations | Medium |
| 39 | Combination Sum | Medium |
| 40 | Combination Sum II | Medium |
| 216 | Combination Sum III | Medium |
| 377 | Combination Sum IV | Medium |
| 1239 | Maximum Length of a Concatenated String with Unique Characters | Medium |
| 2397 | Maximum Rows Covered by Columns | Medium |

---

## 30. Backtracking — Permutations

| # | Problem | Difficulty |
|---|---------|------------|
| 46 | Permutations | Medium |
| 47 | Permutations II (with duplicates) | Medium |
| 31 | Next Permutation | Medium |
| 60 | Permutation Sequence | Hard |
| 267 | Palindrome Permutation II | Medium |

---

## 31. Backtracking — Grid & String

| # | Problem | Difficulty |
|---|---------|------------|
| 17 | Letter Combinations of a Phone Number | Medium |
| 22 | Generate Parentheses | Medium |
| 131 | Palindrome Partitioning | Medium |
| 93 | Restore IP Addresses | Medium |
| 320 | Generalized Abbreviation | Medium |
| 79 | Word Search | Medium |
| 526 | Beautiful Arrangement | Medium |
| 1219 | Path with Maximum Gold | Medium |
| 2305 | Fair Distribution of Cookies | Medium |
| 2044 | Count Number of Maximum Bitwise-OR Subsets | Medium |
| 212 | Word Search II | Hard |
| 980 | Unique Paths III | Hard |
| 1255 | Maximum Score Words Formed by Letters | Hard |
| 132 | Palindrome Partitioning II | Hard |

---

## 32. Backtracking — Hard Constraint

| # | Problem | Difficulty |
|---|---------|------------|
| 51 | N-Queens | Hard |
| 52 | N-Queens II | Hard |
| 37 | Sudoku Solver | Hard |
| 488 | Zuma Game | Hard |
| 753 | Cracking the Safe | Hard |
| 996 | Number of Squareful Arrays | Hard |
| 1307 | Verbal Arithmetic Puzzle | Hard |

---

## 33. Graph — Grid BFS

| # | Problem | Difficulty |
|---|---------|------------|
| 733 | Flood Fill | Easy |
| 463 | Island Perimeter | Easy |
| 1020 | Number of Enclaves | Medium |
| 994 | Rotting Oranges | Medium |
| 286 | Walls and Gates | Medium |
| 1162 | As Far from Land as Possible | Medium |
| 542 | 01 Matrix | Medium |
| 1091 | Shortest Path in Binary Matrix | Medium |
| 1926 | Nearest Exit from Entrance in Maze | Medium |
| 2146 | K Highest Ranked Items Within a Price Range | Medium |
| 2258 | Escape the Spreading Fire | Hard |
| 2290 | Minimum Obstacle Removal to Reach Corner | Hard |
| 1293 | Shortest Path in a Grid with Obstacles Elimination | Hard |
| 2812 | Find the Safest Path in a Grid | Medium |
| 1368 | Minimum Cost to Make at Least One Valid Path in a Grid | Hard |

---

## 34. Graph — Grid DFS

| # | Problem | Difficulty |
|---|---------|------------|
| 200 | Number of Islands | Medium |
| 695 | Max Area of Island | Medium |
| 1254 | Number of Closed Islands | Medium |
| 1905 | Count Sub Islands | Medium |
| 130 | Surrounded Regions | Medium |
| 417 | Pacific Atlantic Water Flow | Medium |
| 1020 | Number of Enclaves | Medium |
| 2316 | Count Unreachable Pairs of Nodes in an Undirected Graph | Medium |
| 329 | Longest Increasing Path in a Matrix | Hard |
| 1971 | Find if Path Exists in Graph | Easy |

---

## 35. Graph — General BFS

| # | Problem | Difficulty |
|---|---------|------------|
| 1971 | Find if Path Exists in Graph | Easy |
| 127 | Word Ladder | Hard |
| 126 | Word Ladder II | Hard |
| 752 | Open the Lock | Medium |
| 909 | Snakes and Ladders | Medium |
| 1129 | Shortest Path with Alternating Colors | Medium |
| 1306 | Jump Game III | Medium |
| 1345 | Jump Game IV | Hard |
| 1376 | Time Needed to Inform All Employees | Medium |
| 2039 | The Time When the Network Becomes Idle | Medium |
| 2059 | Minimum Operations to Convert Number | Medium |
| 2492 | Minimum Score of a Path Between Two Cities | Medium |
| 2608 | Shortest Cycle in a Graph | Hard |
| 2612 | Minimum Reverse Operations | Hard |
| 2617 | Minimum Number of Visited Cells in a Grid | Hard |

---

## 36. Graph — General DFS

| # | Problem | Difficulty |
|---|---------|------------|
| 133 | Clone Graph | Medium |
| 547 | Number of Provinces | Medium |
| 1059 | All Paths from Source Lead to Destination | Medium |
| 1466 | Reorder Routes to Make All Paths Lead to the City Zero | Medium |
| 1557 | Minimum Number of Vertices to Reach All Nodes | Medium |
| 802 | Find Eventual Safe States | Medium |
| 2101 | Detonate the Maximum Bombs | Medium |
| 2360 | Longest Cycle in a Graph | Hard |
| 2467 | Most Profitable Path in a Tree | Medium |
| 2477 | Minimum Fuel Cost to Report to the Capital | Medium |
| 2492 | Minimum Score of a Path Between Two Cities | Medium |
| 2699 | Modify Graph Edge Weights | Hard |

---

## 37. Union Find (DSU)

| # | Problem | Difficulty |
|---|---------|------------|
| 547 | Number of Provinces | Medium |
| 684 | Redundant Connection | Medium |
| 261 | Graph Valid Tree | Medium |
| 323 | Number of Connected Components | Medium |
| 990 | Satisfiability of Equality Equations | Medium |
| 1319 | Number of Operations to Make Network Connected | Medium |
| 1202 | Smallest String With Swaps | Medium |
| 1584 | Min Cost to Connect All Points | Medium |
| 721 | Accounts Merge | Medium |
| 737 | Sentence Similarity II | Medium |
| 1061 | Lexicographically Smallest Equivalent String | Medium |
| 1258 | Synonymous Sentences | Medium |
| 1579 | Remove Max Number of Edges to Keep Graph Fully Traversable | Hard |
| 1697 | Checking Existence of Edge Length Limited Paths | Hard |
| 1722 | Minimize Hamming Distance After Swap Operations | Medium |
| 1970 | Last Day Where You Can Still Cross | Hard |
| 2076 | Process Restricted Friend Requests | Medium |
| 2092 | Find All People With Secret | Hard |
| 2421 | Number of Good Paths | Hard |
| 2424 | Longest Uploaded Prefix | Medium |
| 2492 | Minimum Score of a Path Between Two Cities | Medium |
| 2685 | Count the Number of Complete Components | Medium |
| 305 | Number of Islands II | Hard |
| 839 | Similar String Groups | Hard |
| 952 | Largest Component Size by Common Factor | Hard |
| 685 | Redundant Connection II | Hard |

---

## 38. Topological Sort

| # | Problem | Difficulty |
|---|---------|------------|
| 207 | Course Schedule | Medium |
| 210 | Course Schedule II | Medium |
| 310 | Minimum Height Trees | Medium |
| 444 | Sequence Reconstruction | Medium |
| 802 | Find Eventual Safe States | Medium |
| 1136 | Parallel Courses | Medium |
| 1557 | Minimum Number of Vertices to Reach All Nodes | Medium |
| 2115 | Find All Possible Recipes from Given Supplies | Medium |
| 1462 | Course Schedule IV | Medium |
| 1059 | All Paths from Source Lead to Destination | Medium |
| 269 | Alien Dictionary | Hard |
| 1203 | Sort Items by Groups Respecting Dependencies | Hard |
| 1857 | Largest Color Value in a Directed Graph | Hard |
| 630 | Course Schedule III | Hard |
| 2050 | Parallel Courses III | Hard |
| 2360 | Longest Cycle in a Graph | Hard |

---

## 39. Shortest Path — Dijkstra

| # | Problem | Difficulty |
|---|---------|------------|
| 743 | Network Delay Time | Medium |
| 1514 | Path with Maximum Probability | Medium |
| 1631 | Path With Minimum Effort | Medium |
| 1786 | Number of Restricted Paths From First to Last Node | Medium |
| 1976 | Number of Ways to Arrive at Destination | Medium |
| 2045 | Second Minimum Time to Reach Destination | Hard |
| 2290 | Minimum Obstacle Removal to Reach Corner | Hard |
| 778 | Swim in Rising Water | Hard |
| 1368 | Minimum Cost to Make at Least One Valid Path in a Grid | Hard |
| 505 | The Maze II | Medium |
| 499 | The Maze III | Hard |
| 882 | Reachable Nodes In Subdivided Graph | Hard |
| 1928 | Minimum Cost to Reach Destination in Time | Hard |
| 2093 | Minimum Cost to Reach City With Discounts | Medium |
| 2203 | Minimum Weighted Subgraph With the Required Paths | Hard |
| 2473 | Minimum Cost to Buy Apples | Medium |
| 2492 | Minimum Score of a Path Between Two Cities | Medium |
| 2577 | Minimum Time to Visit a Cell In a Grid | Hard |
| 2642 | Design Graph With Shortest Path Calculator | Hard |
| 2699 | Modify Graph Edge Weights | Hard |
| 2812 | Find the Safest Path in a Grid | Medium |

---

## 40. Shortest Path — Bellman-Ford / SPFA

| # | Problem | Difficulty |
|---|---------|------------|
| 787 | Cheapest Flights Within K Stops | Medium |
| 743 | Network Delay Time | Medium |
| 1334 | Find the City With the Smallest Number of Neighbors | Medium |
| 2976 | Minimum Cost to Convert String I | Medium |
| 2977 | Minimum Cost to Convert String II | Hard |

---

## 41. Shortest Path — Floyd-Warshall

| # | Problem | Difficulty |
|---|---------|------------|
| 1334 | Find the City With the Smallest Number of Neighbors | Medium |
| 399 | Evaluate Division | Medium |
| 2976 | Minimum Cost to Convert String I | Medium |

---

## 42. Minimum Spanning Tree

| # | Problem | Difficulty |
|---|---------|------------|
| 1584 | Min Cost to Connect All Points | Medium |
| 1135 | Connecting Cities With Minimum Cost | Medium |
| 1168 | Optimize Water Distribution in a Village | Hard |
| 1489 | Find Critical and Pseudo-Critical Edges in MST | Hard |

---

## 43. Strongly Connected Components / Bridges

| # | Problem | Difficulty |
|---|---------|------------|
| 1192 | Critical Connections in a Network | Hard |
| 1568 | Minimum Number of Days to Disconnect Island | Hard |

---

## 44. Bipartite Graph

| # | Problem | Difficulty |
|---|---------|------------|
| 785 | Is Graph Bipartite? | Medium |
| 886 | Possible Bipartition | Medium |
| 2493 | Divide Nodes Into the Maximum Number of Groups | Hard |

---

## 45. Eulerian Path

| # | Problem | Difficulty |
|---|---------|------------|
| 332 | Reconstruct Itinerary | Hard |
| 753 | Cracking the Safe | Hard |
| 2097 | Valid Arrangement of Pairs | Hard |

---

## 46. 1D DP — Linear / Index-based

| # | Problem | Difficulty |
|---|---------|------------|
| 70 | Climbing Stairs | Easy |
| 746 | Min Cost Climbing Stairs | Easy |
| 509 | Fibonacci Number | Easy |
| 1137 | N-th Tribonacci Number | Easy |
| 198 | House Robber | Medium |
| 213 | House Robber II | Medium |
| 740 | Delete and Earn | Medium |
| 2140 | Solving Questions With Brainpower | Medium |
| 2466 | Count Ways To Build Good Strings | Medium |
| 91 | Decode Ways | Medium |
| 639 | Decode Ways II | Hard |
| 1043 | Partition Array for Maximum Sum | Medium |
| 2369 | Check if There is a Valid Partition For The Array | Medium |
| 256 | Paint House | Medium |
| 265 | Paint House II | Hard |
| 1218 | Longest Arithmetic Subsequence of Given Difference | Medium |
| 1477 | Find Two Non-overlapping Sub-arrays Each With Target Sum | Medium |
| 1621 | Number of Sets of K Non-Overlapping Line Segments | Medium |
| 1641 | Count Sorted Vowel Strings | Medium |
| 1646 | Get Maximum in Generated Array | Easy |
| 1654 | Minimum Jumps to Reach Home | Medium |
| 1696 | Jump Game VI | Medium |
| 1770 | Maximum Score from Performing Multiplication Operations | Medium |
| 1871 | Jump Game VII | Medium |
| 2008 | Maximum Earnings From Taxi | Medium |
| 2054 | Two Best Non-Overlapping Events | Medium |
| 2320 | Count Number of Ways to Place Houses | Medium |
| 2400 | Number of Ways to Reach a Position After Exactly k Steps | Medium |
| 2501 | Longest Square Streak in an Array | Medium |
| 2547 | Minimum Cost to Split an Array | Hard |
| 2560 | House Robber IV | Medium |
| 2707 | Extra Characters in a String | Medium |
| 2767 | Partition String Into Minimum Beautiful Substrings | Medium |
| 2826 | Sorting Three Groups | Medium |

---

## 47. 1D DP — Kadane (Max Subarray)

| # | Problem | Difficulty |
|---|---------|------------|
| 53 | Maximum Subarray | Medium |
| 152 | Maximum Product Subarray | Medium |
| 918 | Maximum Sum Circular Subarray | Medium |
| 1749 | Maximum Absolute Sum of Any Subarray | Medium |
| 2321 | Maximum Score Of Spliced Array | Hard |
| 2414 | Length of the Longest Alphabetical Continuous Substring | Medium |
| 2606 | Find the Substring With Maximum Cost | Medium |

---

## 48. 1D DP — LIS & Variants

| # | Problem | Difficulty |
|---|---------|------------|
| 300 | Longest Increasing Subsequence | Medium |
| 673 | Number of Longest Increasing Subsequence | Medium |
| 354 | Russian Doll Envelopes | Hard |
| 1964 | Find the Longest Valid Obstacle Course at Each Position | Hard |
| 1626 | Best Team With No Conflicts | Medium |
| 1671 | Minimum Number of Removals to Make Mountain Array | Hard |
| 1713 | Minimum Operations to Make a Subsequence | Hard |
| 2111 | Minimum Operations to Make the Array K-Increasing | Hard |
| 2370 | Longest Ideal Subsequence | Medium |
| 2407 | Longest Increasing Subsequence II | Hard |
| 2771 | Longest Non-decreasing Subarray From Two Arrays | Medium |
| 368 | Largest Divisible Subset | Medium |
| 646 | Maximum Length of Pair Chain | Medium |
| 1218 | Longest Arithmetic Subsequence of Given Difference | Medium |
| 1027 | Longest Arithmetic Subsequence | Medium |

---

## 49. 1D DP — Stock Problems

| # | Problem | Difficulty |
|---|---------|------------|
| 121 | Best Time to Buy and Sell Stock | Easy |
| 122 | Best Time to Buy and Sell Stock II | Medium |
| 123 | Best Time to Buy and Sell Stock III | Hard |
| 188 | Best Time to Buy and Sell Stock IV | Hard |
| 309 | Best Time to Buy and Sell Stock with Cooldown | Medium |
| 714 | Best Time to Buy and Sell Stock with Transaction Fee | Medium |

---

## 50. 1D DP — State Machine

| # | Problem | Difficulty |
|---|---------|------------|
| 309 | Best Time to Buy and Sell Stock with Cooldown | Medium |
| 714 | Best Time to Buy and Sell Stock with Transaction Fee | Medium |
| 376 | Wiggle Subsequence | Medium |
| 1186 | Maximum Subarray Sum with One Deletion | Medium |
| 2222 | Number of Ways to Select Buildings | Medium |

---

## 51. 1D DP — Knapsack 0/1

| # | Problem | Difficulty |
|---|---------|------------|
| 416 | Partition Equal Subset Sum | Medium |
| 494 | Target Sum | Medium |
| 1049 | Last Stone Weight II | Medium |
| 474 | Ones and Zeroes | Medium |
| 2915 | Length of the Longest Subsequence That Sums to Target | Medium |
| 1774 | Closest Dessert Cost | Medium |
| 879 | Profitable Schemes | Hard |
| 956 | Tallest Billboard | Hard |
| 1434 | Number of Ways to Wear Different Hats to Each Other | Hard |

---

## 52. 1D DP — Knapsack Unbounded

| # | Problem | Difficulty |
|---|---------|------------|
| 322 | Coin Change | Medium |
| 518 | Coin Change II | Medium |
| 279 | Perfect Squares | Medium |
| 983 | Minimum Cost For Tickets | Medium |
| 1449 | Number of Ways of Cutting a Pizza | Hard |
| 2218 | Maximum Value of K Coins From Piles | Hard |
| 2547 | Minimum Cost to Split an Array | Hard |
| 2585 | Number of Ways to Earn Points | Hard |
| 2902 | Count of Sub-Multisets With Bounded Sum | Hard |

---

## 53. 2D DP — Grid

| # | Problem | Difficulty |
|---|---------|------------|
| 62 | Unique Paths | Medium |
| 63 | Unique Paths II | Medium |
| 64 | Minimum Path Sum | Medium |
| 120 | Triangle | Medium |
| 221 | Maximal Square | Medium |
| 1277 | Count Square Submatrices with All Ones | Medium |
| 1504 | Count Submatrices With All Ones | Medium |
| 931 | Minimum Falling Path Sum | Medium |
| 1289 | Minimum Falling Path Sum II | Hard |
| 741 | Cherry Pickup | Hard |
| 1463 | Cherry Pickup II | Hard |
| 174 | Dungeon Game | Hard |
| 2304 | Minimum Path Cost in a Grid | Medium |
| 2435 | Paths in Matrix Whose Sum Is Divisible by K | Hard |
| 2510 | Check if There is a Path With Equal Number of 0's And 1's | Medium |
| 2684 | Maximum Number of Moves in a Grid | Medium |
| 2770 | Maximum Number of Jumps to Reach the Last Index | Medium |

---

## 54. 2D DP — Two Strings (LCS / Edit Distance)

| # | Problem | Difficulty |
|---|---------|------------|
| 1143 | Longest Common Subsequence | Medium |
| 583 | Delete Operation for Two Strings | Medium |
| 72 | Edit Distance | Medium |
| 97 | Interleaving String | Medium |
| 115 | Distinct Subsequences | Hard |
| 1035 | Uncrossed Lines | Medium |
| 1092 | Shortest Common Supersequence | Hard |
| 44 | Wildcard Matching | Hard |
| 10 | Regular Expression Matching | Hard |
| 1458 | Max Dot Product of Two Subsequences | Hard |
| 1682 | Longest Palindromic Subsequence II | Hard |
| 2707 | Extra Characters in a String | Medium |

---

## 55. DP — Palindrome

| # | Problem | Difficulty |
|---|---------|------------|
| 5 | Longest Palindromic Substring | Medium |
| 647 | Palindromic Substrings | Medium |
| 516 | Longest Palindromic Subsequence | Medium |
| 1312 | Minimum Insertion Steps to Make a String Palindrome | Hard |
| 1771 | Maximize Palindrome Length From Subsequences | Hard |
| 730 | Count Different Palindromic Subsequences | Hard |
| 1930 | Unique Length-3 Palindromic Subsequences | Medium |
| 2002 | Maximum Product of the Length of Two Palindromic Subsequences | Medium |
| 2longest | (see Manacher section) | — |

---

## 56. DP — Interval (Range DP)

| # | Problem | Difficulty |
|---|---------|------------|
| 312 | Burst Balloons | Hard |
| 1039 | Minimum Score Triangulation of Polygon | Medium |
| 1547 | Minimum Cost to Cut a Stick | Hard |
| 375 | Guess Number Higher or Lower II | Medium |
| 877 | Stone Game | Medium |
| 1140 | Stone Game II | Medium |
| 1406 | Stone Game III | Hard |
| 1510 | Stone Game IV | Hard |
| 1563 | Stone Game V | Hard |
| 1686 | Stone Game VI | Medium |
| 1690 | Stone Game VII | Medium |
| 2029 | Stone Game IX | Medium |
| 546 | Remove Boxes | Hard |
| 664 | Strange Printer | Hard |
| 1000 | Minimum Cost to Merge Stones | Hard |
| 1130 | Minimum Cost Tree From Leaf Values | Medium |
| 1531 | String Compression II | Hard |
| 1039 | Minimum Score Triangulation of Polygon | Medium |

---

## 57. DP — Partition

| # | Problem | Difficulty |
|---|---------|------------|
| 132 | Palindrome Partitioning II | Hard |
| 139 | Word Break | Medium |
| 140 | Word Break II | Hard |
| 1278 | Palindrome Partitioning III | Hard |
| 1745 | Palindrome Partitioning IV | Hard |
| 1043 | Partition Array for Maximum Sum | Medium |
| 813 | Largest Sum of Averages | Medium |
| 1335 | Minimum Difficulty of a Job Schedule | Hard |
| 410 | Split Array Largest Sum | Hard |
| 1444 | Number of Ways of Cutting a Pizza | Hard |
| 2767 | Partition String Into Minimum Beautiful Substrings | Medium |
| 2911 | Minimum Changes to Make K Semi-palindromes | Hard |

---

## 58. DP — Digit DP

| # | Problem | Difficulty |
|---|---------|------------|
| 233 | Number of Digit One | Hard |
| 357 | Count Numbers with Unique Digits | Medium |
| 600 | Non-negative Integers without Consecutive Ones | Hard |
| 788 | Rotated Digits | Medium |
| 902 | Numbers At Most N Given Digit Set | Hard |
| 1012 | Numbers With Repeated Digits | Hard |
| 1067 | Digit Count in Range | Hard |
| 2376 | Count Special Integers | Hard |
| 2719 | Count of Integers | Hard |
| 2801 | Count Stepping Numbers in Range | Hard |
| 2827 | Number of Beautiful Integers in the Range | Hard |

---

## 59. DP — Bitmask DP

| # | Problem | Difficulty |
|---|---------|------------|
| 464 | Can I Win | Medium |
| 526 | Beautiful Arrangement | Medium |
| 847 | Shortest Path Visiting All Nodes | Hard |
| 943 | Find the Shortest Superstring | Hard |
| 1125 | Smallest Sufficient Team | Hard |
| 1349 | Maximum Students Taking Exam | Hard |
| 1411 | Number of Ways to Paint N × 3 Grid | Hard |
| 1434 | Number of Ways to Wear Different Hats to Each Other | Hard |
| 1494 | Parallel Courses II | Hard |
| 1681 | Minimum Incompatibility | Hard |
| 2002 | Maximum Product of the Length of Two Palindromic Subsequences | Medium |
| 2172 | Maximum AND Sum of Array | Hard |
| 2305 | Fair Distribution of Cookies | Medium |
| 2403 | Minimum Time to Kill All Monsters | Hard |
| 2741 | Special Permutations | Medium |

---

## 60. DP — Tree DP

| # | Problem | Difficulty |
|---|---------|------------|
| 337 | House Robber III | Medium |
| 543 | Diameter of Binary Tree | Easy |
| 687 | Longest Univalue Path | Medium |
| 834 | Sum of Distances in Tree | Hard |
| 968 | Binary Tree Cameras | Hard |
| 979 | Distribute Coins in Binary Tree | Medium |
| 1026 | Maximum Difference Between Node and Ancestor | Medium |
| 1245 | Tree Diameter | Medium |
| 1372 | Longest ZigZag Path in a Binary Tree | Medium |
| 2246 | Longest Path With Different Adjacent Characters | Medium |
| 2538 | Difference Between Maximum and Minimum Price Sum | Hard |
| 2925 | Maximum Score After Applying Operations on a Tree | Medium |
| 2973 | Find Number of Coins to Place in Tree Nodes | Medium |
| 310 | Minimum Height Trees | Medium |
| 2477 | Minimum Fuel Cost to Report to the Capital | Medium |

---

## 61. Greedy — Intervals & Scheduling

| # | Problem | Difficulty |
|---|---------|------------|
| 252 | Meeting Rooms | Easy |
| 253 | Meeting Rooms II | Medium |
| 435 | Non-overlapping Intervals | Medium |
| 452 | Minimum Number of Arrows to Burst Balloons | Medium |
| 646 | Maximum Length of Pair Chain | Medium |
| 1353 | Maximum Number of Events That Can Be Attended | Medium |
| 1094 | Car Pooling | Medium |
| 1326 | Minimum Number of Taps to Open to Water a Garden | Hard |
| 1834 | Single-Threaded CPU | Medium |
| 2054 | Two Best Non-Overlapping Events | Medium |
| 2136 | Earliest Possible Day of Full Bloom | Hard |
| 2406 | Divide Intervals Into Minimum Number of Groups | Medium |
| 630 | Course Schedule III | Hard |

---

## 62. Greedy — Sorting-based

| # | Problem | Difficulty |
|---|---------|------------|
| 455 | Assign Cookies | Easy |
| 860 | Lemonade Change | Easy |
| 881 | Boats to Save People | Medium |
| 976 | Largest Perimeter Triangle | Medium |
| 1029 | Two City Scheduling | Medium |
| 1046 | Last Stone Weight | Easy |
| 1054 | Distant Barcodes | Medium |
| 1383 | Maximum Performance of a Team | Hard |
| 1402 | Reducing Dishes | Hard |
| 1405 | Longest Happy String | Medium |
| 1465 | Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts | Medium |
| 1509 | Minimum Difference Between Largest and Smallest Value in Three Moves | Medium |
| 1561 | Maximum Number of Coins You Can Get | Medium |
| 1567 | Maximum Length of Subarray With Positive Product | Medium |
| 1710 | Maximum Units on a Truck | Easy |
| 1846 | Maximum Element After Decreasing and Rearranging | Medium |
| 1877 | Minimize Maximum Pair Sum in Array | Medium |
| 2126 | Destroying Asteroids | Medium |
| 2233 | Maximum Product After K Increments | Medium |
| 2279 | Maximum Bags With Full Capacity of Rocks | Medium |
| 2294 | Partition Array Such That Maximum Difference Is K | Medium |
| 2333 | Minimum Sum of Squared Difference | Medium |
| 2357 | Make Array Zero by Subtracting Equal Amounts | Easy |
| 2410 | Maximum Matching of Players With Trainers | Medium |
| 2449 | Minimum Number of Operations to Make Arrays Similar | Hard |
| 2462 | Total Cost to Hire K Workers | Medium |
| 2486 | Append Characters to String to Make Subsequence | Medium |
| 2522 | Partition String Into Substrings With Values at Most K | Medium |
| 2611 | Mice and Cheese | Medium |
| 406 | Queue Reconstruction by Height | Medium |

---

## 63. Greedy — String

| # | Problem | Difficulty |
|---|---------|------------|
| 392 | Is Subsequence | Easy |
| 402 | Remove K Digits | Medium |
| 316 | Remove Duplicate Letters | Medium |
| 763 | Partition Labels | Medium |
| 678 | Valid Parenthesis String | Medium |
| 1081 | Smallest Subsequence of Distinct Characters | Medium |
| 1328 | Break a Palindrome | Medium |
| 1400 | Construct K Palindrome Strings | Medium |
| 1529 | Minimum Suffix Flips | Medium |
| 1616 | Split Two Strings to Make Palindrome | Medium |
| 1647 | Minimum Deletions to Make Character Frequencies Unique | Medium |
| 1717 | Maximum Score From Removing Substrings | Medium |
| 2116 | Check if a Parentheses String Can Be Valid | Medium |
| 2182 | Construct String With Repeat Limit | Medium |
| 2434 | Using a Robot to Print the Lexicographically Smallest String | Medium |
| 2645 | Minimum Additions to Make Valid String | Medium |
| 2697 | Lexicographically Smallest Palindrome | Easy |
| 2734 | Lexicographically Smallest String After Substring Operation | Medium |
| 44 | Wildcard Matching | Hard |

---

## 64. Greedy — Array / Number

| # | Problem | Difficulty |
|---|---------|------------|
| 55 | Jump Game | Medium |
| 45 | Jump Game II | Medium |
| 134 | Gas Station | Medium |
| 135 | Candy | Hard |
| 846 | Hand of Straights | Medium |
| 1899 | Merge Triplets to Form Target Triplet | Medium |
| 2027 | Minimum Moves to Convert String | Easy |
| 2038 | Remove Colored Pieces if Both Neighbors are the Same Color | Medium |
| 2086 | Minimum Number of Food Buckets to Feed the Hamsters | Medium |
| 2340 | Minimum Adjacent Swaps to Make a Valid Array | Medium |
| 2380 | Time Needed to Rearrange a Binary String | Medium |
| 2384 | Largest Palindromic Number | Medium |
| 2457 | Minimum Addition to Make Integer Beautiful | Medium |
| 2498 | Frog Jump II | Medium |
| 2571 | Minimum Operations to Reduce X to Zero | Medium |
| 2578 | Split With Minimum Sum | Easy |
| 2600 | K Items With the Maximum Sum | Easy |
| 2656 | Maximum Sum With Exactly K Elements | Easy |
| 2673 | Make Costs of Paths Equal in a Binary Tree | Medium |
| 2700 | Differences Between Two Objects | Easy |
| 2745 | Construct the Longest New String | Medium |
| 2789 | Largest Element in an Array after Merge Operations | Medium |
| 2829 | Determine the Minimum Sum of a Mountain Array | Medium |

---

## 65. Intervals

| # | Problem | Difficulty |
|---|---------|------------|
| 252 | Meeting Rooms | Easy |
| 253 | Meeting Rooms II | Medium |
| 56 | Merge Intervals | Medium |
| 57 | Insert Interval | Medium |
| 435 | Non-overlapping Intervals | Medium |
| 452 | Minimum Number of Arrows to Burst Balloons | Medium |
| 986 | Interval List Intersections | Medium |
| 1288 | Remove Covered Intervals | Medium |
| 1851 | Minimum Interval to Include Each Query | Hard |
| 2054 | Two Best Non-Overlapping Events | Medium |
| 2406 | Divide Intervals Into Minimum Number of Groups | Medium |
| 2410 | Maximum Matching of Players With Trainers | Medium |
| 759 | Employee Free Time | Hard |
| 715 | Range Module | Hard |
| 352 | Data Stream as Disjoint Intervals | Hard |

---

## 66. Sorting — Merge Sort Applications

| # | Problem | Difficulty |
|---|---------|------------|
| 148 | Sort List | Medium |
| 315 | Count of Smaller Numbers After Self | Hard |
| 327 | Count of Range Sum | Hard |
| 493 | Reverse Pairs | Hard |
| 218 | The Skyline Problem | Hard |
| 2426 | Number of Pairs Satisfying Inequality | Hard |
| 2179 | Count Good Triplets in an Array | Hard |

---

## 67. Sorting — Quick Select

| # | Problem | Difficulty |
|---|---------|------------|
| 215 | Kth Largest Element in an Array | Medium |
| 973 | K Closest Points to Origin | Medium |
| 347 | Top K Frequent Elements | Medium |
| 324 | Wiggle Sort II | Medium |

---

## 68. Sorting — Custom Comparator

| # | Problem | Difficulty |
|---|---------|------------|
| 179 | Largest Number | Medium |
| 406 | Queue Reconstruction by Height | Medium |
| 791 | Custom Sort String | Medium |
| 937 | Reorder Data in Log Files | Medium |
| 1122 | Relative Sort Array | Easy |
| 1636 | Sort Array by Increasing Frequency | Easy |
| 2418 | Sort the People | Easy |
| 2545 | Sort the Students by Their Kth Score | Medium |
| 2099 | Find Subsequence of Length K With the Largest Sum | Easy |

---

## 69. Sorting — Counting / Bucket / Radix

| # | Problem | Difficulty |
|---|---------|------------|
| 164 | Maximum Gap | Hard |
| 274 | H-Index | Medium |
| 275 | H-Index II | Medium |
| 347 | Top K Frequent Elements | Medium |
| 451 | Sort Characters By Frequency | Medium |
| 1275 | Find Winner on a Tic Tac Toe Game | Easy |
| 1636 | Sort Array by Increasing Frequency | Easy |

---

## 70. Divide & Conquer

| # | Problem | Difficulty |
|---|---------|------------|
| 169 | Majority Element | Easy |
| 53 | Maximum Subarray | Medium |
| 148 | Sort List | Medium |
| 4 | Median of Two Sorted Arrays | Hard |
| 23 | Merge k Sorted Lists | Hard |
| 315 | Count of Smaller Numbers After Self | Hard |
| 327 | Count of Range Sum | Hard |
| 493 | Reverse Pairs | Hard |
| 218 | The Skyline Problem | Hard |
| 932 | Beautiful Array | Hard |
| 241 | Different Ways to Add Parentheses | Medium |
| 395 | Longest Substring with At Least K Repeating Characters | Medium |

---

## 71. Math — Number Theory

| # | Problem | Difficulty |
|---|---------|------------|
| 204 | Count Primes (Sieve) | Medium |
| 263 | Ugly Number | Easy |
| 264 | Ugly Number II | Medium |
| 313 | Super Ugly Number | Medium |
| 1979 | Find Greatest Common Divisor of Array | Easy |
| 2413 | Smallest Even Multiple | Easy |
| 2427 | Number of Common Factors | Easy |
| 2507 | Smallest Value After Replacing With Sum of Prime Factors | Medium |
| 2521 | Distinct Prime Factors of Product of Array | Medium |
| 2523 | Closest Prime Numbers in Range | Medium |
| 2584 | Split the Array to Make Coprime Products | Hard |
| 1250 | Check If It Is a Good Array | Hard |
| 365 | Water and Jug Problem | Medium |
| 858 | Mirror Reflection | Medium |
| 2344 | Minimum Deletions to Make Array Divisible | Hard |
| 1819 | Number of Different Subsequences GCDs | Hard |
| 2338 | Count the Number of Ideal Arrays | Hard |
| 878 | Nth Magical Number | Hard |

---

## 72. Math — Combinatorics & Probability

| # | Problem | Difficulty |
|---|---------|------------|
| 62 | Unique Paths | Medium |
| 119 | Pascal's Triangle II | Easy |
| 118 | Pascal's Triangle | Easy |
| 1401 | Circle and Rectangle Overlapping | Medium |
| 1726 | Tuple with Same Product | Medium |
| 1759 | Count Number of Homogenous Substrings | Medium |
| 1828 | Queries on Number of Points Inside a Circle | Medium |
| 2063 | Vowels of All Substrings | Medium |
| 2189 | Number of Ways to Build House of Cards | Medium |
| 2212 | Maximum Points in an Archery Competition | Medium |
| 2244 | Minimum Rounds to Complete All Tasks | Medium |
| 1922 | Count Good Numbers | Medium |
| 2147 | Number of Ways to Divide a Long Corridor | Hard |
| 1359 | Count All Valid Pickup and Delivery Options | Hard |
| 1569 | Number of Ways to Reorder Array to Get Same BST | Hard |
| 1575 | Count All Possible Routes | Hard |

---

## 73. Math — Modular Arithmetic

| # | Problem | Difficulty |
|---|---------|------------|
| 50 | Pow(x, n) | Medium |
| 372 | Super Pow | Medium |
| 1922 | Count Good Numbers | Medium |
| 2338 | Count the Number of Ideal Arrays | Hard |
| 1916 | Count Ways to Build Rooms in an Ant Colony | Hard |

---

## 74. Math — Geometry

| # | Problem | Difficulty |
|---|---------|------------|
| 48 | Rotate Image | Medium |
| 54 | Spiral Matrix | Medium |
| 59 | Spiral Matrix II | Medium |
| 885 | Spiral Matrix III | Medium |
| 2326 | Spiral Matrix IV | Medium |
| 73 | Set Matrix Zeroes | Medium |
| 289 | Game of Life | Medium |
| 2013 | Detect Squares | Medium |
| 149 | Max Points on a Line | Hard |
| 587 | Erect the Fence | Hard |
| 1232 | Check If It Is a Straight Line | Easy |
| 1266 | Minimum Time Visiting All Points | Easy |
| 1401 | Circle and Rectangle Overlapping | Medium |
| 1828 | Queries on Number of Points Inside a Circle | Medium |
| 2152 | Minimum Number of Lines to Cover Points | Medium |
| 2280 | Minimum Lines to Represent a Line Chart | Medium |

---

## 75. Math — Simulation

| # | Problem | Difficulty |
|---|---------|------------|
| 7 | Reverse Integer | Medium |
| 9 | Palindrome Number | Easy |
| 12 | Integer to Roman | Medium |
| 13 | Roman to Integer | Easy |
| 14 | Longest Common Prefix | Easy |
| 66 | Plus One | Easy |
| 67 | Add Binary | Easy |
| 415 | Add Strings | Easy |
| 43 | Multiply Strings | Medium |
| 202 | Happy Number | Easy |
| 258 | Add Digits | Easy |
| 412 | Fizz Buzz | Easy |
| 836 | Rectangle Overlap | Easy |
| 1806 | Minimum Number of Operations to Reinitialize a Permutation | Medium |
| 1041 | Robot Bounded In Circle | Medium |
| 874 | Walking Robot Simulation | Medium |
| 2120 | Execution of All Suffix Instructions Staying in a Grid | Medium |
| 2169 | Count Operations to Obtain Zero | Easy |
| 2296 | Design a Text Editor | Hard |
| 2303 | Calculate Amount Paid in Taxes | Easy |
| 2460 | Apply Operations to an Array | Easy |
| 2562 | Find the Array Concatenation Value | Easy |
| 2566 | Maximum Difference by Remapping a Digit | Easy |
| 2587 | Rearrange Array to Maximize Prefix Score | Medium |
| 2678 | Number of Senior Citizens | Easy |
| 2682 | Find the Losers of the Circular Game | Easy |
| 2706 | Buy Two Chocolates | Easy |
| 2710 | Remove Trailing Zeros From a String | Easy |
| 2739 | Total Distance Traveled | Easy |
| 2833 | Furthest Point From Origin | Easy |
| 172 | Factorial Trailing Zeroes | Medium |
| 780 | Reaching Points | Hard |

---

## 76. Bit Manipulation — XOR Tricks

| # | Problem | Difficulty |
|---|---------|------------|
| 136 | Single Number | Easy |
| 268 | Missing Number | Easy |
| 461 | Hamming Distance | Easy |
| 137 | Single Number II | Medium |
| 260 | Single Number III | Medium |
| 421 | Maximum XOR of Two Numbers in an Array | Medium |
| 1829 | Maximum XOR for Each Query | Medium |
| 2425 | Bitwise XOR of All Pairings | Medium |
| 2997 | Minimum Number of Operations to Make Array XOR Equal to K | Medium |
| 1707 | Maximum XOR With an Element From Array | Hard |
| 2935 | Maximum Strong Pair XOR II | Hard |
| 1310 | XOR Queries of a Subarray | Medium |
| 1442 | Count Triplets That Can Form Two Arrays of Equal XOR | Medium |
| 1734 | Decode XORed Permutation | Medium |
| 2317 | Maximum XOR After Operations | Medium |
| 2564 | Substring XOR Queries | Medium |

---

## 77. Bit Manipulation — Masking & Counting

| # | Problem | Difficulty |
|---|---------|------------|
| 191 | Number of 1 Bits | Easy |
| 190 | Reverse Bits | Easy |
| 338 | Counting Bits | Easy |
| 762 | Prime Number of Set Bits in Binary Representation | Easy |
| 1009 | Complement of Base 10 Integer | Easy |
| 1356 | Sort Integers by The Number of 1 Bits | Easy |
| 371 | Sum of Two Integers | Medium |
| 201 | Bitwise AND of Numbers Range | Medium |
| 477 | Total Hamming Distance | Medium |
| 29 | Divide Two Integers | Medium |
| 1318 | Minimum Flips to Make a OR b Equal to c | Medium |
| 78 | Subsets (bitmask) | Medium |
| 2220 | Minimum Bit Flips to Convert Number | Easy |
| 2275 | Largest Combination With Bitwise AND Greater Than Zero | Medium |
| 2411 | Smallest Subarrays With Maximum Bitwise OR | Medium |
| 2419 | Longest Subarray With Maximum Bitwise AND | Medium |
| 2438 | Range Product Queries of Powers | Medium |
| 2505 | Bitwise OR of All Subsequence Sums | Medium |
| 2527 | Find Xor-Beauty of Array | Medium |
| 2568 | Minimum Impossible OR | Medium |
| 2595 | Number of Even and Odd Bits | Easy |
| 2731 | Movement of Robots | Medium |
| 2767 | Partition String Into Minimum Beautiful Substrings | Medium |
| 898 | Bitwise ORs of Subarrays | Medium |
| 1611 | Minimum One Bit Operations to Make Integers Zero | Hard |

---

## 78. String — KMP / Z-Algorithm

| # | Problem | Difficulty |
|---|---------|------------|
| 28 | Find the Index of the First Occurrence in a String | Easy |
| 459 | Repeated Substring Pattern | Easy |
| 686 | Repeated String Match | Medium |
| 214 | Shortest Palindrome | Hard |
| 1392 | Longest Happy Prefix | Hard |
| 796 | Rotate String | Easy |
| 1408 | String Matching in an Array | Easy |
| 2800 | Shortest String That Contains Three Strings | Medium |

---

## 79. String — Rolling Hash / Rabin-Karp

| # | Problem | Difficulty |
|---|---------|------------|
| 187 | Repeated DNA Sequences | Medium |
| 718 | Maximum Length of Repeated Subarray | Medium |
| 1044 | Longest Duplicate Substring | Hard |
| 1062 | Longest Repeating Substring | Medium |
| 1147 | Longest Chunked Palindrome Decomposition | Hard |
| 1316 | Distinct Echo Substrings | Hard |
| 2223 | Sum of Scores of Built Strings | Hard |

---

## 80. String — Manacher's Algorithm

| # | Problem | Difficulty |
|---|---------|------------|
| 5 | Longest Palindromic Substring | Medium |
| 647 | Palindromic Substrings | Medium |
| 214 | Shortest Palindrome | Hard |
| 1960 | Maximum Product of the Length of Two Palindromic Substrings | Hard |

---

## 81. Randomized Algorithms / Reservoir Sampling

| # | Problem | Difficulty |
|---|---------|------------|
| 382 | Linked List Random Node | Medium |
| 398 | Random Pick Index | Medium |
| 528 | Random Pick with Weight | Medium |
| 384 | Shuffle an Array | Medium |
| 470 | Implement Rand10() Using Rand7() | Medium |
| 380 | Insert Delete GetRandom O(1) | Medium |
| 381 | Insert Delete GetRandom O(1) - Duplicates | Hard |
| 710 | Random Pick with Blacklist | Hard |
| 478 | Generate Random Point in a Circle | Medium |

---

## 82. Design — Cache & Memory

| # | Problem | Difficulty |
|---|---------|------------|
| 146 | LRU Cache | Medium |
| 460 | LFU Cache | Hard |
| 1603 | Design Parking System | Easy |
| 1797 | Design Authentication Manager | Medium |

---

## 83. Design — Data Structure

| # | Problem | Difficulty |
|---|---------|------------|
| 155 | Min Stack | Medium |
| 716 | Max Stack | Hard |
| 232 | Implement Queue using Stacks | Easy |
| 225 | Implement Stack using Queues | Easy |
| 622 | Design Circular Queue | Medium |
| 641 | Design Circular Deque | Medium |
| 295 | Find Median from Data Stream | Hard |
| 380 | Insert Delete GetRandom O(1) | Medium |
| 381 | Insert Delete GetRandom O(1) - Duplicates | Hard |
| 703 | Kth Largest Element in a Stream | Easy |
| 895 | Maximum Frequency Stack | Hard |
| 1172 | Dinner Plate Stacks | Hard |
| 1206 | Design Skiplist | Hard |
| 1348 | Tweet Counts Per Frequency | Medium |
| 1381 | Design a Stack With Increment Operation | Medium |
| 1670 | Design Front Middle Back Queue | Medium |
| 2034 | Stock Price Fluctuation | Medium |
| 2080 | Range Frequency Queries | Medium |
| 2166 | Design Bitset | Medium |
| 2276 | Count Integers in Intervals | Hard |
| 2296 | Design a Text Editor | Hard |
| 2353 | Design a Food Rating System | Medium |
| 2590 | Design a Todo List | Medium |

---

## 84. Design — Iterator

| # | Problem | Difficulty |
|---|---------|------------|
| 173 | Binary Search Tree Iterator | Medium |
| 281 | Zigzag Iterator | Medium |
| 284 | Peeking Iterator | Medium |
| 341 | Flatten Nested List Iterator | Medium |
| 604 | Design Compressed String Iterator | Easy |
| 1286 | Iterator for Combination | Medium |

---

## 85. Design — System / Miscellaneous

| # | Problem | Difficulty |
|---|---------|------------|
| 208 | Implement Trie | Medium |
| 211 | Design Add and Search Words DS | Medium |
| 355 | Design Twitter | Medium |
| 588 | Design In-Memory File System | Hard |
| 635 | Design Log Storage System | Medium |
| 642 | Design Search Autocomplete System | Hard |
| 705 | Design HashSet | Easy |
| 706 | Design HashMap | Easy |
| 729 | My Calendar I | Medium |
| 731 | My Calendar II | Medium |
| 732 | My Calendar III | Hard |
| 981 | Time Based Key-Value Store | Medium |
| 1472 | Design Browser History | Medium |
| 1500 | Design a File Sharing System | Medium |
| 1570 | Dot Product of Two Sparse Vectors | Medium |
| 1656 | Design an Ordered Stream | Easy |
| 1858 | Longest Word With All Prefixes | Medium |
| 2069 | Walking Robot Simulation II | Medium |
| 2424 | Longest Uploaded Prefix | Medium |

---

## Study Order

```
Phase 1 — Foundations (Weeks 1–4)
  Arrays & Hashing → Prefix Sum → Two Pointers → Fast/Slow Pointers
  → Sliding Window (Fixed) → Sliding Window (Variable) → Stack → Binary Search (Classic)

Phase 2 — Core Data Structures (Weeks 5–9)
  Linked List (Basic → Reversal → Two Pointers)
  → Trees (DFS → Path → Construction → BFS)
  → BST → Trie → Heap / Priority Queue

Phase 3 — Graphs (Weeks 10–14)
  Grid BFS → Grid DFS → General BFS → General DFS
  → Union Find → Topological Sort
  → Dijkstra → Bellman-Ford → Floyd-Warshall → MST

Phase 4 — Backtracking (Weeks 13–15)
  Subsets → Combinations → Permutations → Grid/String → Hard Constraint

Phase 5 — Dynamic Programming (Weeks 16–24)
  1D Linear → Kadane → LIS → Stock → State Machine
  → Knapsack 0/1 → Knapsack Unbounded
  → 2D Grid → Two-String DP → Palindrome
  → Interval DP → Partition DP → Digit DP → Bitmask DP → Tree DP

Phase 6 — Advanced (Weeks 25+)
  Monotonic Stack → Monotonic Deque
  → Segment Tree → Fenwick Tree / BIT
  → Greedy (all types) → Intervals
  → Sorting variants → Divide & Conquer
  → Math (Number Theory → Combinatorics → Geometry)
  → Bit Manipulation → String Algorithms (KMP, Rolling Hash, Manacher)
  → Randomized → Design (all types)
```

---

## Pattern Recognition Quick Reference

| If problem says... | Use this pattern |
|-------------------|-----------------|
| subarray / substring with some constraint | Sliding Window |
| sorted array, find pair / triplet | Two Pointers |
| cycle in linked list / array | Fast & Slow Pointers |
| find kth largest, top-K, median | Heap |
| all subsets / combinations / permutations | Backtracking |
| shortest path, unweighted grid | BFS |
| shortest path, weighted graph | Dijkstra |
| negative weights or at-most-k steps | Bellman-Ford |
| all-pairs shortest | Floyd-Warshall |
| detect cycle / group nodes | Union Find |
| ordering with dependencies | Topological Sort |
| minimize spanning connections | MST (Kruskal/Prim) |
| optimal substructure + overlapping subproblems | DP |
| max subarray | Kadane |
| increasing subsequence | LIS (patience sort) |
| pick items under weight | Knapsack |
| counting subsets summing to target | 0/1 Knapsack |
| two string comparison (edit, LCS) | 2D DP |
| intervals [i..j] decisions | Interval DP |
| state = bitmask of visited items | Bitmask DP |
| digit-by-digit count ≤ N | Digit DP |
| next greater / smaller element | Monotonic Stack |
| range max/min in sliding window | Monotonic Deque |
| range sum with updates | Segment Tree / BIT |
| prefix search / autocomplete | Trie |
| XOR of subset / find missing | Bit Manipulation XOR |
| minimize max / maximize min | Binary Search on Answer |
| local choice provably optimal | Greedy |
| sequence of Euler edges | Eulerian Path (Hierholzer) |
