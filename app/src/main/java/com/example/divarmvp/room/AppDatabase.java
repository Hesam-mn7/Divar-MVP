package com.example.divarmvp.room;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.divarmvp.room.dao.ProductDao;
import com.example.divarmvp.room.entity.Product;

@Database(entities = Product.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductDao getProductDao();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(application, AppDatabase.class, "DivarMVM.DB").build();

        }
        return instance;
    }


}
