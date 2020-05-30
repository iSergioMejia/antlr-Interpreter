package co.edu.javeriana.ast;

import co.edu.javeriana.context.*;

public class VarRef implements ASTNode
{
	private String name;
	
	public VarRef(String name) {
		super();
		this.name = name;
	}

	@Override
	public Object execute(Context context) {
		Object val = context.getValue(name);
		if(val == null)
		{
			System.err.println("Error, var \""+name+"\" not found in this scope");
			System.exit(1);
			return null;
		}
		else return val;
	}

}
