/**
You have a TV Screen which has the following layout of a keyboard.
  0 1 2 3 4 5 6
0 a b c d e f g 
1 h i j k l m n
2 o p q r s t u
3 v w x y z # #

# -> Unreachable Positions

The only movements allowed by your TV remote is the following set of operations 
set_of_operations_allowed = { up, down, left, right} 

Your goal is to create a mobile application on your phone that relays via IR specific commands
to your TV. for Egs: 
"shrek" = {
movement from "a" to "s" + *Enter* + movement from "s" to "h" + *Enter* + movement from "r" to "e" +
      + *Enter* + movement from "e" to "k" + *Enter*
}

Constraints:
- Initial state of your TV keyboard will be at position 'a' (0,0).
- You can only move using the following operations = { up, down, left, right} 
- The "#-positions" are unreacheable and can be considered as blocked paths.
- Try to find the most efficient way to go from one place to another.


*Things to remember*:

If you cannot go diagonally so for going from say a to z you have to do the following moves 
in various different combinations, but at the end of the day you need to make
= 3 * down's + 4 * right's = movement from 'a' to 'z'

Algorithm: 
0.) Figure out the exact ascii offset from 'a' by doing the following: ord('s') - ord('a') = 18
1.) Figure out the row you need to go to, 18 / 7 = 2 therefore row = 2
2.) Figure out the col you need to go to, 18 % 7 = 4 therefore row = 4
3.) Go three (2 + 1) rows down.
4.) Go Four(4) rows to the left.

// Todo figure out the boundary conditions as well... 
// - No left move, when you are at the 0th column. 
// - No right move, when you are at the 6th column.
// - No down move, when you are at the 3rd row.
// - No up move, when you are at the 0th row.

==============================
*Algorithm for row identification*::
==============================
1.) ord('s') - ord('a') = ascii_offset 
2.) ascii_offset / 7 = row_no + 1


==============================
*Algorithm for co identification*::
==============================
1.) ord('s') - ord('a') = ascii_offset 
2.) ascii_offset % 7 = col_no

==============================
*Algorithm for Row movement* :: 
==============================
if (from.row < to.row) 
  move down by Math.abs(from.row - to.row)
else if (from.row > to.row)
  move up by Math.abs(from.row - to.row)
else
  stay in the same down

==============================
*Algorithm for Col movement* ::
==============================
if (from.col < to.col)
   move right by Math.abs(from.col - to.col)
else if (from.col > to.col)
   move left by Math.abs(from.col - to.col)
else 
   stay in same col
   

*/


public class TVScreenKeyboardProblem {


}
