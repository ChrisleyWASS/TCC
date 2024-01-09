<template>
  <div class="c-app my-app">
    <TheSidebar />
    <CWrapper>
      <div v-if="defineHeader == 'mestre'">
        <TheHeaderMestre />
      </div>
      <div v-if="defineHeader == 'jogador'">
        <TheHeaderPersonagem />
      </div>
      <div v-if="defineHeader == 'base'">
        <TheHeader />
      </div>
      <div class="c-body">
        <main>
          <CContainer fluid>
            <transition name="fade" mode="out-in">
              <router-view :key="$route.path"></router-view>
            </transition>
          </CContainer>          
        </main>
      </div>
    </CWrapper>
  </div>
</template>

<script>
import TheSidebar from './TheSidebar'
import TheHeader from './TheHeader'
import TheHeaderPersonagem from './TheHeaderPersonagem'
import TheHeaderMestre from './TheHeaderMestre'
import TheFooter from './TheFooter'
import settings from '../settings'
import { http } from "@/services/config";

export default {
  name: 'TheContainer',
  components: {
    TheSidebar,
    TheHeader,
    TheHeaderPersonagem,
    TheHeaderMestre,
    TheFooter
  },
  data() {
    return {
      rota: "",
      rotaJogador: "/game/jogador/",
      rotaMestre: "/game/mestre/",
      header: "base"
    }
  },
  computed: {
    
    defineHeader() {
      this.rota = this.$route.path
      if (this.rota.slice(0, this.rotaMestre.length) === this.rotaMestre) {
        this.telaMestre()
        return 'mestre'
      } else
      if (this.rota.slice(0, this.rotaJogador.length) === this.rotaJogador) {
        this.telaPersonagem()
        return 'jogador'
      } else {
        this.foraDeJogo()      
        return 'base'          
      }
    },

    personagem() {
      return this.$store.state.personagem;
    },

    sala() {
      return this.$store.state.sala;
    },
  },

  beforeCreate() {
    if (settings.user.name == null) {
      let sessionUser = JSON.parse(sessionStorage.getItem('user'))
      if (sessionUser == null) {
        http.defaults.headers.common['Authorization'] = "";
        this.$router.push(this.$route.query.redirect || "/login");
      } else {
        settings.user = sessionUser
        http.defaults.headers.common['Authorization'] = "Bearer " + sessionUser.token;
      }
    }
  },

  methods: {

    foraDeJogo(){ 
      if(settings.conexao.idSala != 0){
        this.closeSala()   
      }      
    },

    telaMestre(){
      settings.conexao.idSala = parseInt(this.$route.params.idSala)
      settings.conexao.idPersonagem = 0
      settings.conexao.ativa = true
      this.updateSala();
    },

    telaPersonagem(){
      settings.conexao.idSala = 0
      settings.conexao.idPersonagem = parseInt(this.$route.params.idPersonagem)
      this.updatePersonagem();
      this.updateSalabyPersonagem()
    },

    async updatePersonagem() {
      await this.$store.dispatch('updatePersonagem', settings.conexao.idPersonagem);
    },

    async updateSalabyPersonagem() {
      await this.$store.dispatch('updateSalabyPersonagem', settings.conexao.idPersonagem);
    },

    async updateSala() {
      await this.$store.dispatch('updateSala', settings.conexao.idSala);
    },

    closeSala() {
      this.$store.dispatch('closeSala');
    },
  }
}

</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.3s;
}

.fade-enter,
.fade-leave-to {
  opacity: 0;
}
</style>
