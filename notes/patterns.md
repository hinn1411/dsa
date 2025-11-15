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