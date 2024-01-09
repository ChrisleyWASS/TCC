<template>
    <div class="c-app my-app flex-row">
        <CContainer>
            <CRow class="justify-content-center">
                <CCol>
                    <CCard class="my-card">
                        <CCardHeader class="text-center">
                            <h2>6° - Finalização</h2>
                            <p>Revisão e conclusão da criação do personagem</p>
                        </CCardHeader>
                        <CCardBody>
                            <b-row class="my-1">
                                <b-col sm="12" md="4">
                                    <b-form-input v-model="personagem.nome" size="md"
                                        placeholder="Nome do Personagem"></b-form-input>
                                </b-col>
                                <b-col sm="12" md="4">
                                    <b-form-input v-model="personagem.linhagem" size="md"
                                        placeholder="Nome da Família ou Clã (opcional)"></b-form-input>
                                </b-col>
                                <b-col sm="12" md="4">
                                    <b-form-input v-model="personagem.alternativo" size="md"
                                        placeholder="Títulos & Apelidos (opcional)"></b-form-input>
                                </b-col>
                            </b-row>
                            <hr>
                            <b-row>
                                <CCol class="text-center">
                                    <CButton v-if="personagem.nome.length < 3" color="danger" variant="outline" size="lg"
                                        class="align-middle" disabled>
                                        Dê um nome ao seu personagem
                                    </CButton>
                                    <CButton v-else color="success" variant="outline" size="lg" class="align-middle"
                                        @click="save()">
                                        Criar Personagem
                                    </CButton>
                                    <p>Verifique as informações antes de confirmar</p>
                                </CCol>
                            </b-row>

                            <b-tabs content-class="mt-3">
                                <b-tab title="Info">
                                    <b-row>
                                        <b-col sm="12">
                                            <b-card class="my-card-border">
                                                <h5>Espécie {{ personagem.especiesPersonagem.nome }}</h5>
                                                <p>{{ personagem.especiesPersonagem.descricao }}</p>
                                                <h5>Raça {{ personagem.racasPersonagem.nome }}</h5>
                                                <p>{{ personagem.racasPersonagem.descricao }}</p>
                                                <h5>Etnia {{ personagem.etniasPersonagem.nome }}</h5>
                                                <p>{{ personagem.etniasPersonagem.descricao }}</p>
                                            </b-card>
                                        </b-col>
                                    </b-row>
                                </b-tab>
                                <b-tab title="Status Geral" active>
                                    <b-row>
                                        <b-col sm="12" md="6">
                                            <b-card class="my-card-border" style="text-align: center; margin-bottom: 5px;">
                                                <b-card-header id="integridade">
                                                    <b-avatar style="background-color: rgba(255, 255, 255, 0);" rounded
                                                        size="6rem"
                                                        :src="this.utilImage.getCommon('integridade_')"></b-avatar>
                                                    <span class="mr-auto"
                                                        style="font-size: 40px; padding: 0px 10px 0px 10px;">Integridade</span>
                                                    <span style="color: #f39237ff; font-size: 40px">{{
                                                        personagem.integridade }}</span>
                                                </b-card-header>
                                                <b-popover target="integridade" triggers="hover" placement="top">
                                                    <template #title>Integridade</template>
                                                    Indica a comunhão das aptidões físicas e mentais de um ser, além de
                                                    beneficiar testes de saúde.
                                                    Também estabelece quantos redutores do mesmo tipo um personagem consegue
                                                    suportar antes de entrar em colapso.
                                                </b-popover>
                                                <b-row>
                                                    <b-col xs="6" id="apFisica">
                                                        <b-img fluid-grow :src="this.utilImage.getCommon('apf_')"
                                                            style="padding: 25px;  max-width: 200px">
                                                        </b-img>
                                                        <h4 class="mr-auto">Aptidão Física</h4>
                                                        <h2>{{ personagem.apFisica }}</h2>
                                                        <b-popover target="apFisica" triggers="hover" placement="bottom">
                                                            <template #title>Aptidão Física</template>
                                                            Relação das capacidades estruturais, de coordenação e saúde do
                                                            indivíduo,
                                                            representando o potencial e trabalho conjunto de seu corpo,
                                                            beneficiando testes de estrutura e coordenação.
                                                        </b-popover>
                                                    </b-col>
                                                    <b-col xs="6" id="apMental">
                                                        <b-img fluid-grow :src="this.utilImage.getCommon('apm_')"
                                                            style="padding: 25px; max-width: 200px;">
                                                        </b-img>
                                                        <h4 class="mr-auto">Aptidão Mental</h4>
                                                        <h2>{{ personagem.apMental }}</h2>
                                                        <b-popover target="apMental" triggers="hover" placement="bottom">
                                                            <template #title>Aptidão Mental</template>
                                                            Relação das capacidades intelectuais, sociais e de saúde do
                                                            indivíduo,
                                                            representando o potencial e trabalho conjunto de sua mente,
                                                            beneficiando testes de intelecto e socialização.
                                                        </b-popover>
                                                    </b-col>
                                                </b-row>
                                            </b-card>
                                        </b-col>
                                        <b-col style="display: flex; align-items: center;">
                                            <div style="width: 100%;">
                                                <b-list-group-item class="d-flex align-items-center" id="deslocamento">
                                                    <h3 class="mr-auto">Deslocamento</h3>
                                                    <h2>{{ personagem.deslocamento }} m/T</h2>
                                                    <b-popover target="deslocamento" triggers="hover" placement="top">
                                                        <template #title>Deslocamento</template>
                                                        Indica a velocidade máxima de um personagem, definindo quantos
                                                        metros ele consegue percorrer em um turnos,
                                                        o que condiz a aproximadamente 5 segundos do tempo do jogo,
                                                        portanto, o deslocamento é medido em metros por turno (m/T).
                                                    </b-popover>
                                                </b-list-group-item>
                                                <b-list-group-item class="d-flex align-items-center" id="inicitativa">
                                                    <h3 class="mr-auto">Iniciativa</h3>
                                                    <h2>{{ personagem.inicitativa }}</h2>
                                                    <b-popover target="inicitativa" triggers="hover" placement="top">
                                                        <template #title>Iniciativa</template>
                                                        Representa a velocidade de ação e reação de um personagem em
                                                        batalha,
                                                        sendo usado para definir a ordem de combate.
                                                        Este valor combina a velocidade de ação do personagem e sua
                                                        capacidade para ler os
                                                        estímulos do ambiente para se antecipar e identificar brechas para
                                                        agir.
                                                    </b-popover>
                                                </b-list-group-item>
                                                <b-list-group-item class="d-flex align-items-center" id="guarda">
                                                    <h3 class="mr-auto">Guarda</h3>
                                                    <h2>{{ personagem.guarda }}</h2>
                                                    <b-popover target="guarda" triggers="hover" placement="top">
                                                        <template #title>Guarda</template>
                                                        A guarda de um personagem representa a sua capacidade de evitar
                                                        ataques, seja
                                                        por esquiva ou bloqueio, se tratando do valor padrão de sua defesa.
                                                        Quanto maior
                                                        o valor da guarda, mais difícil é ser atingido. Basicamente, em
                                                        relação à quem ataca, a
                                                        guarda atua como o nível de precisão necessária para que um ataque
                                                        seja efetivo contra o
                                                        alvo em questão.
                                                    </b-popover>
                                                </b-list-group-item>
                                                <b-list-group-item class="d-flex align-items-center" id="baseOfensiva">
                                                    <h3 class="mr-auto">Base Ofensiva</h3>
                                                    <h2>{{ personagem.baseOfensiva }}</h2>
                                                    <b-popover target="baseOfensiva" triggers="hover" placement="top">
                                                        <template #title>Base Ofensiva</template>
                                                        Capacidade básica de ataque de um personagem, seja corpo a corpo ou
                                                        a distância,
                                                        portanto, abrange ataques desarmados, com armas brancas, ou armas de
                                                        disparo e arremesso.
                                                        A base ofensiva será modificada conforme os requisitos e penalidades
                                                        de cada arma em particular.
                                                    </b-popover>
                                                </b-list-group-item>
                                                <b-list-group-item class="d-flex align-items-center" id="basePoder">
                                                    <h3 class="mr-auto">Base de Poder</h3>
                                                    <h2>{{ personagem.basePoder }}</h2>
                                                    <b-popover target="basePoder" triggers="hover" placement="top">
                                                        <template #title>Base de Poder</template>
                                                        Capacidade básica para utilização de poderes, seja por magias,
                                                        feitiços, milagres, canalização e outros fenômenos sobrenaturais.
                                                        A base de poder será modificada conforme os requisitos e penalidades
                                                        de cada poder em particular.
                                                    </b-popover>
                                                </b-list-group-item>
                                                <b-list-group-item class="d-flex align-items-center" id="carga">
                                                    <h3 class="mr-auto">Carga Suportada</h3>
                                                    <h2>{{ personagem.carga }}</h2>
                                                    <b-popover target="carga" triggers="hover" placement="top">
                                                        <template #title>Carga Suportada</template>
                                                        Capacidade de carga do personagem, limitando quanto peso em
                                                        equipamentos ele consegue carregar
                                                        sem sofrer penalidades de sobrecarga.
                                                    </b-popover>
                                                </b-list-group-item>
                                            </div>

                                        </b-col>
                                    </b-row>
                                    <b-row sm="12" md="12">
                                        <b-card class="my-card-border" style="width: 100%;">
                                            <capstable :prop_textHover="'Relação das capacidades do personagem'"
                                                :prop_items="prop_Chosed_Status" :prop_fields="prop_Fields">
                                            </capstable>
                                        </b-card>
                                    </b-row>
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
import settings from "@/settings";
import criacaoServices from "@/services/CriaPersonagem";
import personagemServices from "@/services/Personagem";
import capstable from "@/components/tables/CapsTable";
import objPersonagem from "@/util/Personagens"
import Image from "@/util/image";
import utilServices from '@/services/Util';


