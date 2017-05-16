/*
Interval Problem: 

Given a stream of numbers coming into the system, find all the intervals in which the numbers arrived. 
An interval is continous numbers from lower bound to upper bound. Egs: 

2 4 3 20 6 10 15 21 19 16 5 17

All intervals are: < [2,3,4,5,6], [10], [15,16,17], [19,20,21] >
# of intervals: 4 

Input size is about 100K numbers and each number is a 32 bit integer.

How will you keep track of the intervals streaming into the system. 

Alternate 1: Priority Queue, using a pq sort the numbers in the PQ based on the default comparator. This method
        will sort all the numbers when storing the numbers inside the PQ. When you are polling values from PQ
        You will receive the next lowest number as seen by the system.
        Pros: You can keep track of intervals based on polling operation of the PQ.
        Cons: Space efficiency is pretty bad as you will maintain all the values you have seen in the PQ. O(n)

32 bit * 100K = 3200 Kilo bits or 3.2 GB of integer bits. 
3.2GB integer bits can be stored in the memory but you want to keep it in disk. 

Alternate 2: Store all values in memory. 
- Create a 100K bit array. 
    boolean[] array = new boolean[100,000 * sizeof(int)] 
- As and when the system encounters an integer. Use the integer as an offset from 0th position in the array and set the 
  boolean bit to true in the array.
    array[N] = true
- As the numbers come in you set the bit using the offset. 
    Interval Problem: using bits 0......100KB all to false.
- To find intervals keep a counter and parse through the entire array once and increment counter when you see continuous 
  values.
    int cnt = 0; boolean isInterval = false;
    for (int i = 0; i < 100000; i++) {
      if (arr[i] == true) {  // set the isInterval flag to true and continue counting.
        isInterval = true;
      } else if (arr[i] == false && isInterval == true) {  // set the isInterval flag to false and increment the number of  
          isInterval = false;                                // intervals += 1;
          cnt +=1;
      } else {
        // do nothing just pass through
      }
      }

Pros: Now your space efficiency O(100K) henceforth  constant space.
Cons: can't think of any at the moment.

*/
class IntervalProblemWithATwist {

}
