package br.com.pizzaria77.modelos;

import javax.swing.JOptionPane;

public class Pizza 
{
	private int codigo;
	private static String[] pizza = {"Mussarela","Calabresa","Portuguesa"};
	public Pizza(int codPizza) {
		setCode(codPizza);
	}
	public void setCode(int cod) {
		codigo = cod;
	}
	public int getCode() {
		return codigo;
	}

	public static String[] getPizzas() {
		return pizza;
	}

}
