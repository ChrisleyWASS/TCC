(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4e878a3f"],{"3a81":function(e,t,a){},"433f":function(e,t,a){"use strict";a("3a81")},b3f4:function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("b-row",[a("b-col",{staticClass:"capacidades_box overflowy",style:{height:e.sidebarHSize},attrs:{sm:"3",lg:"2"}},[e.carregado?a("div",[a("b-table",{attrs:{striped:"",hover:"","sort-by":"id",fields:e.fields,"sort-desc":!0,items:e.sala.log}})],1):e._e()]),a("b-col",{staticClass:"overflowy",style:{height:e.sidebarHSize}},[e.carregado?a("div",[e.isDesktop?a("mesa"):e._e(),a("ficha")],1):e._e()])],1)],1)},s=[],o=a("978e"),n=a("d233"),r=a("1fd3"),c=a("9235"),l=a("5abe"),d={name:"Game",components:{ficha:c["a"],utilServices:n["a"],mesa:l["a"],personagemServices:r["a"]},computed:{sala:function(){return this.$store.state.sala},sidebarHSize:function(){return window.innerHeight+"px"}},data:function(){return{carregado:!1,utilImage:o["a"],idPersonagem:null,isDesktop:!0,log:[],fields:[{key:"descricao",label:"Histórico da Sala"}]}},created:function(){window.innerHeight>500?this.isDesktop=!0:this.isDesktop=!1},mounted:function(){var e=this;setTimeout((function(){e.carregado=!0}),1e3)}},u=d,f=(a("433f"),a("2877")),b=Object(f["a"])(u,i,s,!1,null,null,null);t["default"]=b.exports}}]);
//# sourceMappingURL=chunk-4e878a3f.a0a1722a.js.map