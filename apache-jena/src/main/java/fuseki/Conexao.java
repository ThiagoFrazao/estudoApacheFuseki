package fuseki;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

public class Conexao {
	
	private static final String URI = "http://localhost:3030/estudando";
	
	public static void inserirBanco(String nome){
		String queryUpdate;
		queryUpdate = "PREFIX VCARD: <http://www.w3.org/2001/vcard-rdf/3.0#> INSERT DATA "
				+ "{ <http://testando/ThiagoFrazao>  VCARD:FN\""+ nome + "\" }";
		
		UpdateRequest up = UpdateFactory.create(queryUpdate);
		UpdateProcessor  upQ = UpdateExecutionFactory.createRemote(up,URI);
		upQ.execute();
		
		
	}	

}
