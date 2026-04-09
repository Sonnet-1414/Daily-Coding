package com.lullaby.number_theory.P3383;

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[] primes = new int[n + 1];
//        int count = 0;
//        boolean[] isPrime = new boolean[n + 1];
//        for (int i = 2; i <= n; i++) {
//            isPrime[i] = true;
//        }
//
//        for (int i = 2; i <= n; i++) {
//            if (isPrime[i])
//                primes[++count] = i;
//
//            for (int j = 1; j <= count; j++) {
//                int x = i * primes[j];
//                if (x > n) break;
//                isPrime[x] = false;
//                if (i % primes[j] == 0) break;
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            int num = scanner.nextInt();
//            System.out.println(primes[num]);
//        }
//    }
//}

// 需要快速读写

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 快速输入
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        // 快速输出
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        // 读取 n 和 m
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;

        // 以下逻辑保持完全不动
        int[] primes = new int[n + 1];
        int count = 0;
        boolean[] isPrime = new boolean[n + 1];
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

        // 快速输出查询结果
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int num = (int) st.nval;
            out.println(primes[num]);
        }

        // 必须刷新缓冲区，否则不会有任何输出
        out.flush();
        out.close();
    }
}
