package model.exceptions;

public class VerticeFinalNotFoundException extends Exception {

	private static final long serialVersionUID = -5141868199360118006L;
	
	@Override
	public String getMessage() {
		return "Vertice final nao configurado.";
	}

}
