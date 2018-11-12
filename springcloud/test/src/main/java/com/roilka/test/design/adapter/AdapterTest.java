package com.roilka.test.design.adapter;

public class AdapterTest {

	public static void main(String[] args) {
		Targetable targetable = new Adapter();
		targetable.method1();
		targetable.method2();
		
		Source source = new Source();
 		targetable = new Wrapper(source);
 		targetable.method1();
		targetable.method2();
		
		Sourceable sourceable1 = new SourceSub1();
		Sourceable sourceable2 = new SourceSub2();
		sourceable1.method1();
		System.out.println("---- 我是分割线 ----");
		sourceable1.method2();
		System.out.println("---- 我是分割线 ----");
		sourceable2.method1();
		System.out.println("---- 我是分割线 ----");
		sourceable2.method2();
	}
}
