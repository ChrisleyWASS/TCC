import { http } from "./config";
import settings from "@/settings";

export default {
    listEspecies: () => {
        return http.get("api/criar/especie");
    },

    listQualidades: () => {
        return http.get("api/criar/caracteristica/" + 'Q');
    },

    listDefeitos: () => {
        return http.get("api/criar/caracteristica/" + 'D');
    },

    listTreinamentos: () => {
        return http.get("api/criar/treinamentos/");
    },

    listConhecimentos: () => {
        return http.get("api/criar/conhecimentos/");
    },

    resumoPersonagem: (personagem) => {
        return http.post("api/criar/finalizar/", personagem);
    }
}