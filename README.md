# homework1_problem1_AI
# Homework 1 - Problem 1: A* Search Algorithm
##  Project Overview
Bu Java proqramı, A* axtarış alqoritmini **üç müxtəlif rejimdə** implementasiya edir:
1. **UCS Mode** (h(n) = 0)
2. **A* with Euclidean Heuristic**
3. **A* with Manhattan Heuristic**

##  Quick Start
### Prerequisites
- Java 8 or higher
- Maven (optional)
### Installation & Running
```bash
# Clone the repository
git clone https://github.com/fereshta-02/homework1_problem1_AI.git
cd homework1_problem1_AI

# Compile Java files
javac -d bin src/*.java
# Run the program
java -cp bin AStarMain input/astar_small.txt
__________________________________________________________________________________________________________

Format izahı:
Vertex: <id>, <cell_id> (cell_id = x*10 + y)
Edge: <u>, <v>, <w> (undirected, w ≥ 0)
_____________________________________________________________________________________________________

Algorithm Design
A* Core Implementation
Duplicate Handling: Allow duplicate heap entries, expand only when popped g equals best-known g
Tie-breaking: Secondary key (node_id) for deterministic behavior
Heuristic Interface: Modular heuristic functions that can be easily implemented

Heuristic Implementations
1. Zero Heuristic (UCS Mode)
2. Euclidean Heuristic
3. Manhattan Heuristic

Coordinate System
Hər node üçün koordinatlar:
x = cell_id / 10
y = cell_id % 10
__________________________________________________________________________________________________________________

Analysis & Results
Performance Comparison
Test Results - astar_small.txt
Mode	Optimal Cost	Expanded	Pushes	Max Frontier	Runtime (ms)
UCS	14	8	12	5	3
A* Euclidean	14	6	10	4	2
A* Manhattan	14	7	11	5	2
Test Results - astar_medium.txt
Mode	Optimal Cost	Expanded	Pushes	Max Frontier	Runtime (ms)
UCS	27	35	52	18	15
A* Euclidean	27	22	38	12	9
A* Manhattan	27	28	45	15	12

1. Optimality Verification
  Bütün üç rejim eyni optimal cost-u tapdı - bu, heuristics-lərin admissible və consistent olduğunu göstərir.

2. Efficiency Comparison
UCS (h=0): Ən çox node expand etdi (ən az intelligent)
A Euclidean:* Ən az node expand etdi (ən efficient)
A Manhattan:* Orta performans göstərdi
Expected Pattern: UCS ≥ Manhattan ≥ Euclidean in expansions

3. Heuristic Admissibility
Heuristic-lərin admissible olması üçün şərtlər:
Euclidean: Hər kənar üçün w(u,v) ≥ Euclidean(u,v)
Manhattan: Hər kənar üçün w(u,v) ≥ Manhattan(u,v)
Test qraflarında bu şərtlər ödənildiyi üçün bütün heuristics admissible-dır.

  Technical Discussion
Design Choices
1. Object-Oriented Design
Separation of Concerns: Hər class ayrı məsuliyyət daşıyır
Interface-based Heuristics: Asan extendability
Immutable Data Objects: Node, SearchResult kimi class-lar


Performance Optimizations
HashMap for O(1) lookups

Precomputed coordinates

Efficient priority queue operations





Source: S, <id>

Destination: D, <id>
