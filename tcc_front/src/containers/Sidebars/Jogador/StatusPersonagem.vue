<template>
  <div class="px-3 py-0">

    <b-row>
      <b-list-group style="width: 100%" class="orange">

        <b-list-group-item class="d-flex align-items-center d-flex justify-content-center">
          <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="3rem"
            :src="this.utilImage.getCommon('integridade_')">
          </b-avatar>
          <span class="ml-3" style="font-size: 30px;">INTEGRIDADE</span>
          <span class="ml-3 ciano" style="font-size: 30px;">
            <strong>
              {{ personagem.integridade }}
            </strong>
          </span>
        </b-list-group-item>
      </b-list-group>

      <b-list-group horizontal style="width: 100%" class="orange">
        <b-list-group-item class="d-flex align-items-center" style="width: 50%">
          <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
            :src="this.utilImage.getCommon('apf_')">
          </b-avatar>
          <span class="ml-3" style="font-size: 22px;">Aptidão Física</span>
          <span class="ml-3 ciano" style="font-size: 30px;">
            <strong>
              {{ personagem.apFisica }}
            </strong>
          </span>
        </b-list-group-item>
        <b-list-group-item class="d-flex align-items-center" style="width: 50%">
          <b-avatar style="background-color: rgba(255, 255, 255, 0); align-items: center;" rounded size="2rem"
            :src="this.utilImage.getCommon('apm_')">
          </b-avatar>
          <span class="ml-3" style="font-size: 22px;">Aptidão Mental</span>
          <span class="ml-3 ciano" style="font-size: 30px;">
            <strong>
              {{ personagem.apMental }}
            </strong>
          </span>
        </b-list-group-item>
      </b-list-group>
    </b-row>

    <b-row>
      <capstable :prop_textHover="'Relação das capacidades do personagem'" :prop_items="historicoCapacidades"
        :prop_fields="fields">
      </capstable>
    </b-row>

  </div>
</template>

<script>
import { http } from "@/services/config";
import Image from "@/util/image";
import capUtil from "@/util/Capacidades";
import settings from "@/settings";
import capstable from "@/components/tables/CapsTable";

export default {
  name: 'Sidebar_StatusPersonagem',
  components: {
    capstable,
    capUtil
  },

  data() {
    return {
      utilImage: Image,
      historicoCapacidades: [],
      fields: [
        {
          key: 'capacidade',
          width: '25px',
          class: 'tb-coluna-principal'
        },
        {
          key: 'Especie',
          variant: 'secondary',
          class: 'tb-coluna',
          tdClass: this.capValueColor
        },
        {
          key: 'Raça',
          variant: 'secondary',
          class: 'tb-coluna',
          tdClass: this.capValueColor
        },
        {
          key: 'Qualidade',
          variant: 'secondary',
          class: 'tb-coluna',
          tdClass: this.capValueColor
        },
        {
          key: 'Defeito',
          variant: 'secondary',
          class: 'tb-coluna',
          tdClass: this.capValueColor
        },
        {
          key: 'Treinamento_1',
          label: 'Tr.1',
          class: 'tb-coluna',
          tdClass: this.capValueColor
        },
        {
          key: 'Treinamento_2',
          label: 'Tr.2',
          class: 'tb-coluna',
          tdClass: this.capValueColor
        },
        {
          key: 'Treinamento_3',
          label: 'Tr.3',
          class: 'tb-coluna',
          tdClass: this.capValueColor
        },
        {
          key: 'Personagem',
          sortable: true,
          class: 'tb-coluna-info ',
          tdClass: this.capValueColor
        },
      ],
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

  beforeMount: function () {
    this.carregarCapacidades()
  },

  mounted() {
    this.$store.state.sidebarMinimize = true
  },

  methods: {
    capValueColor(value) {
      if (value == 0) {
        return 'td-element-zero';
      } else if (value < 0) {
        if (value < -2) {
          return 'td-element-vbad';
        } else {
          return 'td-element-bad';
        }
      } else if (value > 0) {
        if (value > 2) {
          return 'td-element-vgood';
        } else {
          return 'td-element-good';
        }
      }
    },

    carregarCapacidades() {
      this.historicoCapacidades = capUtil.capsChosed(
        this.personagem.especiesPersonagem,
        this.personagem.racasPersonagem,
        this.personagem.qualidade,
        this.personagem.defeito,
        this.personagem.treinamentos[0],
        this.personagem.treinamentos[1],
        this.personagem.treinamentos[2],
      )
    },
  }

}
</script>
