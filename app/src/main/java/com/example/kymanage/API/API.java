package com.example.kymanage.API;

public interface API {
//    PropertiesUtil pt = new PropertiesUtil();
//    String filename = new File("app/src/main/java/com/example/kymanage/config/config.properties").getAbsolutePath();


//    String BASEURL = "http://"+pt.getString("baseurl")+"/";
    String BASEURL = "http://"+"10.254.100.81"+"/";
    //登录
    String LOGIN = "ThingX/Things/AppProgramThing/Services/Login";

    //更新APP
    String UpdateApp = "ThingX/Things/AppProgramThing/Services/UpdateAPP";


    //物流通用-----------------------------------------------------------------------
    //获取物料主数据接口
    String GetMaterialMasterDataJS="ThingX/Things/AppProgramThing/Services/GetMaterialMasterDataJS";
    //获取要预占物料的生产订单信息
    String PreMaterialProductOrder= "ThingX/Things/AppProgramThing/Services/PreMaterialProductOrder";

    //批量获取预占物料的生产订单信息接口
    String PreMaterialProductOrderJS= "ThingX/Things/AppProgramThing/Services/PreMaterialProductOrderJS";


    //采购---------------------------------------------------------------------------
    //获取预收货物料信息
    String GetPreRecMaterialCodeInfoJS= "ThingX/Things/AppProgramThing/Services/GetPreRecMaterialCodeInfoJS";

    //103收货
    String AdvanceRec103JS= "ThingX/Things/AppProgramThing/Services/AdvanceRec103JS";



    //查询采购列表
    String GetRecevingDetail= "ThingX/Things/AppProgramThing/Services/GetRecevingDetail";
    //采购收货103预入库
    String MaterialFlow103= "ThingX/Things/AppProgramThing/Services/MaterialFlow103";
    //获取采购中心收货记录
    String PurchaseCenterRecord= "ThingX/Things/AppProgramThing/Services/PurchaseCenterRecord";
    //物流通用103预入库冲销
    String MaterialFlow103WriteOff="ThingX/Things/AppProgramThing/Services/MaterialFlow103WriteOff";
    //打印采购中心标签接口
    String GetParchaseCenterLable= "ThingX/Things/AppProgramThing/Services/GetParchaseCenterLable";
    //获取库位信息接口
    String GetSapStorageInfoByFactoryJS= "ThingX/Things/KY_SiteBaseDataManage/Services/GetSapStorageInfoByFactoryJS";


    //库房---------------------------------------------------------------------------
    //获取库房收货物料信息接口
    String GetMaterialPropertieInfoJS="ThingX/Things/AppProgramThing/Services/GetMaterialPropertieInfoJS";
    //库房收货及发料接口
    String WarehouseReceipt="ThingX/Things/AppProgramThing/Services/WarehouseReceipt";
    //库房收货(采购入库)记录
    String WarehouseReceiptRecord="ThingX/Things/AppProgramThing/Services/WarehouseReceiptRecord";
    //获取物料库存信息接口
    String GetStockInformationDataJS="ThingX/Things/AppProgramThing/Services/GetStockInformationDataJS";
    //261生产订单发料
//    String InsertProductOrderIssue="ThingX/Things/AppProgramThing/Services/InsertProductOrderIssue";
    String SendProductOrderIssue="ThingX/Things/AppProgramThing/Services/SendProductOrderIssue";

    //扫码发料
    String ScanIssueNoteDetail="ThingX/Things/AppProgramThing/Services/ScanIssueNoteDetail";


    //打印库房标签
    String GenerateStorageLssueRecord="ThingX/Things/AppProgramThing/Services/GenerateStorageLssueRecord";

    //打印库房标签
    String GetIssueNoteDetail="ThingX/Things/AppProgramThing/Services/GetIssueNoteDetail";
    //库房发料记录接口
    String GetIssueDetailRecord="ThingX/Things/AppProgramThing/Services/GetIssueDetailRecord";
    //库房261发料冲销
    String WriteOffProductOrderIssue="ThingX/Things/AppProgramThing/Services/WriteOffProductOrderIssue";
    //打印库房标签接口
    String InsertStorageLableRecord="ThingX/Things/AppProgramThing/Services/InsertStorageLableRecord";
    //补打库房标签接口
    String GetWarehouselabel="ThingX/Things/AppProgramThing/Services/GetWarehouselabel";
    //库房105入库冲销接口
    String Warehouse105Writeoff="ThingX/Things/AppProgramThing/Services/WarehouseReceiptWriteoff";

    //#获取301转储收获确认记录
    String GetTransferRecord="ThingX/Things/AppProgramThing/Services/GetTransferRecord";

    //301转储发料
    String InsertDumpTransferRecord="ThingX/Things/AppProgramThing/Services/InsertDumpTransferRecord";

    //外协------------------------------------------------------------------------------------------
    //获取采购订单信息接口（机加）
    String GetPurchaseOrderInfoJS="ThingX/Things/AppProgramThing/Services/GetPurchaseOrderInfoJS";

    //外协采购半成品收货接口（103、105）
    String Semi_FinishedProductReceiving="ThingX/Things/AppProgramThing/Services/Semi-FinishedProductReceiving";

    //外协采购成品收货入库接口（103、105、261、101或103、105）
    String OutsourceFinishedProductReceivingJS="ThingX/Things/AppProgramThing/Services/OutsourceFinishedProductReceivingJS";

    //101成品入库
    String InsertFinProStorageRecord="ThingX/Things/AppProgramThing/Services/InsertFinProStorageRecord";

    //#获取101入库记录（记录查询）
    String GetFinProStorageRecord="ThingX/Things/AppProgramThing/Services/GetFinProStorageRecord";

