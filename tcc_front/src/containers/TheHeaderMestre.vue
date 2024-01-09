<template>
  <CHeader fixed light class="my-app header-box">
    <CToggler in-header class="ml-3 d-lg-none" @click="$store.commit('toggleSidebarMobile')" />
    <CToggler in-header class="ml-3 d-md-down-none" @click="$store.commit('toggleSidebarDesktop')" />

    <div id="box" class="gameplay-header-item d-flex justify-content-end">

      <b-list-group horizontal style="height: 45px;" button class="status-list-group">
        <b-list-group-item class="d-flex align-items-center" button v-b-toggle.galeria>
          <b-avatar class="status-avatar" rounded size="2rem" :src="this.utilImage.getCommon('galeria')"></b-avatar>
        </b-list-group-item>
      </b-list-group>

      <b-list-group horizontal style="height: 45px;" button class="status-list-group">
        <b-list-group-item class="d-flex align-items-center" button v-b-toggle.notes>
          <b-avatar class="status-avatar" rounded size="2rem" :src="this.utilImage.getCommon('notes')"></b-avatar>
        </b-list-group-item>
      </b-list-group>

      <b-button class="input_totalWH button_nome" size="sm" v-b-toggle.info>
        <b-form-input placeholder="Pesquise por regras, locais, criaturas, itens, magias, armas, etc"></b-form-input>
      </b-button>

      <b-list-group horizontal style="height: 45px;" button class="status-list-group">
        <b-list-group-item class="d-flex align-items-center" button v-b-toggle.add>
          <b-avatar class="status-avatar" rounded size="2rem" :src="this.utilImage.getCommon('addNPC')"></b-avatar>
        </b-list-group-item>
      </b-list-group>

      <b-list-group horizontal style="height: 45px;" button class="status-list-group">
        <b-list-group-item class="d-flex align-items-center" button v-b-toggle.testes>
          <b-avatar class="status-avatar" rounded size="2rem" :src="this.utilImage.getCommon('d20')"></b-avatar>
        </b-list-group-item>
      </b-list-group>

      <b-list-group horizontal style="height: 45px;" button class="status-list-group">
        <b-list-group-item class="d-flex align-items-center" button v-b-toggle.acesso>
          <b-avatar class="status-avatar" rounded size="2rem" :src="this.utilImage.getCommon('usuarios')"></b-avatar>
          <b-badge v-if="carregado">{{ this.sala.solicitacoes.length }}</b-badge>
        </b-list-group-item>
      </b-list-group>
    </div>

    <b-sidebar id="acesso" right :width="sidebarWSize" backdrop backdrop-variant="dark">
      <template #header>
        <div style="width: 100%;">
          <b-button-group class="mx-1 d-flex justify-content-center">
            <b-button v-b-toggle.acesso class="btn_just_icon" style="color:#d11d10;"><b-icon icon="x"
                aria-hidden="true"></b-icon>
            </b-button>
          </b-button-group>
        </div>
      </template>
      <div v-if="carregado">
        <TheSidebarAcessoMestre></TheSidebarAcessoMestre>
      </div>
    </b-sidebar>

    <b-sidebar id="add" right :width="sidebarWSize" backdrop backdrop-variant="dark">
      <template #header>
        <div style="width: 100%;">
          <b-button-group class="mx-1 d-flex justify-content-center">
            <b-button v-b-toggle.add class="btn_just_icon" style="color:#d11d10;"><b-icon icon="x"
                aria-hidden="true"></b-icon>
            </b-button>
          </b-button-group>
        </div>
      </template>
      <div v-if="carregado">
        <TheSidebarAddNPCMestre></TheSidebarAddNPCMestre>
      </div>
    </b-sidebar>

    <b-sidebar id="testes" right :width="bigSidebarWSize" backdrop backdrop-variant="dark">
      <template #header>
        <div style="width: 100%;">
          <b-button-group class="mx-1 d-flex justify-content-center">
            <b-button v-b-toggle.testes class="btn_just_icon" style="color:#d11d10;">
              <b-icon icon="x"></b-icon>
            </b-button>
          </b-button-group>
        </div>
      </template>
      <div v-if="carregado">
        <TheSidebarSolicitaTestesMestre></TheSidebarSolicitaTestesMestre>
      </div>
    </b-sidebar>

    <b-sidebar id="notes" right :width="sidebarWSize" backdrop backdrop-variant="dark">
      <template #header>
        <div style="width: 100%;">
          <b-button-group class="mx-1 d-flex justify-content-center">
            <b-button v-b-toggle.notes class="btn_just_icon" style="color:#d11d10;"><b-icon icon="x"
                aria-hidden="true"></b-icon>
            </b-button>
          </b-button-group>
        </div>
      </template>
      <div v-if="carregado">
        <TheSidebarNotesMestre></TheSidebarNotesMestre>
      </div>
    </b-sidebar>

    <b-sidebar id="galeria" right :width="sidebarWSize" backdrop backdrop-variant="dark">
      <template #header>
        <div style="width: 100%;">
          <b-button-group class="mx-1 d-flex justify-content-center">
            <b-button v-b-toggle.galeria class="btn_just_icon" style="color:#d11d10;"><b-icon icon="x"
                aria-hidden="true"></b-icon>
            </b-button>
          </b-button-group>
        </div>
      </template>
      <div v-if="carregado">
        <TheSidebarGaleriaMestre></TheSidebarGaleriaMestre>
      </div>
    </b-sidebar>
  </CHeader>
</template>

<script>
import TheSidebarSolicitaTestesMestre from './Sidebars/Mestre/SolicitaTestes.vue'
import TheSidebarNotesMestre from './Sidebars/Mestre/Notes.vue'
import TheSidebarGaleriaMestre from './Sidebars/Mestre/Galeria.vue'
import TheSidebarAcessoMestre from './Sidebars/Mestre/Acessos.vue'
import TheSidebarAddNPCMestre from './Sidebars/Mestre/AddNPC.vue'
import Image from "@/util/image";
import settings from "@/settings";
import capUtil from "@/util/Capacidades";
import salaServices from "@/services/Sala";
import utilServices from '@/services/Util';
import SSE from "@/util/SSE";
import { http } from "@/services/config";

export default {
  name: 'TheHeaderPersonagem',
  components: {
    TheSidebarSolicitaTestesMestre,
    TheSidebarAddNPCMestre,
    TheSidebarNotesMestre,
    TheSidebarGaleriaMestre,
    TheSidebarAcessoMestre,
    salaServices,
    utilServices,
    settings,
    capUtil,
    SSE
  },


  computed: {

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

  data() {
    return {
      utilImage: Image,
      carregado: false,
      idSala: 0,
      historicoCapacidades: [],
      loader: this.$loading.show({})
    }
  },

  created: function () {
    if (this.$route.params.idSala == null) {
      this.$router.push({ path: '/sala/list' })
    } else {
      this.idSala = parseInt(this.$route.params.idSala);
    }
  },

  beforeMount: async function () {
    this.subSala()
  },

  mounted: function () {
    setTimeout(() => {
      this.loader.hide();
      this.carregado = true
    }, 1000);
  },

  methods: {

    async subSala() {
      this.$store.dispatch('subSala');
    },

  }
}
</script>
<style scoped>
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
