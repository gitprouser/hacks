
class IntegerToRoman {
  
  public String intToRoman () {
    String res = "";
    if (n < 1) return res;
    
    char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    int[] value = {1000, 500, 100, 50, 10, 5, 1};
    
    for (int i = 0; i < 7; i += 2) {
      int msd = n / value[i];    // msd = mostSignificantDigit
      
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
      msd %= value[i];
    }
    return res;
  }
  
}
