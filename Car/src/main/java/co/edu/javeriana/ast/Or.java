package co.edu.javeriana.ast;
import co.edu.javeriana.context.Context;

public class Or implements ASTNode {

	private ASTNode param1;
	private ASTNode param2;
	
	
	
	public Or(ASTNode param1, ASTNode param2) {
		super();
		this.param1 = param1;
		this.param2 = param2;
	}


	@Override
	public Object execute(Context context)
	{
		Object op1 = param1.execute(context);
		Object op2 = param2.execute(context);
		if(op1 instanceof String || op1 instanceof Float
				|| op2 instanceof String || op2 instanceof Float)
		{
			System.err.println("Error, or operand only admits boolean values");
			System.exit(1);
		}
		return (boolean)op1 || (boolean)op2;
	}

}
