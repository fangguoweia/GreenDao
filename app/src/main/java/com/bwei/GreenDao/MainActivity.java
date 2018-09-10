package com.bwei.GreenDao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bwei.GreenDao.gen.UserBeanDao;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    Button addclick;
    Button deleteclick;
    Button updateclick;
    Button selectclick;
    private UserBeanDao userBeanDao;
    private Long id;
    private UserBean userBean1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addclick = findViewById(R.id.addclick);
        deleteclick = findViewById(R.id.deleteclick);
        updateclick = findViewById(R.id.updateclick);
        selectclick = findViewById(R.id.selectclick);

        userBeanDao = App.getInstances().getDaoSession().getUserBeanDao();
        //增删改查
        adusClick();
    }

    private void adusClick() {

        //添加数据
        addclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userBean1 = new UserBean();
                userBean1.setName("数据01");
                userBean1.setAge(20);
                userBeanDao.save(userBean1);
            }
        });
        //删除数据
        deleteclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userBeanDao.deleteByKey(id);
                Log.i("aaa","删除了id---"+id);
            }
        });
        //修改数据
        updateclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userBean1 = new UserBean();
                userBean1.setName("update数据01");
                userBean1.setAge(20);
                userBeanDao.update(userBean1);
            }
        });
        //查询数据
        selectclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<UserBean> loadAll = userBeanDao.loadAll();
                if (loadAll.size()<1){
                    Log.i("aaa","查询数据--- null");
                }else {
                    for (int i = 0; i < loadAll.size(); i++) {
                        //获取id
                        id = loadAll.get(i).getId();
                        Log.i("aaa","查询数据---"+loadAll.get(i).getName()+","+loadAll.get(i).getAge());
                    }
                }
            }
        });
    }
}
