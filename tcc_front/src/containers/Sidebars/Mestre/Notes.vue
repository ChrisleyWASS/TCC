<template>
  <div class="px-3 py-0">

      <b-card class="my-card">
        <h2>Anotações</h2>
        <b-form-textarea
          id="textarea-rows"
          placeholder="Tall textarea"
          rows="10"
        ></b-form-textarea><hr>
        <b-form-textarea
          id="textarea-rows"
          placeholder="Tall textarea"
          rows="10"
        ></b-form-textarea><hr>
        <b-form-textarea
          id="textarea-rows"
          placeholder="Tall textarea"
          rows="10"
        ></b-form-textarea>
      </b-card>      

  </div>
</template>

<script>
import { http } from "@/services/config";
import Image from "@/util/image";
import settings from "@/settings";

export default {
  name: 'Sidebar_Notes',
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
