<template>
    <div class="c-app my-app flex-row">
        <CContainer>
            <CRow class="justify-content-center">
                <CCol>
                    <CCard class="my-card">
                        <CCardHeader class="text-center">
                            <h2>1° - Nascimento</h2>                            
                            <p>Escolha a espécie, raça e etnia do seu personagem</p>
                        </CCardHeader>
                        <CCardBody>                         
                            <b-tabs content-class="mt-3"  align="center" active-nav-item-class="font-weight-bold">
                                    <b-tab v-for="(especie, index) in listEspecies" :key="index" :title="especie.nome" active>                                         
                                            {{especie.descricao}}   
                                            <h5>Opções de raça para {{ especie.nome }}:</h5>                                                                                              
                                            <div v-for="(raca, index) in especie.racas" :key="index">                                                                                                      
                                                <racaOption 
                                                    :prop_Raca="raca"
                                                    :prop_Especie="especie"
                                                    :prop_choseEspRacEtnia="prop_choseEspRacEtnia"
                                                ></racaOption>
                                            </div>                                                                                                                                                                                                             
                                    </b-tab>                                                                                                          
                            </b-tabs>                           
                        </CCardBody>
                    </CCard>
                </CCol>
            </CRow>
        </CContainer>
    </div>
</template>


<script>
import racaOption from './RacaOptions.vue';
import criacaoServices from "@/services/CriaPersonagem";
import utilServices from '@/services/Util';


export default {
    name: 'Raca',
    components: {
        racaOption,
        criacaoServices
    },
    props: {
        prop_choseEspRacEtnia:  Function,
    },
    data() {        
        return {
            listEspecies: [],            
        }
    },
    beforeMount: function () {
        let loader = this.$loading.show({});
        criacaoServices.listEspecies()
            .then((response) => {
                this.listEspecies = response.data
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




