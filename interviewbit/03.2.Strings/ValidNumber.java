public class ValidNumber {

    public static void main(String[] args) {
        ValidNumber _this = new ValidNumber();

        String [] positivecases = new String[]{
            "0"," 0.1 ","2e10","0.1e10","-01.1e-10","008",".2"
        };
        String [] negativecases = new String[]{
                "abc","1 a","1u","0xFF","3.","3e0.1"," +","    ","43232412#312312"
        };

        for (String s:positivecases){
            if (_this.isNumber(s)!=1){
                System.out.println(s+ " is not a number, but should be!");
            }
        }
        for (String s:negativecases){
            if (_this.isNumber(s)!=0){
                System.out.println(s+ " is a number, but shouldn't be!");
            }
        }
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isNumber(final String A) {
        String regex = "((\\+|-)[0-9])?[0-9]*(\\.[0-9]+)?(e(\\+|-)?[0-9]+)?";
        String result = A.trim();
        if (result.length()>0){
            return A.trim().matches(regex)?1:0;
        }
        return 0;
    }

}
