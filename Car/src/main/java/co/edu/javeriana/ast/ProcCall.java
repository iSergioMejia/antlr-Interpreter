package co.edu.javeriana.ast;

import java.util.ArrayList;

import co.edu.javeriana.context.Context;

public class ProcCall implements ASTNode
{
	private String nombre;
	private ArrayList<ASTNode> params;
	
	public ProcCall(String nombre, ArrayList<ASTNode> params) {
		super();
		this.nombre = nombre;
		this.params = params;
	}

	@Override
	public Object execute(Context context)
	{
		Context newContext = new Context(null);
		//context.print();
		ProcDef proc = (ProcDef)context.getValue(nombre);
		if(proc == null)
		{			
			System.err.println("Error in proc "+this.nombre+" call. Function doesn't exist");
			System.exit(-1);
		}
		if(params.size() != proc.getParams().size())
		{
			System.err.println("Error in proc "+this.nombre+" call. Number of parameters mismatch");
			System.exit(-1);
		}
		for(int i = 0; i < params.size(); i++)
		{
			newContext.add(proc.getParams().get(i), this.params.get(i).execute(context));
		}
		Object ret = proc.executeProc(newContext);
		if(ret != null && ret instanceof Return)
		{
			Return retorno = (Return)ret;
			Object valor = retorno.getValue();
			if(valor == null) return null;
			else if(valor instanceof Float) return (float)valor;
			else if(valor instanceof Boolean) return (boolean)valor;
			else if(valor instanceof String) return (String)valor;
			else return valor;
		}
		return null;
	}

}
