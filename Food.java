package com.source.administrator.listtest;

/**
 * Created by Administrator on 6/29/2016.
 */
public class Food {
    private String name;
    private String description;
    private int imageResourceId;
    public static final Food[]foods={new Food("Burger","World class burgers with fresh patties and hand made buns ",R.drawable.burger),new Food("Hotdog","Freshly made hot dogs with poltry fresh meat, available in veg and non-veg",R.drawable.hotdog)
            ,new Food("Sandwiches","Highest quality fresh vegetables packed into a choice of white or brown bread served with your choice of dressing.",R.drawable.sandwich)};
    private Food(String name,String description,int imageResourceId)
    {
        this.name=name;
        this.description=description;
        this.imageResourceId=imageResourceId;
    }
    public String getDescription()
    {
        return  description;
    }
    public String getName()
    {
        return name;
    }
    public int getImageResourceId()
    {
        return imageResourceId;
    }
    public String toString()
    {
        return name;
    }
}
