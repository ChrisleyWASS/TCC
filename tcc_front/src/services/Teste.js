import { http } from "./config";
export default {

	testeCapacidade: (idSala, idPersonagem, tipo) => { 
		return http.get("api/teste/capacidade/" + idSala + "/" + idPersonagem + "/" + tipo);
	},


	testeRedutor: (idSala, idsPersonagem) => { 
		return http.post("api/teste/redutor/" + idSala, idsPersonagem);
	},

}