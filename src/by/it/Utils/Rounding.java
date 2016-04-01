package by.it.Utils;

import java.math.BigDecimal;

/**
 * Статическая функция округления числа до 3 знаков после запятой по математическим правилам
 */
public class Rounding {
    public static Double myRound(Double a){
        String temp=a.toString();
        String b=new BigDecimal(temp).setScale(3, BigDecimal.ROUND_HALF_UP).toString();
        return Double.parseDouble(b);
    }
}
