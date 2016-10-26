package br.com.pizzaria77.modelos;

public class Main{

	public static void main(String args[]) {
		ListaPedidos lp = new ListaPedidos();
		for (int i = 0; i < 4; i++) {
			lp.novoPedido(i, i * 2, i + 10);
			System.out.println(lp.imprimeLista());
		}
	}
}