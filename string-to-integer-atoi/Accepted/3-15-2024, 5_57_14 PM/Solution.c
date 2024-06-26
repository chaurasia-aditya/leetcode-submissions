// https://leetcode.com/problems/string-to-integer-atoi

// #define INT_MAX ((1<<31)-1)
// #define INT_MIN (-(1<<31))
int myAtoi(char* s) {
    int res = 0;
    int neg = 1;
    while(*s && *s == ' '){
        s++;
    }
    // printf("*s = %c",*s);
    if(!(*s)){
        // printf("here\n");
        return 0;
    }
    if(*s == '-'){
        neg = -1;
        s++;
    }else if(*s == '+')
    {
        s++;
    }
    // printf("*s = %c\n",*s);
    int ch = (*s-'0');
    while(*s && !(ch<0 || ch>9)){
        // printf("*s = %c %d | res = %d\n",*s, *s, res);
        if(res>(INT_MAX/10) || (res== (INT_MAX/10) && (ch>7)))
            return neg<0?INT_MIN:INT_MAX;
        res = res*10+ch;
        s++;
        ch = (*s-'0');
        // printf("ch=%d ",ch);
    }

    return res*neg;
}