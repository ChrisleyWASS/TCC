<template>
    <div style="margin: 14px;">
        <CRow>
            <CCol>
                <CCard class="my-card-border">
                    <CCardBody class="text-center">
                        <div>
                            <div class="d-flex justify-content-center">
                                <b-img :src="this.utilImage.getCommon('perfil')" style="height: 100px">
                                </b-img>
                            </div>
                            <h2 class="d-flex justify-content-center"> {{prop_personagem.nome}} {{prop_personagem.linhagem}} </h2>
                            <p class="d-flex justify-content-center"> {{returnNomeAlternativo()}} </p>
                            <b-row>
                                <b-col>
                                    <b-list-group-item>
                                        <b-avatar style="background-color: rgba(255, 255, 255, 0);" rounded size="3rem"
                                            :src="this.utilImage.getCommon('apf_')"></b-avatar>
                                        <span class="mr-auto" style="font-size: 40px; padding: 0px 10px 0px 10px;">
                                            {{prop_personagem.apFisica}}</span>
                                    </b-list-group-item>
                                </b-col>
                                <b-col>
                                    <b-list-group-item>
                                        <b-avatar style="background-color: rgba(255, 255, 255, 0);" rounded size="3rem"
                                            :src="this.utilImage.getCommon('integridade_')"></b-avatar>
                                        <span class="mr-auto" style="font-size: 40px; padding: 0px 10px 0px 10px;">
                                            {{prop_personagem.integridade}}</span>
                                    </b-list-group-item>
                                </b-col>
                                <b-col>
                                    <b-list-group-item>
                                        <b-avatar style="background-color: rgba(255, 255, 255, 0);" rounded size="3rem"
                                            :src="this.utilImage.getCommon('apm_')"></b-avatar>
                                        <span class="mr-auto" style="font-size: 40px; padding: 0px 10px 0px 10px;">
                                            {{prop_personagem.apMental}}</span>
                                    </b-list-group-item>
                                </b-col>
                            </b-row>
                        </div>
                        <hr>
                        <div class="d-flex justify-content-center">
                            <CButton color="success" variant="outline" size="lg" class="align-middle" @click="select()">
                                <p> Acessar </p>
                            </CButton>
                        </div>
                    </CCardBody>
                </CCard>
            </CCol>
        </CRow>
    </div>
</template>


<script>
import Image from "@/util/image";

export default {
    name: 'Card_select_personagem',
    props: {
        prop_personagem: Object,
    },
    data() {
        return {
            utilImage: Image,
            listTreinamento: [],
            selected: false,
            personagemSelecionado: {},
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
        

    },

    methods: {

        select() {
            this.$router.push({
                path: '/game/jogador/' + this.prop_personagem.id,
                params: {
                    prop_idPersonagem: this.prop_personagem.id
                }
            });
        },

        remove() {
        },

        returnNomeAlternativo(){
            if(this.prop_personagem.alternativo.length == 0){
                return '-'
            } else {
                return this.prop_personagem.alternativo
            }
        }
    }
}
</script>

<style></style>