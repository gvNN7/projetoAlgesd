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
}
