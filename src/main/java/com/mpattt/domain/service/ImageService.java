package com.mpattt.domain.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mpattt.app.user.ImageAddForm;
import com.mpattt.domain.entity.Image;
import com.mpattt.domain.repository.ImageRepository;

@Service
public class ImageService {
	
	private static String UPLOAD_ROOT = "src/main/resources/static/upload";
	
	private final ImageRepository respository;
	private final ResourceLoader resourceLoader;
	
	@Autowired
	public ImageService(ImageRepository respository,ResourceLoader resourceLoader){
		this.respository = respository;
		this.resourceLoader = resourceLoader;
	}
	
	public Page<Image> findPage(Pageable pageable){
		return respository.findAll(pageable);
	}
	
	public Resource findOneImage(String filename){
		return resourceLoader.getResource("file:" + UPLOAD_ROOT +"/"+filename);
	}
	


	public void createImage(ImageAddForm imageAddForm,MultipartFile file) throws IOException {
		if(!file.isEmpty()){
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_ROOT,file.getOriginalFilename()));
			Image img = new Image(file.getOriginalFilename());
			img.setDate(imageAddForm.getDate());
			img.setLocation(imageAddForm.getLocation());
			respository.save(img);
		}
	}

	
	

}
