<template>
    <div class="button_box">
        <span style="font-size: 38px; position: absolute; z-index: 2;">
            <strong>
                {{isPositive()}}{{prop_value}}
            </strong>            
        </span>        
    </div>    
</template>


<script>
import Image from "@/util/image";
import capUtil from "@/util/Capacidades";

import { create } from "domain";
import { thisTypeAnnotation } from "@babel/types";

export default {
    name: 'CapacidadeTeste',
    props: {
        prop_action: Function,
        prop_value: Number
    },
    data() {
        return {
            utilImage: Image,   
        }
    },

    methods: {

        select() {
            this.prop_action();
        },

        isPositive(){
            if(this.prop_value >= 0){
                return '+'
            } else {
                return ''
            }

        },

        // buttonColor(){
        //     if(this.prop_value > 2){
        //         if (this.prop_value > 4) {
        //             return 'teste-item-button-pro'
        //         } else {
        //             return 'teste-item-button-alto'
        //         }
        //     } else 
        //     if(this.prop_value < -2){
        //         if (this.prop_value < -4) {
        //             return 'teste-item-button-critico'
        //         } else {
        //             return 'teste-item-button-baixo'
        //         }
        //     } else {
        //         return 'teste-item-button'
        //     }
        // }
    }
}
</script>

<style>
.button_box{
    display: flex; 
    align-items: center; 
    justify-content: center; 
    min-height: 10px;
}
</style>