(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-162d68a0"],{"19d1":function(e,t,a){"use strict";var s=a("c3e4");t["a"]={login:function(e){return s["a"].post("acesso/login",e,{headers:{Authorization:""}})},save:function(e){return s["a"].post("acesso/cadastro",e,{headers:{Authorization:""}})}}},"8b48":function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"c-app my-app flex-row align-items-center"},[a("CContainer",[a("CRow",{staticClass:"justify-content-center"},[a("CCol",{attrs:{sm:"12",md:"8",lg:"6"}},[e.abaLogin?a("CCard",{staticClass:"p-5 my-card",staticStyle:{height:"400px"}},[a("CCardHeader",{staticClass:"text-center"},[a("h2",[e._v("Login")])]),a("CCardBody",[a("CForm",{staticClass:"my-form"},[a("CInput",{attrs:{placeholder:"Login"},scopedSlots:e._u([{key:"prepend-content",fn:function(){return[a("CIcon",{attrs:{name:"cil-user"}})]},proxy:!0}],null,!1,3945887885),model:{value:e.username,callback:function(t){e.username=t},expression:"username"}}),a("CInput",{attrs:{placeholder:"Senha",type:"password",autocomplete:"curent-password"},scopedSlots:e._u([{key:"prepend-content",fn:function(){return[a("CIcon",{attrs:{name:"cil-lock-locked"}})]},proxy:!0}],null,!1,3300492400),model:{value:e.password,callback:function(t){e.password=t},expression:"password"}}),e._v(" "),a("br"),a("CCol",{staticClass:"text-center"},[a("CButton",{staticClass:"align-middle",attrs:{color:"success",variant:"outline",size:"lg"},on:{click:function(t){return e.login()}}},[e._v(" Acessar ")])],1),a("CCol",[a("CButton",{attrs:{color:"link",block:""}},[e._v("Esqueceu sua senha?")])],1)],1)],1)],1):a("CCard",{staticClass:"p-5 my-card",staticStyle:{height:"400px"}},[a("CCardHeader",{staticClass:"text-center"},[a("h2",[e._v("Cadastro")])]),a("CCardBody",[a("CForm",[a("CInput",{attrs:{placeholder:"Nome"},model:{value:e.newUser.nome,callback:function(t){e.$set(e.newUser,"nome",t)},expression:"newUser.nome"}}),a("CInput",{attrs:{placeholder:"Login"},model:{value:e.newUser.login,callback:function(t){e.$set(e.newUser,"login",t)},expression:"newUser.login"}}),a("CInput",{attrs:{placeholder:"Senha",type:"password"},model:{value:e.newUser.senha,callback:function(t){e.$set(e.newUser,"senha",t)},expression:"newUser.senha"}}),e._v(" "),a("br"),a("CCol",{staticClass:"text-center"},[a("CButton",{staticClass:"align-middle",attrs:{color:"success",variant:"outline",size:"lg"},on:{click:function(t){return e.cadastrar()}}},[e._v(" Salvar ")])],1)],1)],1)],1)],1)],1),e.abaLogin?a("CCol",{staticClass:"text-center"},[a("CButton",{attrs:{color:"success",variant:"outline",size:"lg"},on:{click:function(t){return e.trocaAba()}}},[e._v(" Cadastrar novo Usuário ")])],1):a("CCol",{staticClass:"text-center"},[a("CButton",{attrs:{color:"success",variant:"outline",size:"lg"},on:{click:function(t){return e.trocaAba()}}},[e._v(" Acessar uma conta ")])],1)],1)],1)},n=[],r=a("83d6"),o=a("c3e4"),c=a("19d1"),i=a("d233");r["a"].user.token="";var l={name:"Login",data:function(){return{username:null,password:null,abaLogin:!0,newUser:{id:0,nome:"",login:"",senha:""}}},beforeMount:function(){this.username="",this.password=""},methods:{login:function(){var e=this,t=this.$loading.show({});c["a"].login({username:this.username,password:this.password}).then((function(t){r["a"].user.name=t.data.name,r["a"].user.token=t.data.token,r["a"].user.username=e.username,o["a"].defaults.headers.common["Authorization"]="Bearer "+r["a"].user.token,sessionStorage.setItem("user",JSON.stringify(r["a"].user)),e.$router.push(e.$route.query.redirect||"/")})).catch((function(t){i["a"].parseServerError(t,e)})).finally((function(){t.hide()}))},cadastrar:function(){var e=this,t=this.$loading.show({});c["a"].save(this.newUser).then((function(t){i["a"].success("Usuário criado com sucesso.",e)})).catch((function(t){i["a"].parseServerError(t,e)})).finally((function(){t.hide()}))},trocaAba:function(){this.abaLogin=!this.abaLogin}}},u=l,d=a("2877"),C=Object(d["a"])(u,s,n,!1,null,null,null);t["default"]=C.exports}}]);
//# sourceMappingURL=chunk-162d68a0.ff0d34ae.js.map