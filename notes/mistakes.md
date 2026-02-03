# Mistakes
Keep bullet points for common errors (off-by-one, overflow, wrong invariant, etc.).

### Valid anagram
- Forget built-in methods of String (length(), charAt()) and Map (getOrDefault())
- Compare reference of the Objects
### Group anagram
- Forget how to sort a String in Java
### Longest Substring Without Repeating Characters 
- Cannot handle duplicate element testcases
### Isomorphic string
- Use very complex logic without null check
### Subarray sum equals K
- Try to implement optimize solution before brute force, and not see prefix sum pattern
### Longest Consecutive Sequence
- Don't check the sequence length of previous element
### Move zeroes
- Index out of bound
### 3 Sums 
- Hash map cannot deduplicate
### Permutation in string
- Forget to compare the first window
### Longest repeating character replacement
- Forget to update window size
- Use wrong logic to update max frequency
### Sliding window maximum 
- remove() of priority queue takes O(n) -> TLE
### Search in Rotated Sorted Array
- Use nums[left] < nums[mid] instead of nums[left] <= nums[mid] -> off by one
### Search in 2D matrix
- Off by one when searching for target row
### LRU Cache
- Delete new (key, value) pair in put() but we didn't track it yet

### Design Twiter
- Null pointer exception when traversing tweets of followees