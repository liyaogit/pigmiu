package com.pigmiu.design.proxy.dynamic;

/**
 * User: yli
 * Date: 2017/7/28
 * Time: 15:26
 */
public interface PersonBean {
    String getName();
    String getGender();
    String getInterests();
    int getHotOrNot();

    void setName(String name);
    void setGender(String gender) ;
    void setInterests(String interests) ;
    void setHotOrNot(int rating);
}
