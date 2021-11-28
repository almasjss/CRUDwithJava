package com.example.SpringMidtermProject.Service;

import com.example.SpringMidtermProject.Entity.Cakes;
import com.example.SpringMidtermProject.Entity.User;
import com.example.SpringMidtermProject.Helpers.PasswordValidationHelper;
import com.example.SpringMidtermProject.Helpers.ValidateHelper;
import com.example.SpringMidtermProject.Models.CakesRequest;
import com.example.SpringMidtermProject.Models.UserRequest;
import com.example.SpringMidtermProject.Repository.CakesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CakesService {

    @Autowired
    private CakesRepository cakesRepository;

    public boolean saveOrder(CakesRequest cakesRequest) {
        boolean isActive = false;
        Cakes cakes = new Cakes(cakesRequest.getTitle(), cakesRequest.getCakeDescription(),
                cakesRequest.getDiameter(), cakesRequest.getPrice());
        cakesRepository.save(cakes);
        return true;
    }

    public Cakes getOrder(Integer cakeid) {

        return cakesRepository.findById(cakeid.longValue()).orElse(null);
    }

    public boolean updateCakes(CakesRequest cakesRequest){
        Optional<Cakes> cakesOptional =cakesRepository.findById(cakesRequest.getCakesid().longValue());
        Cakes cakes = cakesOptional.orElse(null);
        cakes.setTitle(cakesRequest.getTitle());
        cakes.setCakeDescription(cakesRequest.getCakeDescription());
        cakes.setDiameter(cakesRequest.getDiameter());
        cakes.setPrice(cakesRequest.getPrice());
        cakesRepository.save(cakes);
        return true;
    }

    public boolean deleteCake(Integer cakesid) {
        Optional<Cakes> cakesOptional =cakesRepository.findById(cakesid.longValue());
        Cakes cakes = cakesOptional.orElse(null);
        cakesRepository.delete(cakes);
        return true;
    }

}
