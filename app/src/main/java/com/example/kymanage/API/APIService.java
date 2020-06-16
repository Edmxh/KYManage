package com.example.kymanage.API;



import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRep;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReps;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueRecord.GetIssueRecordReps;
import com.example.kymanage.Beans.GetLableInfo.LabelStatussBean;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRep;
import com.example.kymanage.Beans.GetMaterialInfo.GetMaterialInfoBean;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageRep;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRep;
import com.example.kymanage.Beans.GetOutsoureFinProductDataJS.GetOutsoureFinProductDataJSRep;
import com.example.kymanage.Beans.GetPurWayMaterialData.GetPurWayMaterialDataRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailreps;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.GetSapStorageInfoByFactoryJSBean;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableReps;
import com.example.kymanage.Beans.GetStockInformationDataJS.GetStockInformationDataJSRep;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordRep;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueRep;
import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReps;
import com.example.kymanage.Beans.LabelBean;
import com.example.kymanage.Beans.LoginBean;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103Rep;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.PurchaseCenterRecord.PurchaseCenterRecordReps;
import com.example.kymanage.Beans.FlagAndMessageBean;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRep;
import com.example.kymanage.Beans.StatusBean;
import com.example.kymanage.Beans.WarehouseReceiptRecord.WarehouseReceiptRecordReps;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {
    //登录
    @POST(API.LOGIN)
    Observable<LoginBean> login(@Body RequestBody login);



    //查询标签
    @POST(API.QueryLabel)
    Observable<LabelBean> querylabel(@Body RequestBody lableseqnum);

    //收货
    @POST(API.Receipt)
    Observable<StatusRespBean> receipt(@Body RequestBody datas);

    //物料状态查询
    @POST(API.LabelStatus)
    Observable<LabelStatussBean> labelstatus(@Body RequestBody lableseqnum);

    //物料状态查询
    @POST(API.LabelAreaChange)
    Observable<FlagAndMessageBean> labelareachange(@Body RequestBody changeinfo);

    //采购半成品收货(机加103预入库)
    @POST(API.UpdateSemiStorage)
    Observable<StatusRespBean> updatesemistorage(@Body RequestBody updatesemistoragereq);

    //成品入库
    @POST(API.UpdatefinishedStorage)
    Observable<StatusRespBean> updatefinishedstorage(@Body RequestBody finishedinfo);

    //物料配送-物流属性接口
    @POST(API.GetMaterialInfo)
    Observable<GetMaterialInfoBean> getmaterialinfo(@Body RequestBody material);


    //库房301转储
    @POST(API.WarehouseReceipts)
    Observable<StatusRespBean> warehousereceipts(@Body RequestBody material);



    //机加101入库
    @POST(API.InsertCMStorageRecevingRecordDetail)
    Observable<StatusRespBean> InsertCMStorageRecevingRecordDetail(@Body RequestBody material);

    //物流通用
    //物流通用103预入库冲销
    @POST(API.MaterialFlow103WriteOff)
    Observable<StatusRespBean> MaterialFlow103WriteOff(@Body RequestBody datas);
    //获取物料主数据接口
    @POST(API.GetMaterialMasterDataJS)
    Observable<GetMaterialMasterDataRep> GetMaterialMasterDataJS(@Body RequestBody datas);

    //采购
    //采购查询列表
    @POST(API.GetRecevingDetail)
    Observable<GetRecevingDetailreps> GetRecevingDetail(@Body RequestBody noandrow);
    //采购收货103预入库
    @POST(API.MaterialFlow103)
    Observable<MaterialFlow103Rep> MaterialFlow103(@Body RequestBody noandrow);
    //获取采购中心收货记录
    @POST(API.PurchaseCenterRecord)
    Observable<PurchaseCenterRecordReps> PurchaseCenterRecord(@Body RequestBody noandrow);
    //获取要预占物料的生产订单信息
    @POST(API.PreMaterialProductOrder)
    Observable<PreMaterialProductOrderReps> PreMaterialProductOrder(@Body RequestBody noandrow);
    //打印采购中心标签接口
    @POST(API.GetParchaseCenterLable)
    Observable<GetParchaseCenterLableReps> GetParchaseCenterLable(@Body RequestBody changeinfo);
    //获取库位信息接口
    @POST(API.GetSapStorageInfoByFactoryJS)
    Observable<GetSapStorageInfoByFactoryJSBean> GetSapStorageInfoByFactoryJS(@Body RequestBody changeinfo);

    //库房---------------------------------------------------------------------------
    //获取库房收货物料信息接口
    @POST(API.GetPurWayMaterialData)
    Observable<GetPurWayMaterialDataRep> GetPurWayMaterialData(@Body RequestBody material);
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
    @POST(API.InsertProductOrderIssue)
    Observable<InsertProductOrderIssueRep> InsertProductOrderIssue(@Body RequestBody material);

    //打印发料单及发料接口
    @POST(API.GetIssueNoteDetail)
    Observable<GetIssueNoteDetailRep> getissuenotedetail(@Body RequestBody issuevouchernumber);
    //库房发料记录接口
    @POST(API.GetIssueDetailRecordJS)
    Observable<GetIssueRecordReps> GetIssueDetailRecordJS(@Body RequestBody issuevouchernumber);
    //打印库房标签接口
    @POST(API.InsertStorageLableRecord)
    Observable<InsertStorageLableRecordReps> InsertStorageLableRecord(@Body RequestBody issuevouchernumber);
    //补打库房标签接口
    @POST(API.GetWarehouselabel)
    Observable<InsertStorageLableRecordReps> GetWarehouselabel(@Body RequestBody issuevouchernumber);
    //库房105入库冲销接口
    @POST(API.Warehouse105Writeoff)
    Observable<CodeMessageBean> Warehouse105Writeoff(@Body RequestBody issuevouchernumber);

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

    //获取生产派工单接口
    @POST(API.GetDispatchListJS)
    Observable<GetDispatchListJSRep> GetDispatchListJS(@Body RequestBody issuevouchernumber);

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
    @POST(API.GetOutsourceFinProLableJS)
    Observable<GetOutsourceFinProLableJSRep> GetOutsourceFinProLableJS(@Body RequestBody issuevouchernumber);

    //#301转储接口
    @POST(API.MaterialFactoryDump)
    Observable<StatusRespBean> MaterialFactoryDump(@Body RequestBody issuevouchernumber);

    //#301转储单查询接口
    @POST(API.GetMainDumpRecord)
    Observable<GetMainDumpRecordRep> GetMainDumpRecord(@Body RequestBody issuevouchernumber);

    //#301转储详细记录查询
    @POST(API.GetDumpRecord)
    Observable<GetDumpRecordRep> GetDumpRecord(@Body RequestBody issuevouchernumber);

    //##获取厂内配送单
    @POST(API.GetCMInFactoryDeliver)
    Observable<GetCMInFactoryDeliverRep> GetCMInFactoryDeliver(@Body RequestBody issuevouchernumber);

    //物料查询----------------------------------------------------------------------------------------------------------------------------------------
    //物料查询
    @POST(API.GetMaterialStorage)
    Observable<GetMaterialStorageRep> GetMaterialStorage(@Body RequestBody issuevouchernumber);

}
