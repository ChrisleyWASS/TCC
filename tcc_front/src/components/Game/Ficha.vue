<template>
    <div class="d-flex justify-content-center">
        <b-tabs content-class="mt-3" class="fichaTabs" vertical pills end>
            <b-tab class="tabBorder" active v-if="isMobile">
                <template #title class="vertical-tabs">
                    <img id="sala" :src="utilImage.getCommon('team_')" class="icon" />
                </template><b-tooltip target="sala" triggers="hover" placement="left">Sala</b-tooltip>
                <AbaMesa></AbaMesa>
            </b-tab>
            <b-tab class="tabBorder">
                <template #title>
                    <img id="ABAc" :src="utilImage.getCommon('ABAc')" class="icon" />
                </template><b-tooltip target="ABAc" triggers="hover" placement="left">Combate</b-tooltip>
                <div v-if="isMestre">
                    <AbaSelecNPC></AbaSelecNPC>
                </div>
                <div class="tab-border">
                    <AbaCombate></AbaCombate>
                </div>
            </b-tab>
            <b-tab class="tabBorder">
                <template #title>
                    <img id="ABAm" :src="utilImage.getCommon('ABAm')" class="icon" />
                </template><b-tooltip target="ABAm" triggers="hover" placement="left">Poder</b-tooltip>
                <div class="tab-border"></div>
            </b-tab>
            <b-tab class="tabBorder">
                <template #title>
                    <img id="ABAs" :src="utilImage.getCommon('ABAs')" class="icon" />
                </template><b-tooltip target="ABAs" triggers="hover" placement="left">Cartas de Habilidade</b-tooltip>
                <div class="tab-border"></div>
            </b-tab>
            <b-tab class="tabBorder">
                <template #title>
                    <img id="ABAi" :src="utilImage.getCommon('ABAi')" class="icon" />
                </template><b-tooltip target="ABAi" triggers="hover" placement="left">Inventário</b-tooltip>
                <div class="tab-border"></div>
            </b-tab>
            <b-tab class="tabBorder">
                <template #title>
                    <img id="ABAp" :src="utilImage.getCommon('ABAp')" class="icon" />
                </template><b-tooltip target="ABAp" triggers="hover" placement="left">Perfil</b-tooltip>
                <div class="tab-border"></div>
            </b-tab>
        </b-tabs>
    </div>
</template>

<script>
import Image from "@/util/image";
import AbaMesa from "@/components/Game/Abas/Mesa"
import AbaCombate from "@/components/Game/Abas/Combate"
import AbaSelecNPC from "@/components/Game/Abas/SelecionaNPC"

export default {
    name: 'Ficha',
    components: {
        AbaCombate,
        AbaMesa,
        AbaSelecNPC,
    },
    props: {
        prop_personagem: Object,
    },
    data() {
        return {
            isMobile: false,
            min_height: "100px",
            utilImage: Image,
            listTreinamento: [],
            selected: false,
            isMestre: false,
            personagemSelecionado: {},
            fields: [
                {
                    key: 'capacidade'
                },
                {
                    key: 'sigla'
                },
                {
                    key: 'valor',
                    sortable: true,
                    variant: 'secondary'
                }
            ],

        }
    },

    computed: {
        barHSize() {
            return window.innerHeight * 0.5
        }
    },

    created: function () {
        if (window.innerHeight < 500) {
            this.isMobile = true
        } else {
            this.isMobile = false
        }
    },

    beforeMount: function () {
        let rota = this.$route.path
        let rotaJogador = '/game/jogador/'
        let rotaMestre = '/game/mestre/'

        if (rota.slice(0, rotaMestre.length) === rotaMestre) {
            this.isMestre = true
        } else 
        if (rota.slice(0, rotaJogador.length) === rotaJogador){
            this.isMestre = false
        }
    },

    

    

    methods: {

        select() {
            this.$router.push({ path: '/game/jogador/' + this.prop_personagem.id })
        },

        remove() {
        }
    }
}
</script>

<style>
.fichaTabs {
    width: 100%;
}

.icon {
    height: 30px;
}

.vertical-tabs {
    border-color: #f39237ff;
    border-radius: 5px;
    margin-bottom: 2px;
}

.vertical-tabs:hover {
    border: 1px solid rgba(243, 146, 55, 0.432) !important;
    border-radius: 5px;
    margin-bottom: 2px;
}

.vertical-tabs .nav-link.active {
    border: 1px solid #2bd6d4ff !important;
}

.icon-box {
    background-color: #f39237ff !important;
}

.blue {
    background-color: blue !important;
}

.tab-border {
    border-top: 1px solid rgba(243, 146, 55, 0.185) !important;
    padding-top: 20px !important;
}

.tabBorder {
    padding-left: 15px;
    padding-right: 15px;
}
</style>