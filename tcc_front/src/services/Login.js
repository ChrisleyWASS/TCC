import { http } from "./config";
export default {

	login: (user) => { 
		return http.post("acesso/login", user, {headers: {Authorization: ""}});
	},

	save: (user) => { 
		return http.post("acesso/cadastro", user, {headers: {Authorization: ""}});
	},

}