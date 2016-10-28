package br.com.pizzaria77.modelos;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CancelarDialogo extends JDialog implements ActionListener {
	private JTextField numPedido;
	private FlowLayout flwLayout;
	private Container container1;
	private JLabel label1;
	private JButton botao1, botao2;
	private ListaPedidos listaPedidos;

	public CancelarDialogo(ListaPedidos listaPedidos) {
		
		super(new JFrame(), true);
		flwLayout = new FlowLayout(FlowLayout.CENTER, 50, 20);
		container1 = getContentPane();
		container1.setLayout(flwLayout);
		label1 = new JLabel("N°do pedido");	
		numPedido = new JTextField(10);
		botao1 = new JButton("Cancelar pedido");
		botao2 = new JButton("Cancelar");
		this.listaPedidos = listaPedidos;
		
		container1.add(label1);
		container1.add(numPedido);
		container1.add(botao1);
		container1.add(botao2);
		botao2.addActionListener(this);
		botao1.addActionListener(this);
		this.setSize(200,220);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Alterar pedido");

	}
	public ListaPedidos getListaPedidos() {
		return this.listaPedidos;
	}

	public int toInt(String campo) {
		return Integer.parseInt(campo);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == botao1)
		{
			//ação
			listaPedidos.cancelaPedido(toInt(numPedido.getText()));
			JOptionPane.showMessageDialog(null, "Pedido cancelado! ");
			dispose();
		}
		
		if(e.getSource() == botao2)
		{
			dispose();
		}
	}
}
