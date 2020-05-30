package co.edu.javeriana.ast;
import co.edu.javeriana.context.Context;

public class NotEqualTo implements ASTNode {

	private ASTNode param1;
	private ASTNode param2;
	
	
	
	public NotEqualTo(ASTNode param1, ASTNode param2) {
		super();
		this.param1 = param1;
		this.param2 = param2;
	}


	@Override
	public Object execute(Context context) {
		return !param1.execute(context).equals(param2.execute(context));
	}

}
