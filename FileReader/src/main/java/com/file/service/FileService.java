package com.file.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.file.entity.FileDB;
import com.file.repository.FileRepository;

@Service
public class FileService {
	@Autowired
	private FileRepository fileRepository;

	public FileDB store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

		return fileRepository.save(FileDB);
	}

	public Stream<FileDB> getAllFiles() {
		return fileRepository.findAll().stream();
	}

	public String getPDFFiles() throws IOException {

		File file = new File("D:\\SivaResume.pdf");
		PDDocument document = PDDocument.load(file);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String text = pdfStripper.getText(document);
		System.out.println(text);
		document.close();
		return text;
	}

	public byte[] downloadFile(String fileName) throws IOException {

		Optional<FileDB> doc = fileRepository.findByName(fileName);
		File filePath = new File("C:/Users/ELCOT/Pictures/doc.txt");
		OutputStream obj = new FileOutputStream(filePath);
		byte[] by = doc.get().getData();
		by.toString();
		String s = new String(by, StandardCharsets.UTF_8);
		System.out.println("Output : " + s);
		obj.write(doc.get().getData());
	
		
		
		
//		byte[] files = ImageUtils.decompressdoc(doc.get().getData());
//		String filess = files.toString();
//		byte[] bytes = filess.getBytes(StandardCharsets.UTF_8);
//		System.out.println("Text [Byte Format] toString() : " + bytes.toString());
//		String s = new String(bytes, StandardCharsets.UTF_8);
//		System.out.println("Output : " + s);		
//		FileUtils.writeStringToFile(new File("C:/Users/ELCOT/Pictures/doc.txt"), s, Charset.forName("UTF-8"));
//
//		File file = new File("C:/Users/ELCOT/Pictures/doc.txt");
//
//		response.setContentType("application/octet-stream");
//
//		String headerkey = "Content-Disposition";
//		String headerValue = "attachment;filename = " + file.getName();
//
//		response.setHeader(headerkey, headerValue);
//
//		ServletOutputStream outputStream = response.getOutputStream();
//
//		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//
//		byte[] buffer = new byte[(int) file.length()]; // 1MB buffer size
//
//		int bytesRead = -1;
//
//		while ((bytesRead = inputStream.read(buffer)) != -1) {
//			outputStream.write(buffer, 0, bytesRead);
//
//		}
//		inputStream.close();
//		outputStream.close();

		return null;
	}

	public FileDB getFile(String id) {
		return fileRepository.findById(id).get();
	}
}
