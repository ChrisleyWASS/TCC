
import settings from "@/settings";
import salaServices from "@/services/Sala";
import personagemServices from "@/services/Personagem";
import utilServices from '@/services/Util';

let eventSource = null

export default {

    sub(context) {

        const connectToEventSource = () => {

            let idSala = settings.conexao.idSala
            let idPersonagem = settings.conexao.idPersonagem
            eventSource = new EventSource(settings.ws_url + 'sse/sub/' + idSala + '/' + idPersonagem);

            eventSource.addEventListener('update', (event) => {
                context.dispatch('updateSala', idSala);
                if(idPersonagem != 0){
                    context.dispatch('updatePersonagem', idPersonagem);
                }
            });

            eventSource.addEventListener('error', (event) => {
                if (settings.conexao.ativa) {
                    close(idSala)
                    connectToEventSource();
                }
            });
        }

        if (settings.conexao.ativa == true) {
            connectToEventSource();
        }
    },

    close(context) {
        let idSala = settings.conexao.idSala
        let idPersonagem = settings.conexao.idPersonagem

        if (settings.conexao.ativa == true) {
            fetch(settings.ws_url + 'sse/close/' + idSala + '/' + idPersonagem, { method: 'POST' })
                .then(() => {
                    eventSource.close()
                })
                .catch((error) => {
                    console.error('Erro ao encerrar conexão SSE:', error);
                }).finally(() => {                    
                    settings.conexao.idSala = 0
                    settings.conexao.idPersonagem = 0
                    settings.conexao.ativa = false
                })
        }
    },

}