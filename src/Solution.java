import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String romanNumeral){
        // Создание объекта класса HashMap, хранящего соответствие символов римской цифры и их значений в арабской системе исчисления.
        Map<Character, Integer> romanToIntegerMap = new HashMap<>();
        romanToIntegerMap.put('I', 1);
        romanToIntegerMap.put('V', 5);
        romanToIntegerMap.put('X', 10);
        romanToIntegerMap.put('L', 50);
        romanToIntegerMap.put('C', 100);
        romanToIntegerMap.put('D', 500);
        romanToIntegerMap.put('M', 1000);

        // Получение значения римской цифры с конца строки и запись его в переменную result.
        int result = romanToIntegerMap.get(romanNumeral.charAt(romanNumeral.length()-1));

        // Цикл проходит по строке в обратном порядке, начиная со второго символа с конца.
        // В каждой итерации сравнивается значение символа с предыдущим символом.
        // Если значение предыдущего символа меньше, то его значение вычитается из ответа, иначе прибавляется.
        for(int i = romanNumeral.length()-2; i>=0; i--){
            if(romanToIntegerMap.get(romanNumeral.charAt(i)) < romanToIntegerMap.get(romanNumeral.charAt(i+1))){
                result -= romanToIntegerMap.get(romanNumeral.charAt(i));
            }
            else{
                result += romanToIntegerMap.get(romanNumeral.charAt(i));
            }
        }
        // Возвращение итогового значения.
        return result;
    }
}
