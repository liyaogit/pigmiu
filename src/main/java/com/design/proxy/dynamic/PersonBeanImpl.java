package com.design.proxy.dynamic;

/**
 * User: yli
 * Date: 2017/7/28
 * Time: 15:29
 */
public class PersonBeanImpl implements PersonBean{
    String name;
    String gender;
    String interests;
    int rating;
    int ratingCount = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public int getHotOrNot(){
        if (ratingCount == 0) return 0;
        return (rating / ratingCount);
    }

    public void setHotOrNot(int rating){
        this.rating += rating;
        ratingCount ++;
    }
}
