package top.vanserver.wxpublic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vanserver.wxpublic.service.SFoodService;

import java.util.Random;

@RestController
public class SFoodController {
    @Autowired
    SFoodService sFoodService;

    int mathi;
    Random re=new Random();
    @RequestMapping(value = "sfood")
    public String SelectFood(){
        mathi=re.nextInt(1000000)+1;
        String  foodName= sFoodService.SelectOneFood(mathi);
        return  foodName;
    }


}
