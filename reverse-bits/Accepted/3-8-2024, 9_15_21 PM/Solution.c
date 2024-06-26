// https://leetcode.com/problems/reverse-bits

uint32_t reverseBits(uint32_t n) {
    uint32_t res = 0;

    for(int i=0;i<16;i++){
        res |= (n & 1U<<i)<<(31-2*i);
        res |= (n & 1U<<(31-i))>>(31-2*i);
    }

    return res;
}