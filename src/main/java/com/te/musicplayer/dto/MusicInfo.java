package com.te.musicplayer.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "musicfiles")
@XmlRootElement(name="music-info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("music_info")
public class MusicInfo  implements Serializable  {

	
	@Id
	@Column
	private int song_ID;
	@Column
	private String song_Title;
	@Column
	private String artist_Name;
	@Column
	private String album_Name;
	@Column
	private String description;
	public int getSong_ID() {
		return song_ID;
	}
	public void setSong_ID(int song_ID) {
		this.song_ID = song_ID;
	}
	public String getSong_Title() {
		return song_Title;
	}
	public void setSong_Title(String song_Title) {
		this.song_Title = song_Title;
	}
	public String getArtist_Name() {
		return artist_Name;
	}
	public void setArtist_Name(String artist_Name) {
		this.artist_Name = artist_Name;
	}
	public String getAlbum_Name() {
		return album_Name;
	}
	public void setAlbum_Name(String album_Name) {
		this.album_Name = album_Name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
