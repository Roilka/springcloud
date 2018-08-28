package com.roilka.test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class WorkerInterfaceTest {

	public static void execute(WorkerInterface worker) {
		worker.doSomeWork();
	}
	
	public static void main(String[] args) {
		execute(() -> System.out.println("Work invoked using"));
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(System.out::println);
        
        System.out.println(list.stream().allMatch(n->n >2)); 
	}
	
	private void testForeach(List<Integer> list){
		list.stream().filter(x -> x >3).forEach(System.out::println);
	}
	
	private void testFilter(List<Integer> list){
		list.stream().filter(x -> x >3).forEach(System.out::println);
	}
	
	private void testMapReduce(List<Integer> list){
		int sum = list.stream().map(n -> n * n).reduce((n,m) -> n + m).get();
		System.out.println(sum);
	}
	private void testPredicate(List<Integer> list) {
		
	}
	
	/**
	 * 自定义规则，使用断言（Predicate）函数式接口
	 * @param list
	 * @param predicate
	 */
	public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer integer : list) {
			if (predicate.test(integer)) {
				System.out.println( integer + "");
			}
		}
	}
}
