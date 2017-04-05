package com.example.lining.dbutisl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DbUtils mDb;
    private List<Pers> mPersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建表
        mDb = DbUtils.create(this, "data");
        mDb.configDebug(true); // debug模式 会输入sql语句
        mDb.configAllowTransaction(true); // 允许事务
    }

    public void add(View view) {

        try {
            mDb.createTableIfNotExist(Pers.class);
            Pers pers = new Pers(1, "qinaho", 1, "nan");
            mDb.save(pers);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

  /*  public void delete(View view) {

        WhereBuilder whereBuilder = WhereBuilder.b("age", "=", "33");

        try {
            mDb.delete(whereBuilder);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }*/

  /*  public void update(View view) {


        try {
            List<Pers> persons = mDb.findAll(Pers.class);
            for (Pers person : persons) {
                //                    person.setSalary(6000);
                person.setAge(40);
                mDb.update(person, WhereBuilder.b("sex", "=", "man"), "salary", "age");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


       /* try {
           WhereBuilder whereBuilder = WhereBuilder.b("AGE", "=", "33");
           mDb.update(mPersList, WhereBuilder.b("sex", "=", "nan"), "salary","age");
        // db.update(new CopyOfPerson("nv",22), whereBuilder, "name","age");

    } catch (DbException e) {
            e.printStackTrace();
        }*/


    public void query(View view) {

        //        List <Pers> list=mDb.findAll(Pers.class);
        try {
            mPersList = mDb.findAll(Pers.class);

            for (Pers p : mPersList
                    ) {
                Log.d(TAG, "" + p);
            }
           /* new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    Toast.makeText(MainActivity.this, "" + mPersList.get(0)+"eeee", Toast.LENGTH_SHORT).show();
                    Looper.loop();//这句执行

                }
            });*/
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /*public void delete(View v) {
        WhereBuilder whereBuilder = WhereBuilder.b("age", "=", 44);
		// 删除
		try {
			db.delete(Person.class, whereBuilder);
		} catch (DbException e) {

			e.printStackTrace();
		}

	}

	public void update(View v) {
		// db.update(new Student(64, null, 888, "男"), whereBuilder,
		// "age","sex");

		WhereBuilder whereBuilder = WhereBuilder.b("id", "=", 32);
		try {
			db.update(new CopyOfPerson("nv",22), whereBuilder, "name","age");
		} catch (DbException e) {
			e.printStackTrace();
		}

	}
*/
}
