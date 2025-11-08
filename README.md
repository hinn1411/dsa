# leetcode-java

Daily LeetCode practice in **Java 21** with a **topic-structured** repo, GitHub Project board, issue templates, and CI.
- 1 problem/day minimum (Mon–Fri), 2 on Sat, review on Sun
- Spaced repetition: **D+2**, **D+7**, **D+21**
- Track via GitHub Project board (Inbox → In Progress → Review/Explain → Done)

## How to use
1. Create a GitHub repo and push this skeleton.
2. Create a **Project** (table/board) with fields: Difficulty, Topic(s), Status, Est. Time, Actual Time, Attempts.
3. Open an issue from the **Daily Problem** template for each problem.
4. Add your solution under the appropriate `src/<topic>/` folder.
5. Commit with message: `feat(<topic>): <leetcode-id>-<slug>`

## Build
This repo includes a minimal Maven setup to compile check snippets.
```
mvn -q -DskipTests package
```

## Notes
- Add theory and patterns in `notes/patterns.md`
- Summarize common pitfalls in `notes/mistakes.md`
- Weekly retro in `notes/weekly-retros/YYYY-MM-DD.md`
