// https://leetcode.com/problems/reverse-bits

uint32_t reverseBits(uint32_t n) {
    int bits = 32;
    uint32_t res = 0;

    for(int i=0;i<bits-1;i++){
        res |= (n & 1);
        res<<=1;
        n>>=1;
    }
    res |= (n & 1);
    return res;
}