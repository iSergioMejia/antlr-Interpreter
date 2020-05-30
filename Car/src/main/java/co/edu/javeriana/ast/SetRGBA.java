package co.edu.javeriana.ast;

import co.edu.javeriana.car.Car;
import co.edu.javeriana.context.Context;

public class SetRGBA implements ASTNode
{
	private ASTNode color;
	private ASTNode alpha;
	private Car car;
	
	public SetRGBA(ASTNode color, ASTNode alpha, Car car) {
		super();
		this.color = color;
		this.alpha = alpha;
		this.car = car;
	}

	@Override
	public Object execute(Context context)
	{
		String html = (String)color.execute(context);  //#ff2200
														//0123456
		if(!html.startsWith("#"))
		{
			System.err.println("Error. Hex Color bad formatted");
			System.exit(1);
		}
		if(html.length() != 7)
		{
			System.err.println("Error. Hex Color bad formatted");
			System.exit(1);
		}
		Object alp = alpha.execute(context);
		if(alp instanceof Boolean || alp instanceof String)
		{
			System.err.println("Error. set_rgba alpha only admit numerical values");
			System.exit(1);
		}
		float opacity = (float)alp; 
		if(opacity < 0 || opacity > 1)
		{
			System.err.println("Error. alpha channel only admits values between 0.0 and 1.0");
			System.exit(1);
		}
		int R = Integer.parseInt(html.substring(1,3),16);
		int G = Integer.parseInt(html.substring(3,5),16);
		int B = Integer.parseInt(html.substring(5,7),16);
		car.color((float)R,(float)G,(float)B,opacity*255);
		return null;

	}

}
