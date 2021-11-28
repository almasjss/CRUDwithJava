package com.example.SpringMidtermProject.Controllers;

import com.example.SpringMidtermProject.Constants.Constants;
import com.example.SpringMidtermProject.Entity.Cakes;
import com.example.SpringMidtermProject.Entity.User;
import com.example.SpringMidtermProject.Helpers.PasswordValidationHelper;
import com.example.SpringMidtermProject.Helpers.ValidateHelper;
import com.example.SpringMidtermProject.Models.CakesRequest;
import com.example.SpringMidtermProject.Models.UserRequest;
import com.example.SpringMidtermProject.Service.CakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cakes")
public class CakesController {

    @Autowired
    private CakesService cakesService;

    @Autowired
    public void setCakesService(CakesService cakesService){
        this.cakesService=cakesService;

    }

    @PostMapping("/cakes-order")
    public ResponseEntity createCake(@RequestParam CakesRequest cakesRequest) {
        boolean result = cakesService.saveOrder(cakesRequest);
        if (!result) {
            return new ResponseEntity(Constants.ORDERED_SUCCESSFULLY, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(cakesRequest);
    }

    @GetMapping("/cakesget")
    public ResponseEntity getCake(@RequestParam Integer cakes_id) {
        Cakes cakes = cakesService.getOrder(cakes_id);
        if (cakes == null) {
            return new ResponseEntity(Constants.ORDER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(cakes);
    }
    @PostMapping("/edit")
    public ResponseEntity updateCakes(@RequestBody CakesRequest cakesRequest) {
        boolean result = cakesService.updateCakes(cakesRequest);
        if (!result) {
            return new ResponseEntity(Constants.EDITING_FAILED, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(cakesRequest);
    }
    @GetMapping("/delete")
    public ResponseEntity deleteCake(@RequestParam Integer cakesid) {
        boolean result = cakesService.deleteCake(cakesid);
        if (!result) {
            return new ResponseEntity(Constants.DELETING_FAILED, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(Constants.DELETED_SUCCESSFULLY, HttpStatus.OK);
    }

}
