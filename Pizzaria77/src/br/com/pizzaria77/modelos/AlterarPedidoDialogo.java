package br.com.pizzaria77.modelos;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AlterarPedidoDialogo extends JFrame implements ActionListener {
	private JTextArea texto;
	private JTextField numPedido, pizza;
	private FlowLayout flwLayout;
	private Container container1;
	private JLabel label, label1, label2;
	private JButton botao1, botao2;

	public AlterarPedidoDialogo() {
		
		super("Alterar pedido");
		flwLayout = new FlowLayout(FlowLayout.CENTER, 50, 20);
		container1 = getContentPane();
		container1.setLayout(flwLayout);
		label = new JLabel("Pedidos" , SwingConstants.CENTER);
		label1 = new JLabel("N°do pedido");
		label2 = new JLabel("Pizza            ");
		texto = new JTextArea(12, 22);
		numPedido = new JTextField(10);
		pizza = new JTextField(10);
		botao1 = new JButton("Alterar");
		botao2 = new JButton("Cancelar");
		
		//Adicionando ao Label
		container1.add(label);
		container1.add(texto);
		texto.setEditable(false);
		container1.add(label1);
		container1.add(numPedido);
		container1.add(label2);
		container1.add(pizza);
		container1.add(botao1);
		container1.add(botao2);
		botao2.addActionListener(this);
		botao1.addActionListener(this);
		this.setSize(300, 470);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == botao1)
		{
			//ação
			numPedido.getText();
			pizza.getText();
			
			JOptionPane.showMessageDialog(null, "Pedido alterado! ");
			numPedido.setText(null);
			pizza.setText(null);
		}
		
		if(e.getSource() == botao2)
		{
			System.exit(1);
		}
	}
}
