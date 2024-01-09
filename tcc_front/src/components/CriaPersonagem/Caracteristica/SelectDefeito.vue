<template>
    <div class="c-app my-app flex-row">
        <CContainer>
            <CRow class="justify-content-center">
                <CCol>
                    <CCard class="my-card">
                        <CCardHeader class="text-center">
                            <h2>3° - Defeito</h2>
                            <p>Escolha um defeito para o seu personagem, determinando características negativas.</p>
                        </CCardHeader>
                        <CCardBody>
                            <b-row>
                                <b-col sm="12" md="6" lg="6" xl="4" v-for="(Defeito, index) in listDefeitos" :key="index">
                                    <DefeitoOption 
                                    :prop_Caract="Defeito"
                                    :prop_choseCaract="prop_choseDefeito"
                                ></DefeitoOption>
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
import utilServices from '@/services/Util';
import DefeitoOption from './CaracteristicaOptions';
import criacaoServices from "@/services/CriaPersonagem";


export default {
    name: 'Defeitos',
    components: {
        DefeitoOption,
        criacaoServices
    },
    props: {
        prop_choseDefeito:  Function,
    },
    data() {        
        return {
            listDefeitos: [],            
        }
    },
    beforeMount: function () {
        let loader = this.$loading.show({});
        window.scrollTo(0,0)
        criacaoServices.listDefeitos()
            .then((response) => {
                this.listDefeitos = response.data
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




