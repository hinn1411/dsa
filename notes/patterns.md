# Patterns
Short notes for each pattern you use (intuition, invariants, pitfalls).

## Hashing
### Two sum
- Variant: For each index j > 1, the map store all nums[i] for i < j. If target - nums[j] exists in map. (i, j) is a valid pair
### Valid anagram
- Variant: For each string, we can build a map to keep track the frequency of each character. And then we can compare the quantity of characters in two maps.
### Group anagram
- Variant: For anagrams of a string, we can sort them alphabetically to create a string that can represent all of them.
### Longest Substring Without Repeating Characters
- Variant: Use array/hashmap to keep track index of seen elements
### Isomorphic string
- Use array/hashmap to keep track index of seen element  
### Subarray sum equals k
- sum(i..j) = sum(0..j) - sum(0..i - 1)
### Longest consecutive sequence
- set.contains(element - 1) for checking the first element

## Two pointers
### Move zeroes
- Use two pointers left and right, if left points to zero element and right points to non-zero element, we will swap left and right and then move left to the right
### 3 Sums
- Use sorting to remove duplicate elements
### Permutation in string 
- Keep a fixed window with all elements map to a frequency hash map
### Longest substring without repeating characters
- Use window size - max frequency > replacement times to shrink window
### Sliding window maximum
- Use lazy removal to delete outbound elements in a heap

## Stack
### Min stack
- Use a monotonic stack for accessing min/max element in O(1)
### Daily temperatures
- Pop outdate elements before adding new ones to keep the stack monotonic
### Next greater element ii
- Use a monotonic queue (asc) to handle remained elements in stack
- Use  index % len and 2 * n to loop through a circular array
### Car Fleet
- Merge condition: time to target of a car is shorter than time to target of the slowest car in the fleet in front of it

## Binary Search
### Search in Rotated Sorted Array 
- Use nums[left] <= nums[mid] for checking sorted sub list
### Search in 2D matrix
- use current <= target then update lower index to find upper bound