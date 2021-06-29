package com.te.musicplayer.service;

import java.util.List;

import com.te.musicplayer.dto.MusicInfo;

public interface MusicService {
	
	public List<MusicInfo> getAllMusic();

	public boolean addMusic(MusicInfo musicInfo);

	public boolean deleteItem(int id);

	public boolean update(MusicInfo musicInfo);

	public MusicInfo getMusicById(int id);

	public MusicInfo getMusicByName(String name);

}
