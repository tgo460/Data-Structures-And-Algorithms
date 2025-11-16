// Solution 3: Decoding String
import java.util.Stack;

class DecodingString {
    static String decode(String str) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int currentCount = 0;

        for(char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) {
                currentCount = currentCount * 10 + (ch - '0');
            }
            else if(ch == '[') {
                countStack.push(currentCount);
                stringStack.push(currentString);
                currentCount = 0;
                currentString = "";
            }
            else if(ch == ']') {
                int count = countStack.pop();
                String previousString = stringStack.pop();
                currentString = previousString + currentString.repeat(count);
            }
            else {
                currentString += ch;
            }
        }
        return currentString;
    }

    public static void main(String[] args) {
        String str = "3[b2[ca]]";

        System.out.println(decode(str));
    }
}
