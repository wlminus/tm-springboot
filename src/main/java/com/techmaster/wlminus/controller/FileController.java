package com.techmaster.wlminus.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@RestController
public class FileController {

    @PostMapping("/file/level1")
    public String multiPartFormData1(MultipartFile file) {
        System.out.println(file);
        return "Done level1";
    }

    @PostMapping("/file/level2")
    public String multiPartFormData2(MultipartFile file, MultipartFile newFile) {
        System.out.println(file);
        System.out.println(newFile);
        return "Done level2";
    }

    @PostMapping(value = "/file/level3",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String multiPartFormData3(@RequestParam("newFile") MultipartFile file) {
        System.out.println(file);
        return "Done level3";
    }

    @PostMapping(value = "/file/level25")
    public String multiPartFormData25(@RequestPart("newFile") MultipartFile file) {
        System.out.println(file);
        return "Done level25";
    }

    @PostMapping(value = "/file/level4")
    public String multiPartFormData4(@RequestBody MultipartFile file) {
        System.out.println(file);
        return "Done level4";
    }

    @PostMapping(value = "/file/level5")
    public String multiPartFormData5(@RequestBody MultipartFile[] file) {
        System.out.println(Arrays.toString(file));
        return "Done level5";
    }

    @PostMapping(value = "/file/level6")
    public String multiPartFormData6(@RequestBody List<MultipartFile> file) {
        System.out.println(file);
        return "Done level6";
    }

    @PostMapping(value = "/file/level7",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String multiPartFormData7(FileVM fileVM) {
        System.out.println(fileVM);
        return "Done level7";
    }

    @PostMapping(value = "/file/level8")
    public String multiPartFormData8(InputStream file) {
        System.out.println(file);
        return "Done level8";
    }

    @PostMapping(value = "/file/level9")
    public String multiPartFormData9(@RequestBody String based64) {
        System.out.println(based64);
        var file = Base64.getDecoder().decode(based64);
        System.out.println(Arrays.toString(file));
        return "Done level9";
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FileVM {
        private String title;
        private String desc;
        private MultipartFile file;
    }
}