export default {
    name: 'Finaliza',
    components: {
        settings,
        criacaoServices,
        capstable,
        personagemServices
    },
    props: {
        prop_Especie: Object,
        prop_Raca: Object,
        prop_Etnia: Object,
        prop_Qualidade: Object,
        prop_Defeito: Object,
        prop_Trn1: Object,
        prop_Trn2: Object,
        prop_Trn3: Object,
        prop_Con: Array,
        prop_Chosed_Status: Array,
        prop_Fields: Array,
    },
    data() {
        return {
            utilImage: Image,
            utilPersonagem: objPersonagem,
            personagem: {
                id: 0,
                nome: '',
                linhagem: '',
                alternativo: '',
                integridade: 0,
                apFisica: 0,
                apMental: 0,
                deslocamento: 0,
                inicitativa: 0,
                baseOfensiva: 0,
                basePoder: 0,
                guarda: 0,
                carga: 0,
                especiesPersonagem: {
                    id: 0,
                    nome: '',
                    descricao: ''
                },
                racasPersonagem: {
                    id: 0,
                    nome: '',
                    descricao: ''
                },
                etniasPersonagem: {
                    id: 0,
                    nome: '',
                    descricao: ''
                }
            },
        }
    },
    beforeMount: function () {
        let loader = this.$loading.show({});
        window.scrollTo(0, 0)
        criacaoServices.resumoPersonagem(this.inicializaPersonagem())
            .then((response) => {
                this.personagem = response.data
                this.personagem.nome = ''
            }).catch((error) => {
                utilServices.parseServerError(error, this);
            })
            .finally(() => {
                loader.hide();
            });
    },
    methods: {
        inicializaPersonagem() {
            let basePersonagem = {
                id_especie: this.prop_Especie.id,
                id_raca: this.prop_Raca.id,
                id_etnia: this.prop_Etnia.id,
                id_qualidade: this.prop_Qualidade.id,
                id_defeito: this.prop_Defeito.id,
                id_trein1: this.prop_Trn1.id,
                id_trein2: this.prop_Trn2.id,
                id_trein3: this.prop_Trn3.id
            }
            return basePersonagem
        },

        save() {
            let loader = this.$loading.show({});  

            let objPersonagem = this.utilPersonagem.personagemFilter(settings.user.username,
                                                                    this.personagem.nome,
                                                                    this.personagem.linhagem,
                                                                    this.personagem.alternativo,
                                                                    this.prop_Especie.id,
                                                                    this.prop_Raca.id,
                                                                    this.prop_Etnia.id,
                                                                    this.prop_Qualidade.id,
                                                                    this.prop_Defeito.id,
                                                                    this.prop_Trn1,
                                                                    this.prop_Trn2,
                                                                    this.prop_Trn3,
                                                                    this.prop_Con)
            personagemServices.save(objPersonagem)
                .then((response) => {
                    if(response.data.id > 0){
                        utilServices.success( response.data.nome + ' criada com sucesso!', this) 
                        this.$router.push({path: '/personagens/list'})
                    }
                }).catch((error) => {
                    utilServices.parseServerError(error, this);
                })
                .finally(() => {
                    loader.hide();
                });

            }
        }
}
</script>

<style></style>




