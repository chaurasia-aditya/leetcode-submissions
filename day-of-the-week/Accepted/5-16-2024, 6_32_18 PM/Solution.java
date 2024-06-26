// https://leetcode.com/problems/day-of-the-week

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        int sum = 0;
        boolean leap = (year%4 == 0 && year!=2100);
        for(int i = 1971;i<year;i++){
            sum+=365;
            if(i%4 == 0 && i!=2100)
                sum++;
        }
        
        for(int i=0;i<month-1;i++){
            sum+=months[i];
        }
        
        sum+=day;
        
        if(leap && (month>2))
            sum++;
        
        System.out.println(sum);
        return days[sum%7];        
    }
}