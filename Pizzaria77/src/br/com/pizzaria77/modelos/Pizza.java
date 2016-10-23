package br.com.pizzaria77.modelos;

import javax.swing.JOptionPane;

public class Pizza 
{
	int numberRequest;
	int code;
	int priority;
	Node node, start, end;
	Lista lista;
	
	public Pizza()
	{
		
	}
	
	public void newRequest(int cod, int prio)
	{
		//no.setNode(int cod, int prio);
		numberRequest++;
		code = cod;
		priority = prio;
		
	}
	
	public String updateRequest() throws Exception
	{
		return null;
		
	}
	
	public void cancelRequest(int request)
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
				if(aux == request)
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
					if(ref.node == request)
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
	
	public String sortByNumberRequest() throws Exception
	{
		return null;
	}
	
	
}
