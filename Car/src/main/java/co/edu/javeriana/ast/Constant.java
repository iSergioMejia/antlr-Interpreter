package co.edu.javeriana.ast;
import co.edu.javeriana.context.Context;

public class Constant implements ASTNode {
	
	private Object value;
	
	public Constant(Object value)
	{
		super();
		this.value = value;
	}

	@Override
	public Object execute(Context context) {
		return value;
	}

}
