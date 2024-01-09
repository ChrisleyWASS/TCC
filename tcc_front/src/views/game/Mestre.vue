<template>
    <div>
        <b-row>
            <b-col sm="3" lg="2" class="capacidades_box overflowy" v-bind:style="{ 'height': sidebarHSize }">
                <div v-if="carregado">
                    <b-table striped hover :sort-by="'id'" :fields="fields" :sort-desc="true" :items="sala.log"></b-table>
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

import ficha from '@/components/Game/Ficha'
import mesa from "@/components/Game/Abas/Mesa"
export default {
    name: 'Game',

    components: {
        ficha,
        utilServices,
        mesa,
        personagemServices,
    },

    computed: {
        sala() {
            return this.$store.state.sala;
        },

        sidebarHSize() {
            return window.innerHeight + 'px';
        }
    },

    data() {
        return {
            carregado: false,
            utilImage: Image,
            idPersonagem: null,
            isDesktop: true,
            log: [],
            fields: [
                {
                    key: 'descricao',
                    label: 'Histórico da Sala'
                }
            ],
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