<template>
  <div class="c-app my-app flex-row align-items-center">
    <CContainer>
      <CRow class="justify-content-center">
        <CCol sm="12" md="8" lg="6">
            <CCard class="p-5 my-card" v-if="abaLogin" style="height: 400px;" >
              <CCardHeader class="text-center" >                
                <h2>Login</h2>
              </CCardHeader>
              <CCardBody>
                <CForm class="my-form">
                  <CInput placeholder="Login" v-model="username">
                    <template #prepend-content>
                      <CIcon name="cil-user" />
                    </template>
                  </CInput>
                  <CInput placeholder="Senha" type="password" autocomplete="curent-password" v-model="password">
                    <template #prepend-content>
                      <CIcon name="cil-lock-locked" />
                    </template>
                  </CInput> <br>                                   
                  <CCol class="text-center">
                    <CButton color="success" variant="outline" size="lg" class="align-middle" @click="login()">
                      Acessar
                    </CButton>         
                  </CCol>  
                  <CCol>
                    <CButton color="link" block>Esqueceu sua senha?</CButton>
                  </CCol>
                </CForm>
              </CCardBody>
            </CCard>  

            <CCard class="p-5 my-card" v-else style="height: 400px;">
              <CCardHeader class="text-center">                
                <h2>Cadastro</h2>
              </CCardHeader>
              <CCardBody>
                <CForm>
                  <CInput placeholder="Nome" v-model="newUser.nome"></CInput>
                  <CInput placeholder="Login" v-model="newUser.login"></CInput>
                  <CInput placeholder="Senha" v-model="newUser.senha" type="password"></CInput> <br>                                   
                  <CCol class="text-center">
                    <CButton color="success" variant="outline" size="lg" class="align-middle" @click="cadastrar()">
                      Salvar
                    </CButton>         
                  </CCol> 
                </CForm>
              </CCardBody>
            </CCard>

        </CCol>

      </CRow>
        <CCol class="text-center" v-if="abaLogin">
            <CButton color="success" variant="outline" size="lg" @click="trocaAba()">
              Cadastrar novo Usuário
            </CButton>
        </CCol>
        <CCol class="text-center" v-else>
            <CButton color="success" variant="outline" size="lg" @click="trocaAba()">
              Acessar uma conta
            </CButton>
        </CCol>
    </CContainer>
  </div>
</template>

<script>

import settings from "@/settings";
import { http } from "@/services/config";
import LoginService from "@/services/Login";
import UserService from "@/services/Usuario";
import utilServices from '@/services/Util';

settings.user.token = "";

export default {
  name: 'Login',

  data() {
    return {
      username: null,
      password: null,
      abaLogin: true,
      newUser: {
        id: 0,
        nome: "",
        login: "",
        senha: ""
      }
    };
  },

  beforeMount() {
    if (process.env.NODE_ENV === "development") {
      this.username = "chrisley619@gmail.com";
      this.password = "123";
    } else {
      this.username = "";
      this.password = "";
    }
  },

  methods: {
    login() {
      let loader = this.$loading.show({});
      LoginService.login({
        username: this.username,
        password: this.password
      })
        .then((response) => {
          settings.user.name = response.data.name;
          settings.user.token = response.data.token;
          settings.user.username = this.username;
          http.defaults.headers.common['Authorization'] = "Bearer " + settings.user.token;
          sessionStorage.setItem("user", JSON.stringify(settings.user));       
          this.$router.push(this.$route.query.redirect || "/");
        })
        .catch((error) => {
          utilServices.parseServerError(error, this);
        })
        .finally(() => {
          loader.hide();
        });
    },

    cadastrar() {
      let loader = this.$loading.show({});
      LoginService.save(this.newUser)
        .then((response) => {
          utilServices.success("Usuário criado com sucesso.", this);
        }).catch((error) => {
          utilServices.parseServerError(error, this);
        })
        .finally(() => {
          loader.hide();
        });
    },

    trocaAba(){
      this.abaLogin = !this.abaLogin
    }
  }
};
</script>
