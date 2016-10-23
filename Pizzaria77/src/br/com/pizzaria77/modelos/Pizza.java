package br.com.pizzaria77.modelos;

import javax.swing.JOptionPane;

public class Pizza 
{
	static int codigo;

	public Pizza(int codPizza) {
		setCode(codPizza);
	}
	public static void setCode(int cod) {
		codigo = cod;
	}
	public static int getCode() {
		return codigo;
	}
	

}
