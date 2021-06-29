package com.te.musicplayer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.te.musicplayer.dto.MusicInfo;


@Repository
public class MusicDaoImpl implements MusicDao{
	
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public List<MusicInfo> getAllMusic() {
		List<MusicInfo> InfoBeans = null;

		try {
			
			EntityManager manager = factory.createEntityManager();

			Query query = manager.createQuery("from MusicInfo");

			InfoBeans = query.getResultList();
			
			
		} catch (Exception e) {
			InfoBeans = null;
			e.printStackTrace();
		}

		return InfoBeans;
	}

	@Override
	public boolean addMusic(MusicInfo musicInfo) {
		try {
			
				EntityManager manager = factory.createEntityManager();
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
				manager.persist(musicInfo);
				transaction.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
		}
	}

	@Override
	public boolean deleteItem(int id) {
		try {
			
				EntityManager manager = factory.createEntityManager();
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
			MusicInfo infoBean = manager.find(MusicInfo.class, id);
				manager.remove(infoBean);
				transaction.commit();
				return true;
			} catch (Exception e) {

				e.printStackTrace();
				return false; 

				//throw new EmployeeException("The Data is not present");
			}
	}

	@Override
	public boolean update(MusicInfo musicInfo) {
		try {
			
				EntityManager manager = factory.createEntityManager();
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
				MusicInfo data = manager.find(MusicInfo.class, musicInfo.getSong_ID());

				if (musicInfo.getAlbum_Name() != null && musicInfo.getAlbum_Name() != "") {
					 data .setAlbum_Name(musicInfo.getAlbum_Name());
				}
				if (musicInfo.getArtist_Name() != null && musicInfo.getArtist_Name() != "") {
					 data .setArtist_Name(musicInfo.getArtist_Name());
				}
				if (musicInfo.getSong_Title() != null && musicInfo.getSong_Title() != "") {
					 data .setSong_Title(musicInfo.getSong_Title());
				}
				
				if (musicInfo.getDescription() != null && musicInfo.getDescription() != "") {
					 data .setDescription(musicInfo.getDescription());
				}

				

				transaction.commit();
		return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
			// TODO: handle exception
	}

	@Override
	public MusicInfo getMusicById(int id) {
	
		EntityManager manager = factory.createEntityManager();
		MusicInfo bean = manager.find(MusicInfo.class, id);
		return bean;
	}

	@Override
	public MusicInfo getMusicByName(String name) {
		EntityManager manager = factory.createEntityManager();
		MusicInfo bean = manager.find(MusicInfo.class, name);
		return bean;
	}

}
