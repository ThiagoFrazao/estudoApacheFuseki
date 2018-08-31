package jena;

import java.util.ArrayList;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.util.iterator.ExtendedIterator;

public class Ontologia {
	
	public static void main(String[] args) {
		OntModel ont = ModelFactory.createOntologyModel();
		ont.read("C:/Users/thiag/Documents/Faculdade/TCC/Ontologias/ModeloRDF-XML.owl", "RDF/XML");
		ExtendedIterator<OntProperty> ei = ont.listAllOntProperties();
		ArrayList<Property> props = new ArrayList<Property>();
		
		while(ei.hasNext()){
			Property prop = ont.getProperty(ei.next().toString());
			System.out.println(prop.getURI());
		}
	}

}
