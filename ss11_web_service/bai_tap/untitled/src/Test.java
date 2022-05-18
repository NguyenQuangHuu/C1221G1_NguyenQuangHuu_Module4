public class Test {
    public static void main(String[] args) {
        int n = 7;
        for(int i = 0 ; i <= n ; i++){
            for(int k = 0 ; k < i ; k++){
                if(k==0 || k == i-1 || i==n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }
}
