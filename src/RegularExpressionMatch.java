class RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        // constraints
        if (p.length() == 0 || p.length() > 20) {
            return (s.length() == 0 || s.length() > 20);
        }

        // '.' Matches any single character
        // '*' Matches zero or more of the preceding element
        boolean match = s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            if (match) {
                return isMatch(s.substring(1), p);
            }
        } else {
            if (match) {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        return false;
    }
}
