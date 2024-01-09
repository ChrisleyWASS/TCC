<template>
    <div>
        <b-row>
            <b-col md="4" lg="3" style="height: max-content;" v-b-toggle.combate >
                <b-card class="my-card-border d-flex align-items-center item_title">
                    <span>BASE OFENSIVA</span>
                    <span class="orange"> {{ this.personagem.baseOfensivaAtual }}</span>
                </b-card>
                <b-card class="my-card-border d-flex align-items-center">
                    <div class="d-flex align-items-center iniciativa_title">
                        <span>INICIATIVA {{ this.personagem.inicitativaAtual }} </span>
                    </div>

                    <div class="item_guard_box d-flex align-items-center">
                        <b-avatar style="background-color: rgba(255, 255, 255, 0);" rounded size="5rem"
                            :src="this.utilImage.getImage('combate/GD_')"></b-avatar>
                        <span class="mr-auto guard_span">{{ this.personagem.guardaAtual }}</span>
                    </div>

                    <div class="item_guard_box d-flex align-items-center">
                        <b-avatar style="background-color: rgba(255, 255, 255, 0);" rounded size="5rem"
                            :src="this.utilImage.getImage('combate/PGD_')"></b-avatar>
                        <span class="mr-auto guard_span">{{ this.personagem.posguarda }}</span>
                    </div>
                </b-card>
            </b-col>
            <b-col class="fullH">
                <b-list-group horizontal style="width: 100%" v-for="(arma, index) in this.personagem.armas" :key="index">
                    <b-list-group-item style="width: 80%" class="capacidades-item">
                        <b-avatar class="arma_icon" rounded size="3rem"
                            :src="utilImage.getImage(armaIcon(arma.nome))"></b-avatar>
                        <span class="mr-auto arma_nome">{{ arma.nome }}</span>
                    </b-list-group-item>
                    <b-list-group-item style="width: 20%" button class="teste-item-button">
                        <teste :prop_value="arma.bonusAtaque"></teste>
                    </b-list-group-item>
                </b-list-group>
            </b-col>
        </b-row>

        <b-sidebar id="combate" right :width="sidebarWSize" backdrop backdrop-variant="dark" no-close-on-backdrop v-b-toggle.combate>
            <template #header>
                <div style="width: 100%;">
                    <b-button-group class="mx-1 d-flex justify-content-center">
                        <b-button class="btn_just_icon" style="color:#d11d10;">
                            <b-icon icon="x" aria-hidden="true"></b-icon>
                        </b-button>
                    </b-button-group>
                </div>
            </template>
            <div class="white" style="padding: 20px;">
                <h4>Guarda</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                    Fusce condimentum, tortor quis euismod tincidunt, sem tellus lacinia mi, 
                    at efficitur sem neque et neque. Ut dapibus aliquam magna vel laoreet. 
                    Nulla malesuada lectus auctor, facilisis ex sit amet, semper nisl. </p>

                <h4>Pós-Guarda</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                    Fusce condimentum, tortor quis euismod tincidunt, sem tellus lacinia mi, 
                    at efficitur sem neque et neque. Ut dapibus aliquam magna vel laoreet. 
                    Nulla malesuada lectus auctor, facilisis ex sit amet, semper nisl. </p>
                
                <h4>Iniciativa</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                    Fusce condimentum, tortor quis euismod tincidunt, sem tellus lacinia mi, 
                    at efficitur sem neque et neque. Ut dapibus aliquam magna vel laoreet. 
                    Nulla malesuada lectus auctor, facilisis ex sit amet, semper nisl. </p>
                
                <h4>Deslocamento</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                    Fusce condimentum, tortor quis euismod tincidunt, sem tellus lacinia mi, 
                    at efficitur sem neque et neque. Ut dapibus aliquam magna vel laoreet. 
                    Nulla malesuada lectus auctor, facilisis ex sit amet, semper nisl. </p>            
            </div>
        </b-sidebar>
    </div>
</template>


<script>
import Image from "@/util/image";
import teste from '@/components/Game/Button/ButtonTeste'

export default {
    name: 'Mesa',
    components: {
        teste,
    },
    data() {
        return {
            utilImage: Image,
            listTreinamento: [],
            selected: false,
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

        sidebarWSize() {
            if (window.innerWidth < 992) {
                return '50%';
            } else {
                return '30%';
            }
        }
    },

    mounted: function () {

    },

    methods: {

        select() {
            this.$router.push({ path: '/game/jogador/' + this.prop_personagem.id })
        },

        armaIcon(nome) {
            return 'armas/' + nome;
        }
    }
}
</script>

<style>
.item_guard_box {
    padding-bottom: 10px;
}

.item_title {
    justify-content: center;
    font-size: 15px;
    padding: 0px;
    margin: 0px;
    font-weight: bold;
}

.iniciativa_title {
    justify-content: center;
    color: #f39237ff;
    font-size: 18px;
    padding: 0px 10px 10px 10px;
}

.guard_span {
    font-size: 60px;
    padding: 0px 10px 0px 10px;
    font-weight: bold;
    color: #2bd6d4ff;
}

.protecao_span {
    font-size: 10px;
}

.arma_icon {
    padding: 5px;
    background-color: #f39237ff;
}

.arma_nome {
    font-size: 20px;
    padding: 0px 10px 0px 10px;
}
</style>