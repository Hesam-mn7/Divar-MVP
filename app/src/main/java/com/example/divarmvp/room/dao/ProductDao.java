package com.example.divarmvp.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.divarmvp.room.entity.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface ProductDao {

    @Insert
    Completable insert(Product product);

    @Query("select * from product order by id desc")
    Observable<List<Product>> select();

    @Query("DELETE FROM product WHERE id = :id")
    Completable deleteById(int id);

    @Update
    Completable update(Product product);

}
