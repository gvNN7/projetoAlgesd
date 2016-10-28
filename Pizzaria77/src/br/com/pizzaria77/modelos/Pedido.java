package br.com.pizzaria77.modelos;

public class Pedido {

	private Pedido anterior, proximo;
	private int prioridade;
	private int numeroPedido;
	private Pizza pizza;

	public Pedido(int numeroPedido, int prioridade, int codPizza) {
		this.numeroPedido = numeroPedido;
		this.prioridade = prioridade;
		this.proximo  = null;
		pizza = new Pizza(codPizza);
	}

	public Pedido() {
	}

	public void setAnterior(Pedido anterior) {
		this.anterior = anterior;
	}

	public Pedido getAnterior() {
		return anterior;
	}
	
	public void setProximo(Pedido proxima) {
		this.proximo = proxima;
	}

	public Pedido getProximo() {
		return proximo;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getPrioridade() {
		return prioridade;
	}
	
	
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setPizza(int pizzaCode) {
		pizza.setCode(pizzaCode);
	}

	public int getPizza() {
		return pizza.getCode();
	}
}
