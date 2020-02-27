# Coding-Practice
**Google Interview Question


Find a way to schedule meetings when both person 1 and person 2 are available. Output should consist of a list of lists containing the times both person 1 and 2 are free.

Sample input 1:
     
person 1 [[9:00, 10:30], [12:00, 13:00], [16:00, 18:00]]                                - person 1 works between [9:00, 20:00] (9am - 8pm)

person 2 [[10:00, 11:30], [12:30, 14:30], [14:30, 15:00], [16:00, 17:00]]               - person 2 works between [10:00, 18:30] (10am - 6:30pm)

sample output: [[11:30, 12:00], [15:00, 16:00], [18:00, 18:30]]


Sample input 2:

person 1 [[9:00, 10:30], [12:00, 13:00], [16:00, 18:00]]                                - person 1 works between [7:00, 23:00] (9am - 8pm)

person 2 [[10:00, 11:30], [12:30, 14:30], [14:30, 15:00], [16:00, 17:00]]               - person 2 works between [8:00, 23:30] (10am - 6:30pm)

sample output: [[8:00, 9:00], [11:30, 12:00], [15:00, 16:00], [18:00, 23:00]]


******************************************************************************************************************
**Microsoft Interview Questions

1) You are processing plane seat reservations. The plane has N rows of seats, numbered from 1 to N. Therea re ten seats in each row (labelled from A to K, with letter I ommited).

Some seats are already reserved. The list of reserved seats is give nas a string S(of length M) containing seat numbers separated by single spaces: for example, "1A 3C 2B 40G 5A". The reserved seats can be listed in S in any order.

Your task is to allocate seats for as many four-person families as possible. A four-person family occupies four seats in one row, that are next to each other - seats across an aisle(such as 2C and 2D) are not considered to be next to each other. It is permissible for the family to be separated by an aisle, but in this case exactly two people have to sit on each side of the aisle. Obviously, no seat can be allocated to more than one family.

Given the number of rows N and a list of reserved seats as string S, return the maximum number of four-person families that can be seated in the remaining unreserved seats.

for instance, given N = 2 and s = "1A 2F 1C", your function should return 2.
******************************************************************************************************************

2) Given an array A consisting of N integers, returns the mximum sum of two numbers who digits add up to an equal sum. If there are no two numbers who digits have an equal sum, the function should return -1.

Examples:
1. Given A = [51, 71, 17, 42], the function should return 93. There are two pairs of numbers whose digits add up to an equal sum: (51 ,42) and (17, 71). the first pair sums up to 93.

2. Given A = [42, 33, 60], the function should return 102. The digits of all numbers in A add up to the same sum, and choosing to add 42 and 60 gives. the result 102.

3. Given A = [51, 32, 43], the function should return -1, since all numbers in A have digits that add up to different, unique sums.
