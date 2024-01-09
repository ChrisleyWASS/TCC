import { http } from "./config";
import settings from "@/settings";

export default {
    list: () => {
        return http.get("api/usuarios/");
    },
    get: (idUsuario) => {
        return http.get("api/usuarios/" + idUsuario);
    },
    save: (Usuario) => {
        return http.put("api/usuarios/" + Usuario.id, Usuario);
    },
    trocaSenha: (idUsuarioEmpresa, novaSenha) => {
        return http.post("api/usuarios/trocasenha/" + idUsuarioEmpresa, novaSenha);
    },
    getUsuarioLogado:() => {
        return http.get("api/usuarios/usuariologado");
    },
}