package com.example.roomdatabase;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class UserDao {

        @Query("SELECT * FROM User")
        public abstract List<User> getAll();

        @Query("SELECT * FROM User WHERE uid IN (:userIds)")
        public abstract List<User> loadAllByIds(int[] userIds);

        @Query("SELECT * FROM User WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1")
        public abstract User findByName(String first, String last);

        @Insert
        public abstract void insertAll(User... users);

        @Delete
        public abstract void delete(User user);
    }

