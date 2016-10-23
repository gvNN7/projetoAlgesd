package br.com.pizzaria77.modelos;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Exemplo de Diálogo por Método - Teste 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main{

	public static void main(String args[]) {
		JFrame frame =  new JFrame("Pedidos - Pizzaria");
		TelaPizzaria pane = new TelaPizzaria();
		frame.add(pane);
		frame.setVisible(true);
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}