package com.lab206.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.lab206.models.File;
import com.lab206.repositories.FileUploadDAO;

@Service
public class FileService {
	
	private FileUploadDAO fileUploadDao;
	
	public FileService(FileUploadDAO fileUploadDao) {
		this.fileUploadDao = fileUploadDao;
	}
	
	public File createFile(MultipartFile multipartFile) throws Exception {
		if( multipartFile.getBytes() != null
				&& multipartFile.getOriginalFilename().contains(".gif")
				|| multipartFile.getOriginalFilename().contains(".png")
				|| multipartFile.getOriginalFilename().contains(".jpg")) {
			File uploadedFile = new File();
            uploadedFile.setFileName(multipartFile.getOriginalFilename());
            uploadedFile.setData(multipartFile.getBytes());
            return fileUploadDao.save(uploadedFile);
		}
		return null;
	}
	
	public File replaceFile(MultipartFile multipartFile) {
		return new File();
	}

}
