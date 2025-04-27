package semaphore.trabalhoInterfaces;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class exemplos {
	
    public static void exemploRunnable() {
        Runnable tarefa = () -> System.out.println("Executando uma tarefa...");
        Thread thread = new Thread(tarefa);
        thread.start();
    }
	
	public static void exemploConsumer() {
        Consumer<String> imprimirMensagem = mensagem -> System.out.println(mensagem);
        imprimirMensagem.accept("Olá, mundo!");
    }
	
	public static void exemploBiConsumer() {
        BiConsumer<String, Integer> mostrarNomeIdade = (nome, idade) -> System.out.println(nome + " tem " + idade + " anos.");
        
        mostrarNomeIdade.accept("Ana", 25);
    }
	
	public static void exemploFunction() {
        Function<Integer, String> verificarParOuImpar = numero -> (numero % 2 == 0) ? "Par" : "Ímpar";
        
        String resultado = verificarParOuImpar.apply(4);
        System.out.println(resultado);
    }
	
    public static void exemploBiFunction() {
        BiFunction<Integer, Integer, Integer> somar = (a, b) -> a + b;
        
        Integer resultado = somar.apply(5, 10);
        System.out.println("Soma: " + resultado);
    }
    
    public static void exemploSupplier() {
        Supplier<String> fornecerMensagem = () -> "Mensagem gerada pelo Supplier!";
        
        String mensagem = fornecerMensagem.get();
        System.out.println(mensagem);
    }
    
    public static void exemploPredicate() {
        Predicate<Integer> ehMaiorQueDez = numero -> numero > 10;
        
        boolean resultado = ehMaiorQueDez.test(20);
        System.out.println("É maior que 10? " + resultado);
    }

    public static void main(String[] args) {
        //exemploRunnable();
        //exemploConsumer();
        //exemploBiConsumer();
    	//exemploFunction();
    	//exemploBiFunction();
    	//exemploSupplier();
    	exemploPredicate();
    }
    
    
}
