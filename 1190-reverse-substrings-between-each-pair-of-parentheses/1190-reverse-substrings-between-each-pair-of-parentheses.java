class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder cur = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(cur);
                cur = new StringBuilder();
            } 
            else if (c == ')') {
                cur.reverse();
                cur = st.pop().append(cur);
            } 
            else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}