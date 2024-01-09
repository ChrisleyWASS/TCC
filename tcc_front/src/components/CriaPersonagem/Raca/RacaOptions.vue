<template>
    <div style="margin: 3px;">
        <CRow>
            <CCol sm="12">
                <b-button class="btn_selection" variant="outline-success" block v-b-toggle=[this.idRaca]>
                    <b-avatar href="#" :src="this.utilImage.getRaca(this.prop_Raca.nome)" variant="success"
                        style="margin-right: 10px;"></b-avatar>
                    {{ this.prop_Raca.nome }}
                </b-button>
                <b-collapse v-bind:id="idRaca" class="race-collapse-option" accordion="my-accordion" role="tabpanel">
                    <b-card class="my-card">
                        <b-row>
                            <b-col sm="12" md="5" xl="5">
                                <b-jumbotron class="jumbotron-orange">
                                    <p> {{ this.prop_Raca.descricao }}</p>
                                </b-jumbotron>
                                <b-jumbotron class="jumbotron-orange">
                                    <capstable 
                                        :prop_textHover="'Relação das capacidades da espécie e raça'"
                                        :prop_items="capsEspecieRaca"
                                        :prop_fields="fields"
                                        >
                                    </capstable>                                    
                                </b-jumbotron>                                
                                <b-jumbotron class="jumbotron-orange">
                                    <template #lead>
                                        Carta de Habilidade
                                    </template>
                                    <p>
                                        Descrição da carta de habilidade obtida com a escolha desta raça.
                                    </p>
                                </b-jumbotron>
                            </b-col>
                            <b-col sm="12" md="7" xl="7" >
                                <b-jumbotron class="jumbotron-no-border">
                                    <template #lead>Etnias, Povos e Clãs</template>
                                    <b-tabs pills card vertical active-nav-item-class="font-weight-bold"
                                        v-model="etniaTabIndex">
                                        <b-tab v-for="(etnia, index) in listEtnias" :key="index" :title="etnia.nome">
                                            <b-card-text style="margin: auto;">
                                                <b-img :src="utilImage.getEtnia(etnia.nome)" fluid alt="Fluid image" style="min-height: 200px; min-width: 133px;"></b-img>
                                            </b-card-text>
                                        </b-tab>
                                    </b-tabs>
                                    <b-card-body>
                                    {{ getEtniaDescricao() }}                                    
                                </b-card-body>
                                </b-jumbotron>
                                
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col sm="12" md="5" xl="5">
                            </b-col>
                            <b-col sm="12" md="7" xl="7" class="d-flex justify-content-center">
                                <CButton color="success" variant="outline" size="lg" class="align-middle" @click="select()">
                                    <p> Escolher {{ this.prop_Especie.nome }} {{ this.prop_Raca.nome }} {{ getEtniaNome() }}</p>
                                </CButton>
                            </b-col>
                        </b-row>
                    </b-card>
                </b-collapse>
            </CCol>
        </CRow>
    </div>
</template>


<script>
import Image from "@/util/image";
import capUtil from "@/util/Capacidades";
import capstable from "@/components/tables/CapsTable";

export default {
    name: 'RacaCard',
    props: {
        prop_Raca: Object,
        prop_Especie: Object,
        prop_choseEspRacEtnia:  Function,
    },
    components: {
        capstable
    },
    data() {
        return {
            utilImage: Image,
            listEtnias: [],
            etniaTabIndex: 0,
            fields: [
                {
                    key: 'sigla'
                },
                {
                    key: 'Especie',
                    variant: 'secondary'
                },
                {
                    key: 'Raça',
                    variant: 'secondary'
                },
                {
                    key: 'Personagem',
                    label: 'Total',
                    sortable: true
                },
            ],
            capsEspecieRaca: [],

        }
    },

    created: function () {
        this.idRaca = "id_" + this.prop_Raca.id;
        this.listEtnias = this.prop_Raca.etnias;
        this.calculaCapacidades();        
    },

    methods: {
        getEtniaDescricao() {
            return this.listEtnias[this.etniaTabIndex].descricao
        },

        getEtniaNome() {
            return this.listEtnias[this.etniaTabIndex].nome
        },

        select(){
            this.prop_choseEspRacEtnia(this.prop_Especie, this.prop_Raca, this.listEtnias[this.etniaTabIndex])
        },

        calculaCapacidades(){
            
            let obj = {}
            obj.nome = "";            
            obj.capacidades = capUtil.capsVazia();   

            let capsTemp = capUtil.capsChosed(this.prop_Especie,this.prop_Raca,obj,obj,obj,obj,obj);            
            this.capsEspecieRaca = capUtil.capsCleanByTotal(capsTemp);
        },
    }
}
</script>

<style></style>