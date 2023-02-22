package com.multi.pratice.multipratice.algorithm.basic.backjoon;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.*;
import java.util.StringTokenizer;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.backjoon
 * fileName : C15651
 * author : taeil
 * date : 2023/01/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/19        taeil                   최초생성
 */
public class C15651 {
// 재귀함수
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }
    static int N, M;
    static int[] selected;

    static void rec_func(int k) {
        if(k == M + 1) { // 다 골랐다면.
            // selected[1...M] 배열이 새롭게 탐색된 결과
            for (int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for(int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                // k+1번 ~ M번을 모두 탐색하는 일을 해야한다.
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();

        // 1번째 원소부터 M번째 원소를 조건에 맞는 모든 방법을 찾는다.
        rec_func(1);
        System.out.println(sb.toString());
    }


    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        //public FastReader(String s) throws FileNotFoundException { br = new BufferedReader(new FileReader(new File(s))); }
        java.lang.String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        java.lang.String nextLine() {
            java.lang.String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }

}