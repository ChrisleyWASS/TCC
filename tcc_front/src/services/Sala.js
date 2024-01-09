import { http } from "./config";

export default {

    get: (idSala) => {
        return http.get("/api/salas/" + idSala);
    },

    getByPersonagem: (idPersonagem) => {
        return http.get("/api/salas/byPersonagem/" + idPersonagem);
    },

    list: () => {
        return http.get("/api/salas/list");
    },

    save: (sala) => {
        return http.post("/api/salas/novo", sala);
    },

    solicitarAcesso: (idPersonagem, sala) => {
        return http.post("/api/salaspersonagens/solicita/" + idPersonagem, sala);
    },

    aprovarAcesso: (idSala, idPersonagem, autorizacao) => {
        return http.post("/api/salaspersonagens/aprova/" + idSala + "/" + idPersonagem, autorizacao);
    },

   
}