package ppc.order.util;

import java.util.Random;

public class KeyUtil {

    public  static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(90000)+10000;
        return System.currentTimeMillis()+ String.valueOf(number);
    }

    public static void main(String[] args) {
        System.out.println(genUniqueKey());
    }
}
