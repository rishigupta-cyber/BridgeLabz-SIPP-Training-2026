public class PenDistribution {
    public static void main(String[] args) {
        int pens = 14;
        int distribute = pens / 3;
        int remaining = pens % 3;
        System.out.printf("The Pen Per Student is %d and the remaining pen not distributed is %d", distribute,
                remaining);
    }
}