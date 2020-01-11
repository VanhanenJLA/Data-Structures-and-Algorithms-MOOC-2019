
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jouni
 */
public class Main {

    public static void main(String[] args) {
        int n = (int) 1E8;

        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList();

        benchmarkArray(arr);
        benchmarkArrayList(list, n);
    }

    private static void benchmarkArray(int[] arr) {
        arrayWrite(arr);
        arrayRead(arr);
    }

    private static void benchmarkArrayList(ArrayList<Integer> list, int n) {
        arrayListWrite(list, n);
        arrayListRead(list, n);
    }

    private static void printElapsedTime(long start, long finish) {
        System.out.println("Time elapsed " + ((finish - start) / 1e9) + " s");
    }

    private static void printElapsedNanoTime(long start, long finish) {
        System.out.println("Time elapsed " + (finish - start) + " ns");
    }

    private static void arrayWrite(int[] arr) {
        long start = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long finish = System.nanoTime();
        System.out.println("ARRAY WRITE:");
        printElapsedTime(start, finish);
    }

    private static void arrayRead(int[] arr) {
        long start = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
        }
        long finish = System.nanoTime();
        System.out.println("ARRAY READ:");
        printElapsedTime(start, finish);
    }

    private static void arrayListWrite(ArrayList<Integer> list, int n) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.add(i, 1);
        }
        long finish = System.nanoTime();
        System.out.println("ARRAYLIST WRITE:");
        printElapsedTime(start, finish);
    }

    private static void arrayListRead(ArrayList<Integer> list, int n) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int j = list.get(i);
        }
        long finish = System.nanoTime();
        System.out.println("ARRAYLIST READ:");
        printElapsedTime(start, finish);
    }

}
