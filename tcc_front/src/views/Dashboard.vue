<template>
  <div>
    <!-- <div style="position: absolute; z-index: 0; width: 100%; height: 250px;
      background-image: url('/img/wallpaper/MAPz.png'); 
      background-position: center;
      background-repeat: no-repeat;
      background-size: cover;"></div> 
    style="position: absolute; z-index: 0;-->


    <b-row v-if="isMobile">
      <b-col sm="12">
        <b-card class="my-card" style="background-image: url('/img/wallpaper/MAPt.png'); 
          background-position: center;
          background-repeat: no-repeat;
          background-size: cover;
          text-shadow: 2px 2px #3c1e90ff;
          font-family: Helvetica, sans-serif;
          padding-right: 25px;">
          <h1>Mysthen</h1>
          <p>Uma experiência RPG</p>
          <hr>
          <CButton color="success" variant="outline" size="lg" class="align-middle"
            style="background-color: rgb(0 0 0 / 50%);">
            Sobre o Projeto
          </CButton>
        </b-card>
      </b-col>
    </b-row>

    <b-row v-else>
      <b-col sm="12">
        <b-card class="my-card">
          <b-row>
            <b-col>
              <b-jumbotron header="Mysthen" lead="Uma experiênia RPG" class="jumbotron-no-border">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget metus egestas, rhoncus nisi id,
                  tincidunt dolor. Sed non metus non turpis gravida placerat sit amet eget purus. Ut in placerat dui, eu
                  blandit urna. Morbi egestas nulla sed leo vestibulum, ac suscipit elit tempor.</p>
                <hr>
                <CButton color="success" variant="outline" size="lg" class="align-middle"
                  style="background-color: rgb(0 0 0 / 50%);">
                  Sobre o Projeto
                </CButton>                
              </b-jumbotron>
            </b-col>
            <b-col sm="12" md="6" lg="6" xl="8">
              <div style="display: flex; align-items: center;">
                <b-img :src="this.utilImage.getCapa('MAPz')" fluid-grow style=" max-height: 100%; max-width: 100%;"></b-img>
              </div>
            </b-col>
          </b-row>
        </b-card>
      </b-col>
    </b-row>

    <b-row class="d-flex align-items-stretch">
      <b-col xs="12" md="6" lg="3" style="padding-bottom: 5px;" v-bind:style="{ height: blockHeight + 'px' }">
          <CButton @click="routeTo(1)" color="success" variant="outline" size="lg" block style="text-align: start;height: 100%;">
            <b-avatar button class="my-avatar" icon="person-plus"></b-avatar>
            <label style="padding-left: 10px;" >Criar Personagem<br></label>
            <label style="font-size: small;">Através do seu personagem você embarca
                                             em grandes aventuras, superar desafios e vive momentos inesqucíveis!</label>
          </CButton>             
      </b-col>
      <b-col xs="12" md="6" lg="3" style="padding-bottom: 5px;" v-bind:style="{ height: blockHeight + 'px' }">
          <CButton @click="routeTo(2)" color="success" variant="outline" size="lg" block style="text-align: start;height: 100%;">
            <b-avatar button class="my-avatar" icon="list-stars"></b-avatar>
            <label style="padding-left: 10px;">Meus Personagens<br></label>
            <label style="font-size: small;">Aqui você acompanha a evolução do personagem, planeja suas proximas habilidades, 
                                                           administra seus itens, etc.</label>
          </CButton>             
      </b-col>     
      <b-col xs="12" md="6" lg="3" style="padding-bottom: 5px;" v-bind:style="{ height: blockHeight + 'px' }">
          <CButton @click="routeTo(3)" color="success" variant="outline" size="lg" block style="text-align: start;height: 100%;">
            <b-avatar button class="my-avatar" icon="play"></b-avatar>
            <label style="padding-left: 10px;">Salas de Jogo<br></label>
            <label style="font-size: small;">Que retomar uma partida em curso ou vai começar uma nova?
                                                           Clique aqui, a aventura não pode parar!</label>
          </CButton>          
      </b-col>
      <b-col xs="12" md="6" lg="3" style="padding-bottom: 5px;" v-bind:style="{ height: blockHeight + 'px' }">
          <CButton color="success" variant="outline" size="lg" block style="text-align: start;height: 100%;">
            <b-avatar button class="my-avatar" icon="info"></b-avatar>
            <label style="padding-left: 10px;">Tire suas dúvidas<br></label>
            <label style="font-size: small;">Novo por aqui? Seja bem vindo(a)! 
                                                           Clique para conhecer o funcionamento do jogo e
                                                           como utilizar esta plataforma.</label>
          </CButton>          
      </b-col>  
    </b-row>
  </div>
</template>

<script>
import MainChartExample from './charts/MainChartExample'
import WidgetsDropdown from './widgets/WidgetsDropdown'
import WidgetsBrand from './widgets/WidgetsBrand'
import Image from "@/util/image";
import SSE from "@/util/SSE";

import LoginService from "@/services/Login";

import utilServices from '@/services/Util';

export default {
  name: 'Dashboard',
  components: {
    MainChartExample,
    WidgetsDropdown,
    WidgetsBrand,
    SSE
  },
  data() {
    return {
      utilImage: Image,
      isMobile: false,
      blockHeight: 150,
      closed: false,
    }
  },

  created(){
    this.sizeConfig() 
  },

  
  beforeMount: function () {
    window.addEventListener("resize", this.sizeConfig);
  },

  methods: {
    
    routeTo(destino){
      if(destino == 1){
        this.$router.push({path: '/personagens/new'})
      } else if(destino == 2){
        this.$router.push({path: '/personagens/list'})
      } else if(destino == 3){
        this.$router.push({path: '/sala/list'})
      }
    },

    sizeConfig(){   
      var screenWidth = window.innerWidth
      if (screenWidth < 576) {        //'sm'
      this.isMobile = true
      this.blockHeight = 150 
      } else if (screenWidth < 768) { //'md'
      this.isMobile = true
      this.blockHeight = 150         
      } else if (screenWidth < 992) { //'lg'
      this.isMobile = false
      this.blockHeight = 200         
      } else {                       //'xl'
      this.isMobile = false
      this.blockHeight = 200         
      }
  },
    
}
}
</script>
