# Domain Testing Table
## Rectangle Point Analyzer

### Rectangle Boundaries
- X-axis: from -3 to +3 (inclusive)
- Y-axis: from -4 to +4 (inclusive)

---

## Test Cases Table

| Test Case | Category | x | y | Expected Result |
|-----------|----------|---|---|-----------------|
| T1 | Inside | 0 | 0 | INSIDE |
| T2 | Inside | 2 | 2 | INSIDE |
| T3 | Inside | -1 | 3 | INSIDE |
| T4 | Horizontal border | 0 | -4 | HORIZONTAL border |
| T5 | Horizontal border | 2 | 4 | HORIZONTAL border |
| T6 | Vertical border | -3 | 0 | VERTICAL border |
| T7 | Vertical border | 3 | 2 | VERTICAL border |
| T8 | Corner | -3 | -4 | CORNER |
| T9 | Corner | 3 | 4 | CORNER |
| T10 | Outside | -5 | 0 | OUTSIDE |
| T11 | Outside | 5 | 5 | OUTSIDE |

---

## Selected Values for Unit Tests

| Category | Values |
|----------|--------|
| INSIDE | (0,0), (2,2), (-1,3) |
| HORIZONTAL | (0,-4), (2,-4), (-2,4), (0,4) |
| VERTICAL | (-3,0), (-3,2), (3,0), (3,-2) |
| CORNERS | (-3,-4), (3,-4), (-3,4), (3,4) |
| OUTSIDE | (-5,0), (5,1), (0,-6), (0,6) |

---

## Boundary Value Analysis

| Boundary | Test Values |
|----------|-------------|
| x = -3 (left) | -4, -3, -2 |
| x = 3 (right) | 2, 3, 4 |
| y = -4 (bottom) | -5, -4, -3 |
| y = 4 (top) | 3, 4, 5 |

---
