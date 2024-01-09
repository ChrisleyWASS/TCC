import 'core-js/stable'
import Vue from 'vue'
import App from './App'
import router from './router'
import CoreuiVue from '@coreui/vue'
import { iconsSet as icons } from './assets/icons/icons.js'
import store from './store'
import { BootstrapVue, IconsPlugin} from 'bootstrap-vue'
import { ToastPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { library } from '@fortawesome/fontawesome-svg-core';
import { faGear } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import VueLoading from 'vue-loading-overlay';
import 'vue-loading-overlay/dist/vue-loading.css';

library.add(faGear);
Vue.config.performance = true;
Vue.use(CoreuiVue);
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(ToastPlugin);
Vue.component('font-awesome-icon', FontAwesomeIcon);
Vue.use(VueLoading);
Vue.prototype.$log = console.log.bind(console)

new Vue({
  el: '#app',
  router,
  store,
  icons,
  template: '<App/>',
  components: {
    App
  }
})
