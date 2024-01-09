<template>
    <div class="c-app my-app flex-row">
        <CContainer>
            <CRow class="justify-content-center">
                <CCol>
                    <CCard class="my-card">
                        <CCardHeader class="text-center">
                            <h2>5° - Experiência</h2>
                            <p>Defina a história de fundo do persoagem e selecione conhecimentos relacionados.</p>
                        </CCardHeader>
                        <CCardBody>
                            <b-row>
                                <b-col xs="12" sm="12" md="12" lg="12" xl="12">
                                        <b-progress max="6">
                                            <b-progress-bar :value="progresso" variant="success">
                                                <span><strong>Conhecimentos: {{ progresso }} / 6</strong></span>
                                            </b-progress-bar>
                                        </b-progress>
                                        <b-progress :max="3" height="2rem">
                                            <b-progress-bar variant="secondary" :value="1" animated show-progress>
                                                <b-button @click="setEtapa(1)"
                                                    v-bind:class="[etapa == 1 ? 'btn_progress_bar_selected' : 'btn_progress_bar']">
                                                    1° Fase
                                                </b-button>
                                            </b-progress-bar>
                                            <b-progress-bar variant="secondary" :value="1" animated show-progress>
                                                <b-button @click="setEtapa(2)"
                                                    v-bind:class="[etapa == 2 ? 'btn_progress_bar_selected' : 'btn_progress_bar']">
                                                    2° Fase
                                                </b-button>
                                            </b-progress-bar>
                                            <b-progress-bar variant="secondary" :value="1" animated show-progress>
                                                <b-button @click="setEtapa(3)"
                                                    v-bind:class="[etapa == 3 ? 'btn_progress_bar_selected' : 'btn_progress_bar']">
                                                    3° Fase
                                                </b-button>
                                            </b-progress-bar>
                                        </b-progress>
                                </b-col><hr>                            
                            </b-row>
                            <div v-show="etapa == 1">
                                <ConhecimentoOption :prop_etapa=1 :prop_listAntc="listAntc" :prop_listOfic="listOfic"
                                    :prop_listTeor="listTeor" :prop_NomeEtapa="'Origem'"
                                    :prop_Dica1="'De que onde seu personagem veio?'"
                                    :prop_Dica2="'Qual era a sua ocupação na infância/juventude?'"
                                    :prop_Dica3="'O que aprendeu com seus cuidadores na infância?'"
                                    :prop_Dica4="'Seu ambiente proporcionou que tipo de aprendizado?'"
                                    :prop_Dica5="'Quais os principais eventos dessa etapa de sua vida?'"
                                    :prop_choseConhecimentos="choseConhecimentos" :prop_confirmar="confirmar"
                                    :prop_finalizar="finaliza"
                                    :prop_setEtapa="setEtapa">
                                </ConhecimentoOption>
                            </div>
                            <div v-show="etapa == 2">
                                <ConhecimentoOption :prop_etapa=2 :prop_listAntc="listAntc" :prop_listOfic="listOfic"
                                    :prop_listTeor="listTeor" :prop_NomeEtapa="'Desenvolvimento'"
                                    :prop_Dica1="'Quando seu personagem começou a se virar por conta própria?'"
                                    :prop_Dica2="'Aprendeu alguma profissão, realizou estudos ou treinamentos?'"
                                    :prop_Dica3="'Que tipo de conhecimento seu personagem teve que desenvolver?'"
                                    :prop_Dica4="'Ocorreu algum marco que mudou sua trajetória de vida?'"
                                    :prop_Dica5="'Quem foram suas principais influências e referências?'"
                                    :prop_choseConhecimentos="choseConhecimentos" :prop_confirmar="confirmar"
                                    :prop_finalizar="finaliza"
                                    :prop_setEtapa="setEtapa">
                                </ConhecimentoOption>
                            </div>
                            <div v-show="etapa == 3">
                                <ConhecimentoOption :prop_etapa=3 :prop_listAntc="listAntc" :prop_listOfic="listOfic"
                                    :prop_listTeor="listTeor" :prop_NomeEtapa="'Atual'"
                                    :prop_Dica1="'Qual a ocupação atual do personagem?'"
                                    :prop_Dica2="'Quais os conhecimentos usados no dia a dia?'"
                                    :prop_Dica3="'Qual a sua condição financeira e estilo de vida?'"
                                    :prop_Dica4="'Seu personagem possui alguma fama? Títulos? Posses?'"
                                    :prop_Dica5="'O que seu persongem busca ou deseja realizar?'"
                                    :prop_choseConhecimentos="choseConhecimentos" :prop_confirmar="confirmar"
                                    :prop_finalizar="finaliza"
                                    :prop_setEtapa="setEtapa">
                                </ConhecimentoOption>
                            </div>
                        </CCardBody>
                    </CCard>
                </CCol>
            </CRow>
        </CContainer>
    </div>
