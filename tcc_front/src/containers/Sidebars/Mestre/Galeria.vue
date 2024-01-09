<template>
  <div class="px-3 py-0">

    <b-card class="my-card">
      <h2>Galeria</h2>
      <b-row>
        <b-col>
          <b-img thumbnail fluid src="https://picsum.photos/250/250/?image=17" alt="Image 1"></b-img>
        </b-col>
        <b-col>
          <b-img thumbnail fluid src="https://picsum.photos/250/250/?image=58" alt="Image 2"></b-img>
        </b-col>
        <b-col>
          <b-img thumbnail fluid src="https://picsum.photos/250/250/?image=15" alt="Image 3"></b-img>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-img thumbnail fluid src="https://picsum.photos/250/250/?image=28" alt="Image 1"></b-img>
        </b-col>
        <b-col>
          <b-img thumbnail fluid src="https://picsum.photos/250/250/?image=49" alt="Image 2"></b-img>
        </b-col>
        <b-col>
          <b-img thumbnail fluid src="https://picsum.photos/250/250/?image=46" alt="Image 3"></b-img>
        </b-col>
      </b-row>
    </b-card>

  </div>
</template>

<script>
import { http } from "@/services/config";
import Image from "@/util/image";
import settings from "@/settings";

export default {
  name: 'Sidebar_Galeria',
  components: {
  },
  props: {
    prop_personagem: {}
  },

  data() {
    return {
      utilImage: Image,
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
  }

}
</script>
