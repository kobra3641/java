package ru.uppskilling;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;

public class Main {

    public static void main(String[] args) {
        int[] a = {1,3,5,6,7};
        int[] b = {2,4,8,9};
        int[] c = {3,5,4,5,4,3,2,1,2,3,6,3,3,2};
        int[] d = {-1,2,-5,3,4,-3};
        int[] f = {2,3,3,2,1,5,6,1};
        int[] e = {9,3,5,7,1,2,4};
        System.out.println(Arrays.toString(combineTwoSortedArrays(a,b)));
        firstNonRecurringElements(c);
        System.out.println();
        reverse(d);
        System.out.println();
        System.out.println(countPairs(f));
        countOccurrencesInArray(f);
        System.out.println(findDuplicateInArray(f));
        System.out.println(sumBetweenMinAndMaxSortedArray(e));
        System.out.println(sumBetweenMinAndMaxUnsortedArray(e));
    }

    // 1
    public static int[] combineTwoSortedArrays(int[] a, int[] b) {
        return Stream.of(a, b)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.groupingBy(e -> e,
                        TreeMap::new, Collectors.counting()))
                .entrySet().stream()
                .flatMapToInt(e ->
                        LongStream.range(0, e.getValue()).mapToInt(v -> e.getKey()))
                .toArray();
    }

    // 2
    public static void firstNonRecurringElements(int[] a){
        Integer[] b = new HashSet<>(
                Arrays.stream(a)
                        .sorted()
                        .boxed()
                        .collect(Collectors.toList()))
                        .toArray(new Integer[0]);
        if(b.length >= 1){
            System.out.print(b[0] + " "); // first min element
            if(b.length >= 2)
                System.out.print(b[1] + " "); // second min element
        }
        System.out.print(b[b.length-1] + " "); // first max element
        System.out.print(b[b.length-2] + " "); // second max element
    }

    // 3
    public static void reverse(int[] a){
        Arrays.stream(a)
                .boxed()
                .sorted(comparingInt(x -> x))
                .forEach(System.out::print);
    }

    // 4
    public static long countPairs(int[] a) {
       return findAndCountDuplicate(a).entrySet().stream().filter(item -> item.getValue() > 1).count();
    }

    // 5
    public static void countOccurrencesInArray(int[] a) {
        findAndCountDuplicate(a).entrySet().forEach(System.out::println);
    }

    private static Map<Integer, Integer> findAndCountDuplicate(int[] a) {
        Map<Integer, Integer> pairs = new HashMap<>();
        IntStream.range(0, a.length).forEach(i -> {
            if (pairs.containsKey(a[i])) {
                if (pairs.get(a[i]) != null) {
                    pairs.put(a[i], pairs.get(a[i]) + 1);
                }
            } else if (!pairs.containsValue(a[i])) {
                pairs.put(a[i], 1);
            }
        });
        return pairs;
    }

    // 6
    public static List<Integer> findDuplicateInArray(int[] a) {
        return IntStream.of(a).boxed()
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) )
                .entrySet()
                .stream()
                .filter( p -> p.getValue() > 1 )
                .map( Map.Entry::getKey )
                .collect( Collectors.toList() );
    }

    // 7
    public static long sumBetweenMinAndMaxSortedArray(int[] a) {
        return Arrays.stream(a).sorted().skip(1).limit(a.length-2).sum();
    }

    // 8
    public static long sumBetweenMinAndMaxUnsortedArray(int[] a){
        int minIndex = IntStream.range(0, a.length)
                .reduce((t1,t2)->a[t1]>a[t2]? t2: t1)
                .getAsInt();
        int maxIndex = IntStream.range(0, a.length)
                .reduce((t1,t2)->a[t1]<a[t2]? t2: t1)
                .getAsInt();
        AtomicInteger sum = new AtomicInteger();
        IntStream.range(Math.min(minIndex, maxIndex) + 1, Math.max(minIndex, maxIndex)).forEach(index -> {
            sum.addAndGet(a[index]);
        });
        return sum.get();
    }
}
