package me.josh.cubits.utils;

import me.josh.cubits.playerdata.PlayerProfile;

import java.util.List;

public interface Serializer<T> {
    void serialize(T data);
    T deserialize();




}
