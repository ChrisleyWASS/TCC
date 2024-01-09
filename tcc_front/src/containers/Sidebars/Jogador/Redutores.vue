<template>
  <div class="px-3 py-0">

    <b-row>
      <b-list-group style="width: 100%" class="orange">        
        <b-list-group-item class="d-flex align-items-center d-flex justify-content-center">
          <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="3rem"
            :src="this.utilImage.getCommon('AD')">
          </b-avatar>
          <span class="ml-3" style="font-size: 30px;">Adversidade</span>
          <span class="ml-3 red" style="font-size: 30px;"><strong>{{this.AD}}</strong></span>
        </b-list-group-item>
      </b-list-group>
    </b-row>
    <b-row>
      <b-card class="my-card-redutores" style="width: 100%">
        <span style="color: rgba(117, 119, 119, 0.589);">REDUTORES</span>
        <b-list-group horizontal style="width: 100%" class="orange">
          <b-list-group-item class="d-flex align-items-center" style="width: 80%">
            <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
              :src="this.utilImage.getCommon('r_post')">
            </b-avatar>
            <span class="ml-3" style="font-size: 22px;">Postura</span>
          </b-list-group-item>
          <b-list-group-item class="d-flex align-items-center" style="width: 20%">            
            <span class="ml-3" style="font-size: 30px; color: red;">
              <strong>
                {{ this.personagem.salaPersonagem.rdt_postura }}
              </strong>
            </span>
          </b-list-group-item>
        </b-list-group>

        <b-list-group horizontal style="width: 100%" class="orange">
          <b-list-group-item class="d-flex align-items-center" style="width: 80%">
            <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
              :src="this.utilImage.getCommon('r_cansaco')">
            </b-avatar>
            <span class="ml-3" style="font-size: 22px;">Cansaço</span>
          </b-list-group-item>
          <b-list-group-item class="d-flex align-items-center" style="width: 20%">            
            <span class="ml-3" style="font-size: 30px; color: red;">
              <strong>
                {{ this.personagem.salaPersonagem.rdt_cansaco }}
              </strong>
            </span>
          </b-list-group-item>
        </b-list-group>

        <b-list-group horizontal style="width: 100%" class="orange">
          <b-list-group-item class="d-flex align-items-center" style="width: 80%">
            <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
              :src="this.utilImage.getCommon('r_estre')">
            </b-avatar>
            <span class="ml-3" style="font-size: 22px;">Estresse</span>
          </b-list-group-item>
          <b-list-group-item class="d-flex align-items-center" style="width: 20%">            
            <span class="ml-3" style="font-size: 30px; color: red;">
              <strong>
                {{ this.personagem.salaPersonagem.rdt_estresse }}
              </strong>
            </span>
          </b-list-group-item>
        </b-list-group>

        <b-list-group horizontal style="width: 100%" class="orange">
          <b-list-group-item class="d-flex align-items-center" style="width: 80%">
            <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
              :src="this.utilImage.getCommon('r_nece')">
            </b-avatar>
            <span class="ml-3" style="font-size: 22px;">Necessidade</span>
          </b-list-group-item>
          <b-list-group-item class="d-flex align-items-center" style="width: 20%">            
            <span class="ml-3" style="font-size: 30px; color: red;">
              <strong>
                {{ this.personagem.salaPersonagem.rdt_necessidade }}
              </strong>
            </span>
          </b-list-group-item>
        </b-list-group>

        <b-list-group horizontal style="width: 100%" class="orange">
          <b-list-group-item class="d-flex align-items-center" style="width: 80%">
            <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
              :src="this.utilImage.getCommon('r_feri')">
            </b-avatar>
            <span class="ml-3" style="font-size: 22px;">Ferimento</span>
          </b-list-group-item>
          <b-list-group-item class="d-flex align-items-center" style="width: 20%">            
            <span class="ml-3" style="font-size: 30px; color: red;">
              <strong>
                {{ this.personagem.salaPersonagem.rdt_ferimento }}
              </strong>
            </span>
          </b-list-group-item>
        </b-list-group>

        <b-list-group horizontal style="width: 100%" class="orange">
          <b-list-group-item class="d-flex align-items-center" style="width: 80%">
            <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
              :src="this.utilImage.getCommon('r_contm')">
            </b-avatar>
            <span class="ml-3" style="font-size: 22px;">Contaminação</span>
          </b-list-group-item>
          <b-list-group-item class="d-flex align-items-center" style="width: 20%">            
            <span class="ml-3" style="font-size: 30px; color: red;">
              <strong>
                {{ this.personagem.salaPersonagem.rdt_contaminacao }}
              </strong>
            </span>
          </b-list-group-item>
        </b-list-group>

      </b-card>
    </b-row>

  </div>
</template>

<script>
import { http } from "@/services/config";
import Image from "@/util/image";
import settings from "@/settings";

export default {
  name: 'Sidebar_Redutores',
  components: {
  },

  data() {
    return {
      AD: 0,
      utilImage: Image,
      red1: 'Postura'
    }
  },
  computed: {
    personagem() {
      return this.$store.state.personagem;
    },
    show() {
      return this.$store.state.sidebarShow
    },
    minimize() {
      return this.$store.state.sidebarMinimize
    }
  },

  beforeMount: function () {
        this.AD = this.personagem.salaPersonagem.rdt_postura +
                  this.personagem.salaPersonagem.rdt_cansaco +
                  this.personagem.salaPersonagem.rdt_estresse +
                  this.personagem.salaPersonagem.rdt_necessidade +
                  this.personagem.salaPersonagem.rdt_ferimento +
                  this.personagem.salaPersonagem.rdt_contaminacao

        this.AD = 0 - this.AD
    },

  mounted() {
    this.$store.state.sidebarMinimize = true
  }

}
</script>
