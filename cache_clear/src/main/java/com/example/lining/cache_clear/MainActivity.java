package com.example.lining.cache_clear;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    TextView tv_cache_size;
    private File mCacheDir;
    private long totalSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_cache_size = (TextView) findViewById(R.id.tv_cache_size);
        //写入缓存信息
        File cacheDir = getCacheDir();
        mCacheDir = cacheDir;
        //显示当前缓存大小`
        try {
            String cacheSize = DataClearManager.getCacheSize(mCacheDir);
            tv_cache_size.setText(cacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟存储缓存内容
     *
     * @param cacheDir
     */
    private void writeCache(File cacheDir) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(cacheDir, "aaaa.txt"));
            fileOutputStream.write("dhoadhlfajdlsjddddddddddddddddddakfsavoannvkawodqqqqqfnawdnfawnvvnkanvaovnjaonvalvnakdjfnajdvjjdjjdjdjdjdjdjdjdjdjdjdjakdnfaeo;aeo".getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        File file = new File(cacheDir, "uuuu");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, "bbbb.txt"));
            fileOutputStream.write("dhoadhlfajdlsjddddddddddddddddddakfsavoannvkawodfnawdnfawnvvnkanvaovnjaonvalvnakdjfnajdvjjdjjdjdjdjdjdjdjdjdjdjdjakdnfaeo;aeo".getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 清除缓存
     *
     * @param view
     */
    public void clearCache(View view) {
        //        clearAllCache(cacheDir);
        //判断是否删光
        //        String cacheSize = getCacheSize(cacheDir);
        //删除某个指定文件夹下的所有信息
        DataClearManager.deleteFolderFile(mCacheDir.getAbsolutePath(), true);
        String size = null;
        try {
            size = DataClearManager.getCacheSize(mCacheDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tv_cache_size.setText(size);
    }
}
