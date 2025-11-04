 class prac_1 {
     static int recursive(int n){
        if(n <=1){
            return n;
        }
        return recursive(n-1) + recursive(n-2);  
     }

     static void non_recursive(int n){
        int a = 0, b = 1, c;
        if(n == 0){
            System.out.println(a);
            return;
        }
        for(int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(b);
     }
    
     public static void main(String[] args) {
            System.out.println(recursive(2));
            non_recursive(2);
            // Time Complexity of recursive approach is O(2^n)
            // Time Complexity of non-recursive approach is O(n)
            // Space Complexity of recursive approach is O(n) due to call stack
            // Space Complexity of non-recursive approach is O(1)
     }
}