</template>


<script>
import utilServices from '@/services/Util';
import ConhecimentoOption from './ConhecimentoOptions';
import criacaoServices from "@/services/CriaPersonagem";


export default {
    name: 'Conhecimentos',
    components: {
        ConhecimentoOption,
        criacaoServices
    },
    props: {
        prop_choseCon: Function,
    },
    data() {
        return {
            etapa: 1,
            progresso: 0,
            confirmar: false,
            listConhecimentos: [],
            listAntc: [],
            listOfic: [],
            listTeor: [],
            listChosed_etapa1: [],
            listChosed_etapa2: [],
            listChosed_etapa3: [],
            listChosed: [],
        }
    },

    beforeMount: function () {
        let loader = this.$loading.show({});
        window.scrollTo(0, 0)
        criacaoServices.listConhecimentos()
            .then((response) => {
                this.listConhecimentos = response.data
                response.data.forEach(c => {
                    //c.checked = false
                    if (c.tipo.id == 1) {
                        this.listAntc.push(c)
                    } else if (c.tipo.id == 2) {
                        this.listOfic.push(c)
                    } else if (c.tipo.id == 3) {
                        this.listTeor.push(c)
                    }
                });
            }).catch((error) => {
                utilServices.parseServerError(error, this);
            })
            .finally(() => {
                loader.hide();
            });
    },

    methods: {
        setEtapa(e) {
            this.etapa = e
        },

        trataList(item, refList) {
            if (refList.length == 0) {
                refList.push(item)
            } else
                if (refList.length == 1) {
                    if (refList[0].id != item.id) {
                        refList.push(item)
                    }
                } else
                    if (refList.length == 2) {
                        refList.splice(0, 1)

                        if (refList[0].id != item.id) {
                            refList.push(item)
                        }
                    }

            return refList
        },

        choseConhecimentos(con, etapa) {

            this.confirmar = false

            if (etapa == 1) {
                this.listChosed_etapa1 = this.trataList(con, this.listChosed_etapa1)
            } else
                if (etapa == 2) {
                    this.listChosed_etapa2 = this.trataList(con, this.listChosed_etapa2)
                } else
                    if (etapa == 3) {
                        this.listChosed_etapa3 = this.trataList(con, this.listChosed_etapa3)

                    }

            this.progresso = this.listChosed_etapa1.length +
                this.listChosed_etapa2.length +
                this.listChosed_etapa3.length


            if (this.progresso == 6) {
                this.listChosed = []

                this.listChosed_etapa1.forEach(element => {
                    this.listChosed.push(element)
                });
                this.listChosed_etapa2.forEach(element => {
                    this.listChosed.push(element)
                });
                this.listChosed_etapa2.forEach(element => {
                    this.listChosed.push(element)
                });

                this.confirmar = true;

            }
        },

        finaliza() {
            this.prop_choseCon(this.listChosed)
        }
    }

}
</script>

<style></style>




