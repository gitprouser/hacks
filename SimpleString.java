class SimpleString {

    public static void main(String[] args) {
        String[] str = {"hi", "Hello", "therefore"};
        System.out.println("Before:"); 
  
        for (String s : str)
            System.out.print(" " + s);
        System.out.println(" "); 
        prettyPrint(str);


        System.out.println("After:"); 
        for (String s : str) 
            System.out.print(" " + s);
    }

    public static void prettyPrint(String[] s) {
        s[0] = "world";
    }
}
