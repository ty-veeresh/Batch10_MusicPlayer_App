package com.te.musicplayer.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.musicplayer.dto.MusicInfo;
import com.te.musicplayer.dto.MusicResponce;
import com.te.musicplayer.service.MusicService;


@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class MusicPlayerAppControler {

	@Autowired
	private MusicService service;
	
	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public MusicResponce getAllMusic() {
		MusicResponce response = new MusicResponce();
		List<MusicInfo> infoBeans = service.getAllMusic();

		if (infoBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setInfoBean(infoBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("Datas not found");
		}

		return response;
	}
	
	
	@PostMapping(path = "/addmusic", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public MusicResponce addEmpData(@RequestBody MusicInfo musicInfo) {
		MusicResponce response = new MusicResponce();

		if (service.addMusic(musicInfo)) {
			response.setStatusCode(200);
			response.setMsg("success , Added the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not add the data");
		}

		return response;
	}
	
	
	
	@DeleteMapping(path = "/delete/{iId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public MusicResponce deleteEmpData(@PathVariable(name = "iId")int id ) {
		MusicResponce response = new MusicResponce();

		if (service.deleteItem(id)) {
			response.setStatusCode(200);
			response.setMsg("success , record deleted");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not delete the record");
		}
		return response;
	}
	
	
	
	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public  MusicResponce update(@RequestBody MusicInfo infoBean) {
		 MusicResponce response = new  MusicResponce();

		if (service.update(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("success , Updated the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not update the record");
		}
		return response;
	} // update
	
	
	
	
	
	
	@GetMapping(path="/get",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public MusicResponce getMusicById(int id) {
		MusicResponce responce=new MusicResponce();
		MusicInfo musicInfo=service.getMusicById(id);
		System.out.println(musicInfo);
		if(musicInfo != null) {
			responce.setStatusCode(200);
			responce.setMsg("success");
			responce.setBean(musicInfo);
		} else {
			responce.setStatusCode(404);
			responce.setMsg("Failure");
		}
		return responce;
	}
	
	
	
	@GetMapping(path="/getname",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public MusicResponce getMusicByName(String name) {
		MusicResponce responce=new MusicResponce();
		MusicInfo musicInfo=service.getMusicByName(name);
		System.out.println(musicInfo);
		if(musicInfo != null) {
			responce.setStatusCode(200);
			responce.setMsg("success");
			responce.setBean(musicInfo);
		} else {
			responce.setStatusCode(404);
			responce.setMsg("Failure");
		}
		return responce;
	}
}
