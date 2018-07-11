package model.exceptions;

public class NomeInvalidoException extends Exception{

	private static final long serialVersionUID = -1804986680414061851L;

	public NomeInvalidoException(String message) {
		super(message);
	}
	
	public NomeInvalidoException() {
		this("");
	}
	
	@Override
	public String getMessage() {
		if(super.getMessage().equals("")) {
			return "Nome invalido.";
		} else {
			return "Nome invalido: "+super.getMessage();
		}
	}
	
}
