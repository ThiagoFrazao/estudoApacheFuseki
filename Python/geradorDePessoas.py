# -*- coding: utf-8 -*-
"""
Created on Sun Apr  7 12:02:07 2019

@author: thiag
"""
from random import randint
from random import uniform
class GeradorDePessoas:
    sexo = ["masculino","feminino"]
    corDePele   = ["amarelo","pardo","negro","branco"]
    corDeCabelo = ["ruivo","preto","loiro","azul"]
    corDosOlhos = ["pretos","castanhos","azul","verde","ambar"]
    marcas = ["mancha na coxa esquerda","mancha na coxa direita",
                             "mancha na panturrilha esquerda","mancha na panturrilha direita",
                             "tatuagem na coxa esquerda","nenhuma","tatuagem na coxa direita",
                             "tatuagem na panturrilha esquerda","tatuagem na panturrilha direita",
                             "mancha no braço esquerdo","nenhuma","mancha no braço direito", 
                             "mancha no antebraço esquerdo","nenhuma","mancha no antebraço direito",
                             "tatuagem no braço esquerdo","nenhuma","tatuagem no braço direito", 
                             "tatuagem no antebraço esquerdo","nenhuma","tatuagem no antebraço direito",
                             "cicatriz na bochecha esquerda","cicatriz na bochecha direita"]
    
    transtorno = ["ansiedade","nenhum","esquizofrenia","transtorno bipolar","nenhum",
                        "transtorno obsessivo-compulsivo","nenhum","anorexia",
                        "bulimia","depressão","nenhum","alzheimer","autismo","nenhum",
                        "amnésia dissociativa","transtorno dissociativo de identidade","nenhum"
                        "nenhum","nenhum","nenhum"]
        
    def gerarDatas(self):
        dia = str(randint(1,28))
        mes = str(randint(1,12))
        anoNascimento = str(randint(1960,2018))       
        dataNascimento = anoNascimento+"-"+mes+"-"+dia
        
        dia = str(randint(1,28))
        mes = str(randint(1,12))
        anoDesaparecimento = str(randint(int(anoNascimento),2019))
        dataDesaparecimento = anoDesaparecimento+"-"+mes+"-"+dia
        
        datas = {"dataNascimento" :dataNascimento, "dataDesaparecimento" : dataDesaparecimento}
        return datas
    
    def gerarTipoFisico(self,peso,altura):
        imc = peso / (altura ** 2)
        if imc <= 18.5:
            return "muito magro"
        elif imc > 18.5 and imc <= 24.9:
            return "normal"
        elif imc > 24.9 and imc <= 29.9:
            return "gordo"
        elif imc > 29.9 and imc <= 34.9:
            return "muito gordo"
        elif imc > 34.9 and imc <= 39.9:
            return "obeso"
        else:
            return "obesidade morbida"
            
    def gerarInfoPessoa(self):
        infoPessoa = {}
        datas = self.gerarDatas()
        infoPessoa.update({"sexo" : self.sexo[randint(0,1)]})
       
        infoPessoa.update({"dataNascimento" : datas["dataNascimento"]})
        infoPessoa.update({"dataDesaparecimento" : datas["dataDesaparecimento"]})
        infoPessoa.update({"corPele" : self.corDePele[randint(0,len(self.corDePele)-1)]})             
        infoPessoa.update({"corOlhos" : self.corDosOlhos[randint(0,len(self.corDosOlhos)-1)]})
        infoPessoa.update({"corCabelo" : self.corDeCabelo[randint(0,len(self.corDeCabelo)-1)]})             
        infoPessoa.update({"marcaCaracteristica" : self.marcas[randint(0,len(self.marcas)-1)]})
        infoPessoa.update({"transtornoMental" : self.transtorno[randint(0,len(self.transtorno)-1)]})
        
        pesoAproximado = float("{0:.2f}".format(uniform(45,200)))
        alturaAproximada = float("{0:.2f}".format(uniform(1.5,2.1)))
        tipoFisico = self.gerarTipoFisico(pesoAproximado,alturaAproximada)        
        infoPessoa.update({"pesoAproximado" : pesoAproximado })        
        infoPessoa.update({"alturaAproximada" : alturaAproximada })
        infoPessoa.update({"tipoFisico" : tipoFisico})   
        return infoPessoa
        
