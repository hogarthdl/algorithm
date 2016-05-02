import java.util.*;

/**
 * Created by hogarth on 2016/5/2.
 */

public class my_sqrt {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Partition p = new Partition();
        System.out.println("二分法");
        p.bi_sqrt(2,0.00001);
        System.out.println("牛顿迭代");
        p.newton_sqrt(2,0.00001);
    }

    public static class Partition {
        public double bi_sqrt(double num, double e) {
            double low = 0;
            double high = num;
            double guess = num / 2;
            double e0 = e+1;//为了有第一次循环；使e0 > e
            int count = 0;
            while (e0 > e) {
                guess = (low + high) / 2;
                if (guess * guess > num) {
                    high = guess;
                    e0 = guess*guess - num;
                } else {
                    low = guess;
                    e0 = num - guess*guess;
                }
                count++;
                System.out.println("times: " + count + " guess: " + guess);
            }
            return guess;
        }

        public double newton_sqrt(double num, double e){
            double guess = num / 2;
            double e0 = e + 1;
            int count = 0;
            while(e0 > e){
                guess = (guess + num  / guess) / 2;
                e0 = guess * guess - num;
                count++;
                System.out.println("times: " + count + " guess: " + guess);
            }
            return guess;
        }
    }
}
