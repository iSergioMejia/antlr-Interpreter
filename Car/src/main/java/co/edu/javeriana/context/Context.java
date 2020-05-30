package co.edu.javeriana.context;

import java.util.HashMap;

public class Context
{
	private HashMap<String,Object> symbolTable;
	protected Context anterior = null;
	
	public Context(Context ant)
	{
		symbolTable = new HashMap<>();
		anterior = ant;
	}
	
	public Context(HashMap<String, Object> symbolTable, Context anterior) {
		this.symbolTable = new HashMap<>(symbolTable);
		this.anterior = anterior;
	}



	public Object getValue(String id)
	{
		for(Context e = this; e!=null; e = e.anterior)
		{
			Object val = e.symbolTable.get(id);
			if(val != null)
			{
				return val;
			}
		}
		return null;
	}
	
	public void add(String id, Object val)
	{
		this.symbolTable.put(id,val);
	}
	
	public void change(String id, Object val)
	{
		for(Context e = this; e!=null; e = e.anterior)
		{
			if(e.symbolTable.containsKey(id))
			{
				e.symbolTable.put(id,val);
				break;
			}
		}
	}
	
	public void print()
	{
		System.out.println(this.symbolTable.toString());
	}

	public HashMap<String, Object> getSymbolTable() {
		return symbolTable;
	}

	public Context getAnterior() {
		return anterior;
	}

	public void setAnterior(Context anterior)
	{
		this.anterior = anterior;		
	}
	
	
}
