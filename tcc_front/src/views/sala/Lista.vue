<template>
    <CCard class="my-card">
        <CCardHeader class="text-center">
            <h2>Lista de Salas</h2>
            <p v-if="listSalas.length > 0">Selecione uma sala para jogar</p>
            <p v-else>Você ainda não criou nenhuma sala, clique para criar</p>
        </CCardHeader>
        <CCardBody>
            <b-row v-if="listSalas.length > 0">
                <b-table striped hover class="table-text" :items="listSalas" :fields="fields">
                    <template #cell(botao)="row">
                        <CButton color="success" variant="outline" class="align-middle" @click="acessar(row.item)">
                        Jogar
                        </CButton>
                    </template>
                </b-table>
            </b-row>
            <b-row>
                <hr style="background-color: red; height: 1px; border: 0;">
                <CCol class="text-center">
                    <CButton color="success" variant="outline" size="lg" class="align-middle" @click="criar()">
                        Criar Nova Sala
                    </CButton>
                </CCol>
            </b-row>
        </CCardBody>
    </CCard>
</template>


<script>
import salaServices from "@/services/Sala";
export default {
    name: 'Lista',

    components: {
        salaServices,
    },

    data() {
        return {
            listSalas: [],
            fields: [
                {
                    key: 'nome',
                    label: 'Nome da Sala'
                },
                {
                    key: 'codigo',
                    label: 'Codigo de acesso'
                },
                {
                    key: 'botao',
                    label: 'Selecionar'  
                }
            ],
        }
    },

    beforeMount: function () {
        let loader = this.$loading.show({});
        salaServices.list()
            .then((response) => {
                this.listSalas = response.data
            }).catch((error) => {
                utilServices.parseServerError(error, this);
            })
            .finally(() => {
                loader.hide();
            });
    },

    methods: {
        criar(){
            this.$router.push({path: '/sala/new'})
        }, 

        acessar(item){
            this.$router.push({ path: '/game/mestre/' + item.id })
        }
    }

}
</script>

<style>
.table-text{
    color: #f39237ff !important;
    font-size: larger;
}
</style>