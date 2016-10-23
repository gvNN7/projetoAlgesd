package br.com.pizzaria77.modelos;

import javax.swing.JOptionPane;

public class Lista
{
	int size;
	Node node, start, end;
	
	public void insert(int element)
	{
		Node novo = start;
		novo.node = element;
		novo.next = null;
		start = novo;
		end = novo;
		size++;
	}
	
	public void insertEnd(int element)
	{
		if(size == 0)
		{
			Node novo = start;
			novo.node = element;
			novo.next = null;
			start = novo;
			end = novo;
			size = 1;
		}
		else
		{
			Node novo = start;
			novo.node = element;
			novo.next = null;
			end.next = novo;
			end = novo;
			size ++;
		}
	}
	
	public void removeStart()
	{
		if(size == 0) 
		{
			throw new RuntimeException();
		}
		else 
		{
			if(size == 1) //elemento no inicio
			{
				int aux = start.element;
				start = null;
				end = null;
				size = 0;
				JOptionPane.showMessageDialog(null, "O elemento "+aux+", foi removido do inicio!");
			}
			else 
			{
				int aux = start.element;
				start = start.next;
				size --;
				JOptionPane.showMessageDialog(null, "O elemento "+aux+", foi removido do inicio!");
			}
				if(size > 2)
				{
					int aux = end.element;
					Node ref = start;
					while(ref.next != end)
					{
						ref = ref.next;
					}
					ref.next = null;
					end = ref;
					size --;
					JOptionPane.showMessageDialog(null, "O elemento "+aux+", foi removido do inicio!");
				}
		}
	}
	
	public void removeEnd()
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
				aux = end.node;
				start = null;
				end = null;
				size = 0;
				JOptionPane.showMessageDialog(null, "O ultimo elemento: "+aux+", foi removido");
			}
			else
			{
				aux = end.node;
				end.next = null;
				size--;
				JOptionPane.showMessageDialog(null, "O ultimo elemento "+aux+", foi removido!");
			}
		}
	}

//	public void bubbleSort(Node pizza, int size) {
//		for (int i = 1; i <= size - 1; i++) {
//			for (int j = 0; j < size - 1; j++) {
//				if (pizza.priority > pizza.next.priority) {
//					Node aux = pizza;
//					pizza = pizza.next;
//					pizza.next = aux;
//				}
//			}
//		}
//	}

	/**
	 * Falha, se forem incluidas 3 pizzas seguidas de mesmo codigo a posicao
	 * retornada sera a da primeira pizza de mesmo codigo...
	 */
	public int buscaLinear(Node pizza, int codPizza) {
		for (int i = 0; i < size; i++) {
			if (pizza.element == codPizza)
				return i;
		}
		return -1;
	}
}
