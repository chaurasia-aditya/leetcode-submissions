// https://leetcode.com/problems/time-based-key-value-store

class TimeMap {
    // HashMap<String, ArrayList<Value>> map;
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> temp = map.get(key);

        if(temp == null){
            temp = new TreeMap<>();
            temp.put(timestamp, value);
            map.put(key, temp);
        }else{
            temp.put(timestamp, value);
        }

    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> temp = map.get(key);

        if(temp == null)
            return "";

        Map.Entry<Integer, String> e = temp.floorEntry(timestamp);

        if(e == null)
            return "";
        
        // String ret;

        // if((ret = temp.get(timestamp)) !=null)
        //     return ret;

        // int cur_tmax=-1;

        // for(Map.Entry<Integer, String> e:temp.entrySet()){
        //     int k = e.getKey();
        //     String val = e.getValue();
        //     if(k<timestamp && k>cur_tmax){
        //         cur_tmax = k;
        //         ret = val;
        //     }else if(k > timestamp)
        //         break;
        // }
        // return ret;

        return e.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */