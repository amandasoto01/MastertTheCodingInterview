package Recursive;

import java.util.ArrayList;
import java.util.List;

public class RecursiveMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(findFactorialIterative(5));
        System.out.println(findFactorialRecursive(5));
        System.out.println(findFibonacciIterative(8));
        System.out.println(findFibonacciRecursive(8));
    }

    public static int findFactorialRecursive(int num) {
        if(num == 1) {
            return 1;
        }
        return num * findFactorialRecursive(num - 1);
}

    public static int findFactorialIterative(int num) {
        int factorial = 1;
        for(int i=num; i>1; i--) {
            factorial *= i;
        }
        return factorial;
    }

    public static int findFibonacciRecursive(int num) {
        if(num < 2) {
            return num;
        }
        return findFibonacciRecursive(num-1) + findFibonacciRecursive(num-2);
    }

    public static int findFibonacciIterative(int num) {
        List<Integer> array = new ArrayList<>();
        array.add(0);
        array.add(1);

        for(int i=2; i< num +1 ; i++) {
            array.add(array.get(i-2) + array.get(i-1));
        }

        return array.get(num);
    }
}