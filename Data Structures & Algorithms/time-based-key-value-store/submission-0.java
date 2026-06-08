class TimeMap {
    private class Record{
        String val;
        int time;
        Record(int time, String val){
            this.val = val;
            this.time = time;
        }
    }
    HashMap<String,List<Record>> timeMap;
    public TimeMap() {
        this.timeMap = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        Record r = new Record(timestamp, value);
        if(timeMap.containsKey(key)) timeMap.get(key).add(r);
        else{
            List<Record> l = new ArrayList<>();
            l.add(r);
            timeMap.put(key,l);
        }
        return;
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) return "";
        List<Record> arr = timeMap.get(key);
        int i = 0;
        int j = arr.size()-1;
        String res = "";
        while(i<=j){
            int mid = (i+j)/2;
            Record r = arr.get(mid);
            if(r.time <= timestamp){
                res = r.val;
                i = mid+1;
            }   
            else j = mid-1;
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */