package com.example.felipe.rpgapp.Control;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * Created by Trabalho on 1/23/2018.
 */

public abstract class AbstractEntity
{
    public String toJSONString()
    {
        return new Gson().toJson(this);
    }
}
