<template>
    <div style="margin-left: 15px;">
        <div v-if="carregado">
            <div v-if="displayMesa == 'SOLICITA'" style="padding: 20px;">
                <b-jumbotron header="Acesse uma sala" lead="Este personagem não está em uma sala" class="jumbotron-orange">
                    <p>Insira o código da sala</p>
                    <b-form-input id="input-formatter" v-model="codigoAcessoSala" maxlength="15" @keypress="noSpace"
                        :formatter="formatter" placeholder="Insira o código da sala"></b-form-input>
                    <hr>
                    <CButton color="success" variant="outline" size="lg" class="align-middle" @click="solicitar()"
                        :disabled="valid()">
                        <p> Acessar Sala </p>
                    </CButton>
                </b-jumbotron>
            </div>
            <div v-if="displayMesa == 'PENDENTE'" style="padding: 20px;">
                <b-jumbotron header="Acesso Solicitado" :lead="sala.nome" class="jumbotron-orange">
                    <p>Aguardando resposta</p>
                    <CButton color="warning" variant="outline" size="lg" class="align-middle" @click="refresh()">
                        <p> Verificar</p>
                    </CButton>
                </b-jumbotron>
            </div>
            <div v-if="displayMesa == 'SUSPENSA'" style="padding: 20px;">
                <b-jumbotron header="Sala desativada" :lead="sala.nome" class="jumbotron-orange">
                    <p>Aguarde o mestre reabrir a sala</p>
                    <CButton color="warning" variant="outline" size="lg" class="align-middle" @click="refresh()">
                        <p>Verificar</p>
                    </CButton>
                </b-jumbotron>
            </div>

            <div v-if="displayMesa == 'MESA'">
                <b-row class="row-title">
                    <h3>Campanha: <strong class="orange">{{ sala.nome }}</strong></h3>
                    <hr>
                </b-row>
                <b-row class="overflowx row-box">
                    <div class="enemy-card card-w" v-for="(inimigo, index) in inimigos" :key="index">
                        <b-list-group class="card-w align-items-center">
                            <b-button disabled class="transp" block style="border-color: rgba(255, 0, 0, 0.39);">
                                <b-img style="height: 100px; width: 100px;" :src="utilImage.getCommon('perfil')"></b-img>
                            </b-button>
                            <b-form-input class="text_center" style="width:100%;" disabled
                                v-model="inimigo.nome"></b-form-input>
                            <b-button-group>
                                <b-button disabled class="transp">
                                    <b-avatar class="icon" rounded size="2rem" :src="utilImage.getCommon('integridade_')">
                                    </b-avatar><span class="info-span">{{ inimigo.integridade }}</span>
                                </b-button>
                                <b-button disabled class="transp">
                                    <b-avatar class="icon" rounded size="2rem" :src="utilImage.getImage('combate/GD_PGD')">
                                    </b-avatar><span class="info-span">{{ inimigo.guarda }}</span>
                                </b-button>
                                <b-button disabled class="transp">
                                    <b-avatar class="icon" rounded size="2rem" :src="utilImage.getCommon('AD')">
                                    </b-avatar><span class="info-span" style="color: red;">{{ inimigo.AD }}</span>
                                </b-button>
                            </b-button-group>
                        </b-list-group>
                    </div>
                </b-row>
                <b-row class="overflowx row-box">
                    <div class="ally-card card-w" v-for="(aliado, index) in sala.personagens" :key="index">
                        <b-list-group class="card-w align-items-center">
                            <b-button disabled class="transp" block style="border-color: rgba(0, 255, 200, 0.39);">
                                <b-img style="height: 100px; width: 100px;" :src="utilImage.getCommon('perfil')"></b-img>
                            </b-button>
                            <b-form-input class="text_center" style="width:100%;" disabled
                                :value="displayNome(aliado)"></b-form-input>
                            <b-button-group>
                                <b-button disabled class="transp">
                                    <b-avatar class="icon" rounded size="2rem" :src="utilImage.getCommon('integridade_')">
                                    </b-avatar><span class="info-span">{{ aliado.integridade }}</span>
                                </b-button>
                                <b-button disabled class="transp">
                                    <b-avatar class="icon" rounded size="2rem" :src="utilImage.getImage('combate/GD_PGD')">
                                    </b-avatar><span class="info-span">{{ displayGuarda(aliado) }}</span>
                                </b-button>
                                <b-button disabled class="transp">
                                    <b-avatar class="icon" rounded size="2rem" :src="utilImage.getCommon('AD')">
                                    </b-avatar><span class="info-span" style="color: red;">{{ displayAD(aliado) }}</span>
                                </b-button>
                            </b-button-group>
                        </b-list-group>
                    </div>
                </b-row>
            </div>
        </div>
        <div v-else style="height: 200px; align-items: center;" class="d-flex justify-content-center" >
            <b-icon icon="hourglass-split" animation="fade" font-scale="4"></b-icon>
        </div>
    </div>
