package erros;

public class RdfQueryException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5940809209673447385L;

	public RdfQueryException(){
		super("O URI informado nao existe.");
	}
}
