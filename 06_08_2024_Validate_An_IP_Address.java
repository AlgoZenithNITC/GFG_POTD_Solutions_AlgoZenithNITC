

// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Split the string based on periods
        String[] segments = str.split("\\.");
        
        // Check if the IP address has exactly 4 segments
        if (segments.length != 4) {
            return false;
        }
        
        // Validate each segment
        for (String segment : segments) {
            // Check if the segment is empty or contains non-digit characters
            if (segment.isEmpty() || !segment.matches("\\d+")) {
                return false;
            }
            
            // Convert the segment to an integer
            int number = Integer.parseInt(segment);
            
            // Check if the number is within the valid range
            if (number < 0 || number > 255) {
                return false;
            }
            
            // Check for leading zeros
            if (segment.length() > 1 && segment.charAt(0) == '0') {
                return false;
            }
        }
        
        // If all checks pass, return true
        return true;
    }
}
