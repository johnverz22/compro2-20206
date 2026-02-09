## Activity: Student Subject Portfolio & CSV Exporter

### Objective

Develop a Java application named `App` or `Main` that allows a student to build a personal grade portfolio. The program will store grades for multiple subjects in a **2D array** and, upon exiting, save the entire academic record into a `.csv` file using buffered writing and exception handling.

---

### Technical Specifications

1. **Storage Structure (Single Student Focus)**:
* **2D Array (Grades)**: A `double[50][3]` array.
* Each of the **50 rows** represents a different **Subject**.
* The **3 columns** represent: `[0] Prelim`, `[1] Midterm`, and `[2] Final`.


* **1D Array (Subject Names)**: A `String[50]` array to store the name of the subject corresponding to each row in the grade array.
* **Counter**: A variable to track the number of subjects added (Max 50).


2. **The Interface**:
* **Main Menu**:
1. Enter Grade (Add a new subject and its term grades)
2. Exit (Save data and close)


* **Input Flow for Option 1**:
* Prompt for **Subject Name**.
* Prompt for **Prelim Grade**.
* Prompt for **Midterm Grade**.
* Prompt for **Final Grade**.
* *Note: After saving one subject, return to the main menu.*




3. **File Persistence (The "Exit" Hook)**:
* When the user selects **Exit**, the program must iterate through the stored subjects and write them to `grades.csv`.
* **Required Tools**: `FileWriter`, `BufferedWriter`, and `try-catch` blocks.
* **CSV Format**: `Subject,Prelim,Midterm,Final`



---

### Instructions for Students

1. **Class Setup**: Create a class named `App` or `Main`. Initialize your arrays at the top of your class.
2. **Input Handling**: Use a `Scanner` for user input. You may choose any loop (`while` or `do-while`) to keep the menu running.
3. **Data Alignment**: Ensure that when you save a subject name in `subjects[0]`, its corresponding grades are saved in `grades[0][0]`, `grades[0][1]`, and `grades[0][2]`.
4. **Exception Handling**: Wrap your file-writing logic in a `try-catch` block to handle `IOException`. Ensure you close the `BufferedWriter` in a `finally` block or use a `try-with-resources` statement.

---

### Grading Rubric (Total: 20 Points)

| Criteria | 5 (Mastery) | 3 (Proficient) | 1 (Novice) | Score |
| --- | --- | --- | --- | --- |
| **Array Implementation** | Correctly manages a `double[50][3]` for grades and a `String[50]` for subject names. | Arrays are used, but indexes between names and grades are misaligned. | Incorrect array dimensions or types used. |  |
| **File I/O & Buffering** | Successfully uses `BufferedWriter` to create a clean, comma-separated `.csv` file. | File is created, but `BufferedWriter` is not used or formatting is poor. | No file is generated or writing logic is missing. |  |
| **Exception Handling** | `try-catch` is implemented correctly; resources (writer) are closed properly. | `try-catch` is present but lacks proper resource management (e.g., no `.close()`). | No exception handling; program crashes on file errors. |  |
| **User Logic & Flow** | Menu-driven system is intuitive; allows for multiple subject entries before exiting. | Program works but can only enter one subject or navigation is confusing. | Logic is broken; user cannot navigate between entering grades and exiting. |  |
| **Total Score** |  |  | **/ 20** |  |
