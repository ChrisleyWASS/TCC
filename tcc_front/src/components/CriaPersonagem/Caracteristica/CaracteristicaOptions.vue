<template>
    <div style="margin: 14px;">
        <CRow>
            <CCol>
                <b-card class="my-card-border" hide-footer>
                    <div style="height: 20em;">
                        <h2 class="d-flex justify-content-center"> {{ this.prop_Caract.nome }} </h2>
                        <p class="d-flex justify-content-center">{{ this.prop_Caract.descricao }}</p>
                        <b-table hover small sort-direction="desc" :items="listCaract" :fields="fields" class="text-center"></b-table>                    
                    </div>   
                    <hr>                 
                    <div class="d-flex justify-content-center">
                        <CButton color="success"  variant="outline" size="lg" class="align-middle" @click="select()">
                            <p> Escolher </p>
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

export default {
    name: 'CaractCard',
    props: {
        prop_Caract: Object,
        prop_choseCaract: Function
    },
    data() {
        return {
            utilImage: Image,
            listCaract: [],
            caractTabIndex: 0,
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

    created: function () {
        this.idCaract = "id_" + this.prop_Caract.id;
        this.listCaract = capUtil.capsClean(this.prop_Caract.capacidades);
    },

    methods: {

        select() {
            this.prop_choseCaract(this.prop_Caract)
        }
    }
}
</script>

<style></style>