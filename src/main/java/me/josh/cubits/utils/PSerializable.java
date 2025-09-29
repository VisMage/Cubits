package me.josh.cubits.utils;

public interface PSerializable<T> {

    Serializer<T> serializer();

}
