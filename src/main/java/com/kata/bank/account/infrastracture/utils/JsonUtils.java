package com.kata.bank.account.infrastracture.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonUtils {

    public static byte[] toJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsBytes(o);
        } catch (JsonProcessingException e) {
           return new byte[] {};
        }
    }
}
