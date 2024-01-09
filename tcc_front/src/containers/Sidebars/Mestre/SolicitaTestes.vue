<template>
  <div class="px-3 py-0">
    <h2 class="orange">Solicitar Testes</h2>
    <hr>
    <span class="ND-text white">Nível de Dificuldade (ND): </span>
    <span class="ND-number orange">{{ ND }}</span>
    <div>
      <b-input-group>
        <b-input-group-prepend>
          <b-button style="width: 40px;" variant="outline-success" @click="subND()">-</b-button>
        </b-input-group-prepend>
        <b-form-input v-model="ND" type="range" autofocus min="0" max="25"></b-form-input>
        <b-input-group-append>
          <b-button style="width: 40px;" variant="outline-success" @click="addND()">+</b-button>
        </b-input-group-append>
      </b-input-group>
    </div>
    <div>
      <b-button-group class="fullW">
        <b-button @click="setND(5)">05</b-button>
        <b-button @click="setND(10)">10</b-button>
        <b-button @click="setND(12)">12</b-button>
        <b-button @click="setND(14)">14</b-button>
        <b-button @click="setND(16)">16</b-button>
        <b-button @click="setND(18)">18</b-button>
        <b-button @click="setND(20)">20</b-button>
        <b-button @click="setND(23)">23</b-button>
      </b-button-group>
    </div>
    <hr>
    <span class="ND-text white">Teste de resisitência a redutores </span>

    <b-list-group style="width: 100%" class="orange" horizontal>
      <b-list-group-item class="d-flex align-items-center">
        <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
          :src="this.utilImage.getCommon('r_post')">
        </b-avatar>
        <span class="ml-3 redutorSize" style="font-size: 22px;">Postura</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('POSTURA', 'DSV', 'r_post')">
        <span style="font-size: 18px;">DSV</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('POSTURA', 'MOB', 'r_post')">
        <span style="font-size: 18px;">MOB</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('POSTURA', 'RES', 'r_post')">
        <span style="font-size: 18px;">RES</span>
      </b-list-group-item>
    </b-list-group>

    <b-list-group style="width: 100%" class="orange" horizontal>
      <b-list-group-item class="d-flex align-items-center">
        <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
          :src="this.utilImage.getCommon('r_cansaco')">
        </b-avatar>
        <span class="ml-3 redutorSize" style="font-size: 22px;">Cansaço</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('CANSACO', 'VIG', 'r_cansaco')">
        <span style="font-size: 18px;">VIG</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('CANSACO', 'RES', 'r_cansaco')">
        <span style="font-size: 18px;">RES</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('CANSACO', 'OBT', 'r_cansaco')">
        <span style="font-size: 18px;">OBT</span>
      </b-list-group-item>
    </b-list-group>

    <b-list-group style="width: 100%" class="orange" horizontal>
      <b-list-group-item class="d-flex align-items-center">
        <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
          :src="this.utilImage.getCommon('r_estre')">
        </b-avatar>
        <span class="ml-3 redutorSize" style="font-size: 22px;">Estresse</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('ESTRESSE', 'RAZ', 'r_estre')">
        <span style="font-size: 18px;">RAZ</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('ESTRESSE', 'OBT', 'r_estre')">
        <span style="font-size: 18px;">OBT</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('ESTRESSE', 'TNA', 'r_estre')">
        <span style="font-size: 18px;">TNA</span>
      </b-list-group-item>
    </b-list-group>

    <b-list-group style="width: 100%" class="orange" horizontal>
      <b-list-group-item class="d-flex align-items-center">
        <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
          :src="this.utilImage.getCommon('r_nece')">
        </b-avatar>
        <span class="ml-3 redutorSize" style="font-size: 22px;">Necessidade</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('NECESSIDADE', 'TNA', 'r_nece')">
        <span style="font-size: 18px;">TNA</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('NECESSIDADE', 'OBT', 'r_nece')">
        <span style="font-size: 18px;">OBT</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('NECESSIDADE', 'RAZ', 'r_nece')">
        <span style="font-size: 18px;">RAZ</span>
      </b-list-group-item>
    </b-list-group>

    <b-list-group style="width: 100%" class="orange" horizontal>
      <b-list-group-item class="d-flex align-items-center">
        <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
          :src="this.utilImage.getCommon('r_feri')">
        </b-avatar>
        <span class="ml-3 redutorSize" style="font-size: 22px;">Ferimento</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('FERIMENTO', 'TNA', 'r_feri')">
        <span style="font-size: 18px;">TNA</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('FERIMENTO', 'OBT', 'r_feri')">
        <span style="font-size: 18px;">OBT</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('FERIMENTO', 'RES', 'r_feri')">
        <span style="font-size: 18px;">RES</span>
      </b-list-group-item>
    </b-list-group>

    <b-list-group style="width: 100%" class="orange" horizontal>
      <b-list-group-item class="d-flex align-items-center">
        <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
          :src="this.utilImage.getCommon('r_contm')">
        </b-avatar>
        <span class="ml-3 redutorSize" style="font-size: 22px;">Contaminação</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('CONTAMINACAO', 'IMD', 'r_contm')">
        <span style="font-size: 18px;">IMD</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('CONTAMINACAO', 'TNA', 'r_contm')">
        <span style="font-size: 18px;">TNA</span>
      </b-list-group-item>
      <b-list-group-item style="text-align: center;" button @click="testar('CONTAMINACAO', 'OBT', 'r_contm')">
        <span style="font-size: 18px;">OBT</span>
      </b-list-group-item>
    </b-list-group>

    <div style="height: 30px;">
    </div>

    <b-modal id="selectAlvos" hide-header hide-footer size="lg">
      <div class="d-flex align-items-center text_center centralize">
        <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="3rem"
          :src="this.utilImage.getCommon(this.icon)">
        </b-avatar>
        <span class="title-redutor ml-3">Redutor {{ redutor }}</span>
      </div>
      <hr>

      <div v-for="(item, index) in sala.autorizados" :key="index" class="fullW">
        <b-list-group style="width: 100%" horizontal>
          <b-list-group-item style="text-align: center; width: 90%;" class="d-flex align-items-center text_one_line">
            <div class="text_center fullW">
              <span class="redutorSize" style="font-size: 18px;">{{ item.personagem.nome }} {{
                item.personagem.nome_linhagem }} ({{ item.usuario.nome }})</span>
            </div>
          </b-list-group-item>
          <b-list-group-item style="text-align: center;">
            <b-form-checkbox size="lg" :value="item.personagem.id" v-model="idsPersonagens"></b-form-checkbox>
          </b-list-group-item>
        </b-list-group>
      </div>
      <hr>
      <div class="text_center fullW">
        <CButton color="success" variant="outline" size="lg" class="align-middle" :disabled="idsPersonagens.length == ''"
          @click="testeRedutor()">
          <p> Solicitar teste de <span class="orange">{{ testeResist }} ND{{ ND }} </span></p>
        </CButton>
      </div>
      <hr>
      
      <div class="text_center">        
        <h2>Resultados</h2>
      </div>
      <div class="text_center" v-if="!showResults" style="height: 100px;">        
        <span>Os resultados do teste serão exibidos aqui</span>
      </div>
      <div class="text_center" v-else-if="resultados.length == 0">        
        <div style="height: 100px; align-items: center; color: #7c7dd1;" class="d-flex justify-content-center">
          <b-icon icon="hourglass-split" animation="fade" font-scale="4"></b-icon>
        </div>
        <span>Carregando resultados</span>
      </div>
      <div v-else>
        <div style="text-align: center;" v-for="(item, index) in resultados" :key="index" class="fullW">
          <b-list-group horizontal style="width: 100%">
            <b-list-group-item style="width: 50%" class="capacidades-item d-flex justify-content-center">
              <span style="font-size: 20px;" class="white">{{ item.nome }}</span>
            </b-list-group-item>
            <b-list-group-item style="width: 50%" class="capacidades-item">
              <div class="d-flex justify-content-center">
                <b-avatar class="icon" rounded size="2rem" :src="utilImage.getCommon('d20')"></b-avatar>
              <span style="font-size: 20px;" class="orange"><strong>{{ item.d20.toString().padStart(2, '0')
              }}</strong></span>
              </div>              
              <span v-if="item.d20 == 20" style="font-size: 16px;" class="verde">{{ " " }}<strong>CRÍTICO</strong></span>
              <span v-if="item.d20 == 1" style="font-size: 16px;" class="red">{{ " " }}<strong>ERRO CRÍTICO</strong></span>
            </b-list-group-item>
            <b-list-group-item style="width: 50%" class="capacidades-item d-flex justify-content-center">
              <span style="font-size: 20px;" class="white">{{ item.sigla }}</span>
              <span style="font-size: 20px;" class="orange"><strong>{{ isPositive(item.bonusCap) }}{{ item.bonusCap
              }}</strong></span>
            </b-list-group-item>
            <b-list-group-item style="width: 50%" class="capacidades-item d-flex justify-content-center">
              <b-avatar class="icon" rounded size="2rem" :src="utilImage.getCommon('AD')"></b-avatar>
              <span style="font-size: 20px;" class="red"><strong>-{{ item.ad }}</strong></span>
            </b-list-group-item>
            <b-list-group-item style="width: 50%" class="capacidades-item d-flex justify-content-center">
              <span style="font-size: 20px;" class="ciano mr-2"><strong>{{ item.result }}</strong></span>
            </b-list-group-item>
            <b-list-group-item style="width: 50%" class="capacidades-item d-flex justify-content-center">
              <span style="font-size: 20px;">
                <strong>{{ item.msgResult }}</strong>
              </span>
            </b-list-group-item>
          </b-list-group>
        </div>
      </div>
      
    </b-modal>
  </div>
