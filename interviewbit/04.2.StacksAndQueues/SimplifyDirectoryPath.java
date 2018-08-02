import java.util.Stack;

public class SimplifyDirectoryPath {

    public static void main(String[] args) {

        System.out.println("Result = "+new SimplifyDirectoryPath().simplifyPath("/a/./b/../c/d/e"));
    }


    public String simplifyPath(String A) {
        Stack<String> path = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String [] dirs = A.split("/");
        for (String dir:dirs){
            if (dir.equals(".")||dir.equals("")){
                continue;
            }
            if (dir.equals("..")){
                if (!path.empty())
                    path.pop();
                continue;
            }
            path.push(dir);
        }
        if (path.empty()){
            return "/";
        }
        for (String dir:path){
            sb.append("/"+dir);
        }
        return sb.toString();
    }
}
