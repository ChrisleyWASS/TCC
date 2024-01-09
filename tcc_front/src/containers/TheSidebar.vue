<template>
  <CSidebar fixed :minimize="minimize" :show="show" @update:show="(value) => $store.commit('set', ['sidebarShow', value])">
    <CSidebarBrand to="/">
      <span class="c-sidebar-brand-full" > Mysthen RPG </span>
      <span class="c-sidebar-brand-minimized"> RPG </span>
    </CSidebarBrand>
    <CRenderFunction flat :content-to-render="$options.nav" />
    <CSidebarMinimizer class="d-md-down-none" @click.native="$store.commit('set', ['sidebarMinimize', !minimize])" />
  </CSidebar>
</template>

<script>
import nav from './_nav'

export default {
  name: 'TheSidebar',
  nav,
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
  }
  
}
</script>
