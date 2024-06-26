// https://leetcode.com/problems/time-based-key-value-store

class TimeMap {
    class Value {
        String val;
        int time;

        Value(String v, int t){
            val = v;
            time = t;
        }
    }

    Map<String, List<Value>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        List<Value> temp = map.get(key);

        if(temp == null){
            temp = new ArrayList<>();
            temp.add(new Value(value, timestamp));
            map.put(key, temp);
        }else{
            temp.add(new Value(value, timestamp));
        }

    }
    
    public String get(String key, int timestamp) {
        List<Value> temp = map.get(key);

        if(temp == null)
            return "";
        
        String ret = "";

        for(int i=temp.size()-1; i>=0;i--){
            int t = temp.get(i).time;
            String v = temp.get(i).val;
            
            if(t<=timestamp){
                ret = v;
                break;
            }
        }
        return ret;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */