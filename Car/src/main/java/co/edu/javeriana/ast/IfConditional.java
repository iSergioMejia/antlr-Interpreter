package co.edu.javeriana.ast;

import java.util.List;
import co.edu.javeriana.context.Context;

public class IfConditional implements ASTNode {

	private List<ASTNode> ifSentences;
	private List<ASTNode> elseSentences;
	private ASTNode condition;
	

	public IfConditional(ASTNode condition, List<ASTNode> ifSentences, List<ASTNode> elseSentences) {
		super();
		this.ifSentences = ifSentences;
		this.elseSentences = elseSentences;
		this.condition = condition;
	}

	@Override
	public Object execute(Context context)
	{
		Context newContext = new Context(context);
		Object op1 = condition.execute(context);
		if(op1 instanceof String || op1 instanceof Float)
		{
			System.err.println("Error, if conditional only admits boolean values");
			System.exit(1);
		}
		if((boolean)op1)
		{
			for(ASTNode s : ifSentences)
			{
				Object ret = s.execute(newContext);
				if(ret != null && ret instanceof Return)
				{
					return ret;
				}
			}
		}
		else
		{
			for(ASTNode s : elseSentences)
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
