package com.nouhoun.springboot.jwt.integration.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nouhoun.springboot.jwt.exception.StorageFileNotFoundException;
import com.nouhoun.springboot.jwt.integration.service.StorageService;

@Controller
public class FileUploadController {

    private final StorageService storageService;
    private final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    private static String UPLOADED_FOLDER = "c://temp//";
    
    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                new Function<Path, Object>() {
					@Override
					public Object apply(Path path) {
						return MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						        "serveFile", path.getFileName().toString()).build().toString();
					}
				})
                .collect(Collectors.toList()));
        logger.debug("Multiple file upload! -- > 3");
        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
    	 logger.debug("Multiple file upload --> 1!");
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
      
       
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile uploadfile,
            RedirectAttributes redirectAttributes) {

    	logger.debug("Single file upload!");

        if (uploadfile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try {

            saveUploadedFiles(uploadfile);

        } catch (IOException e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully uploaded - " +
                uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
    
  //save file
    private void saveUploadedFiles(MultipartFile file) throws IOException {

      //  for (MultipartFile file : files) {

        //    if (file.isEmpty()) {
        //        continue; //next pls
        //    }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

  //      }

    }

}