package com.te.musicplayer.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;


import lombok.Data;

@Data
@JsonRootName("response")
@JsonPropertyOrder({"status" , "msg"})
@XmlRootElement(name = "response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MusicResponce {

	
	@JsonProperty("status")
	@XmlElement(name = "status-code")
	private int statusCode;
	
	
	@JsonProperty("item_info")
	@XmlElement(name = "item-info")
	private MusicInfo bean;
	
	@JsonProperty("Msg")
	@XmlElement(name = "status-Msg")
	private String  msg;
	
	
	@JsonProperty("item")
	@XmlElement(name = "iteminfo")
	private List<MusicInfo> infoBean;
	
	
	
	public void setStatusCode(int i) {
		// TODO Auto-generated method stub
		statusCode=i;
		
	}


	public void setMsg(String string) {
		// TODO Auto-generated method stub
		msg=string;
		
	}


	
	public void setInfoBean(List<MusicInfo> infoBeans) {
		// TODO Auto-generated method stub
		infoBean=infoBeans;
		
	}


	public void setBean(MusicInfo musicInfo) {
		bean=musicInfo;
		
	}
}
