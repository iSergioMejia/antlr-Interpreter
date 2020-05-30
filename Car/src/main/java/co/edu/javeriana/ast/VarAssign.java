package co.edu.javeriana.ast;
import co.edu.javeriana.context.Context;

public class VarAssign implements ASTNode {

	private String name;
	private ASTNode expression;
	
	public VarAssign(String name, ASTNode expression) {
		super();
		this.name = name;
		this.expression = expression;
	}

	@Override
	public Object execute(Context context) {
		context.change(name, expression.execute(context));
		return null;
	}

}
