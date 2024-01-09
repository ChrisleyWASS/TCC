<template>
    <div>
        <b-list-group horizontal style="width: 100%" button>
            <b-list-group-item v-b-toggle="[prop_conhecimento.nome]" style="width: 50%" class="capacidades-item d-flex justify-content-center">
                <span style="font-size: 15px;" class="text_one_line">
                    <strong>{{ prop_conhecimento.nome }}</strong>
                </span>
            </b-list-group-item>
            <b-list-group-item style="width: 50%;" button class="teste-item-button">
                <teste :prop_value="prop_conhecimento.valor"></teste>
            </b-list-group-item>
        </b-list-group>

        <b-sidebar :id="prop_conhecimento.nome" right :width="sidebarWSize" backdrop backdrop-variant="dark" no-close-on-backdrop v-b-toggle="[prop_conhecimento.nome]">
            <template #header>
                <div style="width: 100%;">
                    <b-button-group class="mx-1 d-flex justify-content-center">
                        <b-button class="btn_just_icon" style="color:#d11d10;">
                            <b-icon icon="x" aria-hidden="true"></b-icon>
                        </b-button>
                    </b-button-group>
                </div>
            </template>
            <TheSidebarConhecimento :prop_conhecimento="prop_conhecimento"></TheSidebarConhecimento>
        </b-sidebar>
    </div>
</template>

<script>
import Image from "@/util/image";
import TheSidebarConhecimento from '@/containers/Sidebars/Jogador/Conhecimento.vue'
import teste from '@/components/Game/Button/ButtonTeste'

export default {
    name: 'ConhecimentoItem',
    components: {
        teste,
        TheSidebarConhecimento
    },
    props: {
        prop_conhecimento: Object,
    },
    data() {
        return {
            utilImage: Image,
        }
    },

    computed: {
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
            if (this.prop_value >= 0) {
                return '+'
            } else {
                return ''
            }
        },

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