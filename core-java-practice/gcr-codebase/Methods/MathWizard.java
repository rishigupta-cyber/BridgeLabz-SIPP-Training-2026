public class MathWizard {

    private int callCount = 0;

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static double factorial(double n) {
        double result = 1;
        for (double i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long previous = 0;
        long current = 1;

        for (int i = 2; i <= n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }

        return current;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static double power(double base, int exp) {
        double result = 1;
        for (int i = 0; i < exp; i++) {
            result = result * base;
        }
        return result;
    }

    public void trackCall() {
        int callCount = 100;
        this.callCount++;

        System.out.println("Local callCount inside method: " + callCount);
        System.out.println("Instance callCount (this.callCount): " + this.callCount);
    }

    public static void main(String[] args) {
        System.out.println("isPrime(17): " + isPrime(17));
        System.out.println("isPrime(20): " + isPrime(20));

        System.out.println("factorial(5) [int version]: " + factorial(5));
        System.out.println("factorial(5.0) [double version]: " + factorial(5.0));

        System.out.println("fibonacci(10): " + fibonacci(10));

        System.out.println("gcd(24, 36): " + gcd(24, 36));
        System.out.println("lcm(4, 6): " + lcm(4, 6));

        System.out.println("power(2, 10): " + power(2, 10));

        MathWizard wizard = new MathWizard();
        wizard.trackCall();
        wizard.trackCall();
        wizard.trackCall();
    }
}