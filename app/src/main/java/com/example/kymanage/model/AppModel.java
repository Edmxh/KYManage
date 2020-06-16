package com.example.kymanage.model;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.kymanage.API.APIService;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRep;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordReq;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReps;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReq;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRep;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRepBean;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.Beans.GetIssueRecord.GetIssueRecordReps;
import com.example.kymanage.Beans.GetLableInfo.LabelStatussBean;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRep;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordReq;
import com.example.kymanage.Beans.GetMaterialInfo.GetMaterialInfoBean;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageRep;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageReq;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSReqBean;
import com.example.kymanage.Beans.GetOutsoureFinProductDataJS.GetOutsoureFinProductDataJSRep;
import com.example.kymanage.Beans.GetPurWayMaterialData.GetPurWayMaterialDataRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailreps;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.GetSapStorageInfoByFactoryJSBean;
import com.example.kymanage.Beans.GetStockInformationDataJS.GetStockInformationDataJSRep;
import com.example.kymanage.Beans.InsertCMStorageRecevingRecordDetail.InsertCMStorageRecevingRecordDetailReq;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableReps;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordRep;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReq;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueRep;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueReq;
import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReps;
import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReq;
import com.example.kymanage.Beans.LabelBean;
import com.example.kymanage.Beans.LoginBean;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpRep;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReq;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReqBean;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103Rep;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103Req;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRep;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean2;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean3;
import com.example.kymanage.Beans.OutsoureFinProductWriteOffJS.OutsoureFinProductWriteOffJSReqBean;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.PurchaseCenterRecord.PurchaseCenterRecordReps;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingReq;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingwriteoffJS.Semi_FinishedProductReceivingwriteoffJSReqBean;
import com.example.kymanage.Beans.StatusBean;
import com.example.kymanage.Beans.UpdateStorage.UpdateStorageReq;
import com.example.kymanage.Beans.FlagAndMessageBean;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.UpdateSemiStorage.UpdateSemiStorageReq;
import com.example.kymanage.Beans.UpdatefinishedStorage.UpdatefinishedStorageData;
import com.example.kymanage.Beans.Warehouse105Writeoff.Warehouse105WriteoffReq;
import com.example.kymanage.Beans.WarehouseReceipt.WarehouseReceiptReq;
import com.example.kymanage.Beans.WarehouseReceiptRecord.WarehouseReceiptRecordReps;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReq;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReqBean;
import com.example.kymanage.Beans.warehousereceipts.warehousereceiptsReq;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.net.RetrofitManager;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;


public class AppModel extends BaseModel{
    /**
     * 修改
     * @param name
     * @param password
     * @param httpDataListener
     */


