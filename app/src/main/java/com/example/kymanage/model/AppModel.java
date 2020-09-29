package com.example.kymanage.model;


import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.API.APIService;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordRep;
import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordReq;
import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetCMInFactoryDeliverJS.GetCMInFactoryDeliverJSRep;
import com.example.kymanage.Beans.GetDeliveryListDataJS.GetDeliveryListDataJSRep;
import com.example.kymanage.Beans.GetDeliveryListDetailDataJS.GetDeliveryListDetailDataJSRep;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean3;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSReqBean1;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.Beans.GetDistributorDumpRecordData.GetDistributorDumpRecordDataRep;
import com.example.kymanage.Beans.GetDistributorDumpRecordData.GetDistributorDumpRecordDataReqBean;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRep;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordReq;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRep;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeReqBean;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReps;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReq;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRep;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteReqBean;
import com.example.kymanage.Beans.GetInFactoryDeliverListDetailJS.GetInFactoryDeliverListDetailJSRep;
import com.example.kymanage.Beans.GetInFactoryDeliverListJS.GetInFactoryDeliverListJSRep;
import com.example.kymanage.Beans.GetIssueDetailRecord.GetIssueDetailRecordReq;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.Beans.GetIssueDetailRecord.GetIssueDetailRecordReps;
import com.example.kymanage.Beans.GetLableStorageInfoJS.GetLableStorageInfoJSRep;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRep;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordReq;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageRep;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageReq;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSReqBean;
import com.example.kymanage.Beans.GetOutsourcingExceptionTypeJS.GetOutsourcingExceptionTypeJSRep;
import com.example.kymanage.Beans.GetOutsoureExceptionRecordJS.GetOutsoureExceptionRecordJSRep;
import com.example.kymanage.Beans.GetOutsoureFinProductDataJS.GetOutsoureFinProductDataJSRep;
import com.example.kymanage.Beans.GetMaterialPropertieInfoJS.GetPurWayMaterialDataRep;
import com.example.kymanage.Beans.GetPreRecMaterialCodeInfoJS.GetPreRecMaterialCodeInfoJSRep;
import com.example.kymanage.Beans.GetPreRecMaterialCodeInfoJS.GetPreRecMaterialCodeInfoJSRepBean;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailreps;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.GetSapStorageInfoByFactoryJSBean;
import com.example.kymanage.Beans.GetStockInformationDataJS.GetStockInformationDataJSRep;
import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordRep;
import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordReqBean;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableReps;
import com.example.kymanage.Beans.InsertDumpTransferRecord.InsertDumpTransferRecordRep;
import com.example.kymanage.Beans.InsertDumpTransferRecord.InsertDumpTransferRecordReq;
import com.example.kymanage.Beans.InsertFinAProOrderRecord.InsertFinAProOrderRecordRep;
import com.example.kymanage.Beans.InsertFinAProOrderRecord.InsertFinAProOrderRecordReq;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordRep;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReq;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueRep;
import com.example.kymanage.Beans.InsertProductOrderIssue.SendProductOrderIssueReq;
import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReps;
import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReq;
import com.example.kymanage.Beans.LoginBean;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpRep;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReq;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103RepStatus;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103ReqBean;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.AUFNRBean;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRep;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReq;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.UPAUFNRBean;
import com.example.kymanage.Beans.OutsourcingExceptionJS.OutsourcingExceptionJSReq;
import com.example.kymanage.Beans.OutsoureFinProductWriteOffJS.OutsoureFinProductWriteOffJSReqBean;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.PreMaterialProductOrderJS.PreMaterialProductOrderJSReqBean;
import com.example.kymanage.Beans.PurchaseCenterRecord.PurchaseCenterRecordReps;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailRep;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailReqBean;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingReq;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingLable.Semi_FinishedProductReceivingLableRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingwriteoffJS.Semi_FinishedProductReceivingwriteoffJSReqBean;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.UpdateApp.UpdateAppRep;
import com.example.kymanage.Beans.Warehouse105Writeoff.Warehouse105WriteoffReq;
import com.example.kymanage.Beans.WarehouseReceipt.WarehouseReceiptReq;
import com.example.kymanage.Beans.WarehouseReceiptRecord.WarehouseReceiptRecordReps;
import com.example.kymanage.Beans.WriteOffMaterialFactoryCDump.WriteOffMaterialFactoryCDumpReq;
import com.example.kymanage.Beans.WriteOffMaterialFactoryDump.WriteOffMaterialFactoryDumpReq;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReq;
import com.example.kymanage.Beans.WriteOffProductOrderIssue.WriteOffProductOrderIssueReq;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.net.RetrofitManager;
import com.example.kymanage.net.RetrofitManager2;
import com.example.kymanage.utils.Test;


