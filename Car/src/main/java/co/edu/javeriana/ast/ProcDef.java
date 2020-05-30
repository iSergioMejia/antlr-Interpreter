package co.edu.javeriana.ast;

import java.util.ArrayList;

import co.edu.javeriana.context.Context;

public class ProcDef implements ASTNode
{
	private String name;
	private ArrayList<String> params;
	private ArrayList<ASTNode> sentences;
	private Context actualContext;
	
	public ProcDef(String name, ArrayList<String> params, ArrayList<ASTNode> sentences) {
		super();
		this.name = name;
		this.params = params;
		this.sentences = sentences;
		this.actualContext = new Context(null);
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<String> getParams() {
		return params;
	}

	public ArrayList<ASTNode> getSentences() {
		return sentences;
	}

	@Override
	public Object execute(Context context)
	{
		actualContext = new Context(context.getSymbolTable(), context.getAnterior());
		context.add(name, this);
		actualContext.add(name, this);
		return null;
	}
	
	public Object executeProc(Context context)
	{
		context.setAnterior(actualContext);
		for(ASTNode s : sentences)
		{
			Object ret = s.execute(context);
			if(ret != null && ret instanceof Return)
			{
				return ret;
			}
		}
		return null;
	}

}
