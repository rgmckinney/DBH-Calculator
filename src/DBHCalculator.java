/**
 * Created by Ryan on 2/18/2017.
 */
public class DBHCalculator {
    public enum Type {
        BIN, DEC, HEX
    }

    private Type inType = Type.BIN;

    private Type outType = Type.BIN;

    public void setInType(Type type) {
        inType = type;
    }

    public void setOutType(Type type) {
        outType = type;
    }

    public String calculate(String input) {
        long value = 0;

        try {
            switch (inType) {
                case BIN:
                    value = binToDec(input);
                    break;
                case DEC:
                    value = Integer.parseInt(input);
                    break;
                case HEX:
                    value = hexToDec(input);
                    break;
            }
        }
        catch (InvalidInputException e) {
            return "Invalid Input";
        }

        switch (outType) {
            case BIN:
                return decToBin(value);
            case DEC:
                return Long.toString(value);
            case HEX:
                return decToHex(value);
        }

        return Long.toString(value);
    }

    public static String decToBin(long value) {
        // Find max exponent
        int exp = 0;
        while (Math.pow(2, exp+1) < value) {
            exp++;
        }

        // Form binary string
        StringBuilder sb = new StringBuilder();
        for (int i=exp; i >= 0; i--) {
            long bitValue = (long)Math.pow(2, i);

            if (value >= bitValue) {
                value -= bitValue;
                sb.append('1');
            }
            else {
                sb.append('0');
            }
        }

        return sb.toString();
    }

    public static String decToHex(long value) {
        return Long.toString(value, 16);
    }

    public static long hexToDec(String input) {
        return Long.parseLong(input, 16);
    }

    public static long binToDec(String input)
            throws InvalidInputException {
        long total = 0;

        for (int i=0; i < input.length(); i++) {
            if (input.charAt(input.length() - i - 1) == '1') {
                total += Math.pow(2, i);
            }
            else if (input.charAt(input.length() - i - 1) != '0') {
                throw new InvalidInputException();
            }
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(hexToDec("00f0"));
    }
}


