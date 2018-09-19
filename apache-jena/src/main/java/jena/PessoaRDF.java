package jena;

import org.apache.jena.rdf.model.Resource;

import entidades.Pessoa;

public class PessoaRDF {
	
	
	public void adicionarPessoa(Pessoa pessoa){
		
		Resource novaPessoa = Ontologia.modelOnt.createResource()
							  .addProperty(Ontologia.getPropPessoa("nome"), pessoa.getNome())
							  .addProperty(Ontologia.getPropPessoa("imagem"), pessoa.getImagemBase64())
							  .addProperty(Ontologia.getPropPessoa("sexo"), pessoa.getSexo())
							  .addProperty(Ontologia.getPropPessoa("corCabelo"), pessoa.getCorCabelo())
							  .addProperty(Ontologia.getPropPessoa("corPele"), pessoa.getCorPele())
							  .addProperty(Ontologia.getPropPessoa("corOlhos"), pessoa.getOlhos())
							  .addProperty(Ontologia.getPropPessoa("tipoFisico"), pessoa.getTipoFisico())
							  .addProperty(Ontologia.getPropPessoa("alturaAproximada"), pessoa.getAlturaAproximada())
							  .addProperty(Ontologia.getPropPessoa("pesoAproximado"), pessoa.getPesoAproximado())
							  .addProperty(Ontologia.getPropPessoa("status"), pessoa.getStatus())
							  .addProperty(Ontologia.getPropPessoa("transtornoMental"), pessoa.getTranstornoMental())
							  .addProperty(Ontologia.getPropPessoa("dataNascimento"), pessoa.getNascimento())
							  .addProperty(Ontologia.getPropPessoa("informacoes"), pessoa.getInformacoes())
							  ;
		
		Ontologia.modelOnt.write(System.out);
		
	}
	
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa("Jose","batata","batata","batata","batata","batata","batata","batata","batata","batata","batata","batata","batata");
		PessoaRDF teste = new PessoaRDF();
		
		teste.adicionarPessoa(pessoa);
	}
	

}
