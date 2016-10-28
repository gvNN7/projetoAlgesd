package br.com.pizzaria77.modelos;

import javax.swing.JOptionPane;

public class ListaPedidos {
	private int tamanho = 0;
	private Pedido primeiro, ultimo;

	/**
	 * O método novoPedido tem comportamento de um metodo de inserir o ultimo
	 * elemento em uma lista ligada
	 * 
	 * @param numPedido
	 * @param codPizza
	 * @param prioridade
	 */
	public void novoPedido(int numeroPedido, int prioridade, int codPizza) {
		Pedido novoPedido = new Pedido(numeroPedido, prioridade, codPizza);
		if (tamanho == 0) {
			primeiro = novoPedido;
			primeiro.setAnterior(null);
			primeiro.setProximo(null);
			ultimo = primeiro;
			tamanho++;
		} else if (tamanho == 1) {
			primeiro.setProximo(novoPedido);
			primeiro.getProximo().setAnterior(primeiro);
			ultimo = novoPedido;
			tamanho++;
		} else {
			ultimo.setProximo(novoPedido);
			ultimo.getProximo().setAnterior(ultimo);
			ultimo = novoPedido;
			tamanho++;
		}
	}

	/**
	 * Algoritmo de ordenação tipo bolha, ordena os pedidos por prioridade
	 */
	public static ListaPedidos sortByPriority(ListaPedidos lista) {

		ListaPedidos listaPrioridade = new ListaPedidos();

		// Pedido primeiroAux = primeiro;

		for (int i = 1; i < 4; i++) {
			Pedido auxiliar = lista.primeiro;
			while (auxiliar != null) {
				if (auxiliar.getPrioridade() == i) {
					listaPrioridade.novoPedido(auxiliar.getNumeroPedido(), auxiliar.getPrioridade(),
							auxiliar.getPizza());
				}
				auxiliar = auxiliar.getProximo();
			}
		}
		return listaPrioridade;

	}

	/**
	 * Realiza o cancelamento de um pedido qualquer, poossui comportamento de
	 * algoritmo para remover um elemento em qualquer posição na lista encadeada
	 * 
	 * @param numeroPedido
	 */
	public void cancelaPedido(int numeroPedido) {
		if (tamanho == 0) {
			JOptionPane.showMessageDialog(null, "Lista de pedidos vazia!!!");
		} else {
			if (tamanho == 1) {
				primeiro = null;
				ultimo = null;
				tamanho = 0;
				JOptionPane.showMessageDialog(null, "O pedido: " + numeroPedido + ", foi cancelado");
			} else {
				buscaPedido(numeroPedido).getAnterior().setProximo(buscaPedido(numeroPedido).getProximo());
				tamanho--;
				JOptionPane.showMessageDialog(null, "O pedido: " + numeroPedido + ", foi cancelado");
			}
		}
	}

	/**
	 * Algoritmo de busca linear, realiza busca pelo pedido solicitado
	 */
	public Pedido buscaPedido(int numeroPedido) {
		Pedido pedidoAux = primeiro;
		for (int i = 0; i < tamanho; i++) {
			if (pedidoAux.getNumeroPedido() == numeroPedido)
				return pedidoAux;
			pedidoAux = pedidoAux.getProximo();
		}
		return null;
	}

	/**
	 * attend() atende o primeiro cliente da fila logo, removendo o primeiro da
	 * fila
	 */
	public void attend() {
		if (tamanho == 0) {
			JOptionPane.showMessageDialog(null, "Lista de pedidos vazia!!!");
		} else {
			if (tamanho == 1) {
				primeiro = null;
				ultimo = null;
				tamanho = 0;
				JOptionPane.showMessageDialog(null, "Pedido atendido");
			} else {
				primeiro = primeiro.getProximo();
				tamanho--;
				JOptionPane.showMessageDialog(null, "Pedido atendido");
			}
		}
	}

	/**
	 * updateRequest, método que atualiza o pedido
	 */
	public  void updateRequest(int numeroPedido, int prioridade, int codePizza)  {
		buscaPedido(numeroPedido).setPizza(codePizza);
		buscaPedido(numeroPedido).setPrioridade(prioridade);
	}

	public String imprimeLista() {

		if (tamanho == 0) {
			return "";
		}

		StringBuilder builder = new StringBuilder("");
		Pedido atual = primeiro;

		for (int i = 0; i < tamanho; i++) {
			builder.append("nº pedido" + atual.getNumeroPedido() + "- Prio " + atual.getPrioridade() + "- pizza "
					+ atual.getPizza());
			builder.append(" \n ");
			atual = atual.getProximo();
		}

		builder.append("");
		return builder.toString();
	}
}
