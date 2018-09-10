package com.bwei.GreenDao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bwei.GreenDao.gen.DaoMaster;
import com.bwei.GreenDao.gen.DaoSession;

/**
 * Created by 房国伟 on 2018/9/3.
 */
public class App extends Application {
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static App instances;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化greenDao
        initDB();

        instances=this;
    }

    public static App getInstances() {
        return instances;
    }

    private void initDB() {
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "lxgreendao.db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }
}
