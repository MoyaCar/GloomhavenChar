package com.syntax.gloomeame;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = Personaje.class, version = 1, exportSchema = false)
public abstract class PersonajeBasededatos extends RoomDatabase {
    public abstract PersonajeDao personajeDao();
}
