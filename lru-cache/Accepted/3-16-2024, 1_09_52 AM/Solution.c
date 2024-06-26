// https://leetcode.com/problems/lru-cache

#define HASH_SIZE 9001

typedef struct element{
    int key, value;
    struct element *next, *prev;
}element;

typedef struct {
    element *cache_head, *cache_tail;
    int capacity, count;
    element *hash[HASH_SIZE];
} LRUCache;


void insertEntry(LRUCache*obj, element *cur){
    if(cur == NULL)
        return;

    // printf("| In Insert |");
    cur->prev = obj->cache_tail;
    cur->next = NULL;
    
    if(obj->cache_tail!=NULL)
        obj->cache_tail->next = cur;

    obj->cache_tail = cur;

    if(obj->cache_head == NULL){
        obj->cache_head = cur;
    }

    obj->hash[cur->key] = cur;
    obj->count++;

    if(obj->count > obj->capacity){
        // printf("| Capacity Full! |");
        element* temp = obj->cache_head;
        obj->cache_head = obj->cache_head->next;
        if(obj->cache_head != NULL)
            obj->cache_head->prev = NULL;
        else
            obj->cache_tail = NULL;

        obj->hash[temp->key] = NULL;
        free(temp);

        obj->count--;
    }

}

void updateEntry(LRUCache* obj, element *cur){
    if(cur == NULL)
        return;
    // printf("| In Update |");
    if(cur == obj->cache_tail){
        return;
    }else if(cur == obj->cache_head){
        obj->cache_head = obj->cache_head->next;
        if(obj->cache_head != NULL)
            obj->cache_head->prev = NULL;
        cur->prev = obj->cache_tail;
        cur->next = NULL;
        obj->cache_tail->next = cur;
        obj->cache_tail = cur;
    }else{
        cur->prev->next = cur->next;
        cur->next->prev = cur->prev;
        cur->next = NULL;
        cur->prev = obj->cache_tail;
        obj->cache_tail->next = cur;
        obj->cache_tail = cur;
    }
}

// void print(LRUCache *obj){
//     element *cur = obj->cache_head;
//     printf("count = %d  | ", obj->count);
//     while(cur){
//         printf("|%d - %d ", cur->key, cur->value);
//         cur = cur->next;
//     }
//     printf("\n");
// }

// element* isPresent(LRUCache* obj, int key){
//     if(obj->cache_head == NULL)
//         return NULL;
//     element* cur = obj->cache_head;
//     while(cur){
//         if(cur->key == key)
//             return cur;
//         cur = cur->next;
//     }
//     return NULL;
// }

element* isPresent(LRUCache* obj, int key){
    return obj->hash[key];
}

LRUCache* lRUCacheCreate(int capacity) {
    LRUCache *lru = (LRUCache*)malloc(sizeof(LRUCache));
    lru->cache_head = NULL;
    lru->cache_tail = NULL;
    lru->capacity = capacity;
    lru->count = 0;
    for (size_t i = 0; i < HASH_SIZE; i++)
        lru->hash[i] = NULL;
    // printf("CREATE: ");
    // print(lru);
    // printf("\n");
    return lru; 
}

int lRUCacheGet(LRUCache* obj, int key) {
    element* cur = isPresent(obj, key);
    // printf("GET: ");
    if(cur == NULL){
        return -1;
    }else{
        updateEntry(obj, cur);
        // print(obj);
        // printf("\n");
        return cur->value;
    }
}

void lRUCachePut(LRUCache* obj, int key, int value) {
    element *cur = isPresent(obj, key);
    // printf("PUT: ");

    if(cur == NULL){
        cur = (element*)malloc(sizeof(element));
        cur->key = key;
        cur->value = value;
        cur->prev = NULL;
        cur->next = NULL;
        insertEntry(obj, cur);
    }else{
        cur->value = value;
        updateEntry(obj, cur);
    }
    // print(obj);
    // printf("\n");
}

void lRUCacheFree(LRUCache* obj) {
    element* cur;
    while(obj->cache_head){
        cur = obj->cache_head;
        obj->cache_head = obj->cache_head->next;
        free(cur); 
    }
    free(obj);
}

/**
 * Your LRUCache struct will be instantiated and called as such:
 * LRUCache* obj = lRUCacheCreate(capacity);
 * int param_1 = lRUCacheGet(obj, key);
 
 * lRUCachePut(obj, key, value);
 
 * lRUCacheFree(obj);
*/