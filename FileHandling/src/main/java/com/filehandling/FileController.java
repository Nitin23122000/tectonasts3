package com.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.http.HttpHeaders;
import java.util.Arrays;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

	
	//upload the file
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		
		
		
		String filepath=System.getProperty("user.dir") + "/uploads" +File.separator +file.getOriginalFilename(); 
		String fileUploadStatus;
		
		try {
			FileOutputStream fout=new FileOutputStream(filepath);
			fout.write(file.getBytes());
			fout.close();
			
			fileUploadStatus="File upload successfully";
		} catch (Exception e) {
			e.printStackTrace();
			fileUploadStatus=" Error in uploading the file"+e;
		}
		return fileUploadStatus;
	}
	
	// getting list of file names
	@GetMapping("/getFiles")
	public String[] getFiles() {
		
		String folderPath=System.getProperty("user.dir")+"/uploads";
		
		File directory=new File(folderPath);
		
		String [] filenames=directory.list();
		
		return filenames;
	}
	
	//Download the file
	
	@GetMapping("/download/{path:.+}")
	public ResponseEntity downLoadFile(@PathVariable("path") String filename) throws FileNotFoundException{
		
		String fileUploadPath=System.getProperty("user.dir")+"/Uploads";
		String[] filenames=this.getFiles();
		boolean contains=Arrays.asList(filenames).contains(filename);
		if(!contains) {
			return new ResponseEntity("File not found",HttpStatus.NOT_FOUND);
		}
		
		//setting up the file path
		
		String filePath= fileUploadPath+File.separator+filename;
		
		//creating a new file instance
		File file=new File(filePath);
		
		//creating a inputstreamresource object
		
		InputStreamResource resource=new InputStreamResource(new FileInputStream(file));
		
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		
		String contentType="application/octet-stream";
		String headerValue="attachment; filename=\"" +resource.getFilename()+"\"";
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
		        .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, headerValue)
		        .body(resource);
}
}