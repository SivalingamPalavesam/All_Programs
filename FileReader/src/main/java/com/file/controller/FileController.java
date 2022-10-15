package com.file.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.file.dto.ResponseFile;
import com.file.dto.ResponseMessage;
import com.file.entity.FileDB;
import com.file.service.FileService;

@RestController
public class FileController {

	@Autowired
	private FileService fileService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		String message = "";

		String type1 = "application/pdf";
		String type2 = "application/msword";
		String type3 = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

		System.out.println(file.getContentType());
		if (type1.equals(file.getContentType()) || type2.equals(file.getContentType()) || type3.equals(file.getContentType())) {
			try {
				fileService.store(file);
				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}
		message = "Please upload a PDF  || msword  ||  docx  file only!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));

	}

	@GetMapping(value = "Allfiles")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		try {

			List<ResponseFile> files = fileService.getAllFiles().map(dbFile -> {
				String fileDownloadUri = ServletUriComponentsBuilder
						.fromCurrentContextPath()
						.path("/Allfiles/")
						.path(dbFile.getId())
						.toUriString();

				return new ResponseFile(dbFile.getName(), 
						fileDownloadUri, dbFile.getType(), 
						dbFile.getData().length);
			}).collect(Collectors.toList());

			if (files.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return ResponseEntity.status(HttpStatus.OK).body(files);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Text")
	public String getPDFFiles() throws IOException {

		return fileService.getPDFFiles();
	}

	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadFile(@PathVariable String fileName) throws IOException {

		byte[] fileData = fileService.downloadFile(fileName);
			
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("application/pdf"))
				.body(fileData);
	}

	@GetMapping("/Allfiles/download/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		FileDB fileDB = fileService.getFile(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}

}
