<template>
  <div class="px-3 py-0">
    <b-card class="text_center my-card-border ">
      <h2>Compartilhe o código</h2>
      <span class=" orange codigo">{{ sala.codigo }}</span>
      <h5>com os jogadores que deseja convidar para a sua sala</h5>
    </b-card>
    <h2 class="orange">Personagens/Jogadores</h2>
    <div v-if="sala.autorizados.length > 0">
      <b-table :items="sala.autorizados" :fields="fields_autorizados"></b-table>
    </div>
    <div v-else>
      <span class="white info">Nenhum personagem adicionado.</span><br>
    </div>
    <hr>
    <h2 class="orange">Solicitações</h2>
    <div v-if="sala.solicitacoes.length > 0">
      <b-table :items="sala.solicitacoes" :fields="fields_solicitacoes">
        <template #cell(option)="row">
          <b-button-group>
            <b-button variant="outline-info" @click="aprova(row.item.personagem, true)"><b-icon icon="check2"></b-icon></b-button>
            <b-button variant="outline-danger" @click="aprova(row.item.personagem, false)"><b-icon icon="x-lg"></b-icon></b-button>
          </b-button-group>
        </template>
      </b-table>
    </div>
    <div v-else>
      <span class="white info">Nenhuma solicitação de acesso.</span><br>
    </div>
    <hr>
  </div>
</template>

<script>
import { http } from "@/services/config";
import Image from "@/util/image";
import settings from "@/settings";

import utilServices from '@/services/Util';
import salaServices from "@/services/Sala";

export default {
  name: 'Sidebar_Acesso',
  components: {
    salaServices,
    utilServices
  },

  data() {
    return {
      utilImage: Image,
      fields_autorizados: [
        {
          key: 'personagem.nome',
          label: 'Personagem'
        },
        {
          key: 'usuario.nome',
          label: 'Jogador'
        },
      ],
      fields_solicitacoes: [
        {
          key: 'personagem.nome',
          label: 'Personagem'
        },
        {
          key: 'usuario.nome',
          label: 'Jogador'
        },
        {
          key: 'option',
          label: 'Permitir Acesso'
        }
      ],
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
    aprova(personagem, autorizacao) {
      let loader = this.$loading.show({});
      salaServices.aprovarAcesso(this.sala.id, personagem.id, { autorizado: autorizacao })
        .then((response) => {
          
        }).catch((error) => {
          utilServices.parseServerError(error, this);
          this.$router.push({ path: '/sala/list' })
        })
        .finally(() => {
          loader.hide();
        });
    },
  }
}



</script>

<style scoped>
.info {
  font-size: 20px;
}

.codigo {
  font-size: 30px;
}
</style>
