public class PowerFunction {

    public static void main(String[] args) {

        System.out.println("Result = " + new PowerFunction().pow(79161127,99046373,57263970));
    }


    public int pow(int x, int n, int d) {
        int xMod = x%d;
        if (xMod <0){
            xMod+=d;
        }
        if (n<=1){
            return (n==0&&xMod>0)?1:xMod;
        }
        if (n%2==0){
            int result = pow(xMod,n/2,d);
            return (int) (((long)result * result)%d);
        } else{
            int result = pow(xMod,n-1,d);
            return (int) (((long)result * xMod)%d);
        }
    }
}
