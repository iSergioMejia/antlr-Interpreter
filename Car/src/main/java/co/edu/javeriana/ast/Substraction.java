package co.edu.javeriana.ast;
import co.edu.javeriana.context.Context;

public class Substraction implements ASTNode {

	private ASTNode param1;
	private ASTNode param2;
	
	
	
	public Substraction(ASTNode param1, ASTNode param2) {
		super();
		this.param1 = param1;
		this.param2 = param2;
	}


	@Override
	public Object execute(Context context)
	{
		Object op1 = param1.execute(context);
		Object op2 = param2.execute(context);
		if(op1 instanceof String || op1 instanceof Boolean
				|| op2 instanceof String || op2 instanceof Boolean)
		{
			System.err.println("Error, - operand only admits numerical values");
			System.exit(1);
		}
		return (float)op1 - (float)op2;
	}

}
