<template>
  <div class="px-3 py-0">

    <b-row>
      <b-list-group style="width: 100%" class="orange">
        <b-list-group-item class="d-flex align-items-center">
          <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="5rem"
            :src="this.utilImage.getCommon('perfil')">
          </b-avatar>
        </b-list-group-item>
        <b-list-group-item class="d-flex align-items-center">
          <span class="ml-3 text_one_line" style="font-size: 15px;">
            Nome
          </span>
          <span class="ml-3 text_one_line" style="font-size: 20px; color: azure;">
            {{ this.personagem.nome }}
          </span>
        </b-list-group-item>
        <b-list-group-item class="d-flex align-items-center">
          <span class="ml-3 text_one_line" style="font-size: 15px;">
            Família/Clã
          </span>
          <span class="ml-3 text_one_line" style="font-size: 20px; color: azure;">
            {{ this.personagem.linhagem }}
          </span>
        </b-list-group-item>
        <b-list-group-item class="d-flex align-items-center">
          <span class="ml-3 text_one_line" style="font-size: 15px;">
            Títulos/Apelidos
          </span>
          <span class="ml-3 text_one_line" style="font-size: 20px; color: azure;">
            {{ this.personagem.alternativo }}
          </span>
        </b-list-group-item>
        <b-list-group-item>
          <span class="ml-3" style="font-size: 15px;">
            Traços de Personalidade</span>
          <span class="ml-3" style="font-size: 20px; color: azure;">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut tincidunt tincidunt lacus, sed luctus orci molestie sed. In rhoncus fermentum odio, sit amet sagittis libero finibus nec. </span>
        </b-list-group-item>
        <b-list-group-item>
          <span class="ml-3" style="font-size: 15px;">
            Antecedentes</span>
          <span class="ml-3" style="font-size: 20px; color: azure;">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut tincidunt tincidunt lacus, sed luctus orci molestie sed. In rhoncus fermentum odio, sit amet sagittis libero finibus nec. </span>
        </b-list-group-item>
        <b-list-group-item>
          <span class="ml-3" style="font-size: 15px;">
            Aparência</span>
          <span class="ml-3" style="font-size: 20px; color: azure;">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut tincidunt tincidunt lacus, sed luctus orci molestie sed. In rhoncus fermentum odio, sit amet sagittis libero finibus nec. </span>
        </b-list-group-item>
      </b-list-group>      
    </b-row>

  </div>
</template>

<script>
import { http } from "@/services/config";
import Image from "@/util/image";
import settings from "@/settings";

export default {
  name: 'Sidebar_InfoPersonagem',
  components: {
  },

  data() {
    return {
      utilImage: Image,
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
  mounted() {
    this.$store.state.sidebarMinimize = true
  }

}
</script>
