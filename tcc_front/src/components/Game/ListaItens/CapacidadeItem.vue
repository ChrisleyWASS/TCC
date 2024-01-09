<template>
    <div>
        <b-list-group horizontal style="width: 100%" button>
            <b-list-group-item v-b-toggle="[prop_sigla]" style="width: 50%" class="capacidades-item d-flex justify-content-center">
                <span style="font-size: 25px;"><strong>{{ prop_sigla }}</strong></span>
            </b-list-group-item>
            <b-list-group-item style="width: 50%" button class="teste-item-button" @click="testeCapacidade()">
                <teste :prop_value="prop_valor"></teste>
            </b-list-group-item>
        </b-list-group>

        <b-sidebar :id="prop_sigla" right :width="sidebarWSize" backdrop backdrop-variant="dark" no-close-on-backdrop v-b-toggle="[prop_sigla]">
            <template #header>
                <div style="width: 100%;">
                    <b-button-group class="mx-1 d-flex justify-content-center">
                        <b-button class="btn_just_icon" style="color:#d11d10;">
                            <b-icon icon="x" aria-hidden="true"></b-icon>
                        </b-button>
                    </b-button-group>
                </div>
            </template>
            <TheSidebarCapacidade :prop_nome="prop_nome" :prop_sigla="prop_sigla" :prop_valor="prop_valor"></TheSidebarCapacidade>
        </b-sidebar>

        <b-modal v-model="showModal" style="text-align: center;" hide-footer hide-header>
            <div class="d-flex justify-content-center">
                <span style="font-size: 25px;">Teste de {{ prop_nome }}</span>
            </div>
            <div class="d-flex justify-content-center">
                <span style="font-size: 40px;" class="ciano mr-2"><strong>{{ teste.result }}</strong></span> 
                <span v-if="teste.d20 == 20" style="font-size: 40px;" class="verde">{{ " " }}<strong>CRÍTICO</strong></span>               
                <span v-if="teste.d20 == 1" style="font-size: 40px;" class="red">{{ " " }}<strong>ERRO CRÍTICO</strong></span>   
            </div>
            
            <b-list-group horizontal style="width: 100%">
                <b-list-group-item style="width: 50%" class="capacidades-item d-flex justify-content-center">
                    <b-avatar class="icon" rounded size="2rem" :src="utilImage.getCommon('d20')"></b-avatar>
                    <span style="font-size: 20px;" class="orange"><strong>{{ teste.d20.toString().padStart(2, '0') }}</strong></span>
                </b-list-group-item>
                <b-list-group-item style="width: 50%" class="capacidades-item d-flex justify-content-center">
                    <span style="font-size: 20px;" class="white">{{ prop_sigla }}</span>
                    <span style="font-size: 20px;" class="orange"><strong>{{isPositive()}}{{teste.bonusCap }}</strong></span>
                </b-list-group-item>
                <b-list-group-item style="width: 50%" class="capacidades-item d-flex justify-content-center">
                    <b-avatar class="icon" rounded size="2rem" :src="utilImage.getCommon('AD')"></b-avatar>
                    <span style="font-size: 20px;" class="red"><strong>-{{ teste.ad }}</strong></span>
                </b-list-group-item>
            </b-list-group>

        </b-modal>
    </div>
</template>
  
<script>
import Image from "@/util/image";
import TheSidebarCapacidade from '@/containers/Sidebars/Jogador/Capacidade'
import testeServices from "@/services/Teste";
import teste from '@/components/Game/Button/ButtonTeste'
import utilServices from '@/services/Util';

export default {
    name: 'BotaoTeste',
    components: {
        teste,
        TheSidebarCapacidade,
        testeServices
    },
    props: {
        prop_nome: String,
        prop_sigla: String,
        prop_valor: Number
    },
    data() {
        return {
            utilImage: Image,
            showModal: false,
            teste: {
                ad: 0,
                bonusCap: 0,
                d20: 0,
                result: 0
            }
        }
    },

    computed: {
        sala() {
            return this.$store.state.sala;
        },

        personagem() {
            return this.$store.state.personagem;
        },

        sidebarWSize() {
            if (window.innerWidth < 992) {
                return '50%';
            } else {
                return '30%';
            }
        }
    },

    methods: {

        select() {
            this.prop_action();
        },

        isPositive() {
            if (this.teste.bonusCap >= 0) {
                return '+'
            } else {
                return ''
            }

        },

        testeCapacidade(){
            let loader = this.$loading.show({})
            let idsala = this.personagem.salaPersonagem.sala.id
            if(idsala > 0){                
                testeServices.testeCapacidade(idsala, this.personagem.id, this.prop_sigla)
                .then((response) => {
                    this.teste = response.data
                    this.showModal = true
                }).catch((error) => {
                    utilServices.parseServerError(error, this);
                })
                .finally(() => {
                    loader.hide();
                });
            }
            
        }

        // buttonColor(){
        //     if(this.prop_value > 2){
        //         if (this.prop_value > 4) {
        //             return 'teste-item-button-pro'
        //         } else {
        //             return 'teste-item-button-alto'
        //         }
        //     } else 
        //     if(this.prop_value < -2){
        //         if (this.prop_value < -4) {
        //             return 'teste-item-button-critico'
        //         } else {
        //             return 'teste-item-button-baixo'
        //         }
        //     } else {
        //         return 'teste-item-button'
        //     }
        // }
    }
}
</script>

<style></style>