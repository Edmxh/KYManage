package com.example.kymanage.Beans.GetMaterialStorage;

/**
 * {
 * "factory":"2010",
 * "materialcode":"DQ4402000001"
 * }
 */
public class GetMaterialStorageReq {
    private String factory;
    private String materialcode;

    public GetMaterialStorageReq() {
    }

    public GetMaterialStorageReq(String factory, String materialcode) {
        this.factory = factory;
        this.materialcode = materialcode;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getMaterialcode() {
        return materialcode;
    }

    public void setMaterialcode(String materialcode) {
        this.materialcode = materialcode;
    }
}
