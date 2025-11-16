// Simplify Unix Path
import java.util.*;

public class SimplifyUnixPath {
    public static String simplify(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        
        for(String component : components) {
            // Skip empty strings and current directory references
            if(component.isEmpty() || component.equals(".")) {
                continue;
            }

            // Handle parent directory references
            if(component.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Push valid directory names
            else {
                stack.push(component);
            }
        }

        // Build the simplified path

        StringBuilder result = new StringBuilder();
        for(String dir : stack) {
            result.append("/").append(dir);
        }
        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {
        String str = "/a/./b/../../c/";
        String res = simplify(str);
        System.out.println(res); 
    }
}