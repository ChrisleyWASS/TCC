import settings from "@/settings";

export default {

    getImage(path) {
        return settings.path_image + path + ".png";  
    },

    getCapa(nome) {
        return settings.path_image + "wallpaper/" + nome + ".png";        
    },

    getCommon(nome){
        return settings.path_image + "common/" + nome + ".png";        
    },
    
    getRaca(nome) {  
        return settings.path_image + "criaPersonagem/raca/" + nome + ".png";        
    },

    getEtnia(nome) {
        return settings.path_image + "criaPersonagem/etnia/" + nome + ".png";        
    },    

    getTrain(nome, selected){
        if(selected){
            return settings.path_image + "criaPersonagem/treinamento/" + nome + "_s.png";  
        } else {
            return settings.path_image + "criaPersonagem/treinamento/" + nome + ".png";  
        }
        
    }
}