package com.source.administrator.listtest;

/**
 * Created by Administrator on 6/28/2016.
 */
public class Drink {
    private String name;
    private String description;
    private int imageResourceId;
    public static final Drink[]drinks={new Drink("Latte","A couple of espresso shots with hot milk ",R.drawable.latte),new Drink("Cappucinno","Esspresso hot milk and a steamed milk foam",R.drawable.cappuccino)
    ,new Drink("Filter","Highest quality beans roastedand brewed fresh",R.drawable.filter)};
    private Drink(String name,String description,int imageResourceId)
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
