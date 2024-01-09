<template>
  <CHeader fixed with-subheader light class="my-app">
    <CToggler in-header class="ml-3 d-lg-none" @click="$store.commit('toggleSidebarMobile')" />
    <CToggler in-header class="ml-3 d-md-down-none" @click="$store.commit('toggleSidebarDesktop')" />
    <CBreadcrumbRouter class="my-app" />
  </CHeader>
</template>

<script>
import TheHeaderDropdownAccnt from './TheHeaderDropdownAccnt'
import settings from "@/settings";

export default {
  name: 'TheHeader',
  components: {
    TheHeaderDropdownAccnt
  },

  computed: {

  },

  data() {
    return {
      
    }
  },

  beforeCreate(){

  },

  beforeMount() {
    settings.carregado = false
  },

}
</script>
