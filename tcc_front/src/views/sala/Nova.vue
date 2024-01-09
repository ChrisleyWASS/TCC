<template>
    <CCard class="my-card">
        <CCardHeader class="text-center">
            <h2>Criar Sala</h2>
        </CCardHeader>
        <CCardBody>
            <b-row>
                <b-col xs="12" sm="6" lg="4">
                    <b-form-group class="mb-3" style="padding: 30px;">
                        <h2>Nome da Sala</h2>
                        <b-form-input id="input-formatter" v-model="sala.nome" maxlength="60" 
                        placeholder="Informe o nome da sua nova sala de jogo">
                        </b-form-input>
                        <hr>
                        
                        <h2>Código da sala</h2>
                        <b-form-input id="input-formatter" v-model="sala.codigo" maxlength="15" @keypress="noSpace" :formatter="formatter"
                        placeholder="Compartilhe este código com os jogadores">
                        </b-form-input>
                        <hr>

                        <h2>Disponibilidade</h2>
                        <b-form-radio-group
                            id="radio-group-1"
                            v-model="sala.ativa"
                            :options="options"
                            name="radio-options"
                            size="lg"
                        ></b-form-radio-group>
                        <hr>

                        <CButton color="success" variant="outline" size="lg" @click="criar()" :disabled="valid()">
                            Criar Sala
                        </CButton>
                    </b-form-group>
                </b-col>
                <b-col>
                    <b-card class="my-card-border">
                        <b-tabs content-class="mt-3">
                        <b-tab title="Sinopse da Aventura" active><div style="height: 300px; width: 100%;"></div></b-tab>
                        <b-tab title="Itens Iniciais" active><div style="height: 300px; width: 100%;"></div></b-tab>
                        <b-tab title="Número de Jogadores"><div style="height: 300px; width: 100%;"></div></b-tab>
                        <b-tab title="Redutores Iniciais"><div style="height: 300px; width: 100%;"></div></b-tab>
                    </b-tabs>
                    </b-card>                    
                </b-col>
            </b-row>
        </CCardBody>
    </CCard>
</template>

<script>
import salaServices from "@/services/Sala";
import utilServices from '@/services/Util';
import Image from "@/util/image";
export default {
    name: 'NovaSala',

    components: {
        utilServices,
        salaServices,
        
    },

    data() {
        return {
            utilImage: Image,
            sala: {
                nome: '',
                codigo: '',
                ativa: true,                
            },
            options: [
                { text: 'Criar sala disponível', value: 'true' },
                { text: 'Disponibilizar depois', value: 'false' },
            ],
            isDesktop: true,
            personagem: {}
        }
    },

    beforeMount: function () {

    },

    mounted: function () {
        if (window.innerHeight > 500) {
            this.isDesktop = true
        } else {
            this.isDesktop = false
        }
    },

    methods: {
        criar() {
            let loader = this.$loading.show({}); 
            salaServices.save(this.sala)
                .then((response) => {
                    if(response.data.id > 0){
                        utilServices.success( 'Sala (' + response.data.nome + ') criada com sucesso!', this) 
                        this.$router.push({path: '/sala/list'})
                    }
                }).catch((error) => {
                    utilServices.parseServerError(error, this);
                })
                .finally(() => {
                    loader.hide();
                });            
        },

        formatter(value) {
            return value.toUpperCase()
        },

        noSpace(event) {
            if (event.key === ' ') {
            event.preventDefault();
            }
        },

        valid(){
            if((this.sala.nome.length > 3) && (this.sala.codigo.length > 3)){
                return false;
            } else {
                return true;
            }
        }
    }

}
</script>

<style>
.capacidades_box {
    background-color: #373b40;
}
</style>