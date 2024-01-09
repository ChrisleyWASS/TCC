<template>
    <div>
        <b-dropdown :text="NPCSelecinado.nome" block variant="outline-success" class="m-2" menu-class="w-100" v-model="NPCSelecinado">
            <b-dropdown-item href="#" v-for="(npc, index) in inimigos" :key="index">
                {{npc.nome}}
            </b-dropdown-item>
        </b-dropdown>
    </div>
</template>


<script>
import Image from "@/util/image";

export default {
    name: 'SelecionaNPC',
    components: {
    },
    data() {
        return {
            utilImage: Image,
            listTreinamento: [],
            selected: false,
            NPCSelecinado: {
                id: 0,
                nome: 'Selecionar NPC'
            }, 
            inimigos: [
                {'id':1, 'nome':'inimigo A', 'integridade':3, 'guarda':'8/14', 'AD':0},
                {'id':2, 'nome':'inimigo B', 'integridade':2, 'guarda':'6/12', 'AD':0},
                {'id':3, 'nome':'inimigo C', 'integridade':1, 'guarda':'7/7', 'AD':0},
                {'id':4, 'nome':'inimigo D', 'integridade':2, 'guarda':'5/16', 'AD':0},
                {'id':5, 'nome':'inimigo A', 'integridade':3, 'guarda':'8/14', 'AD':0},
                {'id':6, 'nome':'inimigo B', 'integridade':2, 'guarda':'6/12', 'AD':0},
                {'id':7, 'nome':'inimigo C', 'integridade':1, 'guarda':'7/7', 'AD':0},
                {'id':8, 'nome':'inimigo D', 'integridade':2, 'guarda':'5/16', 'AD':0},
            ],

        }
    },

    computed: {
        personagem() {
            return this.$store.state.personagem;
        },

        sala() {
            return this.$store.state.sala;
        },
        
        barHSize() {
            return window.innerHeight * 0.25
        },

        sidebarWSize() {
            if (window.innerWidth < 992) {
                return '50%';
            } else {
                return '30%';
            }
        }
    },

    mounted: function () {

    },

    methods: {
    }
}
</script>

<style>

.show > .btn-outline-success.dropdown-toggle {
  background-color: rgba(245, 245, 245, 0.096) !important; /* Estilo personalizado para o botão do dropdown quando o mouse está sobre ele */
}

</style>
