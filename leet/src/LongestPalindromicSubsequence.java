public class LongestPalindromicSubsequence {

    public int calculate(char[] str){
        int T[][] = new int[str.length+1][str.length+1];
        for(int m=0; m < str.length; m++){
            T[1][m] = 1;
        }
        for(int i = 2; i <= str.length; i++){
            for(int j = 1; j <= str.length-i+1; j++){
                if(str[j-1] == str[j-1 + i-1] && i == 2){
                    T[i][j] = 2;
                }else if(str[j-1] == str[j+i-2]){
                    T[i][j] = T[i-2][j+1] + 2;
                }else{
                    T[i][j] = Math.max(T[i-1][j+1], T[i-1][j]);
                }
            }
        }
        return T[str.length][1];
    }
    
    public int calculateRecursive(char str[],int start,int len){
        if(len == 1){
            return 1;
        }
        if(len ==0){
            return 0;
        }
        if(str[start] == str[start+len-1]){
            return 2 + calculateRecursive(str,start+1,len-2);
        }else{
            return Math.max(calculateRecursive(str, start+1, len-1), calculateRecursive(str, start, len-1));
        }
    }
    
    public static void main(String args[]){
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "GEEKSFORGEEKS";
        int  r = lps.calculate(str.toCharArray());
        int r1 = lps.calculateRecursive(str.toCharArray(), 0, str.length());
        System.out.print(r + " " + r1);
    }
    
}
