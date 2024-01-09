<template>
    <div class="c-app my-app flex-row">
        <CContainer>
            <CRow class="justify-content-center">
                <CCol>
                    <CCard class="my-card">
                        <CCardHeader class="text-center">
                            <h2>4° - Treinamentos</h2>
                            <p>Escolha as técnicas e habilidades que o seu personagem é proficiente.</p>
                        </CCardHeader>
                        <CCardBody>
                            <CButton 
                                v-bind:color="this.allSelected ? 'success' : 'secondary'"  
                                variant="outline"
                                block class="align-middle" 
                                @click="select()">
                                <b-row>
                                    <b-col sm="12" 
                                        class="d-flex justify-content-center">
                                        <h4>Selecionar</h4> 
                                    </b-col>
                                    <b-col>
                                        <b-img
                                        v-bind:src="this.listChosedTrn.length > 0 ? 
                                                        this.utilImage.getTrain(this.listChosedTrn[0].nome,this.allSelected) : 
                                                        this.utilImage.getTrain('X')"
                                            style="height: 60px; color: aqua;">
                                        </b-img>
                                    </b-col>
                                    <b-col>
                                        <b-img
                                            v-bind:src="this.listChosedTrn.length > 1 ? 
                                                        this.utilImage.getTrain(this.listChosedTrn[1].nome,this.allSelected) : 
                                                        this.utilImage.getTrain('X')"
                                            style="height: 60px">
                                        </b-img>                                        
                                    </b-col>
                                    <b-col>
                                        <b-img
                                            v-bind:src="this.listChosedTrn.length > 2 ? 
                                                        this.utilImage.getTrain(this.listChosedTrn[2].nome,this.allSelected) : 
                                                        this.utilImage.getTrain('X')"
                                            style="height: 60px">
                                        </b-img>
                                    </b-col>
                                </b-row>
                        </CButton>
                            <b-row>
                                <b-col sm="12" md="6" lg="6" xl="4" v-for="(treinamento, index) in listTrn" :key="index">
                                <TreinOptions 
                                    ref="objTrm"
                                    :prop_Treinamento="treinamento"
                                    :prop_choseTrn="choseTrn"
                                    :prop_removeTrn="removeTrn"
                                    :prop_listChosedTrn="listChosedTrn"
                                ></TreinOptions>
                                </b-col>
                            </b-row>
                        </CCardBody>
                    </CCard>
                </CCol>
            </CRow>
        </CContainer>
    </div>
</template>


<script>
import TreinOptions from './TreinamentoOptions.vue';
import utilServices from '@/services/Util';
import criacaoServices from "@/services/CriaPersonagem";
import Image from "@/util/image";


export default {
    name: 'Treinamentos',
    components: {
        TreinOptions,
        criacaoServices
    },
    props: {
        prop_choseTrn:  Function,
    },
    data() {        
        return {
            utilImage: Image,
            listTrn: [],  
            listChosedTrn: [],
            escolhidos: 0 ,     
            allSelected: false, 
        }
    },
    beforeMount: function () {
        let loader = this.$loading.show({});
        window.scrollTo(0,0)
        criacaoServices.listTreinamentos()
            .then((response) => {
                this.listTrn = response.data
            }).catch((error) => {
                utilServices.parseServerError(error, this);
            })
            .finally(() => {
                loader.hide();
            });
    },

    methods: {

        choseTrn(treinamento){     
            
            if(this.escolhidos < 3){
                this.escolhidos += 1
                this.listChosedTrn.push(treinamento)
            }            
            
            if(this.escolhidos == 3){
                window.scrollTo(0,0) 
                this.allSelected = true;               
            }
        },

        removeTrn(treinamento){
            let i = 0;
            this.listChosedTrn.forEach((trn, index) => {
                if(treinamento.id == trn.id){
                    i = index
                }
            });

            if(this.escolhidos != 0){
                this.listChosedTrn.splice(i, 1);
                this.escolhidos -= 1
                this.allSelected = false;               
            }

            
        },

        select(){
            this.prop_choseTrn(this.listChosedTrn[0], 
                               this.listChosedTrn[1], 
                               this.listChosedTrn[2])
        }

    }
}
</script>

<style></style>




