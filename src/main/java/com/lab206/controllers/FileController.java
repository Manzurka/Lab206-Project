package com.lab206.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab206.models.File;
import com.lab206.repositories.FileUploadDAO;
import com.lab206.services.ProjectService;
import com.lab206.services.UserService;

@Controller
public class FileController {
	private UserService us;
	private ProjectService ps;
	
	public FileController(UserService us, ProjectService ps) {
		this.us = us;
		this.ps = ps;
	}
		
	@Autowired
    private FileUploadDAO fileUploadDao;
	
	@RequestMapping("/showFile/{id}")
	public String showFiles(HttpServletRequest request,
				HttpServletResponse response,
				@PathVariable ("id") Long id,
				Model model) throws ServletException, IOException {
		File item = fileUploadDao.findById(id).get();  
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(item.getData());
        response.getOutputStream().close();
        model.addAttribute("show", response);
        
        return "redirect:/dashboard";
}
//image/docx, image/pdf, image/txt, image/css, image/js 
	
	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	  public void showImage(@RequestParam("id") Long userId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{
		Long imageId = us.findById(userId).getFile().getId();		
		File item = fileUploadDao.findById(imageId).get();      
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(item.getData());
	    response.getOutputStream().close();
	}
	
	@RequestMapping(value = "/projectImage", method = RequestMethod.GET)
	  public void projectImage(@RequestParam("id") Long projectId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{
		Long imageId = ps.findProjectById(projectId).getThumbnail().getId();
		File item = fileUploadDao.findById(imageId).get();      
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(item.getData());
	    response.getOutputStream().close();
	}
}
