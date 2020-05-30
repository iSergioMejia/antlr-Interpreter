package co.edu.javeriana.ast;

import co.edu.javeriana.car.Car;
import co.edu.javeriana.context.Context;

public class MoveBk implements ASTNode {

	private ASTNode param;
	private Car car;
	
	public MoveBk(ASTNode param, Car car) {
		super();
		this.param = param;
		this.car = car;
	}


	@Override
	public Object execute(Context context)
	{
		Object op1 = param.execute(context);
		if(op1 instanceof String || op1 instanceof Boolean)
		{
			System.err.println("Error, move_bk operand only admits numerical values");
			System.exit(1);
		}
		car.backwards((float)op1);
		return null;
	}

}