// https://leetcode.com/problems/invalid-transactions

class Solution {
    class Transac{
        String name;
        String city;
        int time;
        int amount;
        int index;
        boolean isInvalid;
        
        Transac(String t, int i){
            String[] s = t.split(",");
            name = s[0];
            time = Integer.parseInt(s[1]);
            amount = Integer.parseInt(s[2]);
            city = s[3];
            index = i;
            isInvalid = false;
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        
        Map<String, List<Transac>> hm = new HashMap<>();
        
        for(int i=0;i<transactions.length;i++){
            String t = transactions[i];
            Transac temp = new Transac(t, i);
            
            List<Transac> al = hm.getOrDefault(temp.name, new ArrayList<Transac>());
            
            if(al.size() != 0){
                for(Transac x:al){
                    if(temp.city.equals(x.city)==false && Math.abs(temp.time-x.time)<=60){
                        if(temp.isInvalid == false){
                            temp.isInvalid = true;
                            res.add(transactions[temp.index]);
                        }
                        
                        if(x.isInvalid == false){
                            x.isInvalid = true;
                            res.add(transactions[x.index]);
                        }
                    }
                }
            }
            
            if(!temp.isInvalid && temp.amount>1000){
                temp.isInvalid = true;
                res.add(transactions[temp.index]);
            }
            
            al.add(temp);
            hm.put(temp.name, al);
        }
        
        return res;
    }
}