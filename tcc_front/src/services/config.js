import axios from "axios";
import settings from "@/settings";

axios.defaults.baseURL = settings.ws_url;
axios.defaults.headers.common['Authorization'] = "Bearer " + settings.user.token;

export const http = new axios.create({
	baseURL: settings.ws_url,
});

