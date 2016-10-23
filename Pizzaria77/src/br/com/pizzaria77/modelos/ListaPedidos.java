package br.com.pizzaria77.modelos;

import javax.swing.JOptionPane;

public class ListaPedidos {
	static int tamanho = 0;
	static Pedido pedido ;

	/**
	 * O método novoPedido tem comportamento de um metodo de inserir o ultimo
	 * elemento em uma lista ligada
	 * 
	 * @param numPedido
	 * @param codPizza
	 * @param prioridade
	 */
	public static void novoPedido(int numeroPedido, int prioridade, int codPizza) {
		Pedido novoPedido = new Pedido(numeroPedido, prioridade, codPizza);
		
		if (tamanho == 0) {
			pedido = novoPedido;
			pedido.setPrimeiro(pedido);
			pedido.setUltimo(pedido);
			pedido.setProximo(null);
			tamanho = 1;
		} else if(tamanho == 1) {
			pedido.setProximo(novoPedido);
			pedido.setUltimo(novoPedido);
			tamanho++;
			sortByPriority();
		} else{
			pedido.getUltimo().setProximo(novoPedido);
			pedido.setUltimo(novoPedido);
			tamanho++;
			sortByPriority();
		}
	}

	/**
	 * Algoritmo de ordenação tipo bolha, ordena os pedidos por prioridade
	 */
	public static void sortByPriority() {
		Pedido pedidoAux = pedido;
		for (int i = 1; i <= tamanho - 1; i++)
			for (int j = 0; j < tamanho - 1; j++){
				if (pedidoAux.getPrioridade() > pedidoAux.getProximo().getPrioridade()) {
					Pedido aux = pedidoAux;
					pedidoAux = pedidoAux.getProximo();
					pedidoAux.setProximo(aux);
				}else{
					pedidoAux = pedidoAux.getProximo();
				}
			}
	}

	/**
	 * Realiza o cancelamento de um pedido qualquer, poossui comportamento de
	 * algoritmo para remover um elemento em qualquer posição na lista encadeada
	 * 
	 * @param numeroPedido
	 */
	public static void cancelaPedido(int numeroPedido) {
		if (tamanho == 0) {
			JOptionPane.showMessageDialog(null, "Lista de pedidos vazia!!!");
		} else {
			if (tamanho == 1) {
				pedido.setPrimeiro(null);
				pedido.setUltimo(null);
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
	public static Pedido buscaPedido(int numeroPedido) {
		Pedido pedidoAux = pedido.getPrimeiro();
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
				pedido.setPrimeiro(null);
				pedido.setUltimo(null);
				tamanho = 0;
				JOptionPane.showMessageDialog(null, "Pedido atendido");
			} else {
				pedido.setPrimeiro(pedido.getPrimeiro().getProximo());
				tamanho--;
				JOptionPane.showMessageDialog(null, "Pedido atendido");
			}
		}
	}

	/**
	 * updateRequest, método que atualiza o pedido
	 */
	public static void updateRequest(int numeroPedido, int codePizza) {
		buscaPedido(numeroPedido).setPizza(codePizza);
	}
	
	public static String imprimeLista() {

		  // Verificando se a Lista está vazia
		  if(tamanho == 0){
		    return "";
		  }
		  
		  StringBuilder builder = new StringBuilder("");
		  Pedido atual = pedido.getPrimeiro();

		  // Percorrendo até o penúltimo elemento.
		  for (int i = 0; i < tamanho - 1; i++) {
		    builder.append(atual.getNumeroPedido() + "-" +atual.getPrioridade());
		    builder.append(" | ");
		    atual = atual.getProximo();
		  }

		  // último elemento
		  builder.append(atual.getNumeroPedido() + "-" +atual.getPrioridade());
		  builder.append("");
		  
		  return builder.toString();
		} 
}
