package com.example.kymanage.Beans.UpdateSemiStorage;

import java.io.Serializable;

public class AdvancedListBean implements Serializable {
    private String MaterialCode;//物料编码
    private String MaterialDes;//物料描述
    private long Num;//数量
    private String Factory;//工厂
    private String Area;//库存地点
    private String ProjectText;//项目文本

    public AdvancedListBean() {
    }

    public AdvancedListBean(String materialCode, String materialDes, long num, String factory, String area, String projectText) {
        MaterialCode = materialCode;
        MaterialDes = materialDes;
        Num = num;
        Factory = factory;
        Area = area;
        ProjectText = projectText;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String materialCode) {
        MaterialCode = materialCode;
    }

    public String getMaterialDes() {
        return MaterialDes;
    }

    public void setMaterialDes(String materialDes) {
        MaterialDes = materialDes;
    }

    public long getNum() {
        return Num;
    }

    public void setNum(long num) {
        Num = num;
    }

    public String getFactory() {
        return Factory;
    }

    public void setFactory(String factory) {
        Factory = factory;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getProjectText() {
        return ProjectText;
    }

    public void setProjectText(String projectText) {
        ProjectText = projectText;
    }
}
