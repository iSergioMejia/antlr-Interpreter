package co.edu.javeriana.ast;
import co.edu.javeriana.context.Context;
public class Echo implements ASTNode {

	private ASTNode param;
	
	
	public Echo(ASTNode param) {
		super();
		this.param = param;
	}


	@Override
	public Object execute(Context context) {
		System.out.println(param.execute(context));
		return null;
	}

}
