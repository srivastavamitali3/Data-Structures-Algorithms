package amazonQuestions;

import java.util.*;

/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 */
public class IntegerToRoman {
    static final Integer i1 = 1;
    final Integer i2 = 2;
    Integer i3 = 3;
    public static void main(String[] args) {
        final Integer i4 = 4;
        Integer i5 = 5;
        class Inner{
            final Integer i6 =6;
            Integer i7 = 7;
            Inner(){
                System.out.println(i6+i7);
            }
        }

    }

    public String intToRoman(int num) {
        String res = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        int count = 1;
        if (num < 10) {
            if (map.containsKey(num))
                return map.get(num);
            else {
                if (num < 5) {
                    String value = map.get(1);
                    while (count != num) {
                        res += value;
                        num--;
                    }
                } else {
                    String five = map.get(5);
                    num -= 5;
                    res += five + map.get(num);

                }
            }
        } else {
            if (map.containsKey(num))
                return map.get(num);
            else {

            }
        }

        return res;
    }
}
