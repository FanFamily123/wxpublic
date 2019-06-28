package top.vanserver.wxpublic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vanserver.wxpublic.bean.Food;
import top.vanserver.wxpublic.dao.SFoodDao;
@Service
public class SFoodService {
    @Autowired
    private SFoodDao sFoodDao;

    public String SelectOneFood(int mathi){
        Food food=sFoodDao.SelectOneFood(mathi);
        return  food.getName();
    }
}
