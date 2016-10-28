package br.com.pizzaria77.modelos;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

//Exemplo de Diálogo por Método 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TelaPizzaria extends JPanel {

	private JLabel pedidos;
	private JButton novoPedido;
	private JButton cancelaPedido;
	private JButton alteraPedido;
	private JButton atendePedido;
	private JButton ordenaPedidos;
	private JTextArea areaPedidos;
	private GridBagConstraints gbc = new GridBagConstraints();
	private JPanel fieldsPanel;
	private ListaPedidos listaPedidos;

	/**
	 * Constructor of panel to ComplexBuilding's CRUD
	 * 
	 * @return
	 */
	public TelaPizzaria() {
		setLayout(new GridBagLayout());
		this.novoPedido = new JButton("Novo");
		this.cancelaPedido = new JButton("Calcelar");
		this.alteraPedido = new JButton("Alterar");
		this.atendePedido = new JButton("Atender");
		this.ordenaPedidos = new JButton("Ordenar");
		this.listaPedidos = new ListaPedidos();
		
		this.areaPedidos = new JTextArea(25,25);
		this.areaPedidos.setEnabled(false);
		this.pedidos = new JLabel("Pedidos");
		
		setFieldsPanel();

		// JFields
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 0, 0);

		add(fieldsPanel, gbc);

		// Listeners
		setupListeners();
	}

	/**
	 * @param fieldsLayout
	 *            the fieldsLayout to set
	 */
	private void setFieldsPanel() {

		this.fieldsPanel = new JPanel(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 6;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(pedidos, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 6;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 0, 0, 0);
		this.fieldsPanel.add(areaPedidos, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 0, 0, 0);
		this.fieldsPanel.add(atendePedido, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10,15, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(cancelaPedido, gbc); 
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(alteraPedido, gbc);
				
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10,15, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(novoPedido, gbc);

		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10, 105, 0, 0);
		gbc.fill = GridBagConstraints.VERTICAL;
		this.fieldsPanel.add(ordenaPedidos, gbc);
	}

	/**
	 * setup Listeners to all buttons
	 */
	public void setupListeners() {
		
		this.novoPedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				NovoPedidoDialogo novoP = new NovoPedidoDialogo(listaPedidos);
				listaPedidos = novoP.getListaPedidos();
				areaPedidos.setText("");
				areaPedidos.setText(listaPedidos.imprimeLista());
			}
		});
		this.alteraPedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				AlterarPedidoDialogo alt = new AlterarPedidoDialogo(listaPedidos);
				areaPedidos.setText("");
				areaPedidos.setText(listaPedidos.imprimeLista());
			}
		});
		this.cancelaPedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				CancelarDialogo canc = new CancelarDialogo(listaPedidos);
				areaPedidos.setText("");
				areaPedidos.setText(listaPedidos.imprimeLista());
			}
		});
		this.ordenaPedidos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				ListaPedidos listaOrdenadaPrioridade = ListaPedidos.sortByPriority(listaPedidos);
				areaPedidos.setText("");
				areaPedidos.setText(listaOrdenadaPrioridade.imprimeLista());
			}
		});
		
		this.atendePedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				listaPedidos.attend();
				areaPedidos.setText("");
				areaPedidos.setText(listaPedidos.imprimeLista());
			}
		});
		
	}
}