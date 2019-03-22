package entidades;

import java.util.List;

import org.apache.jena.query.QuerySolution;

public abstract class EntidadeRDF {	
	public abstract String namedIndividualForm(String nomeIndividuo) throws IllegalArgumentException, IllegalAccessException;
	public abstract EntidadeRDF fromQueryList(List<QuerySolution> qsList);
	public abstract String rdfForm(String rdfName) throws IllegalArgumentException, IllegalAccessException;
}