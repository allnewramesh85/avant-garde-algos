# Ring Buffer
Ring buffer is circular data structure is a simple array backed and fixed-size buffer. The performance optimization achieved by exploiting the efficiency of underlying hardware,  an arrays has  predictable access pattern, thus the entries can be pre-loaded so the processor is not often scan through main memory to load next element in the ring.
The ring buffer is implement using the memory barrier in contrast to traditional data structures such queues are built using locks to avoid contentions, which can case a context switch to the kernel. When this happens the underlying processor is likely to lose the data in it's caches.

#### Important Note
#### 1. Attributes 
       Along array, it has three other attributes
        1.1  WriteSequencer - Track the next avilable slot in the buffer to insert
        1.2  ReadSequence - Track the next unread element in the buffuer
        1.3  Capacity - As it's bounded array and 
#### 2. Overwrite
       Using capacity to make sure no unread data is overwirten when reader lag behind the writer.
#### 3 Find right slots 
      To derive the next avilable slots in the buffer, it uses an mod operations to wraps the sequences around the bounderries.
        index= squence%capacity
#### 4 Operations
##### Offer
        Offer operation insert an lement into the buffer at next avialble slot and return TRUE on success.
        It return FALSE when the size of the buffer is equal to it's capacity, where it is equl to the number of unread elements

##### Poll
    The poll operation return next unread elements in the buffer. This operation doesn't remove the lement but increment a read seuquecer. It returns NULL when write sequence lags behind the read sequence.


