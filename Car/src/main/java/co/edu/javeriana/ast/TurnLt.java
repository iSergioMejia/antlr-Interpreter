package co.edu.javeriana.ast;

import co.edu.javeriana.car.Car;
import co.edu.javeriana.context.Context;

public class TurnLt implements ASTNode {

	private ASTNode param;
	private Car car;
	
	public TurnLt(ASTNode param, Car car) {
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
			System.err.println("Error, turn_lt operand only admits numerical values");
			System.exit(1);
		}
		car.left((float)op1);
		return null;
	}

}
