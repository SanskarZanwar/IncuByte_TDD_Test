package testing;


import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(numbers);
        int length = numbers.length();
        if (length < 2) {
            if (numbers.isEmpty()) {
                return 0;
            } else {
                return convertToInt(numbers);
            }
        }else {
            return Arrays.stream(numbers.split(","))
                    .mapToInt(Integer::valueOf)
                    .sum();
        }
    }

    public int convertToInt(String num){
        return Integer.parseInt(num);
    }
}
