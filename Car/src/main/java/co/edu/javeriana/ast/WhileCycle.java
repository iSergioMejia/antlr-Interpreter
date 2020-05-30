package co.edu.javeriana.ast;

import java.util.List;
import co.edu.javeriana.context.Context;

public class WhileCycle implements ASTNode
{
	
	ASTNode param;
	List<ASTNode> sentences;
	
	public WhileCycle(ASTNode param, List<ASTNode> sentences) {
		super();
		this.param = param;
		this.sentences = sentences;
	}

	@Override
	public Object execute(Context context)
	{
		Object op = param.execute(context);
		if(op instanceof String || op instanceof Float)
		{
			System.err.println("Error, while cycle only admits boolean values");
			System.exit(1);
		}
		while((boolean)param.execute(context))
		{
			Context newContext = new Context(context);
			for(ASTNode s : sentences)
			{
				Object ret = s.execute(newContext);
				if(ret != null && ret instanceof Return)
				{
					return ret;
				}
			}
		}
		return null;
	}

}
