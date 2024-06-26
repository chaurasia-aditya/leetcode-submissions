// https://leetcode.com/problems/maximum-number-of-balloons

int maxNumberOfBalloons(char* text) {
    size_t count[26] = {0};
    
    while(*text !='\0'){
        count[(*text++)-'a']++;
    }

    int min = INT_MAX;

    min = min<count['b'-'a']?min:count['b'-'a'];
    min = min<count['a'-'a']?min:count['a'-'a'];
    min = min<(count['l'-'a']/2)?min:(count['l'-'a']/2);
    min = min<(count['o'-'a']/2)?min:(count['o'-'a']/2);
    min = min<count['n'-'a']?min:count['n'-'a'];

    return min;
}