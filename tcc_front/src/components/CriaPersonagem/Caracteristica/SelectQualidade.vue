<template>
    <div class="c-app my-app flex-row">
        <CContainer>
            <CRow class="justify-content-center">
                <CCol>
                    <CCard class="my-card">
                        <CCardHeader class="text-center">
                            <h2>2° - Qualidade</h2>
                            <p>Escolha uma qualidade para o seu personagem, determinando características positivas.</p>
                        </CCardHeader>
                        <CCardBody>                            
                            <b-row>
                                <b-col sm="12" md="6" lg="6" xl="4" v-for="(qualidade, index) in listQualidades" :key="index">
                                    <qualidadeOption 
                                    :prop_Caract="qualidade"
                                    :prop_choseCaract="prop_choseQualidade"
                                ></qualidadeOption>
                                </b-col>
                            </b-row>
                            <!-- <div v-for="(qualidade, index) in listQualidades" :key="index">                                                                                                      
                                <qualidadeOption 
                                    :prop_Caract="qualidade"
                                    :prop_choseCaract="prop_choseQualidade"
                                ></qualidadeOption>
                            </div>                              -->
                        </CCardBody>
                    </CCard>
                </CCol>
            </CRow>
        </CContainer>
    </div>
</template>


<script>
import utilServices from '@/services/Util';
import qualidadeOption from './CaracteristicaOptions';
import criacaoServices from "@/services/CriaPersonagem";


export default {
    name: 'Qualidades',
    components: {
        qualidadeOption,
        criacaoServices
    },
    props: {
        prop_choseQualidade:  Function,
    },
    data() {        
        return {
            listQualidades: [],            
        }
    },
    beforeMount: function () {
        let loader = this.$loading.show({});
        window.scrollTo(0,0)
        criacaoServices.listQualidades()
            .then((response) => {
                this.listQualidades = response.data
            }).catch((error) => {
                utilServices.parseServerError(error, this);
            })
            .finally(() => {
                loader.hide();
            });
    },
}
</script>

<style></style>




