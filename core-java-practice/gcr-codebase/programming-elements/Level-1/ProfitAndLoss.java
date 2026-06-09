public class ProfitAndLoss {
    public static void main(String[] args) {
        int cp = 129;
        int sp = 191;
        int profit = sp - cp;
        double profit_percentage = ((double)profit/cp)* 100;
        System.out.printf("The Cost Price is INR %d and Selling Price is INR %d .\n",cp,sp);
        System.out.printf("The Profit is INR %d and the Profit Percentage is %.1f.",profit,profit_percentage);
    }
}
