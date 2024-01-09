<template>
  <CDropdown
    inNav
    class="c-header-nav-items"
    placement="bottom-end"
    add-menu-classes="pt-0"
  >
    <template #toggler>
      <CHeaderNavLink>
        <div class="c-avatar">
          <img
            src="img/avatars/user.png"
            class="c-avatar-img "
          />
        </div>
      </CHeaderNavLink>
    </template>    
    <CDropdownHeader
      tag="div"
      class="text-center"
      color="light"
    >
      <strong>Perfil</strong>
    </CDropdownHeader>
    <CDropdownItem>
      <b-icon icon="person-fill"></b-icon>&nbsp;{{nome}}
    </CDropdownItem>
    <!-- <CDropdownItem>
      <b-icon icon="inboxes-fill"></b-icon>&nbsp;Trocar de matriz / filial
    </CDropdownItem> -->
    <CDropdownDivider/>
    <CDropdownItem @click="logout">
      <b-icon icon="door-closed-fill"></b-icon>&nbsp;Sair
    </CDropdownItem>
  </CDropdown>  
</template>

<script>
import settings from "@/settings";
import { http } from "@/services/config";

export default {
    name: 'TheHeaderDropdownAccnt',
    data () {      
      return { 
        itemsCount: 42,
        nome: settings.user.name,
      }
    },
    mounted : function() {
      this.nome = settings.user.name;
         
    },
    methods: {
      logout() {
        // settings.user.name = "";
        // settings.user.token = "";
        // http.defaults.headers.common['Authorization'] = "";
        // http.defaults.headers.common['tenant'] = "";
        // const redirectPath = this.$route.query.redirect || "/";
        // this.$router.push(redirectPath + "login");                
      },  
      closeModal() {
        this.$bvModal.hide('notificaoBloqueio');
      },
      
    }
}
</script>

<style scoped>
  .c-icon {
    margin-right: 0.3rem;
  }
</style>