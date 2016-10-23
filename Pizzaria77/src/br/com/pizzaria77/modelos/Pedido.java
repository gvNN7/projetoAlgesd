package br.com.pizzaria77.modelos;

public class Pedido {

	private Pedido proximo, primeiro, ultimo, anterior;
	private int prioridade;
	private int numeroPedido;
	private Pizza pizza;

	public Pedido(int numeroPedido, int prioridade, int codPizza) {
		this.numeroPedido = numeroPedido;
		this.prioridade = prioridade;
		pizza = new Pizza(codPizza);
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

	public void setPrimeiro(Pedido primeiro) {
		this.primeiro = primeiro;
	}

	public Pedido getPrimeiro() {
		return primeiro;
	}

	public void setUltimo(Pedido ultimo) {
		this.ultimo = ultimo;
	}

	public Pedido getUltimo() {
		return ultimo;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getPrioridade() {
		return prioridade;
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
