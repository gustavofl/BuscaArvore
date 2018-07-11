package model.exceptions;

public class NodeJaExisteException extends Exception {

	private static final long serialVersionUID = 5061190545411830518L;
	
	public NodeJaExisteException(String nome) {
		super(nome);
	}
	
	@Override
	public String getMessage() {
		return "Ja existe um no com o nome "+super.getMessage()+".";
	}

}
