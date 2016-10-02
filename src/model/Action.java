package model;

public class Action {
	
	public interface ActionDelegate {
		public void actionPerformed(World world, String parameters) throws Exception;
	}
	
	private ActionDelegate delegate;
	
	public ActionDelegate getDelegate() {
		return delegate;
	}

	public Action(ActionDelegate delegate){
		this.delegate = delegate;
	}

}
