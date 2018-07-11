package model.exceptions;

public class NodeNotFoundException extends Exception {

	private static final long serialVersionUID = 5782013308966265654L;

	public NodeNotFoundException(String message) {
		super(message);
	}
	
	public NodeNotFoundException() {
		this("");
	}
	
	@Override
	public String getMessage() {
		if(super.getMessage().equals("")) {
			return "No nao encontrado.";
		} else {
			return "No com o nome '"+super.getMessage()+"' nao encontrado.";
		}
	}

}
