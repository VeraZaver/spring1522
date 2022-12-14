package com.example.spring152.controllers;

import com.example.spring152.models.ItemModel;
import com.example.spring152.models.enams.ItemEnum;
import com.example.spring152.repos.ItemRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import com.example.spring152.services.FirebaseImageService;

@Controller
@RequestMapping("/addItem")
public class AddItemController {

    final ItemRepo itemRepo;
    private String name;


    final FirebaseImageService firebaseImageService;

    public AddItemController(ItemRepo itemRepo, FirebaseImageService firebaseImageService) {
        this.itemRepo = itemRepo;
        this.firebaseImageService = firebaseImageService;
    }

    @GetMapping
    public String getAddItemPage(){
        return "addItem";
    }

    @PostMapping
    public RedirectView setData(@RequestParam String name,
                                @RequestParam String price,
                                @RequestParam String disc,
                                @RequestParam MultipartFile file,
                                @RequestParam String type
    ){
        ItemModel itemModel = new ItemModel();
        itemModel.setDisc(disc);
        itemModel.setName(name);
        itemModel.setPrice(price);

       String fileName =  firebaseImageService.save(file);
       itemModel.setUrl(fileName);


        switch (type){
            case "Автомобили":
                itemModel.setItemEnum(ItemEnum.AUTOS);
                break;
            case "Котики":
                itemModel.setItemEnum(ItemEnum.CATS);
                break;
            case "Бытовая техника":
                itemModel.setItemEnum(ItemEnum.HOMETECHNICS);
                break;
            case "Наркотики":
                itemModel.setItemEnum(ItemEnum.OTHER);
                break;
            default:
                itemModel.setItemEnum(ItemEnum.OTHER);
                break;
        }

        itemRepo.save(itemModel);
        RedirectView redirectView = new RedirectView("/");

        return redirectView;
    }
}
