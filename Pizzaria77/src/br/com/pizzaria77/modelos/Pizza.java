package br.com.pizzaria77.modelos;

import javax.swing.JOptionPane;

public class Pizza 
{
	int numberGuest;
	int code;
	int priority;
	Node node, start, end;
	Lista lista;
	
	public Pizza()
	{
		
	}
	
	public void newGuest(int cod, int prio)
	{
		//no.setNode(int cod, int prio);
		numberGuest++;
		code = cod;
		priority = prio;
		
	}
	
	public String updateGuest() throws Exception
	{
		return null;
		
	}
	
	public void cancelGuest(int guest)
	{
		if(lista.size == 0)
		{
			throw new RuntimeException();
		}
		else
		{
			if(lista.size == 1)
			{
				int aux = start.node;
				if(aux == guest)
				{
					node = null;
					start = null;
					end = null;
					lista.size = 0;
					JOptionPane.showMessageDialog(null, "O pedido "+aux+", foi encontrado e cancelado!");
				}
			}
			else
			{
				Node ref = start;
				while(ref.next != null)
				{
					if(ref.node == guest)
					{
						//ref.node.last;
						//ref.node = null;
						ref.next = end.next.next;
						lista.size--;
					}
				}
			}
		}
	}
	
	public String sortByPriority() throws Exception
	{
		return null;
	}
	
	public String sortByNumberGuest() throws Exception
	{
		return null;
	}
	
	
}
