import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import entidades.Pessoa;
import jena.Ontologia;

public class Principal {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException {
		
		/*Pessoa pessoa = new Pessoa("2", "Pessoa teste 2","imagem","sexo","olhos","corPele","corCabelo",
									"tipoFisico","transtornoMental","nascimento","informacoes","pesoAproximado",
									"alturaAproximada","marcaCaracteristica","fonte","boletimOcorrencia");

		FileOutputStream fileOut = new FileOutputStream(new File("C:/Users/thiag/Documents/Faculdade/TCC/Ontologias/text.owl"));
		OutputStreamWriter output = new OutputStreamWriter(fileOut, "UTF-8");
		output.write(pessoa.namedIndividualForm("PessoaTeste1"));
		
		OntModel model = Ontologia.getOntModel();
		
		RDFDataMgr.write(output, model, Lang.RDFXML);
		
		output.close();*/
		
		
		
	}

}