</template>

<script>
import { http } from "@/services/config";
import Image from "@/util/image";
import settings from "@/settings";
import testeServices from "@/services/Teste";
export default {
  name: 'Sidebar_SolicitaTestes',
  components: {
    testeServices
  },
  props: {
    prop_personagem: {}
  },

  data() {
    return {
      showResults: false,
      utilImage: Image,
      ND: 10,
      redutor: "",
      testeResist: "",
      icon: "",
      idsPersonagens: [],
      resultados: [],
    }
  },
  computed: {
    sala() {
      return this.$store.state.sala;
    },
    show() {
      return this.$store.state.sidebarShow
    },
    minimize() {
      return this.$store.state.sidebarMinimize
    }
  },
  mounted() {
    this.$store.state.sidebarMinimize = true
  },
  methods: {
    testar(redutor, teste, icon) {
      this.resultados = []
      this.idsPersonagens = [];
      this.showResults = false;
      this.sala.personagens.forEach(element => {
        this.idsPersonagens.push(element.id)
      });
      this.redutor = redutor
      this.testeResist = teste
      this.icon = icon
      this.$bvModal.show('selectAlvos')
    },

    testeRedutor() {
      this.showResults = true
      let loader = this.$loading.show({})
      let teste = {
        redutor: this.redutor,
        tipo: this.testeResist,
        dificuldade: this.ND,
        idsPersonagens: this.idsPersonagens
      }
      testeServices.testeRedutor(this.sala.id, teste)
        .then((response) => {
          this.resultados = response.data          
        }).catch((error) => {
          utilServices.parseServerError(error, this);
        })
        .finally(() => {
          loader.hide();
        });
    },

    selectPersonagem() {
      this.idsPersonagens = this.selectedItems;
    },

    isPositive(value) {
      if (value >= 0) {
        return '+'
      } else {
        return ''
      }
    },

    setND(value) {
      this.ND = value
    },

    addND() {
      if (this.ND < 25) {
        this.ND++
      }
    },

    subND() {
      if (this.ND > 0) {
        this.ND--
      }
    },
  }

}
</script>

<style scoped>
.ND-number {
  font-size: 20px;
  font-weight: bolder;
}

.ND-text {
  font-size: 18px;
}

.title-redutor {
  font-size: 30px;
  font-weight: bold;
}

.centralize {
  justify-content: center !important;
}

.redutorSize {
  width: 150px !important;

}</style>
