package co.edu.javeriana.ast;
import co.edu.javeriana.context.Context;

public class DefVar implements ASTNode {

	private String name;
	private ASTNode value;
	public DefVar(String name, ASTNode value) {
		super();
		this.value = value;
		this.name = name;
	}

	@Override
	public Object execute(Context context) {
		Object val = context.getValue(name);
		if(val != null)
		{
			System.err.println("Error, var \""+name+"\" already declared in this scope");
			System.exit(1);
		}
		if(value != null)
		{
			Object valor = value.execute(context);
			if(valor == null)
			{
				System.err.println("Error, cannot save null value in variable");
				System.exit(1);
			}
			else context.add(name,  valor);
			}
		else
			context.add(name, new Object());
		return null;
	}

}
