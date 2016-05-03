/**
 * Created by hogarth on 2016/5/3.
 * A problem from programming pearls
 * Rotate String "abcdfefgh" to "defghabc"
 * Solution: AB->ArB->ArBr->(ArBr)r->BA
 */
import java.util.*;

public class vector_rotation {
    public static void main(String[] args) {
        Partition p = new Partition();
        String s = "abcdefgh";
        System.out.println("before:"+ s + " after:" + p.rotate(s,3));
    }

    public static class Partition {
        public String rotate(String s, int i) {
            char[] c = s.toCharArray();
            int length = c.length;
            reverse(c, 0, i-1);
            reverse(c, i, length-1);
            reverse(c, 0, length-1);
//            for (int j = 0; j < length; j++) {
//                System.out.println(c[j]);
//            }
            return String.valueOf(c);
        }

        public void reverse(char[] c, int first, int last){
            int len = last - first;
            for (int j = 0; j < len/2; j++){
                char tmp = c[first+j];
                c[first+j] = c[last-j];
                c[last-j] = tmp;
            }
        }
    }
}

