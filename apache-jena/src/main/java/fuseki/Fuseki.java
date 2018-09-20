package fuseki;


import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import entidades.EntidadeRDF;
import entidades.Pessoa;
import jena.Ontologia;

public class Fuseki {
	
	private static final String URI = "http://localhost:3030/estudando";
	
	public static void adicionarEntidade(EntidadeRDF entidade){
		String queryUpdate;
		queryUpdate = "PREFIX remember: "+ Ontologia.uriBaseOnt +"> INSERT DATA "
				+ "{ " + entidade.rdfForm() + " }";
		
		System.out.println(queryUpdate);
		
		UpdateRequest up = UpdateFactory.create(queryUpdate);
		UpdateProcessor  upQ = UpdateExecutionFactory.createRemote(up,URI);
		upQ.execute();		
	}	
	
	public static void recuperarEntidade(){
		String query = "SELECT ?subject ?predicate ?object WHERE {   ?subject ?predicate ?object }";
		
		QueryExecution q = QueryExecutionFactory.sparqlService(URI,query);
		ResultSet results = q.execSelect();

		ResultSetFormatter.out(System.out, results);

		while (results.hasNext()) {
			QuerySolution soln = results.nextSolution();
			RDFNode x = soln.get("x");
			System.out.println(x);
}
	}
	
	public static void main(String[] args) {
		/*Pessoa pessoa = new Pessoa(0, "Jose da Silva","imagem","sexo","olhos","corPele","corCabelo","tipoFisico","transtornoMental","nascimento","status","informacoes","pesoAproximado","alturaAproximada","marcaCaracteristica","fonte","boletimOcorrencia");
		Fuseki.adicionarEntidade(pessoa);*/
		
		Fuseki.recuperarEntidade();
	}

}
