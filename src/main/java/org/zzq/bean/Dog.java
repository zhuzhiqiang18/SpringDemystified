package org.zzq.bean;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal,Eat{
    private String foodName;

    @Override
    public String say() {
        return "汪汪汪汪！";
    }


    @Override
    public String getFoodName() {
        return foodName;
    }

    @Override
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
