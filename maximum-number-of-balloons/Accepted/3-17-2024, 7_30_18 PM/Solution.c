// https://leetcode.com/problems/maximum-number-of-balloons

int maxNumberOfBalloons(char* text) {
    int count[26] = {0};
    int res = INT_MAX;

    for(int i=0; text[i]!='\0'; i++){
        count[text[i]-'a']++;
    }

    res = res>count['b'-'a']?count['b'-'a']:res;
    res = res>count['a'-'a']?count['a'-'a']:res;
    res = res>(count['l'-'a']/2)?(count['l'-'a']/2):res;
    res = res>(count['o'-'a']/2)?(count['o'-'a']/2):res;
    res = res>count['n'-'a']?count['n'-'a']:res;

    return res;
}
