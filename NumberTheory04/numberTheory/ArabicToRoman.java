package numberTheory;

import java.util.LinkedHashMap;
import java.util.Map;


//OpenAI. "Java Code to Convert Arabic Numbers to Roman Numerals" (2023). Retrieved from https://github.com/openai/gpt-3.5-turbo

public class ArabicToRoman {
    public static void main(String[] args) {
        int number = 3542; // Specify the Arabic number to convert
        
        String romanNumeral = convertToRoman(number);
        
        System.out.println(number + " in Roman numerals is: " + romanNumeral);
    }
    
    public static String convertToRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Invalid number. Roman numerals are between 1 and 3999.");
        }
        
        Map<Integer, String> romanNumeralMap = createRomanNumeralMap();
        StringBuilder romanNumeral = new StringBuilder();
        
        for (Map.Entry<Integer, String> entry : romanNumeralMap.entrySet()) {
            int arabicNum = entry.getKey();
            String romanSymbol = entry.getValue();
            
            while (number >= arabicNum) {
                romanNumeral.append(romanSymbol);
                number -= arabicNum;
            }
        }
        
        return romanNumeral.toString();
    }
    
    public static Map<Integer, String> createRomanNumeralMap() {
        Map<Integer, String> romanNumeralMap = new LinkedHashMap<>();
        romanNumeralMap.put(1000, "M");
        romanNumeralMap.put(900, "CM");
        romanNumeralMap.put(500, "D");
        romanNumeralMap.put(400, "CD");
        romanNumeralMap.put(100, "C");
        romanNumeralMap.put(90, "XC");
        romanNumeralMap.put(50, "L");
        romanNumeralMap.put(40, "XL");
        romanNumeralMap.put(10, "X");
        romanNumeralMap.put(9, "IX");
        romanNumeralMap.put(5, "V");
        romanNumeralMap.put(4, "IV");
        romanNumeralMap.put(1, "I");
        
        return romanNumeralMap;
    }
}


