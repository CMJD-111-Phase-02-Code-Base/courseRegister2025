package lk.ijse.cmjd_111.CourseRegistration2025.controller;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.CourseMaterialDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.PostExchange;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@RestController
@RequestMapping("material")
public class CourseMaterialController {
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CourseMaterialDTO> saveMaterial(
          @RequestParam String materialId,
          @RequestParam String fileName,
          @RequestParam String materialType,
          @RequestParam MultipartFile material,
          @RequestParam (required = false) String uploadAt,
          @RequestParam String courseId
    ){
        //step 1 - Create a DTO based on the received data
        var materialDTO = new CourseMaterialDTO();

        try {
            //Step 2 - Build the object
                //Step - 2.1 - Create Byte collection from the Multipart value
            byte [] materialBytes = material.getBytes();
               // step - 2.2 - Create String based on the byte collection
            String materialString = Base64.getEncoder().encodeToString(materialBytes);
           //Step 3 - Create date if not provided
           String uploadTime = uploadAt != null ? uploadAt : LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
           //Step 4 - Set the object fields
            materialDTO.setMaterialId(materialId);
            materialDTO.setFileName(fileName);
            materialDTO.setMaterialType(materialType);
            materialDTO.setMaterial(materialString);
            materialDTO.setUploadAt(uploadTime);
            materialDTO.setCourseId(courseId);

        }catch (Exception ex){
            ex.printStackTrace();
            return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(materialDTO, HttpStatus.OK);
    }
}
