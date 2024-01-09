export default {
	tokenValid(token) {
		if (typeof token == "undefined" || token == "") {
			return false;
		}

		try {
			let exp = this.parseJwt(token).exp;

			if (Date.now() >= exp * 1000) {
				return false;
			}
		} catch (err) {
			return false;
		}

		return true;
	},

	parseJwt(token) {
		var base64Url = token.split(".")[1];
		var base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
		var jsonPayload = decodeURIComponent(
			atob(base64)
				.split("")
				.map(function (c) {
					return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
				})
				.join("")
		);

		return JSON.parse(jsonPayload);
	},

	parseServerError(error, self, validation) {
		if (error == "Error: Network Error") {
			this.error('Erro de conexão, tente mais tarde.', self);

			setTimeout(() => {
				self.$router.push("/login");
			}, 1000);

		} else if (error.response.status == 400) {
			if (Array.isArray(error.response.data)) {
				for (let i = 0; i < error.response.data.length; i++) {
					if ((validation.hasOwnProperty(error.response.data[i].field)) || (validation.hasOwnProperty(error.response.data[i].field + '_message'))) {
						validation[error.response.data[i].field] = false;
						this.warning(error.response.data[i].message, self);
					} else {
						this.warning(error.response.data[i].message, self);
					}
				}
			} else {
				if (error.response.data.message != undefined)
					this.warning(error.response.data.message, self);
				else
					this.warning(error.response.data, self);
			}
		} else if (error.response.status == 401) {
			this.error('Sessão expirada, acesse novamente.', self);
			setTimeout(() => {
				self.$router.push("/login");;
			}, 1000);
		} else if (error.response.status == 402) {
			this.error(error.response.data.message, self);
		} else if ((error.response.status == 404) || (error.response.status == 409) ||
			(error.response.status == 417) || (error.response.status == 424)) {
			this.error(error.response.data.message, self);
		} else {
			this.error("Ocorreu um erro ao processar a operação.", self);
		}
	},

	warning(message, self) {
		self.$bvToast.toast(message, { title: "Aviso", variant: "warning", solid: true });
	},

	success(message, self) {
		self.$bvToast.toast(message, { title: "Sucesso", variant: "success", solid: true });
	},

	error(message, self) {
		self.$bvToast.toast(message, { title: "Erro", variant: "danger", solid: true });
	},

	// lodashFilter(collection, filter, exclude) {
	// 	filter = this.removeAccents(lodash.toLower(filter)).trim();

	// 	if (filter == "") return collection;

	// 	let teste = this.removeAccents;
	// 	return lodash.filter(collection, function(object) {
	// 		return lodash(object)
	// 			.omit(exclude)
	// 			.some(function(string) {
	// 				return lodash(teste(string))
	// 					.toLower()
	// 					.includes(filter);
	// 			});
	// 	});
	// },

	// removeAccents(string) {
	// 	return string
	// 		.toString()
	// 		.normalize("NFD")
	// 		.replace(/[\u0300-\u036f]/g, "");
	// },
};