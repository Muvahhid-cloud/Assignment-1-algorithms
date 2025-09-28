# – Assignment 1  Algorithms

## 📌 Overview  
This project implements **classic divide-and-conquer algorithms** with safe recursion patterns.  
It is a **Maven project** with JUnit tests, following clean code principles and GitHub workflow guidelines.  

## Algorithms Implemented
1. **MergeSort** – Divide-and-conquer, Master Case 2. Linear merge, buffer reuse, cutoff to insertion sort.
2. **QuickSort** – Randomized pivot, smaller-first recursion, bounded stack (`O(log n)` typical).
3. **Deterministic Select** – Median-of-Medians, `O(n)`, recurses into smaller side.
4. **Closest Pair of Points (2D)** – Classic D&C algorithm, `O(n log n)`.


## Recurrence Analysis
- **MergeSort**: `T(n) = 2T(n/2) + Θ(n)` → `Θ(n log n)` (Master Case 2).
- **QuickSort (avg)**: `T(n) = T(n/2) + T(n/2) + Θ(n)` → `Θ(n log n)`; depth ≈ `O(log n)`.
- **Select (MoM)**: `T(n) = T(n/5) + T(7n/10) + Θ(n)` → `Θ(n)` (Akra–Bazzi).
- **Closest Pair**: `T(n) = 2T(n/2) + Θ(n)` → `Θ(n log n)` (Master Case 2).

 
---

## ⚙️ Project Structure  

Assignmnet 1/

│── pom.xml

│

├── src

│   ├── main/java/edu/ait/recursion/

│   │   ├── MergeSort.java

│   │   ├── QuickSort.java

│   │   ├── DeterministicSelect.java

│   │   ├── ClosestPair.java

│   │   └── Main.java

│   │

│   └── test/java/edu/ait/recursion/

│       ├── MergeSortTest.java

│       ├── QuickSortTest.java

│       ├── DeterministicSelectTest.java

│       ├── ClosestPairTest.java

│       └── UtilTest.java (if needed)


__________________________________________________

## Metrics
- Sorting correctness validated with JUnit tests.
- QuickSort depth tracked: `≤ 2 * floor(log2 n) + O(1)` under randomized pivot.
- Select checked against `Arrays.sort` for 100 random trials.
- Closest Pair validated vs brute force (`O(n^2)`) for `n ≤ 2000`.


## Branches:  
- `main` – working releases (tagged v0.1, v1.0).  
- `feature/mergesort`, `feature/quicksort`, `feature/select`, `feature/closest`, `feature/metrics`.

  

## ✅ Testing

- Sorting algorithms validated against random and adversarial arrays.

- Select verified against Arrays.sort()[k] on 100+ random trials.

- Closest Pair verified against brute force for n ≤ 2000.

- All tests pass (exit code 0).

# 📝 Git Workflow

Commit storyline followed:

* init: add Maven project structure and pom.xml

* feat(mergesort): implement merge sort + tests

* feat(quicksort): implement randomized pivot quicksort + tests

* feat(select): implement deterministic select (MoM5) + tests

* feat(closest): implement closest pair of points + tests

* feat(main): add demo runner

____________________________________
 ## 📦 Maven Configuration  

**The project uses **Maven** for build, testing, and execution.**

**Below is the `pom.xml` configuration (Java 25, JUnit 5, exec plugin):**
______________________________________________


## 🚀 How to Run

- Compile and run with Maven:

  **mvn clean install**

  **mvn exec:java**


  ## Result:

____________________________________________

  **Median via MoM: 49488**
  
  **Closest Pair distance: 1.0606965849348556E-4**

  **Process finished with exit code 0**
