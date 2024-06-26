// https://leetcode.com/problems/maximum-number-of-balloons

int maxNumberOfBalloons(char* text) {
    size_t count[26] = {0};
    
    while(*text !='\0'){
        count[(*text++)-'a']++;
    }
    
    int min = INT_MAX;

    if(count[0]<min){
        min = count[0];
    }
    if(count[1]<min){
        min = count[1];
    }
    if(count['n'-'a']<min){
        min = count['n'-'a'];
    }
    if((count['l'-'a']/2)<min){
        min = (count['l'-'a']/2);
    }
    if((count['o'-'a']/2)<min){
        min = (count['o'-'a'])/2;
    }

    return min;
}