let settings = {
	conexao: {
		idSala: 0,
		idPersonagem: 0,
		ativa: false
	},
	user: {
		name: null,
		token: null,
		username: null
	},	
	ws_url: null,
	routes: {
		 login: "/login"
	},	
};

if (process.env.NODE_ENV === "development") {
	settings.ws_url = window.location.protocol + "//" + window.location.host.replace(window.location.host.split(":")[1], "8081") + "/";	
	settings.path_image = "../img/";
} else {
	settings.ws_url = "https://vps31158.publiccloud.com.br:8443/tccback/";
	settings.path_image = "../../../img/";
}

export default settings;