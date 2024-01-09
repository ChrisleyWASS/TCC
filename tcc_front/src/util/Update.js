import salaServices from "@/services/Sala";
import utilServices from "@/services/Util";

export default {
    methods: {
        updateSala(idSala) {
            let loader = this.$loading.show({});
            salaServices.get(idSala)
                .then((response) => {
                    settings.sala = response.data;
                    return response.data;
                })
                .catch((error) => {
                    utilServices.parseServerError(error, this);
                    this.$router.push({ path: "/sala/list" });
                })
                .finally(() => {
                    loader.hide();
                });
        },

        updatePersonagem(idPersonagem) {
            let loader = this.$loading.show({});
            personagemServices.get(idPersonagem)
                .then((response) => {
                    settings.personagem = response.data
                    this.personagem = response.data
                    return response.data;

                }).catch((error) => {
                    utilServices.parseServerError(error, this);
                    this.$router.push({ path: '/personagens/list' })
                })
                .finally(() => {
                    loader.hide();
                });
        }
    },
};
