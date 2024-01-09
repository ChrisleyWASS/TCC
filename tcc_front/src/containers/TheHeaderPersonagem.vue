<template>
  <CHeader fixed light class="my-app header-box">
    <CToggler in-header class="ml-3 d-lg-none" @click="$store.commit('toggleSidebarMobile')" />
    <CToggler in-header class="ml-3 d-md-down-none" @click="$store.commit('toggleSidebarDesktop')" />

    <div id="box" class="gameplay-header-item d-flex justify-content-start">

      <b-list-group horizontal style="height: 45px; background-color: #d11d1023;">
        <b-list-group-item class="d-flex align-items-center" button v-b-toggle.redutores>
          <b-avatar class="status-avatar" rounded size="2rem" :src="this.utilImage.getCommon('AD')"></b-avatar>
          <span class="ml-3" style="font-size: 35px; color: red;">
            {{ this.AD }}
          </span>
        </b-list-group-item>
      </b-list-group>

      <b-list-group horizontal style="height: 45px;" button v-b-toggle.status class="status-list-group">
        <b-list-group-item class="d-flex align-items-center">
          <b-avatar class="status-avatar" rounded size="2rem" :src="this.utilImage.getCommon('integridade_')"></b-avatar>
          <span class="ml-3" style="font-size: 35px;">
            {{ personagem.integridade }}
          </span>
        </b-list-group-item>

        <b-list-group-item class="d-flex align-items-center">
          <b-avatar class="status-avatar" rounded size="2rem" :src="this.utilImage.getCommon('apf_')"></b-avatar>
          <span class="ml-3" style="font-size: 35px;">
            {{ personagem.apFisica }}
          </span>
        </b-list-group-item>

        <b-list-group-item class="d-flex align-items-center">
          <b-avatar class="status-avatar" rounded size="2rem" :src="this.utilImage.getCommon('apm_')"></b-avatar>
          <span class="ml-3" style="font-size: 35px;">
            {{ personagem.apMental }}
          </span>
        </b-list-group-item>
      </b-list-group>

      <b-button class="input_totalWH button_nome" size="sm" v-b-toggle.info>
        <b-form-input class="input_totalWH" disabled v-model="nome_completo">
        </b-form-input></b-button>
    </div>

    <b-sidebar id="status" right :width="bigSidebarWSize" backdrop backdrop-variant="dark">
      <template #header>
        <div style="width: 100%;">
          <b-button-group class="mx-1 d-flex justify-content-center">
            <b-button v-b-toggle.status class="btn_just_icon" style="color:#d11d10;"><b-icon icon="x"
                aria-hidden="true"></b-icon>
            </b-button>
          </b-button-group>
        </div>
      </template>
      <div v-if="carregado">
        <TheSidebarStatusPersonagem></TheSidebarStatusPersonagem>
      </div>
    </b-sidebar>

    <b-sidebar id="redutores" right :width="sidebarWSize" backdrop backdrop-variant="dark">
      <template #header>
        <div style="width: 100%;">
          <b-button-group class="mx-1 d-flex justify-content-center">
            <b-button v-b-toggle.redutores class="btn_just_icon" style="color:#d11d10;"><b-icon icon="x"
                aria-hidden="true"></b-icon>
            </b-button>
          </b-button-group>
        </div>
      </template>
      <div v-if="carregado">
        <TheSidebarRedutoresPersonagem></TheSidebarRedutoresPersonagem>
      </div>
    </b-sidebar>

    <b-sidebar id="info" right :width="sidebarWSize" backdrop backdrop-variant="dark">
      <template #header>
        <div style="width: 100%;">
          <b-button-group class="mx-1 d-flex justify-content-center">
            <b-button v-b-toggle.info class="btn_just_icon" style="color:#d11d10;"><b-icon icon="x"
                aria-hidden="true"></b-icon>
            </b-button>
          </b-button-group>
        </div>
      </template>
      <div v-if="carregado">
        <TheSidebarInfoPersonagem></TheSidebarInfoPersonagem>
      </div>
    </b-sidebar>
  </CHeader>
</template>

<script>
import TheSidebarStatusPersonagem from './Sidebars/Jogador/StatusPersonagem.vue'
import TheSidebarRedutoresPersonagem from './Sidebars/Jogador/Redutores.vue'
import TheSidebarInfoPersonagem from './Sidebars/Jogador/InfoPersonagem.vue'
import { http } from "@/services/config";
import Image from "@/util/image";
import settings from "@/settings";
import capUtil from "@/util/Capacidades";
import setState from "@/util/Update";
import personagemServices from "@/services/Personagem";
import salaServices from "@/services/Sala";
import utilServices from '@/services/Util';

export default {
  name: 'TheHeaderPersonagem',
  components: {
    TheSidebarStatusPersonagem,
    TheSidebarRedutoresPersonagem,
    TheSidebarInfoPersonagem,
    personagemServices,
    salaServices,
    utilServices,
    settings,
    capUtil,
    setState
  },

  computed: {

    personagem() {
      return this.$store.state.personagem;
    },

    sala() {
      return this.$store.state.sala;
    },

    sidebarWSize() {
      if (window.innerWidth < 992) {
        return '50%';
      } else {
        return '30%';
      }
    },

    bigSidebarWSize() {
      if (window.innerWidth < 992) {
        return '90%';
      } else {
        return '50%';
      }
    },
  },

  watch: {
    personagem: {
      immediate: true,
      handler(newPersonagem, oldPersonagem) {
        if(this.personagem.id > 0){
          this.nome_completo = this.personagem.nome + ' ' + this.personagem.linhagem + ' (' + this.personagem.alternativo + ')'
          this.carregaAdversidade()
        }        
      },
    },
  },

  data() {
    return {
      utilImage: Image,
      carregado: false,
      idPersonagem: 0,
      AD: 0,
      nome_completo: '',
      historicoCapacidades: [],
      loader: this.$loading.show({})
    }
  },

  created: function () {
    this.nomeWSize();
    if (this.$route.params.idPersonagem == null) {
      this.$router.push({ path: '/personagens/list' })
    } else {
      this.idPersonagem = parseInt(this.$route.params.idPersonagem);
    }
  },

  beforeMount: async function () {   
    settings.conexao.ativa = true
  },

  mounted: async function () {
    setTimeout(() => {
      this.nome_completo = this.personagem.nome + ' ' + this.personagem.linhagem + ' (' + this.personagem.alternativo + ')'
      this.carregaAdversidade()      
      this.subSala()
      this.loader.hide();
      this.carregado = true
    }, 1000);
  },
  
  methods: {

    async subSala() {
      this.$store.dispatch('subSala');
    },

    nomeWSize() {
      let space = window.innerWidth - (0.6 * window.innerWidth)
      return (window.innerWidth - space)
    },

    carregaAdversidade() {
      this.AD = this.personagem.salaPersonagem.rdt_postura +
        this.personagem.salaPersonagem.rdt_cansaco +
        this.personagem.salaPersonagem.rdt_estresse +
        this.personagem.salaPersonagem.rdt_necessidade +
        this.personagem.salaPersonagem.rdt_ferimento +
        this.personagem.salaPersonagem.rdt_contaminacao

      this.AD = 0 - this.AD
    },

  }
}
</script>
<style>
.header-box {
  display: flex;
  align-items: center;
}

.button_nome {
  height: 40px;
  padding: 0px;
  background-color: #00000000;
  border-color: #00000000;
}
</style>
