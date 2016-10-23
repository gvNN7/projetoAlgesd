package br.com.pizzaria77.modelos;

import javax.swing.JOptionPane;

public class Lista
{
	int size;
	Pizza pizza;
		
	public Lista()
	{
		pizza = new Pizza();
	}
	
	public void newRequest(Pizza p)
	{
		if(size == 0)
		{
			Pizza novo = pizza.first;
			novo.code = p;
			novo.next = null;
			pizza.first = novo;
			pizza.last = novo;
			size = 1;
		}
		else
		{
			Pizza novo = pizza.first;
			novo.code = p;
			novo.next = null;
			pizza.last.next = novo;
			pizza.last = novo;
			size ++;
		}
	}
	
	public void cancelRequest(int guestNumber)
	{
		int aux = 0;
		if(size == 0)
		{
			throw new RuntimeException();
		}
		else
		{
			if(size == 1)
			{
				aux = pizza.last.code;
				pizza.first = null;
				pizza.last = null;
				size = 0;
				JOptionPane.showMessageDialog(null, "O elemento procurado: "+aux+", foi removido");
			}
			else
			{
				aux = pizza.last.code;
				pizza.last.next = null;
				size--;
				JOptionPane.showMessageDialog(null, "O elemento procurado: "+aux+", foi removido!");
			}
		}
	}
	
	/**
	 * attend() atende o primeiro cliente da fila
	 * logo, removendo o primeiro da fila
	 */
	public void attend()
	{
		if(size == 0) 
		{
			throw new RuntimeException();
		}
		else 
		{
			if(size == 1) //elemento no inicio
			{
				int aux = pizza.first.code;
				pizza.first = null;
				pizza.last = null;
				size = 0;
				JOptionPane.showMessageDialog(null, "O elemento "+aux+", foi removido do inicio!");
			}
			else 
			{
				int aux = pizza.first.code;
				pizza.first = pizza.first.next;
				size --;
				JOptionPane.showMessageDialog(null, "O elemento "+aux+", foi removido do inicio!");
			}
				if(size > 2)
				{
					int aux = pizza.last.code;
					Pizza ref = pizza.first;
					while(ref.next != pizza.last)
					{
						ref = ref.next;
					}
					ref.next = null;
					pizza.last = ref;
					size --;
					JOptionPane.showMessageDialog(null, "O elemento "+aux+", foi removido do inicio!");
				}
		}
	}
	
	/**
	 * métodos de odenação que recebe como parametro o numero do pedido
	 * @throws Exception
	 */
		
	public String sortByPriority(Pizza pizza) throws Exception
	{
		return null;
	}
	
	public String sortByNumberRequest(int num) throws Exception
	{
		return null;
	}
	
	/**
	 *	updateRequest, método que atualiza o pedido
	 */
	
	public void updateRequest(int num, int codePizza)
	{
		linearSearchRequestToUpdate(num);
	}
	
	
	
	/**
	 * Método de ordenaçao que recebe como parametro pizza e o tamanho
	 * @param pizza
	 * @param size
	 */
	
	public void bubbleSort(Pizza pizza, int size) {
		for (int i = 1; i <= size - 1; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (pizza.pizza.priority > pizza.next.pizza.priority) {
					Pizza aux = pizza;
					pizza = pizza.next;
					pizza.next = aux;
				}
			}
		}
	}

	/**
	 * Falha, se forem incluidas 3 pizzas seguidas de mesmo codigo a posicao
	 * retornada sera a da primeira pizza de mesmo codigo...
	 */
	public Pizza linearSearchRequestToUpdate(int numeroPedido) {
		for (int i = 0; i < size; i++) {
			if (pizza.requestNumber == numeroPedido)
				return pizza;
			pizza = pizza.next;
		}
		return null;
	}
}