    public void comingSoondata(String name,String password, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name",name);
            jsonObject.put("password",password);
        } catch (JSONException e) {
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



    public void QueryLabel(String lableseqnum,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("LableSeqNum",lableseqnum);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                querylabel(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LabelBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LabelBean value) {
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
    public void ReceivingDatas(List<UpdateStorageReq> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));

        System.out.println(jsonArray.toString());
        try {
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                receipt(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusRespBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StatusRespBean value) {
                        //System.out.println(111);
                        httpDataListener.onDataSuccess(value);
                        //System.out.println(222);
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


    public void ScanLabelStatuss(String lableseqnum,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("LableSeqNum",lableseqnum);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                labelstatus(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LabelStatussBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LabelStatussBean value) {
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


    public void ChangeLabelArea(String lableseqnum,String areano,String changetime,String people,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("LableSeqNum",lableseqnum);
            jsonObject.put("AreaNO",areano);
            jsonObject.put("ChangeTime",changetime);
            jsonObject.put("people",people);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                labelareachange(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FlagAndMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FlagAndMessageBean value) {
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

    //采购品收货103预入库
    public void UpdateSemiStorage(List<UpdateSemiStorageReq> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        try {
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject.toString());
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                updatesemistorage(body)
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

    //成品入库
    public void UpdatefinishedStorage(List<UpdatefinishedStorageData> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));

        try {
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());

        RetrofitManager.getmInstance().createService1(APIService.class).
                updatefinishedstorage(body)
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

    //物料配送-物流属性接口
    public void GetMaterialInfo(String material,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Material",material);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                getmaterialinfo(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetMaterialInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetMaterialInfoBean value) {
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



    //库房301转储
    public void WarehouseReceipts(List<warehousereceiptsReq> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));

        try {
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());

        RetrofitManager.getmInstance().createService1(APIService.class).
                warehousereceipts(body)
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



    //机加101入库
    public void InsertCMStorageRecevingRecordDetail(List<InsertCMStorageRecevingRecordDetailReq> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));

        try {
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());

        RetrofitManager.getmInstance().createService1(APIService.class).
                InsertCMStorageRecevingRecordDetail(body)
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

    //物流通用-----------------------------------------------------------------------------------------------------------
    //获取要预占物料的生产订单信息
    public void PreMaterialProductOrder(String marketOrderNO,String marketOrderRow,String materialCode,String factoryNO,float matnrCurrentNum,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        System.out.println("marketOrderNO"+marketOrderNO);
        System.out.println("marketOrderRow"+marketOrderRow);
        System.out.println("materialCode"+materialCode);
        System.out.println("factoryNO"+factoryNO);
        System.out.println("matnrCurrentNum"+matnrCurrentNum);
        try {
            jsonObject.put("marketOrderNO",marketOrderNO);
            jsonObject.put("marketOrderRow",marketOrderRow);
            jsonObject.put("materialCode",materialCode);
            jsonObject.put("factoryNO",factoryNO);
            jsonObject.put("matnrCurrentNum",matnrCurrentNum);
        } catch (JSONException e) {
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
    //获取物料主数据接口
    public void GetMaterialMasterDataJS(String materialCode,String factory, final HttpDataListener httpDataListener) {
        JSONObject jsonObject = new JSONObject();
        //System.out.println(data.toString());
        //JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println(materialCode+"=="+factory);
        try {
            jsonObject.put("materialCode",materialCode);
            jsonObject.put("factory",factory);
        } catch (JSONException e) {
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
    //采购查询列表
    public void ReceivingList(String orderno,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("purchaseOrderNo",orderno);
        } catch (JSONException e) {
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
    public void MaterialFlow103(String postingDate, String documentDate, String user, List<MaterialFlow103Req> detail, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(detail));
        System.out.println("预入库的信息为："+jsonArray.toString());
        try {
            jsonObject.put("postingDate",postingDate);
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("user",user);
            jsonObject.put("detail",jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                MaterialFlow103(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MaterialFlow103Rep>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MaterialFlow103Rep value) {
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
    public void PurchaseCenterRecord(String documentDate,String user,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("user",user);
        } catch (JSONException e) {
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
        } catch (JSONException e) {
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
    public void MaterialFlow103WriteOff(List<Long> data,String RequestTime, final HttpDataListener httpDataListener) {
        JSONObject jsonObject = new JSONObject();
        System.out.println(data.toString());
        //JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        try {
            jsonObject.put("AdvanceStorageId",data);
            jsonObject.put("RequestTime",RequestTime);
        } catch (JSONException e) {
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
        } catch (JSONException e) {
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
    public void GetPurWayMaterialData(String PurchaseOrderRow,String PurchaseOrderNO,float Qty,String MaterialCode, String Factory, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println(jsonArray.toString());
        try {
            jsonObject.put("PurchaseOrderRow",PurchaseOrderRow);
            jsonObject.put("PurchaseOrderNO",PurchaseOrderNO);
            jsonObject.put("Qty",Qty);
            jsonObject.put("MaterialCode",MaterialCode);
            jsonObject.put("Factory",Factory);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetPurWayMaterialData(body)
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
        System.out.println("105data"+jsonArray.toString());
        try {
            jsonObject.put("postingDate",postingDate);
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("handler",handler);
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());

        RetrofitManager.getmInstance().createService1(APIService.class).
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
    public void WarehouseReceiptRecord(String DocumentDate,String user, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println(jsonArray.toString());
        try {
            jsonObject.put("DocumentDate",DocumentDate);
            jsonObject.put("user",user);
        } catch (JSONException e) {
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
//        System.out.println(jsonArray.toString());
        try {
            jsonObject.put("materialCode",materialCode);
            jsonObject.put("factory",factory);
        } catch (JSONException e) {
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
    public void InsertProductOrderIssue(List<InsertProductOrderIssueReq> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println("261发料数据："+jsonArray);
        try {
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
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
    //打印发料单及发料接口
    public void GetIssueNoteDetail(List<GetIssueNoteDetailReq> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println(jsonArray.toString());
        try {
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
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
    //库房发料记录接口
    public void GetIssueRecord(String issueDate,String user, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println(jsonArray.toString());
        try {
            jsonObject.put("issueDate",issueDate);
            jsonObject.put("user",user);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetIssueDetailRecordJS(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetIssueRecordReps>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetIssueRecordReps value) {
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
        } catch (JSONException e) {
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
        } catch (JSONException e) {
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
    public void Warehouse105Writeoff(List<Warehouse105WriteoffReq> data,String documentData, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        System.out.println(jsonArray.toString());
        try {
            jsonObject.put("data",jsonArray);
            jsonObject.put("documentData",documentData);
        } catch (JSONException e) {
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

    //外协------------------------------------------------------------------------------------------------
    //获取采购订单信息接口（机加）
    public void GetPurchaseOrderInfoJS(String KDAUF,String KDPOS,String MATNR, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println(jsonArray.toString());
        try {
            jsonObject.put("KDAUF",KDAUF);
            jsonObject.put("KDPOS",KDPOS);
            jsonObject.put("MATNR",MATNR);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
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
    public void Semi_FinishedProductReceiving(String postingDate, String documentDate, String user, Semi_FinishedProductReceivingReq detail, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(detail));
        Object obj = JSON.toJSON(detail);
        System.out.println("外协收货信息为："+obj.toString());
        try {
            jsonObject.put("postingDate",postingDate);
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("user",user);
            jsonObject.put("detail",obj);
        } catch (JSONException e) {
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
        System.out.println("101入库信息为："+obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (JSONException e) {
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
        System.out.println(data.getCurrentDate()+"+"+data.getHandler());
//        System.out.println(data.toString());
        try {
            jsonObject.put("data",obj);
        } catch (JSONException e) {
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
    public void GetOutStorageMaterialOrderJS(String I_INKDPOS,String I_INMATNR,String I_INKDAUF,String I_INWERKS,boolean I_INFLAG, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
//        System.out.println(data.getCurrentDate()+"+"+data.getHandler());
//        System.out.println(data.toString());
        try {
            jsonObject.put("I_INKDPOS",I_INKDPOS);
            jsonObject.put("I_INMATNR",I_INMATNR);
            jsonObject.put("I_INKDAUF",I_INKDAUF);
            jsonObject.put("I_INWERKS",I_INWERKS);
            jsonObject.put("I_INFLAG",I_INFLAG);
        } catch (JSONException e) {
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
        System.out.println(obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (JSONException e) {
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
    public void GetFinProStorageRecordNote(List<WriteOffProStorageRecordReqBean> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(data);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
//        System.out.println(data.getCurrentDate()+"+"+data.getHandler());
        System.out.println("101入库信息"+jsonArray.toString());
        try {
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
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
    public void OutsourceFinishedProductReceivingJS(String postingDate, String documentDate, String user, OutsourceFinishedProductReceivingJSReqBean3 detail, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
//        System.out.println(data.getCurrentDate()+"+"+data.getHandler());
        System.out.println("postingDate："+postingDate);
        System.out.println("documentDate："+documentDate);
        System.out.println("user："+user);
        System.out.println("外协成品收货信息："+obj.toString());
        try {
            jsonObject.put("postingDate",postingDate);
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("user",user);
            jsonObject.put("detail",obj);
        } catch (JSONException e) {
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
    public void GetDispatchListJS(List<Long> AdvanceStorageIds, String User,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(AdvanceStorageId));
//        System.out.println("外协收货信息为："+jsonArray.toString());
//        System.out.println(data.getCurrentDate()+"+"+data.getHandler());
        System.out.println("派工单id信息："+AdvanceStorageIds.toString());
        System.out.println("派工单user信息："+User);
        try {
            jsonObject.put("AdvanceStorageIds",AdvanceStorageIds);
            jsonObject.put("User",User);
        } catch (JSONException e) {
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

    //外协采购半成品收货记录接口
    public void Semi_FinishedProductReceivingRecordJS(String documentDate, String user,String OutsourcingType,final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
        try {
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("user",user);
            jsonObject.put("OutsourcingType",OutsourcingType);
        } catch (JSONException e) {
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
    public void Semi_FinishedProductReceivingwriteoffJS(String user, String CurrentDate, List<Semi_FinishedProductReceivingwriteoffJSReqBean> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
        try {
            jsonObject.put("user",user);
            jsonObject.put("CurrentDate",CurrentDate);
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
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
    public void GetOutsoureFinProductDataJS(String documentDate, String user, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
//        System.out.println("外协收货信息为："+jsonArray.toString());
        try {
            jsonObject.put("documentDate",documentDate);
            jsonObject.put("user",user);
        } catch (JSONException e) {
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
        System.out.println("外协采购成品收货冲销信息为："+user);
        System.out.println("外协采购成品收货冲销信息为："+requestTime);
        System.out.println("外协采购成品收货冲销信息为："+jsonArray.toString());
        try {
            jsonObject.put("user",user);
            jsonObject.put("requestTime",requestTime);
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
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
    public void GetOutsourceFinProLableJS(String user, String requestTime, List<GetOutsourceFinProLableJSReqBean> data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        try {
            jsonObject.put("user",user);
            jsonObject.put("requestTime",requestTime);
            jsonObject.put("data",jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonObject.toString());
        RetrofitManager.getmInstance().createService1(APIService.class).
                GetOutsourceFinProLableJS(body)
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
        System.out.println("301转储数据:"+obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (JSONException e) {
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
        } catch (JSONException e) {
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
//        System.out.println("301转储数据:"+obj.toString());
        try {
            jsonObject.put("data",obj);
        } catch (JSONException e) {
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

    //##获取厂内配送单
    public void GetCMInFactoryDeliver(List<String> DispatchListNO,String user,String requestTime, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
//        Object obj = JSON.toJSON(detail);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(DispatchListNO));
        System.out.println("扫描派工单数据："+jsonArray.toString());
        try {
            jsonObject.put("DispatchListNO",jsonArray);
            jsonObject.put("user",user);
            jsonObject.put("requestTime",requestTime);
        } catch (JSONException e) {
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


    //物料查询----------------------------------------------------------------------------------------------------------------------------------------
    //物料查询
    public void GetMaterialStorage(GetMaterialStorageReq data, final HttpDataListener httpDataListener) {

        JSONObject jsonObject = new JSONObject();
        Object obj = JSON.toJSON(data);
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
        try {
            jsonObject.put("data",obj);
        } catch (JSONException e) {
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
