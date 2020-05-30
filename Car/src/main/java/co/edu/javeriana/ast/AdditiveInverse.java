package co.edu.javeriana.ast;

import co.edu.javeriana.context.Context;

public class AdditiveInverse implements ASTNode {

	private ASTNode param1;
	
	public AdditiveInverse(ASTNode param1) {
		super();
		this.param1 = param1;
	}

	@Override
	public Object execute(Context context) {
		Object op1 = param1.execute(context);
		if(op1 instanceof String || op1 instanceof Boolean)
		{
			System.err.println("Error, - operand only admits numerical values");
			System.exit(1);
		}
		return -1*((float)op1);
	}

}
