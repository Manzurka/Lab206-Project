package com.lab206.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.security.Principal;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lab206.models.FileModel;
import com.lab206.models.User;
import com.lab206.services.UserService;
import com.lab206.validator.UserValidator;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class FileUploadController {
	
	   private final UserService userService;
	   
	   @Autowired
	   ServletContext context; 
	   
	   public FileUploadController (UserService userService) {
			this.userService = userService;
		}
	   
		@RequestMapping("/fileUploadPage")
		public String addimage() {
			return "FileUpload.jsp";
		}

	   @RequestMapping(value="/fileUploadPage", method = RequestMethod.POST)
	   public String fileUpload(Principal principal, @Validated FileModel file, BindingResult result, ModelMap model) throws IOException {
		   if(result.hasErrors()) {
			     return "FileUpload.jsp";
		   } else {
			     System.out.println("Fetching file");
		         MultipartFile multipartFile = file.getFile();
		         String uploadPath = context.getRealPath("")+ "avatars" + File.separator;
		         System.out.println(uploadPath);
		         FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath+file.getFile().getOriginalFilename()));
		         String fileName = multipartFile.getOriginalFilename();
		         User currentUser = userService.findByUsername(principal.getName());
				 currentUser.setImage(fileName);
				 userService.save(currentUser);
				 model.addAttribute("currentUser", currentUser);
				 model.addAttribute("fileName", fileName);
		         model.addAttribute("msg", "uploaded");
				 System.out.println("Saved file");
		         return "dashboard.jsp";
		   }
	   }
		   
}