    //获取成品入库时可选的生产订单接口
    String GetOutStorageMaterialOrderJS="ThingX/Things/AppProgramThing/Services/GetOutStorageMaterialOrderJS";

    //#101入库冲销接口
    String WriteOffProStorageRecord="ThingX/Things/AppProgramThing/Services/WriteOffProStorageRecord";

    //获取机加101入库标签信息
    String GetFinProStorageRecordNote="ThingX/Things/AppProgramThing/Services/GetFinProStorageRecordNote";

    //获取生产派工单接口
    String GetDispatchListJS="ThingX/Things/AppProgramThing/Services/GetDispatchListJS";

    //外协半成品费用入库类型2标签打印接口
    String Semi_FinishedProductReceivingLable="ThingX/Things/AppProgramThing/Services/Semi-FinishedProductReceivingLable";

    //外协采购半成品收货记录接口
    String Semi_FinishedProductReceivingRecordJS="ThingX/Things/AppProgramThing/Services/Semi-FinishedProductReceivingRecordJS";

    //外协采购半成品收货冲销接口
    String Semi_FinishedProductReceivingwriteoffJS="ThingX/Things/AppProgramThing/Services/Semi-FinishedProductReceivingwriteoffJS";

    //外协采购成品收货记录接口
    String GetOutsoureFinProductDataJS="ThingX/Things/AppProgramThing/Services/GetOutsoureFinProductDataJS";

    //##外协采购成品收货冲销接口
    String OutsoureFinProductWriteOffJS="ThingX/Things/AppProgramThing/Services/OutsoureFinProductWriteOffJS";

    //##外协采购成品标签打印接口
//    String GetOutsourceFinProLableJS="ThingX/Things/AppProgramThing/Services/GetOutsourceFinProLableJS";
    String GetOutsourceFinProLableDataJS="ThingX/Things/AppProgramThing/Services/GetOutsourceFinProLableDataJS";

    //#301转储接口
    String MaterialFactoryDump="ThingX/Things/AppProgramThing/Services/MaterialFactoryDump";

    //301转储单查询接口
    String GetMainDumpRecord="ThingX/Things/AppProgramThing/Services/GetMainDumpRecord";

    //#301转储详细记录查询
    String GetDumpRecord="ThingX/Things/AppProgramThing/Services/GetDumpRecord";

    //获取301转储配送单
    String GetDumpRecordNode="ThingX/Things/AppProgramThing/Services/GetDumpRecordNode";

    //#301转储冲销
    String WriteOffMaterialFactoryDump="ThingX/Things/AppProgramThing/Services/WriteOffMaterialFactoryDump";

    //301转储子记录冲销
    String WriteOffMaterialFactoryCDump="ThingX/Things/AppProgramThing/Services/WriteOffMaterialFactoryCDump";

    //##外协采购半成品发料厂内配送单生成
    String GetCMInFactoryDeliver="ThingX/Things/AppProgramThing/Services/GetCMInFactoryDeliver";

    //##外协采购半成品配送单打印接口
    String GetCMInFactoryDeliverJS="ThingX/Things/AppProgramThing/Services/GetCMInFactoryDeliverJS";

    //###获取交货单信息
    String GetDeliveryListInfoJS="ThingX/Things/AppProgramThing/Services/GetDeliveryListInfoJS";

    //销售交货单查询
    String GetDeliveryListDataJS="ThingX/Things/AppProgramThing/Services/GetDeliveryListDataJS";


    //销售发货单详情查询
    String GetDeliveryListDetailDataJS="ThingX/Things/AppProgramThing/Services/GetDeliveryListDetailDataJS";

    //获取销售发货物料信息及库存地点
    String GetLableStorageInfoJS="ThingX/Things/AppProgramThing/Services/GetLableStorageInfoJS";

    //外协采购半成品配送单记录查询接口
    String GetInFactoryDeliverListJS="ThingX/Things/AppProgramThing/Services/GetInFactoryDeliverListJS";

    //外协采购半成品配送单详情查询接口
    String GetInFactoryDeliverListDetailJS="ThingX/Things/AppProgramThing/Services/GetInFactoryDeliverListDetailJS";

    //外协半成品发料配送冲销接口厂内配送单整单冲销
    String GetOutSemifinProductIssueWriteOffJS="ThingX/Things/AppProgramThing/Services/GetOutSemifinProductIssueWriteOffJS";

    //厂内配送单单条冲销
    String OutSemifinProductIssueWriteOffJS="ThingX/Things/AppProgramThing/Services/OutSemifinProductIssueWriteOffJS";

    //外协标签打印接口
    String InsertFinAProOrderRecord="ThingX/Things/AppProgramThing/Services/InsertFinAProOrderRecord";

    //获取外协异常登记原因接口
    String GetOutsourcingExceptionTypeJS="ThingX/Things/AppProgramThing/Services/GetOutsourcingExceptionTypeJS";

    //外协收货后冲销接口
    String OutsourcingExceptionJS="ThingX/Things/AppProgramThing/Services/OutsourcingExceptionJS";

    //异常收货记录查询
    String GetOutsoureExceptionRecordJS="ThingX/Things/AppProgramThing/Services/GetOutsoureExceptionRecordJSRepBean";

    //获取301转储配送记录
    String GetDistributorDumpRecordData="ThingX/Things/AppProgramThing/Services/GetDistributorDumpRecordData";


    //物料查询----------------------------------------------------------------------------------------------------------------------------------------
    //物料查询
    String GetMaterialStorage="ThingX/Things/AppProgramThing/Services/GetMaterialStorage";

}
