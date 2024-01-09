<template>
    <b-container fluid>
        <b-table 
        hover 
        small 
        responsive 
        sort-direction="desc" 
        :items="prop_items" 
        :fields="prop_fields"       
        thead-class="table-header">

            <template #cell(Especie)="row">
                <div :style="{ textAlign: 'center' }">
                    {{ row.value >= 0 ? '+' + row.value : row.value }}
                </div>
            </template>

            <template #cell(Raça)="row">
                <div :style="{ textAlign: 'center' }">
                    {{ row.value >= 0 ? '+' + row.value : row.value }}
                </div>
            </template>

            <template #cell(Qualidade)="row">
                <div :style="{ textAlign: 'center' }">
                    {{ row.value >= 0 ? '+' + row.value : row.value }}
                </div>
            </template>

            <template #cell(Defeito)="row">
                <div :style="{ textAlign: 'center' }">
                    {{ row.value >= 0 ? '+' + row.value : row.value }}
                </div>
            </template>

            <template #cell(Treinamento_1)="row">
                <div :style="{ textAlign: 'center' }">
                    {{ row.value >= 0 ? '+' + row.value : row.value }}
                </div>
            </template>

            <template #cell(Treinamento_2)="row">
                <div :style="{ textAlign: 'center' }">
                    {{ row.value >= 0 ? '+' + row.value : row.value }}
                </div>
            </template>

            <template #cell(Treinamento_3)="row">
                <div :style="{ textAlign: 'center' }">
                    {{ row.value >= 0 ? '+' + row.value : row.value }}
                </div>
            </template>

            <template #cell(Personagem)="row">
                <div :style="{ textAlign: 'center' }">
                    {{ row.value >= 0 ? '+' + row.value : row.value }}
                </div>
            </template>
        </b-table>
    </b-container>
</template>

<script>

export default {
    name: 'BasicTable',

    props: {
        id: String,

        prop_textHover: String,

        prop_items: Array,

        prop_fields: Array,

    },

    data() {
        return {};
    },

    
}
</script>

<style scoped>
.table-header th {
  text-align: center;
}
</style>