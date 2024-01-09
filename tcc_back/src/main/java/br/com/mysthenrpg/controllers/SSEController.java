package br.com.mysthenrpg.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import br.com.mysthenrpg.exceptions.BadRequestException;


@RestController
@RequestMapping("/sse")
public class SSEController {
	
	private static int numeroSalas = 10000; 
	private static final List<List<SseEmitter>> emittersList = new ArrayList<>(numeroSalas);
	static {
	    for (int i = 0; i < numeroSalas; i++) {
	        emittersList.add(new ArrayList<>(Collections.nCopies(10000, null)));
	    }
	}
	
	@RequestMapping( value = {"/sub/{idSala}/{idPersonagem}"}, method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter subscribe(@PathVariable Long idSala, @PathVariable Long idPersonagem){
		
		int idSalaCode = idSala.intValue(); 
		int idPersonagemCode = idPersonagem.intValue(); // id 0 para sala
		List<SseEmitter> listSalaEmitters = null;
		
		listSalaEmitters = emittersList.get(idSalaCode);
		if(listSalaEmitters == null) {
			emittersList.set(idSalaCode, new ArrayList<SseEmitter>(10));
			listSalaEmitters = emittersList.get(idSalaCode);
		}
		
		SseEmitter emitter = listSalaEmitters.get(idPersonagemCode);
		if(emitter == null) {
			emitter = new SseEmitter();
			
			emitter.onCompletion(() -> {
				emittersList.get(idSalaCode).set(idPersonagemCode, null);				
			});			
		}
		
		emittersList.get(idSalaCode).set(idPersonagemCode, emitter);
		
        return emitter;
		
	}
	
	@RequestMapping(value = "/close/{idSala}/{idPersonagem}", method = RequestMethod.POST)
	public void closeSSE(@PathVariable Long idSala, @PathVariable Long idPersonagem) {
		
		int idSalaCode = idSala.intValue(); 
		int idPersonagemCode = idPersonagem.intValue(); // id 0 para sala
		
		if(emittersList.get(idSalaCode).get(idPersonagemCode) != null) {
			emittersList.get(idSalaCode).get(idPersonagemCode).complete();
		}
	}
	
	public void udateSala(Long idSala) {
		
		int idSalaCode = idSala.intValue();
 		if(emittersList.get(idSalaCode) != null) {
			for (SseEmitter emitter : emittersList.get(idSalaCode)) {
				if(emitter != null) {
					try {
						emitter.send(SseEmitter.event()
			        			.data("")
			                    .name("update"));
			        } catch (IOException e) {
			            throw new BadRequestException(e.getMessage());
			        }
				}
				
			}
		}
	}


	
}
