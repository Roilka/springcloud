package com.roilka.test.lambda;


import java.awt.event.ActionEvent;

import javax.swing.JButton;


public class ActionListener {

	public static void main(String[] args) {
		JButton show = new JButton("Show");
		afterJava8(show);
	}
	public static void beforeJava8(JButton show) {
		/*show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent actionevent) {
				System.out.println("我是来自Java-8之前的 ");
			}
		});*/
	}
	public static void afterJava8(JButton show) {
		show.addActionListener(
				(e) -> {
					System.out.println("我是来自Java-8之后的 ");
				}
				);
	}
}
