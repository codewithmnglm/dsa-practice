package com.practice.dsa.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {


    static int merge(List<Integer> ls, int l, int mid, int r) {

        List<Integer> tmp = new ArrayList<>();
        int left = l;
        int right = mid + 1;
        int count = 0;
        while (left <= mid && right <= r) {

            if (ls.get(left) <= ls.get(right)) {
                tmp.add(ls.get(l));
                l++;
            } else {
                tmp.add(ls.get(right));
                right++;
                count = count + (mid - left + 1);
            }
        }
        while (left <= mid) tmp.add(ls.get(left++));
        while (right <= r) tmp.add(ls.get(right++));

        return count;

    }

    static int ms(List<Integer> ls, int l, int r) {
        int res = 0;
        if (l >= r) return 0;
        int mid = (l + r) / 2;
        res = res + ms(ls, l, mid);
        res = res + ms(ls, mid + 1, r);
        res = res + merge(ls, l, mid, r);
        return res;

    }

    public static long countInversions(List<Integer> arr) {

        return ms(arr, 0, arr.size() - 1);


    }


    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        //countInversions(arr);
        System.out.println(countInversions(arr));

    }
}
