<template>
    <div style="margin: 12px;">
        <CRow>
            <CCol>
                <b-row>
                    <h2>{{ prop_NomeEtapa }}</h2>
                </b-row>
                <b-row>
                    <b-col sm="12" md="6" style="mar">
                        <b-list-group>
                            <b-list-group-item>{{ prop_Dica1 }}</b-list-group-item>
                            <b-list-group-item>{{ prop_Dica2 }}</b-list-group-item>
                            <b-list-group-item>{{ prop_Dica3 }}</b-list-group-item>                            
                            <b-list-group-item>{{ prop_Dica4 }}</b-list-group-item>                            
                            <b-list-group-item>{{ prop_Dica5 }}</b-list-group-item>
                        </b-list-group>
                    </b-col>
                    <b-col>                        
                        <b-card class="my-card-border">
                            <h4 class="text-center">Conhecimentos selecionados da {{ prop_etapa }}° Fase:</h4><hr>
                            <h5  class="text-center" v-if="chosedConhecimentos.length > 0"> {{ chosedConhecimentos[0].nome }} </h5>
                            <h5  class="text-center" v-else> Nenhum </h5>
                            <h5  class="text-center" v-if="chosedConhecimentos.length > 1"> {{ chosedConhecimentos[1].nome }} </h5>
                            <h5  class="text-center" v-else> Nenhum </h5>
                            <b-card-footer>
                                <b-row>
                                <b-col sm="6">
                                    <CButton color="success" variant="outline" block @click="setEtapa()">
                                        Próxima Fase
                                    </CButton>
                                </b-col>
                                <b-col sm="6">
                                    <CButton v-if="prop_confirmar" color="success" variant="outline" block @click="prop_finalizar()">
                                        Concluir seleção
                                    </CButton>
                                    <CButton v-else disabled color="success" variant="outline" block>
                                        Concluir seleção
                                    </CButton>                                     
                                </b-col>
                            </b-row>
                            </b-card-footer>                            
                        </b-card>                
                    </b-col>
                </b-row>
                <b-row>
                    <b-col sm="12">
                            <b-card-header>Conhecimentos por categoria</b-card-header>
                            <b-tabs card>
                                <b-tab title="Antecedentes" active style="padding: 0px;">
                                    <b-list-group>
                                        <b-list-group-item 
                                        button @click="select(item)" 
                                        v-bind:class="[isSelected(item) ? 'list-group-item-action-selected' : 'list-group-item']"
                                        v-for="(item, index) in prop_listAntc" :key="index">
                                            <h2> {{ item.nome }}</h2>
                                            <p>  {{ item.descricao }}</p>
                                        </b-list-group-item>
                                    </b-list-group>
                                </b-tab>
                                <b-tab title="Ofícios">
                                    <b-list-group>
                                        <b-list-group-item 
                                        button @click="select(item)" 
                                        v-bind:class="[isSelected(item) ? 'list-group-item-action-selected' : 'list-group-item']"
                                        v-for="(item, index) in prop_listOfic" :key="index">
                                            <h2> {{ item.nome }}</h2>
                                            <p>  {{ item.descricao }}</p>
                                        </b-list-group-item>
                                    </b-list-group>
                                </b-tab>
                                <b-tab title="Teóricos">
                                    <b-list-group>
                                        <b-list-group-item 
                                        button @click="select(item)" 
                                        v-bind:class="[isSelected(item) ? 'list-group-item-action-selected' : 'list-group-item']"
                                        v-for="(item, index) in prop_listTeor" :key="index">
                                            <h2> {{ item.nome }}</h2>
                                            <p>  {{ item.descricao }}</p>
                                        </b-list-group-item>
                                    </b-list-group>
                                </b-tab>
                            </b-tabs>
                    </b-col>
                </b-row>
            </CCol>
        </CRow>
    </div>
</template>


<script>
import Image from "@/util/image";
import capUtil from "@/util/Capacidades";
import { create } from "domain";

export default {
    name: 'ConhecimentoCard',
    props: {
        prop_etapa: Number,
        prop_listAntc: Array,
        prop_listOfic: Array,
        prop_listTeor: Array,
        prop_NomeEtapa: String,
        prop_Dica1: String,
        prop_Dica2: String,
        prop_Dica3: String,
        prop_Dica4: String,
        prop_Dica5: String,
        prop_choseConhecimentos: Function, 
        prop_confirmar: Boolean, 
        prop_finalizar: Function,    
        prop_setEtapa: Function ,
    },
    components: {
    },
    data() {
        return {
            chosedConhecimentos: [],
            fields: [
                {
                    key: 'nome',
                    label: 'Conhecimento'
                },
                {
                    key: 'descricao',
                    label: 'Descrição'
                }
            ],
        }
    },

    beforeMount: function () {
    },

    methods: {
        select(item){

            if(this.chosedConhecimentos.length == 0){
                this.chosedConhecimentos.push(item)
            } else 
            if(this.chosedConhecimentos.length == 1){
                if(this.chosedConhecimentos[0].id != item.id){
                    this.chosedConhecimentos.push(item)
                }
            } else 
            if(this.chosedConhecimentos.length == 2){
                this.chosedConhecimentos.splice(0,1)

                if(this.chosedConhecimentos[0].id != item.id){
                    this.chosedConhecimentos.push(item)
                }
            }         
            
            this.prop_choseConhecimentos(item, this.prop_etapa)
        },

        isSelected(item){
            if(this.chosedConhecimentos.length > 0){
                if (this.chosedConhecimentos[0].id == item.id){
                    return true
                }
            }

            if(this.chosedConhecimentos.length > 1){
                if (this.chosedConhecimentos[1].id == item.id){
                    return true
                }
            }        
        },

        setEtapa(){
            if(this.prop_etapa == 1){
                this.prop_setEtapa(2)
            } else 
            if(this.prop_etapa == 2){
                this.prop_setEtapa(3)
            } else
            if(this.prop_etapa == 3){
                this.prop_setEtapa(1)
            }
        }


    }
}
</script>

<style></style>