package com.pigmiu.design.singleton;

public class Singleton6 {
    //枚举类实现单例，隐藏枚举类
    public enum SingletonEnum{
        Instance;
        private String object;

        SingletonEnum() {
            object = "完成初始化";
        }

        public String getInstance(){
            return object;
        }
    }
    public static String getObject(){
        return SingletonEnum.Instance.getInstance();
    }


}
