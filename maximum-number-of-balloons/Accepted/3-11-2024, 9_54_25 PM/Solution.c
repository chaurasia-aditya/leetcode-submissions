// https://leetcode.com/problems/maximum-number-of-balloons

int maxNumberOfBalloons(char* text) {
    int count[26];
    memset(count, 0, 26*sizeof(int));
    
    for(int i=0; text[i]!='\0'; i++){
        count[text[i]-'a']++;
    }

    for(int i=0; i<26; i++){
        printf("%d ",count[i]);
    }

    int min = 10001;

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