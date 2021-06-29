package com.te.musicplayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.musicplayer.dao.MusicDao;
import com.te.musicplayer.dto.MusicInfo;


@Service
public class MusicServiceImpl implements MusicService {
	
	@Autowired
	private MusicDao dao;

	@Override
	public List<MusicInfo> getAllMusic() {
		// TODO Auto-generated method stub
		return dao.getAllMusic();
	}

	@Override
	public boolean addMusic(MusicInfo musicInfo) {
		// TODO Auto-generated method stub
		return dao.addMusic(musicInfo);
	}

	@Override
	public boolean deleteItem(int id) {
		// TODO Auto-generated method stub
		return  dao.deleteItem(id);
	}

	@Override
	public boolean update(MusicInfo musicInfo) {
		// TODO Auto-generated method stub
		return dao.update(musicInfo);
	}

	@Override
	public MusicInfo getMusicById(int id) {
		// TODO Auto-generated method stub
		return dao.getMusicById(id);
	}

	@Override
	public MusicInfo getMusicByName(String name) {
		// TODO Auto-generated method stub
		return dao.getMusicByName(name);
	}

}
