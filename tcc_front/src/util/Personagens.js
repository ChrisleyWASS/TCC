
export default {

    personagemFilter(usuario, nome,linhagem,alternativo,idEspecie,idRaca,idEtnia,idQualidade,idDefeito,trn1, trn2, trn3,conhecimentos){
        
        const objPersonagem = {
            usuario: '',
            nome: '',
            nome_linhagem: '',
            nome_alternativo: '',
            id_especie: 0,
            id_raca: 0,
            id_etnia: 0,
            id_qualidade: 0,
            id_defeito: 0,
            treinamentos: [],
            conhecimentos: []
        }

        let treinamentos = [];
            treinamentos.push(trn1);
            treinamentos.push(trn2);
            treinamentos.push(trn3);
        
        objPersonagem.usuario = usuario
        objPersonagem.nome = nome
        objPersonagem.nome_linhagem = linhagem
        objPersonagem.nome_alternativo = alternativo
        objPersonagem.id_especie = idEspecie
        objPersonagem.id_raca = idRaca
        objPersonagem.id_etnia = idEtnia
        objPersonagem.id_qualidade = idQualidade
        objPersonagem.id_defeito = idDefeito
        objPersonagem.treinamentos = treinamentos
        objPersonagem.conhecimentos = conhecimentos

        return objPersonagem;

    }
}
