/* *****************************************************************************
 *
 *
 **************************************************************************** */

public class Coupon {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = 0;
        int distinct = 0;
        boolean[] collection = new boolean[n];
        while (distinct < n) {

            int currentCoupon = (int) (Math.random() * n);

            if (!collection[currentCoupon]) {
                collection[currentCoupon] = true;
                distinct++;
            }
            count++;
        }

        System.out.println(count);
    }
}
