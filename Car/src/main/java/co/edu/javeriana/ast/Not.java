package co.edu.javeriana.ast;
import co.edu.javeriana.context.Context;

public class Not implements ASTNode {

	private ASTNode param1;
	
	
	
	public Not(ASTNode param1) {
		super();
		this.param1 = param1;
	}


	@Override
	public Object execute(Context context) {
		Object op1 = param1.execute(context);
		if(op1 instanceof String || op1 instanceof Float)
		{
			System.err.println("Error, not operand only admits boolean values");
			System.exit(1);
		}
		
		return !((boolean)op1);
	}

}
