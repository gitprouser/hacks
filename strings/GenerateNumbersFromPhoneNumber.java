public class GenerateNumbersFromPhoneNumber
{
  public static void main(String[] args) {
    String numb = "6784228989";
	printString(numb);
  }
  
  public static String getLetters (char c) {
  	int digit = c - '0';
    switch (digit){
    	case 0: case 1:  return "";
    	case 2:  return "ABC";
    	case 3:  return "DEF";
    	case 4:  return "GHI";
    	case 5:  return "JKL";
    	case 6:  return "MNO";
    	case 7:  return "PQRS";
    	case 8:  return "TUV";
    	case 9:  return "WXY";
    	default:
    		throw new RuntimeException("incorrect input");
    }
  }
  
  
  public static void printString(String numbers) {
  	helper(numbers, 0, new StringBuilder()); 
  }
  
  public static void helper(String numbers, int pos, StringBuilder sb) {
    
    if (numbers.length() == pos) {
		System.out.println(sb.toString());
      	return;
    }
        
    String letters = getLetters(numbers.charAt(pos));
    
    if (letters.length() == 0) {
      	helper(numbers, pos + 1, sb);
    } else {
      	for (int i = 0; i < letters.length(); i++) {
        	sb.append(letters.charAt(i));
			helper(numbers, pos + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
    }
    
  }
}
