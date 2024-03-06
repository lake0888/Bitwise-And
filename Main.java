import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int T = scanner.nextInt();

        IntStream.range(0, T).forEach(tItr -> {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            System.out.println(bitwiseAnd(N, K));
        });
    }

    public static int bitwiseAnd(int N, int K) {
        int value = 0;
        int i = 1;
        while (i <= N && value != K - 1) {
            //String first = convertToBynary(i);
            for (int j = i + 1; j <= N && value != K - 1; j++) {                
                //String second = convertToBynary(j);
    
                //String result = bitwiseAnd(first, second);
                //int number = convertToInt(result);
                int number = i & j;
                if (number > value && number < K) {
                    value = number;
                }
            }
            i++;
        }
        return value;
    }

    public static String convertToBynary(int number) {
        StringBuilder binary = new StringBuilder();

        while (number > 0) {
            int rest = number % 2;
            binary = binary.insert(0, rest);
            number /= 2;
        }

        return binary.toString();
    }

    public static int convertToInt(String binary) {
        int number = 0;
        int i = 0;
        int exp = binary.length() - 1;
        while (i < binary.length()) {
            number += Integer.parseInt(String.valueOf(binary.charAt(i++))) * Math.pow(2, exp--);
        }
        return number;
    }

    public static String bitwiseAnd(String first, String second) {
        int sizeFirst = first.length();
        int sizeSecond = second.length();
        int sizeMin = Math.min(sizeFirst, sizeSecond);

        StringBuilder binary = new StringBuilder();

        int lastFirstIndex = sizeFirst - 1;
        int lastSecondIndex = sizeSecond - 1;

        while (sizeMin > 0) {
            char chFirst = first.charAt(lastFirstIndex--);
            char chSecond = second.charAt(lastSecondIndex--);

            binary.insert(0, (chFirst == '1' && chSecond == '1') ? "1" : "0");
            sizeMin--;
        }

        return binary.toString();
    }
}