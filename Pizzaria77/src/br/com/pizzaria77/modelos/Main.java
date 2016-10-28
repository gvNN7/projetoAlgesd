package br.com.pizzaria77.modelos;

import javax.swing.JFrame;

public class Main {

	public static void main(String args[]) {
		ListaPedidos lp = new ListaPedidos();
		// for (int i = 0; i < 4; i++) {
		// lp.novoPedido(i, i * 2, i + 10);
		// System.out.println(lp.imprimeLista());
		// }
		JFrame frame = new JFrame("Pedidos - Pizzaria");
		TelaPizzaria pane = new TelaPizzaria();
		frame.add(pane);
		frame.setVisible(true);
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}