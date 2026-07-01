import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

    static class Pair<T, U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    static class Stack<T> {
        private ArrayList<T> items = new ArrayList<>();

        void push(T item) {
            items.add(item);
            System.out.println(item + " pushed to stack");
        }

        T pop() {
            if (items.isEmpty()) {
                System.out.println("Stack is empty");
                return null;
            }
            T item = items.remove(items.size() - 1);
            System.out.println(item + " popped from stack");
            return item;
        }

        T peek() {
            if (items.isEmpty()) return null;
            return items.get(items.size() - 1);
        }

        int size() {
            return items.size();
        }
    }

    static class Repository<T> {
        private ArrayList<T> store = new ArrayList<>();

        void save(T entity) {
            store.add(entity);
            System.out.println("Saved: " + entity);
        }

        T get(int index) {
            return store.get(index);
        }

        void delete(int index) {
            T removed = store.remove(index);
            System.out.println("Deleted: " + removed);
        }

        int count() {
            return store.size();
        }
    }

    interface Printable<T> {
        void print(T item);
    }

    static class Box<T> {
        private T value;

        <V extends T> Box(V value) {
            this.value = value;
            System.out.println("Box created with: " + value);
        }

        T getValue() {
            return value;
        }
    }

    static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];
        for (T item : arr) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    static void printList(List<?> list) {
        System.out.println("--- List Contents ---");
        for (Object item : list) {
            System.out.println(item);
        }
    }

    static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Added numbers to list: " + list);
    }

    public static void main(String[] args) {

        System.out.println("=== Pair ===");
        Pair<String, Integer> studentPair = new Pair<>("Rohit Sharma", 101);
        Pair<String, Double> salaryPair = new Pair<>("Neha Kulkarni", 75000.0);
        System.out.println(studentPair);
        System.out.println(salaryPair);

        System.out.println("\n=== Stack ===");
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("DSA");
        System.out.println("Top: " + stack.peek());
        stack.pop();
        System.out.println("Size after pop: " + stack.size());

        System.out.println("\n=== findMax ===");
        Integer[] intArr = {10, 45, 23, 78, 34};
        String[] strArr = {"Rohit", "Neha", "Vikram", "Anita"};
        System.out.println("Max integer: " + findMax(intArr));
        System.out.println("Max string: " + findMax(strArr));

        System.out.println("\n=== Repository ===");
        Repository<String> repo = new Repository<>();
        repo.save("Rohit Sharma");
        repo.save("Neha Kulkarni");
        repo.save("Vikram Singh");
        System.out.println("Total: " + repo.count());
        repo.delete(1);
        System.out.println("After delete: " + repo.count());

        System.out.println("\n=== printList wildcard ===");
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        List<String> strList = new ArrayList<>();
        strList.add("Java");
        strList.add("Generics");

        printList(intList);
        printList(strList);

        System.out.println("\n=== Upper Bounded Wildcard ===");
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(10.5);
        doubleList.add(20.5);
        doubleList.add(30.0);
        System.out.println("Sum of doubles: " + sumOfList(doubleList));
        System.out.println("Sum of integers: " + sumOfList(intList));

        System.out.println("\n=== Lower Bounded Wildcard ===");
        List<Number> numberList = new ArrayList<>();
        addNumbers(numberList);

        System.out.println("\n=== Box ===");
        Box<Number> box1 = new Box<>(42);
        Box<Number> box2 = new Box<>(3.14);
        System.out.println("Box 1: " + box1.getValue());
        System.out.println("Box 2: " + box2.getValue());

        System.out.println("\n=== Printable Interface ===");
        Printable<String> strPrinter = item -> System.out.println("Printing: " + item);
        Printable<Integer> intPrinter = item -> System.out.println("Printing: " + item);
        strPrinter.print("Hello Generics");
        intPrinter.print(2026);
    }
}