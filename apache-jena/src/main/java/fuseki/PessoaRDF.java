package fuseki;

import entidades.Pessoa;

public class PessoaRDF {
	
	public String prefixosPessoa(){
		StringBuilder str = new StringBuilder();
		
		str.append("PREFIX REMEMBER: <http://www.projeto-myosotis.com.br/pessoasdesaparecidas/ontologiaremember> \n");
		str.append("");
		
		return str.toString();
	}
	
	public String traduzirPessoa(Pessoa pessoa){
		
		StringBuilder str = new StringBuilder();
		
		str.append("");
		
		
		return str.toString();
		
		
	}

}
