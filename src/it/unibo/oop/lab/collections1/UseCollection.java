package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int TIMES = 1000;
	private static final int TO_MS = 1_000_000;
	private static final int RANGE_MIN = 1000;
	private static final int RANGE_MAX = 2000;
	private static final int ELEMS = 100000;
	
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
    	final List<Integer> list = new ArrayList<>();
    	for(int i = RANGE_MIN; i < RANGE_MAX; i++) {
    		list.add(i);
    	}
    	System.out.println(list);
    	
    	
    	final List<Integer> list2 = new ArrayList<Integer>();
    	list2.addAll(list);
    	System.out.println(list2);
        
    	
    	int last = list.size() - 1;
    	int count = 0;
    	int tmp;
    	tmp = list.get(count);
		list.set(count, list.get(last));
		list.set(last, tmp);
    	System.out.println(list);
    	
    	
    	for(int elem: list) {
    		System.out.println(elem);
    	}
    	
    	
    	
    	final List<Integer> sacrificio1 = new ArrayList<Integer>();
    	final List<Integer> sacrificio2 = new LinkedList<Integer>();
    	
    	long time = System.nanoTime();
    	for(int i = 0; i < ELEMS; i++) {
    		sacrificio1.add(0, i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Adding " + ELEMS
                + " elements in ArrayList took " + time
                + " ns (" + time / TO_MS + "ms)");
    	
    	
    	time = System.nanoTime();
    	for(int i = 0; i < ELEMS; i++) {
    		sacrificio2.add(0, i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Adding " + ELEMS
                + " elements in LinkdList took " + time
                + "   ns (" + time / TO_MS + "  ms)");
    	
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         * 
         * LINKED LIST PIU VELOCE DI ARRAY LIST
         */
    	
    	time = System.nanoTime();
    	for(int i = 0; i < TIMES; i++) {
    		sacrificio1.get(50000);
    	}
    	time = System.nanoTime() - time;
    	System.out.println(time);
    	
    	time = System.nanoTime();
    	for(int i = 0; i < TIMES; i++) {
    		sacrificio2.get(50000);
    	}
    	time = System.nanoTime() - time;
    	System.out.println(time);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         * 
         * ARRAY LIST MOLTO PIU VELOCE DI LINKED LIST
         * 
         */
    	
    	final Map<String, Integer> map = new HashMap<String, Integer>();
    	map.put("Africa", 1_110_635_000);
    	map.put("Americas", 972_005_000);
    	map.put("Antarctica", 0);
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    }
}
