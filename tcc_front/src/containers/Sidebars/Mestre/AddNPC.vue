<template>
  <div class="px-3 py-0">
    <h2 class="orange">Adicionar NPC</h2>
    <hr>
    <b-input-group class="mt-3">
      <b-form-input placeholder="Digite o nome ou categoria"></b-form-input>
    </b-input-group>

    <b-table :fields="fields" :items="items">
      <template v-slot:head(integridade)="data">
        <th style="padding: 0px;">
          <div class="tableIconContainer">
            <img class="tableIcon" :src="utilImage.getCommon('integridade_')" fluid-grow />
          </div>          
        </th>
      </template>
      <template #cell(integridade)="row">
        <div style="margin-left: 5px;">{{ row.item.integridade }}</div>        
      </template>
      <template #cell(option)="row">
        <b-button-group class="fullW">
          <b-button pill variant="outline-info" size="sm"><b-icon icon="check2"></b-icon></b-button>
        </b-button-group>
      </template>
    </b-table>
  </div>
</template>

<script>
import { http } from "@/services/config";
import Image from "@/util/image";
import settings from "@/settings";

export default {
  name: 'Sidebar_AddNPC',
  components: {
  },
  props: {
    prop_personagem: {}
  },

  data() {
    return {
      utilImage: Image,
      ND: 10,
      fields: [

        {
          key: 'integridade',
        },
        {
          key: 'nome',
          label: 'Nome'
        },
        {
          key: 'categoria',
          label: 'Categoria'
        },
        ,
        {
          key: 'option',
          label: 'Adicionar'
        }
      ],
      items: [
        { nome: 'Lobo Comum', categoria: 'Animal', integridade: 2 },
        { nome: 'Javarin', categoria: 'Animal', integridade: 3 },
      ],
    }
  },
  computed: {
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

  }

}
</script>

<style scoped>
.table th {
  border: none;
  padding: 0px;
  border-top: none !important;
}

.tableIcon {
  max-height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0;
  padding: 0;
}
.tableIconContainer {
  display: flex !important;
  align-items: center !important;
  justify-content: center !important;
  width: 100%;
}
</style>
