package com.example.kymanage.API;



import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordRep;
import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetCMInFactoryDeliverJS.GetCMInFactoryDeliverJSRep;
import com.example.kymanage.Beans.GetDeliveryListDataJS.GetDeliveryListDataJSRep;
import com.example.kymanage.Beans.GetDeliveryListDetailDataJS.GetDeliveryListDetailDataJSRep;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean3;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.Beans.GetDistributorDumpRecordData.GetDistributorDumpRecordDataRep;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRep;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRep;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReps;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRep;
import com.example.kymanage.Beans.GetInFactoryDeliverListDetailJS.GetInFactoryDeliverListDetailJSRep;
import com.example.kymanage.Beans.GetInFactoryDeliverListJS.GetInFactoryDeliverListJSRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueDetailRecord.GetIssueDetailRecordReps;
import com.example.kymanage.Beans.GetLableStorageInfoJS.GetLableStorageInfoJSRep;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRep;
import com.example.kymanage.Beans.GetMarketOrderNoByCode.GetMarketOrderNoByCodeRep;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageRep;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRep;
import com.example.kymanage.Beans.GetOutsourcingExceptionTypeJS.GetOutsourcingExceptionTypeJSRep;
import com.example.kymanage.Beans.GetOutsoureExceptionRecordJS.GetOutsoureExceptionRecordJSRep;
import com.example.kymanage.Beans.GetOutsoureFinProductDataJS.GetOutsoureFinProductDataJSRep;
import com.example.kymanage.Beans.GetMaterialPropertieInfoJS.GetPurWayMaterialDataRep;
import com.example.kymanage.Beans.GetPreRecMaterialCodeInfoJS.GetPreRecMaterialCodeInfoJSRep;
import com.example.kymanage.Beans.GetPreRecMaterialCodeInfoJS.GetPreRecMaterialCodeInfoJSRepBean;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailreps;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.GetSapStorageInfoByFactoryJSBean;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableReps;
import com.example.kymanage.Beans.GetStockInformationDataJS.GetStockInformationDataJSRep;
import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordRep;
import com.example.kymanage.Beans.InsertDumpTransferRecord.InsertDumpTransferRecordRep;
import com.example.kymanage.Beans.InsertFinAProOrderRecord.InsertFinAProOrderRecordRep;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordRep;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueRep;
import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReps;
import com.example.kymanage.Beans.LoginBean;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpRep;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103RepStatus;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.PurchaseCenterRecord.PurchaseCenterRecordReps;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingLable.Semi_FinishedProductReceivingLableRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRep;
import com.example.kymanage.Beans.UpdateApp.UpdateAppRep;
import com.example.kymanage.Beans.WarehouseReceiptRecord.WarehouseReceiptRecordReps;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {
    //登录
    @POST(API.LOGIN)
    Observable<LoginBean> login(@Body RequestBody login);

    //登录
    @POST(API.UpdateApp)
    Observable<UpdateAppRep> UpdateApp(@Body RequestBody login);


    //物流通用
    //物流通用103预入库冲销
    @POST(API.MaterialFlow103WriteOff)
    Observable<StatusRespBean> MaterialFlow103WriteOff(@Body RequestBody datas);
    //获取物料主数据接口
    @POST(API.GetMaterialMasterDataJS)
    Observable<GetMaterialMasterDataRep> GetMaterialMasterDataJS(@Body RequestBody datas);

    //获取要预占物料的生产订单信息
    @POST(API.PreMaterialProductOrder)
    Observable<PreMaterialProductOrderReps> PreMaterialProductOrder(@Body RequestBody noandrow);

    //获取要预占物料的生产订单信息
    @POST(API.PreMaterialProductOrderJS)
    Observable<PreMaterialProductOrderReps> PreMaterialProductOrderJS(@Body RequestBody noandrow);

    //采购
    //获取预收货物料信息
    @POST(API.GetPreRecMaterialCodeInfoJS)
    Observable<GetPreRecMaterialCodeInfoJSRep> GetPreRecMaterialCodeInfoJS(@Body RequestBody noandrow);

    //103收货
    @POST(API.AdvanceRec103JS)
    Observable<CodeMessageBean> AdvanceRec103JS(@Body RequestBody noandrow);


    //采购查询列表
    @POST(API.GetRecevingDetail)
    Observable<GetRecevingDetailreps> GetRecevingDetail(@Body RequestBody noandrow);
    //采购收货103预入库
    @POST(API.MaterialFlow103)
    Observable<MaterialFlow103RepStatus> MaterialFlow103(@Body RequestBody noandrow);
    //获取采购中心收货记录
    @POST(API.PurchaseCenterRecord)
    Observable<PurchaseCenterRecordReps> PurchaseCenterRecord(@Body RequestBody noandrow);

    //打印采购中心标签接口
    @POST(API.GetParchaseCenterLable)
    Observable<GetParchaseCenterLableReps> GetParchaseCenterLable(@Body RequestBody changeinfo);
    //获取库位信息接口
    @POST(API.GetSapStorageInfoByFactoryJS)
    Observable<GetSapStorageInfoByFactoryJSBean> GetSapStorageInfoByFactoryJS(@Body RequestBody changeinfo);

    //库房---------------------------------------------------------------------------
    //获取物料属性信息接口
    @POST(API.GetMaterialPropertieInfoJS)
    Observable<GetPurWayMaterialDataRep> GetMaterialPropertieInfoJS(@Body RequestBody material);
    //库房收货及发料接口
    @POST(API.WarehouseReceipt)
    Observable<CodeMessageBean> warehousereceipt(@Body RequestBody material);
    //库房收货(采购入库)记录
    @POST(API.WarehouseReceiptRecord)
    Observable<WarehouseReceiptRecordReps> WarehouseReceiptRecord(@Body RequestBody issuevouchernumber);
    //获取物料库存信息接口
    @POST(API.GetStockInformationDataJS)
    Observable<GetStockInformationDataJSRep> GetStockInformationDataJS(@Body RequestBody issuevouchernumber);

    //261发料
    @POST(API.SendProductOrderIssue)
    Observable<InsertProductOrderIssueRep> InsertProductOrderIssue(@Body RequestBody material);

    //扫码发料
    @POST(API.ScanIssueNoteDetail)
    Observable<ScanIssueNoteDetailRep> ScanIssueNoteDetail(@Body RequestBody material);

    //打印发料单
    @POST(API.GenerateStorageLssueRecord)
    Observable<GenerateStorageLssueRecordRep> GenerateStorageLssueRecord(@Body RequestBody issuevouchernumber);

    //打印库房标签
    @POST(API.GetIssueNoteDetail)
    Observable<GetIssueNoteDetailRep> getissuenotedetail(@Body RequestBody issuevouchernumber);
    //库房发料记录接口
    @POST(API.GetIssueDetailRecord)
    Observable<GetIssueDetailRecordReps> GetIssueDetailRecord(@Body RequestBody issuevouchernumber);

    //库房261发料冲销
    @POST(API.WriteOffProductOrderIssue)
    Observable<StatusRespBean> WriteOffProductOrderIssue(@Body RequestBody issuevouchernumber);

    //打印库房标签接口
    @POST(API.InsertStorageLableRecord)
    Observable<InsertStorageLableRecordReps> InsertStorageLableRecord(@Body RequestBody issuevouchernumber);
    //补打库房标签接口
    @POST(API.GetWarehouselabel)
    Observable<InsertStorageLableRecordReps> GetWarehouselabel(@Body RequestBody issuevouchernumber);
    //库房105入库冲销接口
    @POST(API.Warehouse105Writeoff)
    Observable<CodeMessageBean> Warehouse105Writeoff(@Body RequestBody issuevouchernumber);

    //获取301转储收获确认记录
    @POST(API.GetTransferRecord)
    Observable<GetTransferRecordRep> GetTransferRecord(@Body RequestBody issuevouchernumber);

    //301转储发料
    @POST(API.InsertDumpTransferRecord)
    Observable<InsertDumpTransferRecordRep> InsertDumpTransferRecord(@Body RequestBody issuevouchernumber);

    //外协-----------------------------------------------------------------------------------------
    //获取采购订单信息接口（机加）
    @POST(API.GetPurchaseOrderInfoJS)
    Observable<GetPurchaseOrderInfoJSReps> GetPurchaseOrderInfoJS(@Body RequestBody issuevouchernumber);

    //外协采购半成品收货接口（103、105）
    @POST(API.Semi_FinishedProductReceiving)
    Observable<Semi_FinishedProductReceivingRep> Semi_FinishedProductReceiving(@Body RequestBody issuevouchernumber);

    //外协采购成品收货入库接口（103、105、261、101或103、105）
    @POST(API.OutsourceFinishedProductReceivingJS)
    Observable<OutsourceFinishedProductReceivingJSRep> OutsourceFinishedProductReceivingJS(@Body RequestBody issuevouchernumber);

    //#101半成品入库
    @POST(API.InsertFinProStorageRecord)
    Observable<InsertFinProStorageRecordRep> InsertFinProStorageRecord(@Body RequestBody issuevouchernumber);

    //#获取101入库记录（记录查询）
    @POST(API.GetFinProStorageRecord)
    Observable<GetFinProStorageRecordReps> GetFinProStorageRecord(@Body RequestBody issuevouchernumber);

    //获取成品入库时可选的生产订单接口
    @POST(API.GetOutStorageMaterialOrderJS)
    Observable<GetOutStorageMaterialOrderJSRep> GetOutStorageMaterialOrderJS(@Body RequestBody issuevouchernumber);

    //101入库冲销接口
    @POST(API.WriteOffProStorageRecord)
    Observable<StatusRespBean> WriteOffProStorageRecord(@Body RequestBody issuevouchernumber);

    //获取机加101入库标签信息
    @POST(API.GetFinProStorageRecordNote)
    Observable<GetFinProStorageRecordNoteRep> GetFinProStorageRecordNote(@Body RequestBody issuevouchernumber);

    //发料及派工单打印
    @POST(API.GetIssueAndDispatchListJS)
    Observable<GetDispatchListJSRep> GetIssueAndDispatchListJS(@Body RequestBody issuevouchernumber);

    //获取生产派工单接口
    @POST(API.GetDispatchListJS)
    Observable<GetDispatchListJSRep> GetDispatchListJS(@Body RequestBody issuevouchernumber);

    //外协半成品费用入库类型2标签打印接口
    @POST(API.Semi_FinishedProductReceivingLable)
    Observable<Semi_FinishedProductReceivingLableRep> Semi_FinishedProductReceivingLable(@Body RequestBody issuevouchernumber);

    //外协采购半成品收货记录接口
    @POST(API.Semi_FinishedProductReceivingRecordJS)
    Observable<Semi_FinishedProductReceivingRecordJSRep> Semi_FinishedProductReceivingRecordJS(@Body RequestBody issuevouchernumber);

    //外协采购半成品收货冲销接口
    @POST(API.Semi_FinishedProductReceivingwriteoffJS)
    Observable<CodeMessageBean> Semi_FinishedProductReceivingwriteoffJS(@Body RequestBody issuevouchernumber);

    //外协采购成品收货记录接口
    @POST(API.GetOutsoureFinProductDataJS)
    Observable<GetOutsoureFinProductDataJSRep> GetOutsoureFinProductDataJS(@Body RequestBody issuevouchernumber);

    //##外协采购成品收货冲销接口
    @POST(API.OutsoureFinProductWriteOffJS)
    Observable<CodeMessageBean> OutsoureFinProductWriteOffJS(@Body RequestBody issuevouchernumber);

    //##外协采购成品标签打印接口
    @POST(API.GetOutsourceFinProLableDataJS)
    Observable<GetOutsourceFinProLableJSRep> GetOutsourceFinProLableDataJS(@Body RequestBody issuevouchernumber);

    //#301转储接口
    @POST(API.MaterialFactoryDump)
    Observable<MaterialFactoryDumpRep> MaterialFactoryDump(@Body RequestBody issuevouchernumber);

    //#301转储单查询接口
    @POST(API.GetMainDumpRecord)
    Observable<GetMainDumpRecordRep> GetMainDumpRecord(@Body RequestBody issuevouchernumber);

    //#301转储详细记录查询
    @POST(API.GetDumpRecord)
    Observable<GetDumpRecordRep> GetDumpRecord(@Body RequestBody issuevouchernumber);

    //获取301转储配送单
    @POST(API.GetDumpRecordNode)
    Observable<GetDumpRecordNodeRep> GetDumpRecordNode(@Body RequestBody issuevouchernumber);

    //301转储冲销
    @POST(API.WriteOffMaterialFactoryDump)
    Observable<StatusRespBean> WriteOffMaterialFactoryDump(@Body RequestBody issuevouchernumber);

    //301转储子记录冲销
    @POST(API.WriteOffMaterialFactoryCDump)
    Observable<StatusRespBean> WriteOffMaterialFactoryCDump(@Body RequestBody issuevouchernumber);

    //##外协采购半成品发料厂内配送单生成
    @POST(API.GetCMInFactoryDeliver)
    Observable<GetCMInFactoryDeliverRep> GetCMInFactoryDeliver(@Body RequestBody issuevouchernumber);

    //##外协采购半成品配送单打印接口
    @POST(API.GetCMInFactoryDeliverJS)
    Observable<GetCMInFactoryDeliverJSRep> GetCMInFactoryDeliverJS(@Body RequestBody issuevouchernumber);

    //###获取交货单信息
    @POST(API.GetDeliveryListInfoJS)
    Observable<GetDeliveryListInfoJSRepBean3> GetDeliveryListInfoJS(@Body RequestBody issuevouchernumber);

    //销售交货单查询
    @POST(API.GetDeliveryListDataJS)
    Observable<GetDeliveryListDataJSRep> GetDeliveryListDataJS(@Body RequestBody issuevouchernumber);

    //销售发货单详情查询
    @POST(API.GetDeliveryListDetailDataJS)
    Observable<GetDeliveryListDetailDataJSRep> GetDeliveryListDetailDataJS(@Body RequestBody issuevouchernumber);

    //销售发货单冲销
    @POST(API.DeliveryListDataWriteOff)
    Observable<CodeMessageBean> DeliveryListDataWriteOff(@Body RequestBody issuevouchernumber);

    //补打销售发货单
    @POST(API.GetDeliveryListJS)
    Observable<GetDeliveryListInfoJSRepBean3> GetDeliveryListJS(@Body RequestBody issuevouchernumber);

    //获取销售发货物料信息及库存地点
    @POST(API.GetLableStorageInfoJS)
    Observable<GetLableStorageInfoJSRep> GetLableStorageInfoJS(@Body RequestBody issuevouchernumber);

    //外协采购半成品配送单记录查询接口
    @POST(API.GetInFactoryDeliverListJS)
    Observable<GetInFactoryDeliverListJSRep> GetInFactoryDeliverListJS(@Body RequestBody issuevouchernumber);

    //外协采购半成品配送单详情查询接口
    @POST(API.GetInFactoryDeliverListDetailJS)
    Observable<GetInFactoryDeliverListDetailJSRep> GetInFactoryDeliverListDetailJS(@Body RequestBody issuevouchernumber);

    //外协半成品发料配送冲销接口
    @POST(API.GetOutSemifinProductIssueWriteOffJS)
    Observable<CodeMessageBean> GetOutSemifinProductIssueWriteOffJS(@Body RequestBody issuevouchernumber);

    //厂内配送单单条冲销
    @POST(API.OutSemifinProductIssueWriteOffJS)
    Observable<CodeMessageBean> OutSemifinProductIssueWriteOffJS(@Body RequestBody issuevouchernumber);

    //获取预占物料销售订单接口
    @POST(API.GetMarketOrderNoByCode)
    Observable<GetMarketOrderNoByCodeRep> GetMarketOrderNoByCode(@Body RequestBody issuevouchernumber);

    //外协标签打印接口
    @POST(API.InsertFinAProOrderRecord)
    Observable<InsertFinAProOrderRecordRep> InsertFinAProOrderRecord(@Body RequestBody issuevouchernumber);

    //获取外协异常登记原因接口
    @POST(API.GetOutsourcingExceptionTypeJS)
    Observable<GetOutsourcingExceptionTypeJSRep> GetOutsourcingExceptionTypeJS(@Body RequestBody issuevouchernumber);

    //外协收货后冲销接口
    @POST(API.OutsourcingExceptionJS)
    Observable<CodeMessageBean> OutsourcingExceptionJS(@Body RequestBody issuevouchernumber);

    //异常收货记录查询
    @POST(API.GetOutsoureExceptionRecordJS)
    Observable<GetOutsoureExceptionRecordJSRep> GetOutsoureExceptionRecordJS(@Body RequestBody issuevouchernumber);

    //获取301转储配送记录
    @POST(API.GetDistributorDumpRecordData)
    Observable<GetDistributorDumpRecordDataRep> GetDistributorDumpRecordData(@Body RequestBody issuevouchernumber);

    //301物料转储判断
    @POST(API.MaterialExistDumpData)
    Observable<StatusRespBean> MaterialExistDumpData(@Body RequestBody issuevouchernumber);

    //物料查询----------------------------------------------------------------------------------------------------------------------------------------
    //物料查询
    @POST(API.GetMaterialStorage)
    Observable<GetMaterialStorageRep> GetMaterialStorage(@Body RequestBody issuevouchernumber);

}
