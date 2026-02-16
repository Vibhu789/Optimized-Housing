# Optimized-Housing

# Project Overview

The Optimized Housing Allocation System is a Java-based project that demonstrates how to maximize comfort (utility score) within a limited housing space using algorithm optimization techniques.

This project compares:
Brute Force Approach (Recursive)
Dynamic Programming Approach (Optimized) 

The problem solved in this project is a classic computer science problem known as the:  0/1 Knapsack Problem

🎯 Problem Statement

Given:
A set of housing items/features
Each item has:
spaceRequired → space it occupies (in sq ft)
utilityScore → comfort/benefit value
A limited roomCapacity

# Goal:
👉 Select items in such a way that:
Total space does NOT exceed capacity
Total utility score is MAXIMIZED
Each item can either be:
Included (1)
Excluded (0)
TC: O(2^n) -> O(n * Capacity)
This makes it a 0/1 Knapsack problem.
