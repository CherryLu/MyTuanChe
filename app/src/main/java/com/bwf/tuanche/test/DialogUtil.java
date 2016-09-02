package com.bwf.tuanche.test;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import android.widget.TextView;

import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;

/**
 * Created by BWF on 2016/9/1.
 */
public class DialogUtil extends Dialog implements View.OnClickListener{
    private TextView tv_update_desc;
    private TextView tv_version_name;
    private UpdateBean updateBean;


    private File downLoadFile;

    public DialogUtil(Context context,UpdateBean updateBean) {
        super(context);
        this.updateBean = updateBean;
    }

    public DialogUtil(Context context, int themeResId,UpdateBean updateBean) {
        super(context, themeResId);
        this.updateBean = updateBean;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dailog_update);
        tv_update_desc = (TextView) findViewById(R.id.tv_update_desc);
        tv_version_name = (TextView) findViewById(R.id.tv_version_name);
        findViewById(R.id.btn_update).setOnClickListener(this);
        findViewById(R.id.img_close).setOnClickListener(this);
        if (updateBean!=null){
            tv_update_desc.setText(updateBean.description);
            tv_version_name.setText(updateBean.versionName);
            if ("true".equals(updateBean.isFourceUpGrade)){
                setCancelable(false);
            }
        }


    }


    public void showDialog(){
        if (!isShowing()){
            show();
        }
    }

    public void closeDialog(){
        dismiss();
    }

    @Override
    public void onClick(View view) {


    }

    public void doUpdate(String url){
        try {
            if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
                ToastUtil.showToast("没有SD卡");
                return;
            }
            File path = Environment.getExternalStorageDirectory();
            StatFs statFs = new StatFs(path.getPath());
            long availableBlocks = statFs.getAvailableBlocks();
            long blockSize = statFs.getBlockSize();
            if (availableBlocks*blockSize<1024*1024*100){
                ToastUtil.showToast("存储空间不足");
                return;
            }
            String loadPath = Environment.getDataDirectory()+"/car";
            String apkname = "tuanche.apk";
            downLoadFile = new File(loadPath+"/"+apkname);
            NotificationUtil.getInstance().showNotification(getContext(),R.layout.app_upgrade_notice,1);
            OkHttpUtils.get().url(url)
                    .build()
                    .execute(new FileCallBack(loadPath,apkname) {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(File response, int id) {

                        }
                    });

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
