package com.lullaby.number_theory;

public class EulerSieve {
    // 欧拉筛
    public static void main(String[] args) {
        re();
        System.out.println();
        test();
//        return;

    }

    private static void test() {
        int n = 100;
        boolean[] isPrime = new boolean[n + 1];
        int count = 0;
        int[] primes = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // 枚举所有数 + 枚举每个质数的倍数
        for (int i = 2; i <= n; i++) {
            // 如果是质数就加入数组
            if (isPrime[i]) {
                primes[++count] = i;
            }

            // 把i当作质数的倍数来看，枚举所有质数的i倍
            for (int j = 1; j <= count; j++) {
                int x = i * primes[j];
                if (x > n) break;
                isPrime[x] = false;
                // 保证合数只被其最小的质因数标记
                if (i % primes[j] == 0) break;
            }
        }

        for (int i = 1; i <= count; i++) {
            System.out.print(primes[i] + " ");
        }
    }

    public static void re() {
        int n = 100;
        boolean[] isPrime = new boolean[n + 1];
        int[] primes = new int[n + 1];
        int count = 0;

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
                primes[++count] = i;

            for (int j = 1; j <= count; j++) {
                int x = i * primes[j];
                if (x > n) break;
                isPrime[x] = false;
                if (i % primes[j] == 0) break;
            }
        }

        for (int i = 1; i <= count; i++) {
            System.out.print(primes[i] + " ");
        }
    }
}