</template>

<!-- <b-popover target="popover-target-1" triggers="hover" placement="top">
<b-button-group> 
    <b-button disabled class="transp">
        <b-avatar class="icon" rounded size="2rem"
        :src="utilImage.getCommon('integridade_')">
        </b-avatar><span class="info-span">2</span>
    </b-button>                   
    <b-button disabled class="transp">
        <b-avatar class="icon" rounded size="2rem"
        :src="utilImage.getImage('combate/GD_PGD')">
        </b-avatar><span class="info-span">8/13</span>
    </b-button>
    <b-button disabled class="transp">
        <b-avatar class="icon" rounded size="2rem"
        :src="utilImage.getCommon('AD')">
        </b-avatar><span class="info-span">2</span>
    </b-button>
</b-button-group>
<b-button-group> 
    <b-button disabled class="transp">
        <b-avatar class="icon" rounded size="1rem"
        :src="utilImage.getCommon('r_post')">
        </b-avatar><span class="info-redut-span">2</span>
    </b-button>                   
    <b-button disabled class="transp">
        <b-avatar class="icon" rounded size="1rem"
        :src="utilImage.getCommon('r_cansaco')">
        </b-avatar><span class="info-redut-span">2</span>
    </b-button>
    <b-button disabled class="transp">
        <b-avatar class="icon" rounded size="1rem"
        :src="utilImage.getCommon('r_estre')">
        </b-avatar><span class="info-redut-span">2</span>
    </b-button>
    <b-button disabled class="transp">
        <b-avatar class="icon" rounded size="1rem"
        :src="utilImage.getCommon('r_nece')">
        </b-avatar><span class="info-redut-span">2</span>
    </b-button>                   
    <b-button disabled class="transp">
        <b-avatar class="icon" rounded size="1rem"
        :src="utilImage.getCommon('r_feri')">
        </b-avatar><span class="info-redut-span">2</span>
    </b-button>
    <b-button disabled class="transp">
        <b-avatar class="icon" rounded size="1rem"
        :src="utilImage.getCommon('r_contm')">
        </b-avatar><span class="info-redut-span">2</span>
    </b-button>
</b-button-group>
</b-popover>    -->

<!-- <div class="item_guard_box d-flex align-items-center">
        <b-avatar style="background-color: rgba(255, 255, 255, 0);" rounded size="2rem"
            :src="this.utilImage.getCommon('perfil')"></b-avatar>
        <span class="mr-auto nome_title text_one_line">Nome nome nome</span>
    </div>
    <div class="item_guard_box d-flex align-items-center">
        <b-avatar style="background-color: rgba(255, 255, 255, 0);" rounded size="2rem"
            :src="this.utilImage.getImage('combate/GD_PGD_')"></b-avatar>
        <span class="mr-auto info-span">8 / 13</span>
    </div> -->
            
<script>
import Image from "@/util/image";
import utilServices from '@/services/Util';
import salaServices from "@/services/Sala";
import teste from '@/components/Game/Button/ButtonTeste'

