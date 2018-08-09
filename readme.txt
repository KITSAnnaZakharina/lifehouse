The RingBuffer is a data structure of fixed sized and is a FIFO queue.
It is implemented as a linked list that is connected end-to-end which makes the RingBuffer cyclic in nature.

Task requirements:
 1. This ring buffer will hold ints.
 2. Implement the following:
    int write(int[] data), which writes as many elements of data as it can before overwriting and returns the number of elements written to the buffer;
    int read(), which returns a single buffered int in FIFO order, and removes the element from the buffer.

To check expected behaviour you can use junit tests in RingBufferTest.

Note:
In scope of this task RingBuffer works only for primitive type int.
I would suggest to make it generic for any object type.
In such case you will need to specify the type during RingBuffer creation like
RingBuffer buffer = new RingBuffer<Integer>();