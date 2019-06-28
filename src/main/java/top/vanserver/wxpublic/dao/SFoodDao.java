package top.vanserver.wxpublic.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.vanserver.wxpublic.bean.Food;

@Mapper
@Repository
public interface SFoodDao {
    Food SelectOneFood(int mathi);
}
