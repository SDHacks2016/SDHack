package logic;

public class Statement{
	
	public enum StatementType { ASSIGNMENT, METHOD }
	
	public String property = null;
	public String name = null;
	public String value = null;
	public StatementType type = null;

	public Statement(){
		
	}
	
	public String toString(){
		return ("property: " + property + "; name: " + name + "; value: " + value + "; type: " + type);
		
	}


}