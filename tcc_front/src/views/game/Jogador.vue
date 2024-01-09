<template>
    <div>
        <b-row>
            <b-col sm="3" lg="2" class="capacidades_box overflowy" v-bind:style="{ 'height': sidebarHSize }">
                <div v-if="carregado">
                    <listaCapacidades></listaCapacidades>
                </div>                
            </b-col>
            <b-col class="overflowy" v-bind:style="{ 'height': sidebarHSize }">
                <div v-if="carregado">
                    <mesa v-if="isDesktop"></mesa>
                    <ficha></ficha>
                </div>
            </b-col>
        </b-row>
    </div>
</template>

<script>
import Image from "@/util/image";
import utilServices from '@/services/Util';
import personagemServices from "@/services/Personagem";
import salaServices from "@/services/Sala";
import settings from "@/settings";
import ficha from '@/components/Game/Ficha'
import listaCapacidades from '@/components/Game/Lista'
import mesa from "@/components/Game/Abas/Mesa"

export default {
    name: 'Game',

    components: {
        ficha,
        utilServices,
        listaCapacidades,
        mesa,
        personagemServices,
        salaServices,
    },

    computed: {
        personagem() {
            return this.$store.state.personagem;
        },

        sidebarHSize() {
            return window.innerHeight + 'px';
        }
    },

    data() {
        return {
            carregado: false,
            utilImage: Image,
            isDesktop: true,
        }
    },

    created: function () {
        if (window.innerHeight > 500) {
            this.isDesktop = true
        } else {
            this.isDesktop = false
        }
    },

    mounted: function () {
        setTimeout(() => {                 
            this.carregado = true
        }, 1000);
    },

}
</script>

<style>
.capacidades_box {
    background-color: #373b40;
}
</style>