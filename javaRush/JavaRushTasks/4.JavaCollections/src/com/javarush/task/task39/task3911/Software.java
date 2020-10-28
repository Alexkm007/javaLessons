package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if(rollbackVersion>currentVersion){
            return false;
        }

        Integer[] keys = versionHistoryMap.keySet().toArray(new Integer[0]);

        for(Integer key:keys){
            if(key>rollbackVersion){
                versionHistoryMap.remove(key);
            }else if(key==rollbackVersion){
                currentVersion = rollbackVersion;
            }
        }

//        for(Map.Entry entry:versionHistoryMap.entrySet()){
//            Integer key = (Integer) entry.getKey();
//            if(key==rollbackVersion) currentVersion = key;
//            if(key>rollbackVersion){
//                versionHistoryMap.remove(key);
//            }
//        }

        return true;
    }
}
