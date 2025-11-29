package com.practice.dsa;

import java.sql.Connection;
import java.util.*;

public class Queues {

    public static String[] findRelativeRanksLC506(int[] score) {

        String[] st = new String[score.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : score) pq.add(i);

        int i = 1;

        HashMap<Integer, String> map = new HashMap<>();

        while (!pq.isEmpty()) {

            if (i == 1) map.put(pq.remove(), "Gold Medal");
            else if (i == 2) map.put(pq.remove(), "Silver Medal");
            else if (i == 3) map.put(pq.remove(), "Bronze Medal");
            else map.put(pq.remove(), String.valueOf(i));
            i++;


        }

        for (int j = 0; j < score.length; j++) st[j] = map.get(score[j]);

        return st;
    }


    public static int[] topKFrequentLC347(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        System.out.println(map);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) pq.add(entry.getValue());

        System.out.println(pq);

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = getKeyFromValue(map, pq.poll());
            map.remove(res[i]);
        }

        return res;
    }

    public static <K, V> K getKeyFromValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static int thirdMaxLC414(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.offer(1);
        for (int i = 0; i < nums.length; i++) {
            if (!pq.contains(nums[i]))
                pq.add(nums[i]);

            if (pq.size() > 3)
                pq.poll();
        }
        if (pq.size() == 2) pq.poll();
        return pq.peek();
    }

    public static List<String> topKFrequent(String[] words, int k) {

        TreeMap<String, Integer> map = new TreeMap<>();

        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);



        /*PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b)-> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()):a.getValue()-b.getValue()
        );*/

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) ->
                        b.getValue().equals(a.getValue()) ?
                        a.getKey().compareTo(b.getKey()) :
                        b.getValue().compareTo(a.getValue())
        );
        pq.addAll(map.entrySet());

        List<String> li = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            var entry = pq.poll();
            assert entry != null;
            li.add(entry.getKey());


        }


        return li;


    }

    public static String frequencySortLC451(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c: s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);

        PriorityQueue<Map.Entry<Character,Integer>> pq= new PriorityQueue<>((a,b)->
            b.getValue()-a.getValue()
        );

        pq.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();

        while(!pq.isEmpty()){

            Map.Entry<Character,Integer> entrySet= pq.poll();


            for(int i=0;i<entrySet.getValue();i++){
                res.append(entrySet.getKey());
            }

        }

          return res.toString();

    }


    public static void main(String[] args) {

        int ar[] = {5, 2, 2};

        // System.out.println(Arrays.toString(findRelativeRanksLC506(ar)));

        // int []res= topKFrequentLC347(ar,2);
        // for(int i:res) System.out.println(i);
        //System.out.println(thirdMaxLC414(ar));
        String[] str = {"i", "love", "leetcode", "i", "love", "coding"};

        //System.out.println(topKFrequent(str, 3));

        System.out.println(frequencySortLC451("tree"));

    }
}
