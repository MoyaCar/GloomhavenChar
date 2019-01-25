package com.syntax.gloomeame;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface PersonajeDao {

    @Insert
    void agregar(Personaje personaje);
}
