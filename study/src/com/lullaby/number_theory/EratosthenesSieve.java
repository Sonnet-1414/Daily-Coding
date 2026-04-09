package com.lullaby.number_theory;

public class EratosthenesSieve {
    // 埃氏筛
    public static void main(String[] args) {
        int n = 100;
        boolean isPrime[] = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            isPrime[i] = true;
        }
        int[] prime = new int[n + 1];
        int count = 0;

        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                prime[count++] = i;
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.print(prime[i] + " ");
        }
    }
}
