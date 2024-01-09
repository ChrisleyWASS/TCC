<template>
    <CCard class="my-card">
        <CCardHeader class="text-center">
            <h2>Lista de Personagens</h2>
            <p v-if="listPersonagens.length > 0">Selecione um personagem para que possa editar ou jogar</p>
            <p v-else>Você ainda não possui um personagem, clique para criar</p>
        </CCardHeader>
        <CCardBody>
            <b-row>
                <b-col sm="12" md="6" lg="4" xl="3" v-for="(personagem, index) in listPersonagens" :key="index">
                    <SelectPersonagem :prop_personagem=personagem></SelectPersonagem>
                </b-col>
            </b-row>
            <b-row>
                <hr style="background-color: red; height: 1px; border: 0;">
                <CCol class="text-center">
                    <CButton color="success" variant="outline" size="lg" class="align-middle" @click="criar()">
                        Criar Novo Personagem
                    </CButton>
                </CCol>
            </b-row>
        </CCardBody>
    </CCard>
</template>


<script>
import SelectPersonagem from '@/components/SelectPersonagem/CardPersonagem'
import personagemServices from "@/services/Personagem";
import utilServices from '@/services/Util';
export default {
    name: 'Lista',

    components: {
        SelectPersonagem: SelectPersonagem,
        utilServices
    },

    data() {
        return {
            listPersonagens: [],
        }
    },

    beforeMount: function () {
        let loader = this.$loading.show({});
        personagemServices.list()
            .then((response) => {
                this.listPersonagens = response.data
            }).catch((error) => {
                utilServices.parseServerError(error, this);
            })
            .finally(() => {
                loader.hide();   
            });
    },

    methods: {
        criar(){
            this.$router.push({path: '/personagens/new'})
        }
    }

}
</script>