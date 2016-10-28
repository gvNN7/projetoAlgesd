package br.com.pizzaria77.modelos;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AlterarPedidoDialogo extends JDialog implements ActionListener {
	private JTextField numPedido;
	private JComboBox prioridade,pizza;
	
	private FlowLayout flwLayout;
	private Container container1;
	private JLabel label, label1, label2, label3;
	private JButton botao1, botao2;
	private ListaPedidos listaPedidos;

	public AlterarPedidoDialogo(ListaPedidos listaPedidos) {

		super(new JFrame(), true);
		flwLayout = new FlowLayout(FlowLayout.CENTER, 50, 20);
		container1 = getContentPane();
		container1.setLayout(flwLayout);
		label1 = new JLabel("N°do pedido");
		label2 = new JLabel("Pizza             ");
		label3 = new JLabel("Prioridade   ");
		numPedido = new JTextField(10);
		pizza =  new JComboBox(Pizza.getPizzas());
		prioridade = new JComboBox(new String[] {"1","2","3"});
		botao1 = new JButton("Incluir pedido");
		botao2 = new JButton("Cancelar");
		this.listaPedidos = listaPedidos;

		// Adicionando ao Label
		container1.add(label1);
		container1.add(numPedido);
		container1.add(label2);
		container1.add(pizza);
		container1.add(label3);
		container1.add(prioridade);
		container1.add(botao1);
		container1.add(botao2);
		botao2.addActionListener(this);
		botao1.addActionListener(this);
		this.setSize(350, 250);
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botao1) {

			listaPedidos.updateRequest(toInt(numPedido.getText()),pizza.getSelectedIndex(),toInt(prioridade.getSelectedItem().toString()));
			JOptionPane.showMessageDialog(null, "Pedido alterado! ");
			dispose();
		}
		if (e.getSource() == botao2) {
			dispose();
		}
	}
}
