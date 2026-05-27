class Solution {
    public int numberOfSpecialChars(String word) {

        HashSet<Character> lower = new HashSet<>();
        HashSet<Character> upper = new HashSet<>();
        HashSet<Character> special = new HashSet<>();
        HashSet<Character> invalid = new HashSet<>();

        for(char ch : word.toCharArray()) {

            // lowercase
            if(ch >= 'a' && ch <= 'z') {

                // lowercase after uppercase
                if(upper.contains(ch)) {
                    special.remove(ch);
                    invalid.add(ch);
                }

                lower.add(ch);
            }

            // uppercase
            else {

                char small = (char)(ch + 32);

                upper.add(small);

                if(lower.contains(small) &&
                   !invalid.contains(small)) {

                    special.add(small);
                }
            }
        }

        return special.size();
    }
}