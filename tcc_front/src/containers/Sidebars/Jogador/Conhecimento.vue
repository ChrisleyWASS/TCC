<template>
  <div class="px-3 py-0">
    <b-row>
      <b-card class="my-card" style="width: 100%;">
        <b-card-header class="d-flex justify-content-center" style="text-align: center;">
          <h2> Conhecimento {{prop_conhecimento.nome}}</h2>
        </b-card-header>
        <span style="font-size: 15px;">
        {{ prop_conhecimento.descricao }}
        </span>
      </b-card>  
    </b-row>
  </div>
</template>

<script>
import { http } from "@/services/config";
import Image from "@/util/image";
import settings from "@/settings";

export default {
  name: 'Sidebar_Conhecimento',
  props: {
    prop_conhecimento: Object,
  },
  components: {
  },

  data() {
    return {
      utilImage: Image,
      red1: 'Postura'
    }
  },
  computed: {
    sala() {
      return this.$store.state.sala;
    },
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
  mounted() {
    this.$store.state.sidebarMinimize = true
  }

}
</script>
