package jena;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.jena.query.DatasetAccessor;
import org.apache.jena.query.DatasetAccessorFactory;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.apache.jena.vocabulary.VCARD;

public class Modelos {
	
	private static final String URI = "http://localhost:3030/estudando";
	
	public static void uploadRDF(File rdf, String serviceURI) throws IOException {

		// parse the file
		Model m = ModelFactory.createDefaultModel();
		try (FileInputStream in = new FileInputStream(rdf)) {
			m.read(in, null, "RDF/XML");
		}

		// upload the resulting model
		DatasetAccessor accessor = DatasetAccessorFactory.createHTTP(serviceURI);
		accessor.putModel(m);
	}
	
	public static void execSelectAndPrint(String query) {
		QueryExecution q = QueryExecutionFactory.sparqlService(URI,query);
		ResultSet results = q.execSelect();

		ResultSetFormatter.out(System.out, results);

		while (results.hasNext()) {
			QuerySolution soln = results.nextSolution();
			RDFNode x = soln.get("x");
			System.out.println(x);
		}
	}
	
	public static void inserirBanco(String nome){
		String queryUpdate;
		queryUpdate = "PREFIX VCARD: <http://www.w3.org/2001/vcard-rdf/3.0#> INSERT DATA "
				+ "{ <http://testando/ThiagoFrazao>  VCARD:FN\""+ nome + "\" }";
		
		UpdateRequest up = UpdateFactory.create(queryUpdate);
		UpdateProcessor  upQ = UpdateExecutionFactory.createRemote(up,URI);
		upQ.execute();
	}
	
	public static void main(String[] args) {		
		
		String query;
		String queryUpdate;
		
		// QUERY PARA BUSCA
		
		//SELECIONAR URI
		//query = "SELECT ?x WHERE { ?x  <http://www.w3.org/2001/vcard-rdf/3.0#FN>  \"Thiago Frazao\" }";
		
		//SELECIONAR ONTOLOGIA
		//query = "SELECT ?x WHERE { <http://testando/ThiagoFrazao>  ?x  \"Thiago Frazao\" }";
		
		//SELECIONAR NOME
		query = "SELECT ?x WHERE { <http://testando/ThiagoFrazao>  <http://www.w3.org/2001/vcard-rdf/3.0#FN>  ?x }";
		
		// QUERY PARA INSERCAO
		/*queryUpdate = "PREFIX VCARD: <http://www.w3.org/2001/vcard-rdf/3.0#> INSERT DATA "
				+ "{ <http://testando/ThiagoFrazao>  VCARD:FN\"Thiago Frazao\" }";*/
		
		String nome = "Thiago Frazão de Sousa";
		
		inserirBanco(nome);
		execSelectAndPrint(query);
	
		
	    
	}

}
