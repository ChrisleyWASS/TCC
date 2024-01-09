<template>
    <div style="margin: 14px;">
        <CRow>
            <CCol>
                <b-card hide-footer v-bind:class="[this.selected ? 'my-card-border-selected' : 'my-card-border']">
                    <div style="height: 23em;">
                        <div class="d-flex justify-content-center">
                            <b-img :src="this.utilImage.getTrain(this.prop_Treinamento.nome)" rounded="circle"
                                style="background-color: #f39237ff; height: 100px">
                            </b-img>
                        </div>

                        <h2 class="d-flex justify-content-center"> {{ this.prop_Treinamento.nome }} </h2>
                        <p class="d-flex justify-content-center">{{ this.prop_Treinamento.descricao }}</p>
                        <b-table 
                            hover small sort-direction="desc" 
                            :items="listTreinamento" 
                            :fields="fields"
                            class="text-center">
                        </b-table>
                    </div>
                    <hr>
                    <div v-if="!selected" class="d-flex justify-content-center">
                        <CButton color="success" variant="outline" size="lg" class="align-middle" @click="select()">
                            <p> Escolher </p>
                        </CButton>
                    </div>
                    <div v-else class="d-flex justify-content-center">
                        <CButton color="danger" variant="outline" size="lg" class="align-middle" @click="remove()">
                            <p> Remover </p>
                        </CButton>
                    </div>
                </b-card>
            </CCol>
        </CRow>
    </div>
</template>


<script>
import Image from "@/util/image";
import capUtil from "@/util/Capacidades";
import { create } from "domain";
import { thisTypeAnnotation } from "@babel/types";

export default {
    name: 'TreinamentoCard',
    props: {
        prop_Treinamento: Object,
        prop_choseTrn: Function,
        prop_removeTrn: Function,
        prop_listChosedTrn: Array,
    },
    data() {
        return {
            utilImage: Image,
            listTreinamento: [],
            selected: false,
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

    mounted: function () {
        this.listTreinamento = capUtil.capsClean(this.prop_Treinamento.capacidades);
        this.verfySelected()
    },

    methods: {

        verfySelected() {
            if (this.prop_listChosedTrn.length > 0) {
                this.prop_listChosedTrn.forEach(element => {
                    if (element.id == this.prop_Treinamento.id) {
                        this.selected = true
                    } else {
                        this.selected = false
                    }
                });
            } else {
                this.selected = false
            }
        },

        select() {
            this.prop_choseTrn(this.prop_Treinamento)
            this.verfySelected()
        },

        remove() {
            this.prop_removeTrn(this.prop_Treinamento)
            this.verfySelected()
        }
    }
}
</script>

<style></style>