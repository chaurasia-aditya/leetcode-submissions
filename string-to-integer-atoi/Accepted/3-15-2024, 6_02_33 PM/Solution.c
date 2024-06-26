// https://leetcode.com/problems/string-to-integer-atoi

// #define INT_MAX ((1<<31)-1)
// #define INT_MIN (-(1<<31))
int myAtoi(char* s) {
    int res = 0;
    int neg = 1;
    int i = 0;
    while(s[i] == ' '){
        i++;
    }
    if(s[i] == '-'){
        neg = -1;
        i++;
    }else if(s[i] == '+')
    {
        i++;
    }
    int ch = (s[i]-'0');
    while(s[i] && !(ch<0 || ch>9)){
        if(res>(INT_MAX/10) || (res== (INT_MAX/10) && (ch>7)))
            return neg<0?INT_MIN:INT_MAX;
        res = res*10+ch;
        i++;
        ch = (s[i]-'0');
    }

    return res*neg;
}