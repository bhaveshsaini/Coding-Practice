# Coding-Practice
Google Interview Question


Find a way to schedule meetings when both person 1 and person 2 are available. Output should consist of a list of lists containing the times both person 1 and 2 are free.

Sample input 1:
     
person 1 [[9:00, 10:30], [12:00, 13:00], [16:00, 18:00]]                                - person 1 works between [9:00, 20:00] (9am - 8pm)

person 2 [[10:00, 11:30], [12:30, 14:30], [14:30, 15:00], [16:00, 17:00]]               - person 2 works between [10:00, 18:30] (10am - 6:30pm)

sample output: [[11:30, 12:00], [15:00, 16:00], [18:00, 18:30]]


Sample input 2:

person 1 [[9:00, 10:30], [12:00, 13:00], [16:00, 18:00]]                                - person 1 works between [7:00, 23:00] (9am - 8pm)

person 2 [[10:00, 11:30], [12:30, 14:30], [14:30, 15:00], [16:00, 17:00]]               - person 2 works between [8:00, 23:30] (10am - 6:30pm)

sample output: [[8:00, 9:00], [11:30, 12:00], [15:00, 16:00], [18:00, 23:00]]



