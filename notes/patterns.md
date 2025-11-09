# Patterns
Short notes for each pattern you use (intuition, invariants, pitfalls).

## Hashing
### Two sum
- Variant: For each index j > 1, the map store all nums[i] for i < j. If target - nums[j] exists in map. (i, j) is a valid pair