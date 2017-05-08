/**
A perfect number is defined as a number where the sum of its positive 
divisors are equal to itself.

https://en.wikipedia.org/wiki/List_of_perfect_numbers

For egs: 
 - 6 (whose positive divisors are 1, 2, and 3) is 
    a  perfect number as 1 + 2 + 3 = 6
 - 10 (whose positive divisors are 1, 2, and 5) is not a 
    perfect number as 1 + 2 + 5 = 8

0 is not a perfect number. 


*/

class PerfectNumbers {
    /**
      Must take a single integer as an argument and return the count
      of perfect numbers less than or equal to that integer.

      Sample I/O: 
        - 0 return 0.
        - 6 returns 1.
        - 28 returns 2.
    */
    int findPerfectNumbers(int N){ 
    }

   /**
      Returns an integer denoting the number of perfect 
      numbers less than or equal to input. 
      @param input an integer
      @return an integer
    */
    public static int findPefectNumbers(int N) {
      int cnt = 0;
      for (int i = 0; i <= input; i++) {
        if (isPerfectNumb(i))
          ++cnt;
      }
      return cnt;
    }

   /**
     Returns a boolean value denoting whether the input is perfect 
     number or not.

     @param input is an integer
     @return true if pefect number, else false.
   */
    public static boolean isPerfectNumb(int numb) {
        int[] divisors = new int[500];
        getDivisors(numb, divisors);
        boolean isPerfect = false;
        int sum = 0;
        for (int i = 0; i < 500; i++)
            sum += divisors[i];
        
        if (sum == input)
            isPerfect = true;

        return isPerfect;
    }

    /** 
       Get all the divisors for a given input Number.
    */
    private static void getDivisors(int numb, int[] divisors) {
        int idx = 0;
        for (int j = 0; j < numb; j++) {
            if ((numb / j) * j == numb) {
                divisors[idx++] = j; 
            }
        }
    }
}
