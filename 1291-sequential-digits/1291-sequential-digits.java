class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> output = new LinkedList<>();

        int minDigits = getDigitCount(low);
        int maxDigits = getDigitCount(high);

        int starter = 1;
        int incrementor = 1;
        int starterLen = 1;

        for (int targetLen = minDigits; targetLen <= maxDigits; targetLen++) {
            while (starterLen < targetLen) {
                starterLen++;
                starter = (starter * 10) + starterLen; // ie: 12 -> 123
                incrementor = (incrementor * 10) + 1; // ie: 11 -> 111
            }

            int candidate = starter;
            while (candidate <= high) {
                // add to output if legal
                if (candidate >= low)
                    output.add(candidate);

                // increment
                if (candidate % 10 == 9)
                    // the greatest digit is 9. this means it will become 10, which takes up more
                    // than 1 digit and would break the legal pattern
                    break;
                else
                    candidate += incrementor;
            }
        }

        return output;
    }

    private int getDigitCount(int num) {
        if (num == 0)
            return 0;

        // thanks to Dmitry Brant on stackoverflow
        return (int) (Math.log10(num) + 1);
    }
}