export default {
    name: 'Mesa',
    components: {
        teste,
        utilServices
    },
    data() {
        return {
            utilImage: Image,
            listTreinamento: [],
            codigoAcessoSala: '',
            isJogador: true,
            carregado: false,
            displayMesa: 'ACESS',
            inimigos: [
                { 'id': 0, 'nome': 'inimigo A', 'integridade': 3, 'guarda': '8/14', 'AD': 0 },
                { 'id': 1, 'nome': 'inimigo B', 'integridade': 2, 'guarda': '6/12', 'AD': 0 },
                { 'id': 2, 'nome': 'inimigo C', 'integridade': 1, 'guarda': '7/7', 'AD': 0 },
                { 'id': 3, 'nome': 'inimigo D', 'integridade': 2, 'guarda': '5/16', 'AD': 0 },
                { 'id': 0, 'nome': 'inimigo A', 'integridade': 3, 'guarda': '8/14', 'AD': 0 },
                { 'id': 1, 'nome': 'inimigo B', 'integridade': 2, 'guarda': '6/12', 'AD': 0 },
                { 'id': 2, 'nome': 'inimigo C', 'integridade': 1, 'guarda': '7/7', 'AD': 0 },
                { 'id': 3, 'nome': 'inimigo D', 'integridade': 2, 'guarda': '5/16', 'AD': 0 },
            ],

        }
    },

    computed: {
        personagem() {
            return this.$store.state.personagem;
        },

        sala() {
            return this.$store.state.sala;
        },

        barHSize() {
            return window.innerHeight * 0.25
        },
    },

    created: function () {
        let rota = this.$route.path
        let rotaJogador = '/game/jogador/'
        let rotaMestre = '/game/mestre/'

        if (rota.slice(0, rotaMestre.length) === rotaMestre) {
            this.isJogador = false
        } else
            if (rota.slice(0, rotaJogador.length) === rotaJogador) {
                this.isJogador = true
            }
    },

    beforeMount: function () {
        if (this.isJogador) {
            if (this.personagem.salaPersonagem.sala.id == 0) {
                this.displayMesa = 'SOLICITA'
            } else if (this.personagem.salaPersonagem.acesso == 'SO') {
                this.displayMesa = 'PENDENTE'
            } else if (this.personagem.salaPersonagem.sala.ativa == false) {
                this.displayMesa = 'SUSPENSA'
            } else {
                this.displayMesa = 'MESA'
            }
        } else {
            this.displayMesa = 'MESA'
        }
    },

    mounted() {
        this.carregado = true
    },

    methods: {

        select() {
            this.$router.push({ path: '/game/jogador/' + this.personagem.id })
        },

        armaIcon(nome) {
            return 'armas/' + nome;
        },

        formatter(value) {
            return value.toUpperCase()
        },

        refresh(){
            window.location.reload()
        },

        noSpace(event) {
            if (event.key === ' ') {
                event.preventDefault();
            }
        },

        solicitar() {
            let loader = this.$loading.show({});
            let salaSolicitada = {codigo: this.codigoAcessoSala}
            salaServices.solicitarAcesso(this.personagem.id, salaSolicitada)
                .then((response) => {
                    this.displayMesa = 'PENDENTE'
                    this.updateSalabyPersonagem(this.personagem.id)                    
                }).catch((error) => {
                    utilServices.parseServerError(error, this);
                })
                .finally(() => {
                    loader.hide();
                });

        },

        async updateSalabyPersonagem(idPersonagem) {
            await this.$store.dispatch('updateSalabyPersonagem', idPersonagem);
        },

        valid() {
            if (this.codigoAcessoSala.length > 3) {
                return false;
            } else {
                return true;
            }
        },

        displayNome(personagem) {
            let nome = personagem.nome + ' ' + personagem.linhagem
            if ((personagem.alternativo.length > 0) && (personagem.alternativo != '') && (personagem.alternativo != ' ')) {
                nome = nome + ' (' + personagem.alternativo + ')';
            }
            return nome;
        },

        displayGuarda(personagem) {
            return personagem.guardaAtual + '/' + personagem.posguarda;
        },

        displayAD(personagem) {
            let AD = personagem.salaPersonagem.rdt_postura +
                personagem.salaPersonagem.rdt_cansaco +
                personagem.salaPersonagem.rdt_estresse +
                personagem.salaPersonagem.rdt_necessidade +
                personagem.salaPersonagem.rdt_ferimento +
                personagem.salaPersonagem.rdt_contaminacao
            return 0 - AD;
        }
    }
}
</script>

<style>
.row-title {
    margin-left: 5px;
}

.row-box {
    display: flex;
    flex-wrap: nowrap;
    padding: 5px;
}

.pers-name {
    padding: 0px !important;
    color: rgb(137, 122, 179) !important;
    background-color: rgba(255, 255, 255, 0) !important;
}

.card-w {
    width: 230px !important;
}

.enemy-card {
    border-radius: 3px;
    margin: 5px;
    padding: 0px;
}

.ally-card {
    border-radius: 3px;
    margin: 5px;
    padding: 0px;
}

.nome_title {
    width: 100%;
    justify-content: center;
    color: rgba(255, 0, 0, 0.377);
    font-size: 18px;
    font-weight: bold;
    margin-left: 5px;
}

.info-span {
    font-size: 20px;
    padding: 0px 10px 0px 10px;
    font-weight: bold;
    color: #2bd6d4ff;
}

.info-redut-span {
    font-size: 15px;
    color: rgba(255, 0, 0, 0.89);
}

.icon {
    background-color: rgba(255, 255, 255, 0);
    padding: 2px;
}
</style>