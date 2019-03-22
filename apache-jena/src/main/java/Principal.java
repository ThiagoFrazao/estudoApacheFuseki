import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import entidades.Pessoa;
import jena.Ontologia;

public class Principal {
	
	public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException {
		
		Pessoa pessoa = new Pessoa("2", "Pessoa teste 2","imagem","sexo","olhos","corPele","corCabelo","tipoFisico","transtornoMental","nascimento","status","informacoes","pesoAproximado","alturaAproximada","marcaCaracteristica","fonte","boletimOcorrencia");

		OntModel ontModel = Ontologia.ontModel;
		Individual individual = ontModel.listIndividuals().toList().get(0);
		ontModel.createIndividual("http://ontologiarelembrar.github.io/ontologiarelembrar#PessoaTeste2", ontModel.getOntClass("http://ontologiarelembrar.github.io/ontologiarelembrar#Pessoa"));
		FileOutputStream fileOut = new FileOutputStream(new File(Ontologia.PATH));
		RDFDataMgr.write(fileOut, ontModel, Lang.RDFXML);
		
		System.out.println(pessoa.rdfForm("PessoaTeste2"));
		
		
	}

}
