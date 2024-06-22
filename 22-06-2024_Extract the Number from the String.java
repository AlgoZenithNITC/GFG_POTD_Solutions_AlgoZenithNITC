class Solution {
    long ExtractNumber(String sentence) {
        // Define regex to find numbers
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(sentence);

        List<String> numbers = new ArrayList<>();

        // Extract all numbers from the string
        while (matcher.find()) {
            numbers.add(matcher.group());
        }

        long ans = -1;
        long maxVal = Long.MIN_VALUE;

        // Find the largest number that does not contain '9'
        for (String num : numbers) {
            if (!num.contains("9")) {
                long numValue = Long.parseLong(num);
                if (maxVal < numValue) {
                    ans = numValue;
                    maxVal = numValue;
                }
            }
        }

        return ans;
    }
}
