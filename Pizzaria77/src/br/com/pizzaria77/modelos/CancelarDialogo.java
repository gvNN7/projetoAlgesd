package br.com.pizzaria77.modelos;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CancelarDialogo extends JDialog implements ActionListener {
	private JTextArea texto;
	private JTextField numPedido, pizza;
	private FlowLayout flwLayout;
	private Container container1;
	private JLabel label, label1, label2;
	private JButton botao1, botao2;

	public CancelarDialogo() {
		
		super(new JFrame(), true);
		flwLayout = new FlowLayout(FlowLayout.CENTER, 50, 20);
		container1 = getContentPane();
		container1.setLayout(flwLayout);
		label = new JLabel("Pedidos" , SwingConstants.CENTER);
		label1 = new JLabel("N°do pedido");
		texto = new JTextArea(12, 22);
		numPedido = new JTextField(10);
		botao1 = new JButton("Cancelar pedido");
		botao2 = new JButton("Cancelar");
		
		//Adicionando ao Label
		container1.add(label);
		container1.add(texto);
		texto.setEditable(false);
		container1.add(label1);
		container1.add(numPedido);
		container1.add(botao1);
		container1.add(botao2);
		botao2.addActionListener(this);
		botao1.addActionListener(this);
		this.setSize(300, 470);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Alterar pedido");

	}

	public int toInt(String campo) {
		return Integer.parseInt(campo);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == botao1)
		{
			//ação
			ListaPedidos.cancelaPedido(toInt(numPedido.getText()));
			JOptionPane.showMessageDialog(null, "Pedido cancelado! ");
			numPedido.setText(null);
		}
		
		if(e.getSource() == botao2)
		{
			dispose();
		}
	}
}
