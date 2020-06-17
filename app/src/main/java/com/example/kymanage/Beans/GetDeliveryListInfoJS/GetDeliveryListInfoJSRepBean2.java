package com.example.kymanage.Beans.GetDeliveryListInfoJS;

import java.util.List;

public class GetDeliveryListInfoJSRepBean2 {
    private List<GetDeliveryListInfoJSRepBean1> data;
    private String NAME_ORG1;
    private String VBELN_VL;

    public List<GetDeliveryListInfoJSRepBean1> getData() {
        return data;
    }

    public void setData(List<GetDeliveryListInfoJSRepBean1> data) {
        this.data = data;
    }

    public String getNAME_ORG1() {
        return NAME_ORG1;
    }

    public void setNAME_ORG1(String NAME_ORG1) {
        this.NAME_ORG1 = NAME_ORG1;
    }

    public String getVBELN_VL() {
        return VBELN_VL;
    }

    public void setVBELN_VL(String VBELN_VL) {
        this.VBELN_VL = VBELN_VL;
    }
}
