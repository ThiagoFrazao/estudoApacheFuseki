from owlready2 import *

# carregando ontologia
onto = get_ontology("ontologiarelembrar.owl").load()

# criando instancia de pessoa
p1 = onto.Pessoa("p1")
p1.nome.append("Mayara")
p1.dataNascimento.append("20/07/1992")
p1.tipoFisico.append("Magro")
p1.sexo.append("Feminino")
p1.alturaAproximada.append(1.80)
p1.pesoAproximado.append(58.0)
p1.corCabelo.append("Castanho escuro")
p1.corOlhos.append("Castanho escuro")
p1.corPele.append("Negra")
p1.transtornoMental.append("Paranoia profunda")
p1.imagem.append("ola")
p1.marcaCaracteristica.append("Pinta na coxa")


# criando instancia de local
l1 = onto.Local("l1")
l1.latitude.append(100)
l1.longitude.append(100)

# criando instancia de Desaparecimento
d1 = onto.Desaparecimento("d1")
d1.fonte.append("pessoasdesaparecidadas.com.br")
d1.ultimaHoraVista.append("18:42")
d1.dataDesaparecimento.append("03/09/2019")
d1.informacoes.append("Foi vista pela ultima vez na UFRRJ")

# criando instancia de Bairro
b1 = onto.Bairro("b1")
b1.nomeBairro.append("Ouro Verde")

# criando instancia de Cidade
c1 = onto.Cidade("c1")
c1.nomeCidade.append("Nova Iguacu")

# criando instancia de UF
uf = onto.UF("uf1")
uf.sigla.append("RJ")

# criando relacoes
d1.estaAssociado = [p1]
d1.possui = [l1]

# arquivo de saida
onto.save(file = "instancias.owl", format = "rdfxml")