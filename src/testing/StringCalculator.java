package testing;


public class StringCalculator {

    public int add(String numbers) {
        if (numbers.length() < 2) {
            if (numbers.isEmpty()) {
                return 0;
            } else {
                return convertToInt(numbers);
            }
            } else { 
            String delimiter = ",";
            if (numbers.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }
           
            String[] numList = splitNumbers(numbers, delimiter + "|\n");
            return sum(numList);
        }
    }
   
    private String[] splitNumbers(String numbers, String divider) {
        return numbers.split(divider);
    }

    private int convertToInt(String num) {
    	
    	if(num.compareTo("a") >= 0 && num.compareTo("z")<=0) {
    		return convertStringToInt(num);
    	}
        return Integer.valueOf(num);
    }
    private int convertStringToInt(String num) {
    	char[] ch  = num.toCharArray();
    	for(char c : ch){
    	    int temp = (int)c;
    	    int temp_integer = 96; 
    	    if(temp<=122 & temp>=97)
    	        return(temp-temp_integer);
    	}
    	return 0;
    
    }

    private int sum(String[] numbers) {
        int total = 0;
        StringBuilder negativeString = new StringBuilder();
        for (String number : numbers) {
        	
            if (convertToInt(number) < 0) {
                if (negativeString.toString().equals(""))
                    negativeString = new StringBuilder(number);
                
                else
                    negativeString.append(",").append(number);
            }
            if (convertToInt(number) < 1000) 
                total += convertToInt(number); 
        }
        
        
        if (!negativeString.toString().equals("")) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeString);
        }

        return total;
    }
}
