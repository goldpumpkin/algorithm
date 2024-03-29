### 堆是什么？

+ 完全二叉树
+ 每个节点的值大于等于（或小于等于）其子树的值

### 分类

小顶堆 -- 节点的值 <= 子树的值
大顶堆 -- 节点的值 >= 子树的值

### 存储

完全二叉树是非常适合用数组来存储的，因为不需要存储节点的左右指针

### 操作

1. 堆化：往原有堆中，添加或者删除元素，重新构建堆的过程

   方式：从上而下、从下而上

2. 添加元素

   加到尾部，堆化

3. 删除元素-删除头部元素

   合理方法：尾部填充到头部，堆化 

   有问题的方法：把其子节点较大(较小)的节点放置头部，依次进行，会出现子节点空洞，不符合完全二叉树的情况

4. 操作的时间复杂度

   O(logn)  <-  时间复杂度和高度成正比，高度小于$log_2n$

### 堆排序

1. 建堆 - 复杂度 O(n)
   + 方式一：尾部添加节点，进行比较
   + 方式二：从 n/2 开始到 1，进行堆化。核心思想：所有有子节点的节点都堆化了，那么组成的就成堆了
2. 排序 - 复杂度 O(nlogn)
3. 堆排序复杂度是 O(nlogn)

### 问题

1. 为什么堆排序没有快速排序快？

   1. 访问方式

      堆排序中，某个节点的堆化，对数组的访问是跳着的，对CPU缓存访问不友好

   2. 交换次数

      由于有堆化的过程，会使得原有顺序打乱。堆排序交换次数比较多

2. 这种数据结构堆和java内存模型中的堆内存有什么关系呢？

   完全没关系

3. 