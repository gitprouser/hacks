
class IntegerToRoman {
  
  public String intToRoman () {
    String res = "";
    if (n < 1) return res;
    
    char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    int[] value = {1000, 500, 100, 50, 10, 5, 1};
    
    // msd = mostSignificantDigit   *1* 985
    // lsd = leastSignificantDigit   1*985*
    for (int i = 0; i < 7; i += 2) {  // Increments by two because for msd we divide by
                                      // thousands place msd = 1000   i = 0
                                      // Hundreds place msd = 100     i = 2
                                      // Tens place msd = 10     i = 4
                                      // Ones place msd = 1     i = 6
      int msd = n / value[i];
      
      if (msd < 4) {
        for (int j = 1; j <= 4; j++)
          res += roman[i];
      } else if (msd == 4) {
        res += roman[i] + roman[i - 1];  
      } else if (msd > 4 && v < 9) {
        res += roman[i - 1];
        for (int j = 6; j <= msd; j++) 
          res += roman[i];
      } else if (msd == 9) {
        res += roman[i] + roman[i - 2];
      }
      n %= value[i];  // remove the msd and keep the Least significant digits.
    }
    return res;
  }
  
}
