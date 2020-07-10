package com.example.kymanage.API;

public interface API {
    String BASEURL = "http://10.254.100.81/";
    //登录
    String LOGIN = "ThingX/Things/AppProgramThing/Services/Login";


    //物流通用-----------------------------------------------------------------------
    //获取物料主数据接口
    String GetMaterialMasterDataJS="ThingX/Things/AppProgramThing/Services/GetMaterialMasterDataJS";
    //获取要预占物料的生产订单信息
    String PreMaterialProductOrder= "ThingX/Things/AppProgramThing/Services/PreMaterialProductOrder";

    //采购---------------------------------------------------------------------------
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
    String GetPurWayMaterialData="ThingX/Things/AppProgramThing/Services/GetPurWayMaterialData";
    //库房收货及发料接口
    String WarehouseReceipt="ThingX/Things/AppProgramThing/Services/WarehouseReceipt";
    //库房收货(采购入库)记录
    String WarehouseReceiptRecord="ThingX/Things/AppProgramThing/Services/WarehouseReceiptRecord";
    //获取物料库存信息接口
    String GetStockInformationDataJS="ThingX/Things/AppProgramThing/Services/GetStockInformationDataJS";
    //261生产订单发料
    String InsertProductOrderIssue="ThingX/Things/AppProgramThing/Services/InsertProductOrderIssue";

    String SendProductOrderIssue="ThingX/Things/AppProgramThing/Services/SendProductOrderIssue";

    //扫码发料
    String ScanIssueNoteDetail="ThingX/Things/AppProgramThing/Services/ScanIssueNoteDetail";

    //打印发料单及发料接口
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
    String Warehouse105Writeoff="ThingX/Things/AppProgramThing/Services/Warehouse105Writeoff";

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

    //外协采购半成品收货记录接口
    String Semi_FinishedProductReceivingRecordJS="ThingX/Things/AppProgramThing/Services/Semi-FinishedProductReceivingRecordJS";

    //外协采购半成品收货冲销接口
    String Semi_FinishedProductReceivingwriteoffJS="ThingX/Things/AppProgramThing/Services/Semi-FinishedProductReceivingwriteoffJS";

    //外协采购成品收货记录接口
    String GetOutsoureFinProductDataJS="ThingX/Things/AppProgramThing/Services/GetOutsoureFinProductDataJS";

    //##外协采购成品收货冲销接口
    String OutsoureFinProductWriteOffJS="ThingX/Things/AppProgramThing/Services/OutsoureFinProductWriteOffJS";

    //##外协采购成品标签打印接口
    String GetOutsourceFinProLableJS="ThingX/Things/AppProgramThing/Services/GetOutsourceFinProLableJS";

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

    //##获取厂内配送单
    String GetCMInFactoryDeliver="ThingX/Things/AppProgramThing/Services/GetCMInFactoryDeliver";

    //###获取交货单信息
    String GetDeliveryListInfoJS="ThingX/Things/AppProgramThing/Services/GetDeliveryListInfoJS";

    //###获取交货单信息
    String GetDeliveryListDetailDataJS="ThingX/Things/AppProgramThing/Services/GetDeliveryListDetailDataJS";

    //获取销售发货物料信息及库存地点
    String GetLableStorageInfoJS="ThingX/Things/AppProgramThing/Services/GetLableStorageInfoJS";



    //物料查询----------------------------------------------------------------------------------------------------------------------------------------
    //物料查询
    String GetMaterialStorage="ThingX/Things/AppProgramThing/Services/GetMaterialStorage";






}
