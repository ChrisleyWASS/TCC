import Vue from 'vue';
import Vuex from 'vuex';
import personagemServices from "@/services/Personagem";
import salaServices from "@/services/Sala";
import utilServices from '@/services/Util';
import SSE from '@/util/SSE';
import settings from './settings';

Vue.use(Vuex);

const store = new Vuex.Store({

  state: {
    sidebarShow: 'responsive',
    sidebarMinimize: false,
    user: {
      name: null,
      token: null,
      username: null
    },
    personagem: { id: 0 },
    sala: { id: 0 },
  },

  mutations: {
    // updateUser(state, novoUser){
    //   state.user = novoUser;
    // },
    setPersonagem(state, novoPersonagem) {
      state.personagem = novoPersonagem;
    },
    setSala(state, novaSala) {
      state.sala = novaSala;
    },
    cleanPersonagem(state) {
      state.personagem = { id: 0 };
    },
    cleanSala(state) {
      state.sala = { id: 0 };
    },
    toggleSidebarDesktop(state) {
      const sidebarOpened = [true, 'responsive'].includes(state.sidebarShow);
      state.sidebarShow = sidebarOpened ? false : 'responsive';
    },
    toggleSidebarMobile(state) {
      const sidebarClosed = [false, 'responsive'].includes(state.sidebarShow);
      state.sidebarShow = sidebarClosed ? true : 'responsive';
    },
    set(state, [variable, value]) {
      state[variable] = value;
    },
  },
  actions: {
    
    async updateSala(context, idSala) {
      try {
        const response = await salaServices.get(idSala);        
        context.commit('setSala', response.data);
        settings.conexao.idSala = response.data.id;
      } catch (error) {
        utilServices.parseServerError(error, this);
        this.$router.push({ path: '/sala/list' })
      }
    },

    async updateSalabyPersonagem(context, idPersonagem) {
      try {
        const response = await salaServices.getByPersonagem(idPersonagem); 
        settings.conexao.idSala = response.data.id;               
        context.commit('setSala', response.data);
      } catch (error) {
        utilServices.parseServerError(error, this);
        this.$router.push({ path: '/personagem/list' })
      }
    },

    async updatePersonagem(context, idPersonagem) {
      try {
        const response = await personagemServices.get(idPersonagem);
        settings.conexao.idSala = response.data.salaPersonagem.sala.id;
        context.commit('setPersonagem', response.data);
      } catch (error) {
        utilServices.parseServerError(error, this);
        this.$router.push({ path: '/personagem/list' })
      }
    },

    subSala(context) {
      SSE.sub(context);
    },

    closeSala(context) {
      SSE.close(context);
      context.commit('cleanSala');
      context.commit('cleanPersonagem');
    },
  },
});

export default store;
