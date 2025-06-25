package algoritimos;

import java.util.Scanner;

public class App {
	
	Scanner scanner = new Scanner(System.in);
	Counter counter;
	
	private int readInt(String message) {
		
		System.out.print(message);
		int value = scanner.nextInt();
		return value;
	}
	
	private void printLine() {
		
		System.out.println("\n-----------------------------------");
	}
	
	private void ex1() {
		
		counter = new Counter(1, 10, 1);
		counter.count(i->System.out.println(i));
		printLine();
	}
	
	private void ex2() {
		
		int x = readInt("Valor de X:");
		int y = readInt("Valor de Y:");
		
		if(x > y) {
			
			System.out.println("O valor de X é maior que o valor de Y");
			return;
		}
		
		counter = new Counter(x, y, 1);	
		counter.count(System.out::println);
		printLine();
	}
	
	private void ex3() {
		
		counter = new Counter(1, 10, 2);
		counter.count(System.out::println);
		printLine();
	}
	
	private void ex4() {
		
		counter = new Counter(1, 10, 3);
		counter.count(System.out::println);
		printLine();
	}
	
	private void ex5() {
		
		int x = readInt("Valor de X:");
		int y = readInt("Valor de Y:");
		int p = readInt("Valor de P:");
		
		if(x > y) {
			
			System.out.println("O valor de X é menor que o valor de Y");
			return;
		}

		counter = new Counter(x, y, p);	
		counter.count(System.out::println);
		printLine();
	}
	
	private void ex6() {
		
	}
	
	private void ex7() {
		
	}
	
	public static void main(String[] args) {
		
		App app = new App();
		app.ex1();
		app.ex2();
		app.ex3();
		app.ex4();
		app.ex5();
	}
}