import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;


public class AppModel extends BaseModel{
    /**
     * 修改3
     * @param name
     * @param password
     * @param httpDataListener
     */


    public void comingSoondata(String name,String password, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name",name);
            jsonObject.put("password",password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject.toString());
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                login(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void UpdateApp(String name, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name",name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject.toString());
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                UpdateApp(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UpdateAppRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UpdateAppRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //物流通用-----------------------------------------------------------------------------------------------------------
    //获取要预占物料的生产订单信息
    public void PreMaterialProductOrder(String marketOrderNO,String marketOrderRow,String materialCode,String factoryNO,float matnrCurrentNum,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        System.out.println("marketOrderNO"+marketOrderNO);
//        System.out.println("marketOrderRow"+marketOrderRow);
//        System.out.println("materialCode"+materialCode);
//        System.out.println("factoryNO"+factoryNO);
//        System.out.println("matnrCurrentNum"+matnrCurrentNum);
        try {
            jsonObject.put("marketOrderNO",marketOrderNO);
            jsonObject.put("marketOrderRow",marketOrderRow);
            jsonObject.put("materialCode",materialCode);
            jsonObject.put("factoryNO",factoryNO);
            jsonObject.put("matnrCurrentNum",matnrCurrentNum);
            System.out.println("matnrCurrentNum="+matnrCurrentNum);
            System.out.println("获取要预占物料的生产订单信息传参："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                PreMaterialProductOrder(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PreMaterialProductOrderReps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PreMaterialProductOrderReps value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //批量获取预占物料的生产订单信息接口
    public void PreMaterialProductOrderJS(String marketOrderNO, String marketOrderRow, List<PreMaterialProductOrderJSReqBean> materialCodeArr, String factoryNO, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(materialCodeArr));
//        System.out.println("marketOrderNO:"+marketOrderNO);
//        System.out.println("marketOrderRow:"+marketOrderRow);
//        System.out.println("materialCodeArr:"+jsonArray.toString());
//        System.out.println("factoryNO:"+factoryNO);
        try {
            jsonObject.put("marketOrderNO",marketOrderNO);
            jsonObject.put("marketOrderRow",marketOrderRow);
            jsonObject.put("materialCodeArr",jsonArray);
            jsonObject.put("factoryNO",factoryNO);
            System.out.println("批量获取预占物料的生产订单信息接口传参："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                PreMaterialProductOrderJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PreMaterialProductOrderReps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PreMaterialProductOrderReps value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //获取物料主数据接口
    public void GetMaterialMasterDataJS(String materialCode,String factory, final HttpDataListener httpDataListener) {
        JSONObject jsonObject = new JSONObject();
        //System.out.println(data.toString());
        //JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println(materialCode+"=="+factory);
        try {
            jsonObject.put("materialCode",materialCode);
            jsonObject.put("factory",factory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());

        RetrofitManager.getmInstance().createService1(APIService.class).
                GetMaterialMasterDataJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetMaterialMasterDataRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetMaterialMasterDataRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //采购------------------------------------------------------------------------------------------------------------

    //获取预收货物料信息
    public void GetPreRecMaterialCodeInfoJS(long AdvanceStorageId,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("AdvanceStorageId",AdvanceStorageId);
            System.out.println("获取预收货物料信息："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetPreRecMaterialCodeInfoJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetPreRecMaterialCodeInfoJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetPreRecMaterialCodeInfoJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //103收货
    public void AdvanceRec103JS(long AdvanceStorageId,String DocumentDate,String PostingDate,String User,float RecNum,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("AdvanceStorageId",AdvanceStorageId);
            jsonObject.put("DocumentDate",DocumentDate);
            jsonObject.put("PostingDate",PostingDate);
            jsonObject.put("User",User);
            jsonObject.put("RecNum",RecNum);
            System.out.println("103收货传参："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager2.getmInstance().createService1(APIService.class).
                AdvanceRec103JS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeMessageBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //采购查询列表
    public void ReceivingList(String orderno,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("purchaseOrderNo",orderno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetRecevingDetail(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetRecevingDetailreps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetRecevingDetailreps value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //采购收货103预入库
    public void MaterialFlow103(String postingDate, String documentDate, String user, List<MaterialFlow103ReqBean> detail, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(detail));
        System.out.println("预入库的信息为："+jsonArray.toString());
        try {
            jsonObject.put("postingDate",postingDate);
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("user",user);
            jsonObject.put("detail",jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                MaterialFlow103(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MaterialFlow103RepStatus>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MaterialFlow103RepStatus value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //获取采购中心收货记录
    public void PurchaseCenterRecord(String documentDate,String user,String po,String materialCode,boolean checked,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("user",user);
            jsonObject.put("po",po);
            jsonObject.put("materialCode",materialCode);
            jsonObject.put("checked",checked);
            System.out.println("获取采购中心收货记录:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                PurchaseCenterRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PurchaseCenterRecordReps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PurchaseCenterRecordReps value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //打印采购中心标签接口
    public void GetParchaseCenterLable(List<Long> AdvanceStorageIds,String Employee, String PrintTime, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        //JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        //System.out.println(jsonArray.toString());
        System.out.println("打印标签接口调用："+AdvanceStorageIds.size());
        System.out.println(AdvanceStorageIds.toString());
//        System.out.println("打印标签："+AdvanceStorageIds.get(0));
        System.out.println(PrintTime);
        try {
            jsonObject.put("AdvanceStorageIds",AdvanceStorageIds);
            jsonObject.put("Employee",Employee);
            jsonObject.put("PrintTime",PrintTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetParchaseCenterLable(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetParchaseCenterLableReps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetParchaseCenterLableReps value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //103预入库冲销
    public void MaterialFlow103WriteOff(List<Long> data,String handler,String RequestTime, final HttpDataListener httpDataListener) {
        JSONObject jsonObject = new JSONObject();
        System.out.println(data.toString());
        //JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        try {
            jsonObject.put("AdvanceStorageId",data);
            jsonObject.put("handler",handler);
            jsonObject.put("RequestTime",RequestTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());

        RetrofitManager.getmInstance().createService1(APIService.class).
                MaterialFlow103WriteOff(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusRespBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StatusRespBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //获取库位信息
    public void GetSapStorageInfoByFactoryJS(String factory, final HttpDataListener httpDataListener) {
        JSONObject jsonObject = new JSONObject();
        //JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        try {
            jsonObject.put("factory",factory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());

        RetrofitManager.getmInstance().createService1(APIService.class).
                GetSapStorageInfoByFactoryJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetSapStorageInfoByFactoryJSBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetSapStorageInfoByFactoryJSBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //库房---------------------------------------------------------------------------
    //获取库房收货物料信息接口
    public void GetMaterialPropertieInfoJS(long AdvanceStorageId, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println(AdvanceStorageId);
        System.out.println("执行105查询中");
        try {
            jsonObject.put("AdvanceStorageId",AdvanceStorageId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager2.getmInstance().createService1(APIService.class).
                GetMaterialPropertieInfoJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetPurWayMaterialDataRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetPurWayMaterialDataRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //库房收货及发料接口
    public void WarehouseReceipt(String postingDate,String documentDate,String handler,List<WarehouseReceiptReq> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        try {
            jsonObject.put("postingDate",postingDate);
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("handler",handler);
            jsonObject.put("data",jsonArray);
            System.out.println("105data:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());

        RetrofitManager2.getmInstance().createService1(APIService.class).
                warehousereceipt(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeMessageBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //库房收货(采购入库)记录
    public void WarehouseReceiptRecord(String DocumentDate,String user,String po,String materialCode,String storage,boolean checked, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println(jsonArray.toString());
        System.out.println("DocumentDate"+DocumentDate);
        System.out.println("user"+user);
        System.out.println("po"+po);
        System.out.println("materialCode"+materialCode);
        System.out.println("storage"+storage);
        System.out.println("checked"+checked);
        try {
            jsonObject.put("DocumentDate",DocumentDate);
            jsonObject.put("user",user);
            jsonObject.put("po",po);
            jsonObject.put("materialCode",materialCode);
            jsonObject.put("storage",storage);
            jsonObject.put("checked",checked);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                WarehouseReceiptRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WarehouseReceiptRecordReps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WarehouseReceiptRecordReps value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //获取物料库存信息接口
    public void GetStockInformationDataJS(String materialCode,String factory, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("materialCode"+materialCode);
//        System.out.println("factory"+factory);
        try {
            jsonObject.put("materialCode",materialCode);
            jsonObject.put("factory",factory);
            System.out.println("获取物料库存信息接口传参："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetStockInformationDataJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetStockInformationDataJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetStockInformationDataJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //库房261发料
    public void InsertProductOrderIssue(SendProductOrderIssueReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("261发料数据："+jsonArray);
        Object obj = JSON.toJSON(data);
        System.out.println("261发料数据："+obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());

        RetrofitManager.getmInstance().createService1(APIService.class).
                InsertProductOrderIssue(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InsertProductOrderIssueRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InsertProductOrderIssueRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //扫码发料
    public void ScanIssueNoteDetail(ScanIssueNoteDetailReqBean data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
        //JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));

        System.out.println("扫码发料数据："+obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());

        RetrofitManager.getmInstance().createService1(APIService.class).
                ScanIssueNoteDetail(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ScanIssueNoteDetailRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ScanIssueNoteDetailRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //打印库房标签
    public void GetIssueNoteDetail(List<GetIssueNoteDetailReq> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println("打印库房标签:"+jsonArray.toString());
        try {
            jsonObject.put("data",jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                getissuenotedetail(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetIssueNoteDetailRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetIssueNoteDetailRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //打印发料单
    public void GenerateStorageLssueRecord(GenerateStorageLssueRecordReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println("打印发料单:"+obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GenerateStorageLssueRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GenerateStorageLssueRecordRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GenerateStorageLssueRecordRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //库房发料记录接口
    public void GetIssueDetailRecord(GetIssueDetailRecordReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println(jsonArray.toString());
        Object obj = JSON.toJSON(data);
        System.out.println(obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetIssueDetailRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetIssueDetailRecordReps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetIssueDetailRecordReps value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //库房261发料记录冲销
    public void WriteOffProductOrderIssue(WriteOffProductOrderIssueReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println(jsonArray.toString());
        Object obj = JSON.toJSON(data);
        System.out.println("261冲销入参"+obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                WriteOffProductOrderIssue(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusRespBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StatusRespBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //打印库房标签接口
    public void InsertStorageLableRecord(List<InsertStorageLableRecordReq> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println(jsonArray.toString());
        try {
            jsonObject.put("data",jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                InsertStorageLableRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InsertStorageLableRecordReps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InsertStorageLableRecordReps value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //补打库房标签接口
    public void GetWarehouselabel(List<Long> issueId, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println(jsonArray.toString());
        try {
            jsonObject.put("issueId",issueId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetWarehouselabel(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InsertStorageLableRecordReps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InsertStorageLableRecordReps value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //库房105入库冲销接口
    public void Warehouse105Writeoff(List<Warehouse105WriteoffReq> data,String documentData,String handler, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println("105冲销:"+jsonArray.toString());
        System.out.println("documentData"+documentData);
        System.out.println("handler"+handler);
        try {
            jsonObject.put("data",jsonArray);
            jsonObject.put("documentData",documentData);
            jsonObject.put("handler",handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                Warehouse105Writeoff(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeMessageBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //获取301转储收获确认记录
    public void GetTransferRecord(GetTransferRecordReqBean data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        Object obj = JSON.toJSON(data);
        System.out.println(obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetTransferRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetTransferRecordRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetTransferRecordRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //301转储发料
    public void InsertDumpTransferRecord(InsertDumpTransferRecordReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        Object obj = JSON.toJSON(data);

        try {
            jsonObject.put("data",obj);
            System.out.println("301转储发料数据:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                InsertDumpTransferRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InsertDumpTransferRecordRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InsertDumpTransferRecordRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //外协------------------------------------------------------------------------------------------------
    //获取采购订单信息接口（机加）
    public void GetPurchaseOrderInfoJS(String KDAUF,String KDPOS,String MATNR,String RTYPE, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println(jsonArray.toString());
        try {
            jsonObject.put("KDAUF",KDAUF);
            jsonObject.put("KDPOS",KDPOS);
            jsonObject.put("MATNR",MATNR);
            jsonObject.put("RTYPE",RTYPE);
            System.out.println("获取采购订单信息接口传参："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager2.getmInstance().createService1(APIService.class).
                GetPurchaseOrderInfoJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetPurchaseOrderInfoJSReps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetPurchaseOrderInfoJSReps value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //外协采购半成品收货接口（103、105）
    public void Semi_FinishedProductReceiving(Semi_FinishedProductReceivingReq datas, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(detail));
        Object obj = JSON.toJSON(datas);

        try {
            jsonObject.put("datas",obj);
            System.out.println("外协半成品收货信息为："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                Semi_FinishedProductReceiving(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Semi_FinishedProductReceivingRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Semi_FinishedProductReceivingRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //#101成品入库
    public void InsertFinProStorageRecord(InsertFinProStorageRecordReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(detail));

        try {
            jsonObject.put("data",obj);
            System.out.println("101入库信息为："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                InsertFinProStorageRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InsertFinProStorageRecordRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InsertFinProStorageRecordRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //#获取101入库记录（记录查询）
    public void GetFinProStorageRecord(GetFinProStorageRecordReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());

//        System.out.println(data.toString());
        try {
            jsonObject.put("data",obj);
            System.out.println("获取101入库记录--"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetFinProStorageRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetFinProStorageRecordReps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetFinProStorageRecordReps value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //获取成品入库时可选的生产订单接口
    public void GetOutStorageMaterialOrderJS(String KDPOS,String MATNR,String KDAUF,String WERKS,float RQTY, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
//        System.out.println(data.getCurrentDate()+"+"+data.getHandler());
//        System.out.println(data.toString());
        System.out.println("KDPOS:"+KDPOS);
        System.out.println("MATNR:"+MATNR);
        System.out.println("KDAUF:"+KDAUF);
        System.out.println("WERKS:"+WERKS);
        System.out.println("RQTY:"+RQTY);
        try {
            jsonObject.put("KDPOS",KDPOS);
            jsonObject.put("MATNR",MATNR);
            jsonObject.put("KDAUF",KDAUF);
            jsonObject.put("WERKS",WERKS);
            jsonObject.put("RQTY",RQTY);
            Log.d("获取成品入库时可选的生产订单接口传参",jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetOutStorageMaterialOrderJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetOutStorageMaterialOrderJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetOutStorageMaterialOrderJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //101入库冲销接口
    public void WriteOffProStorageRecord(WriteOffProStorageRecordReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
//        System.out.println(data.getCurrentDate()+"+"+data.getHandler());
        System.out.println("101入库冲销接口=="+obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                WriteOffProStorageRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusRespBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StatusRespBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //获取机加101入库标签信息
    public void GetFinProStorageRecordNote(List<GetFinProStorageRecordNoteReqBean> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(data);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
//        System.out.println(data.getCurrentDate()+"+"+data.getHandler());
        System.out.println("101入库标签"+jsonArray.toString());
        try {
            jsonObject.put("data",jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetFinProStorageRecordNote(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetFinProStorageRecordNoteRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetFinProStorageRecordNoteRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //外协采购成品收货入库接口
    public void OutsourceFinishedProductReceivingJS(OutsourceFinishedProductReceivingJSReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
        try {
            jsonObject.put("data",obj);
            System.out.println("外协成品收货请求参数："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                OutsourceFinishedProductReceivingJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OutsourceFinishedProductReceivingJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OutsourceFinishedProductReceivingJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //获取生产派工单接口
    public void GetDispatchListJS(List<Long> AdvanceStorageIdArr, String Handler,String RequestTime,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(AdvanceStorageId));
        try {
            jsonObject.put("AdvanceStorageIdArr",AdvanceStorageIdArr);
            jsonObject.put("Handler",Handler);
            jsonObject.put("RequestTime",RequestTime);
            System.out.println("外协采购半成品生产派工单打印接口请求参数："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetDispatchListJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDispatchListJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDispatchListJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //外协半成品费用入库类型2标签打印接口
    public void Semi_FinishedProductReceivingLable(long AdvanceStorageId, String User,String RequesTime,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(AdvanceStorageId));
        try {
            jsonObject.put("AdvanceStorageId",AdvanceStorageId);
            jsonObject.put("User",User);
            jsonObject.put("RequesTime",RequesTime);
            System.out.println("外协采购半成品生产派工单打印接口请求参数："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                Semi_FinishedProductReceivingLable(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Semi_FinishedProductReceivingLableRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Semi_FinishedProductReceivingLableRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //外协采购半成品收货记录接口
    public void Semi_FinishedProductReceivingRecordJS(String DocumentDate, String User,boolean Checked,String MarketOrderNO,String MarketOrderRow,String MaterialCode,String PurchaseOrderNO,String PurchaseOrderRow,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
        try {
            jsonObject.put("DocumentDate",DocumentDate);
            jsonObject.put("User",User);
            jsonObject.put("Checked",Checked);
            jsonObject.put("MarketOrderNO",MarketOrderNO);
            jsonObject.put("MarketOrderRow",MarketOrderRow);
            jsonObject.put("MaterialCode",MaterialCode);
            jsonObject.put("PurchaseOrderNO",PurchaseOrderNO);
            jsonObject.put("PurchaseOrderRow",PurchaseOrderRow);
            System.out.println("半成品收货记录传参："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                Semi_FinishedProductReceivingRecordJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Semi_FinishedProductReceivingRecordJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Semi_FinishedProductReceivingRecordJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //外协采购半成品收货冲销接口
    public void Semi_FinishedProductReceivingwriteoffJS(String user, String CurrentDate, List<Long> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
        try {
            jsonObject.put("user",user);
            jsonObject.put("CurrentDate",CurrentDate);
            jsonObject.put("data",jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                Semi_FinishedProductReceivingwriteoffJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeMessageBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //外协采购成品收货记录接口
    public void GetOutsoureFinProductDataJS(String user, String documentDate,String MarketOrderNO,String MaterialDesc,String PurchaseOrderRow,boolean checked,String MarketOrderRow,String MaterialCode,String PurchaseOrderNO, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
        try {
            jsonObject.put("user",user);
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("MarketOrderNO",MarketOrderNO);
            jsonObject.put("MaterialDesc",MaterialDesc);
            jsonObject.put("PurchaseOrderRow",PurchaseOrderRow);
            jsonObject.put("checked",checked);
            jsonObject.put("MarketOrderRow",MarketOrderRow);
            jsonObject.put("MaterialCode",MaterialCode);
            jsonObject.put("PurchaseOrderNO",PurchaseOrderNO);
            System.out.println("外协采购成品收货记录接口传参："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetOutsoureFinProductDataJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetOutsoureFinProductDataJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetOutsoureFinProductDataJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //##外协采购成品收货冲销接口
    public void OutsoureFinProductWriteOffJS(String user, String requestTime, List<OutsoureFinProductWriteOffJSReqBean> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        try {
            jsonObject.put("user",user);
            jsonObject.put("requestTime",requestTime);
            jsonObject.put("data",jsonArray);
            System.out.println("外协采购成品收货冲销传参为："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                OutsoureFinProductWriteOffJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeMessageBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //##外协采购成品标签打印接口
    public void GetOutsourceFinProLableDataJS(List<Integer> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        try {
            jsonObject.put("data",jsonArray);
            System.out.println("外协成品收货标签打印传参："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetOutsourceFinProLableDataJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetOutsourceFinProLableJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetOutsourceFinProLableJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //#301转储接口
    public void MaterialFactoryDump(MaterialFactoryDumpReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));

        try {
            jsonObject.put("data",obj);
            System.out.println("301转储数据:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                MaterialFactoryDump(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MaterialFactoryDumpRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MaterialFactoryDumpRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //#301转储单查询接口
    public void GetMainDumpRecord(GetMainDumpRecordReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("301转储数据:"+obj.toString());
        try {
            jsonObject.put("data",obj);
            System.out.println("301转储单查询接口传参:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetMainDumpRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetMainDumpRecordRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetMainDumpRecordRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //#301转储详细记录查询
    public void GetDumpRecord(GetDumpRecordReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println("转储详情数据:"+obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetDumpRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDumpRecordRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDumpRecordRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //获取301转储配送单
    public void GetDumpRecordNode(List<GetDumpRecordNodeReqBean> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(data);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));

        try {
            jsonObject.put("data",jsonArray);
            System.out.println("301转储打印:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetDumpRecordNode(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDumpRecordNodeRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDumpRecordNodeRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //301转储冲销
    public void WriteOffMaterialFactoryDump(WriteOffMaterialFactoryDumpReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println("301转储冲销:"+obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                WriteOffMaterialFactoryDump(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusRespBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StatusRespBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //301转储子记录冲销
    public void WriteOffMaterialFactoryCDump(WriteOffMaterialFactoryCDumpReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));

        try {
            jsonObject.put("data",obj);
            System.out.println("301转储子记录冲销传参:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                WriteOffMaterialFactoryCDump(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusRespBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StatusRespBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //##厂内配送单生成
    public void GetCMInFactoryDeliver(List<String> DispatchListNO,String user,String requestTime, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(DispatchListNO));
        try {
            jsonObject.put("DispatchListNO",jsonArray);
            jsonObject.put("user",user);
            jsonObject.put("requestTime",requestTime);
            System.out.println("厂内配送单生成传参："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetCMInFactoryDeliver(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetCMInFactoryDeliverRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetCMInFactoryDeliverRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //##外协采购半成品配送单打印接口
    public void GetCMInFactoryDeliverJS(List<String> deliverNO, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(deliverNO));
        try {
            jsonObject.put("deliverNO",jsonArray);
            System.out.println("厂内配送单打印传参："+jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetCMInFactoryDeliverJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetCMInFactoryDeliverJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetCMInFactoryDeliverJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //##厂内配送记录
    public void GetInFactoryDeliverListJS(String DeliverID,String IssueStorage,String CreateUser,String CreateTime,boolean Checked,String MarketOrderNO,String Client, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(DispatchListNO));
//        System.out.println("扫描派工单数据："+jsonArray.toString());
        try {
            jsonObject.put("DeliverID",DeliverID);
            jsonObject.put("IssueStorage",IssueStorage);
            jsonObject.put("CreateUser",CreateUser);
            jsonObject.put("CreateTime",CreateTime);
            jsonObject.put("Checked",Checked);
            jsonObject.put("MarketOrderNO",MarketOrderNO);
            jsonObject.put("Client",Client);
            System.out.println("厂内配送记录："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetInFactoryDeliverListJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetInFactoryDeliverListJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetInFactoryDeliverListJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //##外协采购半成品配送单详情查询接口
    public void GetInFactoryDeliverListDetailJS(String DeliverID, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(DispatchListNO));
//        System.out.println("扫描派工单数据："+jsonArray.toString());
        try {
            jsonObject.put("DeliverID",DeliverID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetInFactoryDeliverListDetailJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetInFactoryDeliverListDetailJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetInFactoryDeliverListDetailJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //##外协半成品发料配送冲销接口
    public void GetOutSemifinProductIssueWriteOffJS(List<String> DeliverIDArr,String user, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(DeliverIDArr));
//        System.out.println("扫描派工单数据："+jsonArray.toString());
        try {
            jsonObject.put("DeliverIDArr",jsonArray);
            jsonObject.put("user",user);
            System.out.println("厂内配送单整单冲销："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetOutSemifinProductIssueWriteOffJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeMessageBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //##厂内配送单单条冲销
    public void OutSemifinProductIssueWriteOffJS(List<String> dispatchListNOArr,String user,String deliverID, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(dispatchListNOArr));
//        System.out.println("扫描派工单数据："+jsonArray.toString());
        try {
            jsonObject.put("dispatchListNOArr",jsonArray);
            jsonObject.put("user",user);
            jsonObject.put("deliverID",deliverID);
            System.out.println("厂内配送单单条冲销："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                OutSemifinProductIssueWriteOffJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeMessageBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //##获取交货单信息
    public void GetDeliveryListInfoJS(List<GetDeliveryListInfoJSReqBean1> materialArr,int flag, String user, String requestTime, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(materialArr));

        try {
            jsonObject.put("materialArr",jsonArray);
            jsonObject.put("flag",flag);
            jsonObject.put("user",user);
            jsonObject.put("requestTime",requestTime);
            System.out.println("打印交货单传参："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetDeliveryListInfoJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDeliveryListInfoJSRepBean3>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDeliveryListInfoJSRepBean3 value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //销售交货单查询
    public void GetDeliveryListDataJS(String Handler,boolean Check,String Time,String MaterialCode,String MarketOrderNO, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(materialArr));

        try {
            jsonObject.put("Handler",Handler);
            jsonObject.put("Check",Check);
            jsonObject.put("Time",Time);
            jsonObject.put("MaterialCode",MaterialCode);
            jsonObject.put("MarketOrderNO",MarketOrderNO);
            System.out.println("销售交货单查询："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetDeliveryListDataJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDeliveryListDataJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDeliveryListDataJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //销售发货单详情查询
    public void GetDeliveryListDetailDataJS(String DeliveryListNO, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(materialArr));

        try {
            jsonObject.put("DeliveryListNO",DeliveryListNO);
            System.out.println("销售发货单详情查询："+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetDeliveryListDetailDataJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDeliveryListDetailDataJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDeliveryListDetailDataJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //获取销售发货物料信息及库存地点
    public void GetLableStorageInfoJS(long id,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(materialArr));
//        System.out.println("打印交货单数据："+jsonArray.toString());
        try {
            jsonObject.put("id",id);
            System.out.println("获取销售发货物料信息及库存地点:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetLableStorageInfoJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetLableStorageInfoJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetLableStorageInfoJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //外协标签打印接口
    public void InsertFinAProOrderRecord(InsertFinAProOrderRecordReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(materialArr));
//        System.out.println("打印交货单数据："+jsonArray.toString());
        try {
            jsonObject.put("data",obj);
            System.out.println("获取销售发货物料信息及库存地点:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                InsertFinAProOrderRecord(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InsertFinAProOrderRecordRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InsertFinAProOrderRecordRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //获取外协异常登记原因接口
    public void GetOutsourcingExceptionTypeJS(final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(materialArr));
//        System.out.println("打印交货单数据："+jsonArray.toString());
        try {
//            jsonObject.put("data",obj);
            System.out.println("获取外协异常登记原因接口:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetOutsourcingExceptionTypeJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetOutsourcingExceptionTypeJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetOutsourcingExceptionTypeJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //外协收货后冲销接口
    public void OutsourcingExceptionJS(OutsourcingExceptionJSReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(materialArr));
//        System.out.println("打印交货单数据："+jsonArray.toString());
        try {
            jsonObject.put("data",obj);
            System.out.println("外协收货后冲销接口:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                OutsourcingExceptionJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeMessageBean value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //异常收货记录查询
    public void GetOutsoureExceptionRecordJS(String user,String documentDate,String MarketOrderNO,String MaterialDesc,String PurchaseOrderRow,boolean checked,String MarketOrderRow,String MaterialCode,String PurchaseOrderNO, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(materialArr));
//        System.out.println("打印交货单数据："+jsonArray.toString());
        try {
            jsonObject.put("user",user);
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("MarketOrderNO",MarketOrderNO);
            jsonObject.put("MaterialDesc",MaterialDesc);
            jsonObject.put("PurchaseOrderRow",PurchaseOrderRow);
            jsonObject.put("checked",checked);
            jsonObject.put("MarketOrderRow",MarketOrderRow);
            jsonObject.put("MaterialCode",MaterialCode);
            jsonObject.put("PurchaseOrderNO",PurchaseOrderNO);
            System.out.println("异常收货记录查询:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetOutsoureExceptionRecordJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetOutsoureExceptionRecordJSRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetOutsoureExceptionRecordJSRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //获取301转储配送记录
    public void GetDistributorDumpRecordData(GetDistributorDumpRecordDataReqBean data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(materialArr));
//        System.out.println("打印交货单数据："+jsonArray.toString());
        try {
            jsonObject.put("data",obj);
            System.out.println("获取301转储配送记录传参:"+jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetDistributorDumpRecordData(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDistributorDumpRecordDataRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDistributorDumpRecordDataRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //物料查询----------------------------------------------------------------------------------------------------------------------------------------
    //物料查询
    public void GetMaterialStorage(GetMaterialStorageReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        try {
            jsonObject.put("data",obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetMaterialStorage(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetMaterialStorageRep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetMaterialStorageRep value) {
                        httpDataListener.onDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        httpDataListener.onFailer(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
