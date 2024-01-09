import { http } from "./config";
import settings from "@/settings";

export default {

    get: (idPersonagem) => {
        return http.get("/api/personagem/" + idPersonagem);
    },

    list: () => {
        return http.get("/api/personagem/list");
    },

    save: (personagem) => {
        return http.post("/api/personagem/novo", personagem);
    },
}