<template>
    <div>
        <div v-if="carregado">
            <div class="grupo">
                <span class="divisoria">
                    <strong>Estrutura</strong>
                </span>
                <capacidade :prop_nome="'Força'" :prop_sigla="'FRC'" :prop_valor="personagem.bonusCapacidades.FRC"></capacidade>
                <capacidade :prop_nome="'Mobilidade'" :prop_sigla="'MOB'" :prop_valor="personagem.bonusCapacidades.MOB"></capacidade>
                <capacidade :prop_nome="'Resistência'" :prop_sigla="'RES'" :prop_valor="personagem.bonusCapacidades.RES"></capacidade>
            </div>

            <div class="grupo">
                <span class="divisoria">
                    <strong>Coordenação</strong>
                </span>
                <capacidade :prop_nome="'Agilidade'" :prop_sigla="'AGL'" :prop_valor="personagem.bonusCapacidades.AGL"></capacidade>
                <capacidade :prop_nome="'Desenvoltura'" :prop_sigla="'DSV'" :prop_valor="personagem.bonusCapacidades.DSV"></capacidade>
                <capacidade :prop_nome="'Sutileza'" :prop_sigla="'STZ'" :prop_valor="personagem.bonusCapacidades.STZ"></capacidade>
            </div>

            <div class="grupo">
                <span class="divisoria">
                    <strong>Saúde</strong>
                </span>
                <capacidade :prop_nome="'Vigor'" :prop_sigla="'VIG'" :prop_valor="personagem.bonusCapacidades.VIG"></capacidade>
                <capacidade :prop_nome="'Tenacidade'" :prop_sigla="'TNA'" :prop_valor="personagem.bonusCapacidades.TNA"></capacidade>
                <capacidade :prop_nome="'Imunidade'" :prop_sigla="'IMD'" :prop_valor="personagem.bonusCapacidades.IMD"></capacidade>
            </div>

            <div class="grupo">
                <span class="divisoria">
                    <strong>Intelecto</strong>
                </span>
                <capacidade :prop_nome="'Razão'" :prop_sigla="'RAZ'" :prop_valor="personagem.bonusCapacidades.RAZ"></capacidade>
                <capacidade :prop_nome="'Atenção'" :prop_sigla="'ATN'" :prop_valor="personagem.bonusCapacidades.ATN"></capacidade>
                <capacidade :prop_nome="'Obstinação'" :prop_sigla="'OBT'" :prop_valor="personagem.bonusCapacidades.OBT"></capacidade>
            </div>

            <div class="grupo">
                <span class="divisoria">
                    <strong>Social</strong>
                </span>
                <capacidade :prop_nome="'Retórica'" :prop_sigla="'RET'" :prop_valor="personagem.bonusCapacidades.RET"></capacidade>
                <capacidade :prop_nome="'Carisma'" :prop_sigla="'CAR'" :prop_valor="personagem.bonusCapacidades.CAR"></capacidade>
                <capacidade :prop_nome="'Imposição'" :prop_sigla="'IMP'" :prop_valor="personagem.bonusCapacidades.IMP"></capacidade>
            </div>

            <div class="grupo">
                <span class="divisoria">
                    <strong>Conhecimentos</strong>
                </span>
                <div v-for="(conhecimento, index) in personagem.bonusConhecimentos" :key="index">
                    <conhecimento :prop_conhecimento="conhecimento"></conhecimento>
                </div>
            </div>
        </div>
        <div v-else>
            <div style="height: 200px; align-items: center; color: #7c7dd1;" class="d-flex justify-content-center" >
            <b-icon icon="hourglass-split" animation="fade" font-scale="4"></b-icon>
        </div>
        </div>
    </div>
</template>


<script>
import Image from "@/util/image";
import capacidade from './ListaItens/CapacidadeItem'
import conhecimento from './ListaItens/ConhecimentoItem'

export default {
    name: 'Lista_lateral_capacidades_conhecimentos',
    components: {
        capacidade,
        conhecimento
    },
    computed: {
        sidebarHSize() {
            return window.innerHeight + 'px';
        },

        personagem() {
            return this.$store.state.personagem;
        },
    },
    data() {
        return {
            utilImage: Image,
            listTreinamento: [],
            selected: false,
            carregado: false,
            bonusCapacidades: {},
            bonusConhecimentos: [],
            fields: [
                {key: 'capacidade'},
                {key: 'sigla'},
                {
                    key: 'valor',
                    sortable: true,
                    variant: 'secondary'
                }
            ],

        }
    },

    mounted() {
        this.carregado = true
    },

}
</script>

<style>
.divisoria {
    font-size: 20px;
    font-weight: bold;
    padding-left: 10px;
    color: #595f66;
}


.grupo {
    color: rgba(135, 124, 153, 0.356);
    margin-bottom: 5px;
}
</style>