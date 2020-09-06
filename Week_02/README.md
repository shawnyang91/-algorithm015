Week2 学习笔记

### 数据结构

#### 哈希表

##### 特点

- 使用哈希函数，将key映射到不同的 index.

- java实现:链表 + 红黑树

- 操作复杂度:O(1)



#### 树

##### 示例代码

```java
public class TreeNode {
public int val;
public TreeNode left, right;
public TreeNode (int val) {
  this.val = val;
  this.left = null;
  this.right = null;
	}
}
```

##### 树的遍历

- 前序遍历

  中 -> 左 ->右

  ```java
  public void preOrder(TreeNode root){
    if(root != null) {
      System.out.println(root.val);
      preOrder(root.left);
      preOrder(root.right);
    }
  }
  ```

- 中序遍历

  左->中->右

  ```java
  public void inOrder(TreeNode root){
    if(root != null) {
      inOrder(root.left);
      System.out.println(root.val);
      inOrder(root.right);
    }
  }
  ```

- 后序遍历

  左->右->中

  ```java
  public void postOrder(TreeNode root){
    if(root != null) {
      postOrder(root.left);
      postOrder(root.right);
      System.out.println(root.val);
    }
  }
  ```

  

- 按层遍历

  使用队列辅助，进行BFS 遍历。

  ```java
  public void levelOrder(TreeNode root){
    if(root != null) {
      new DeQueue<TreeNode>();
      postOrder(root.left);
      postOrder(root.right);
      System.out.println(root.val);
    }
  }
  ```

  
  
- 深度优先遍历DFS

```java
    public List<Integer> dfs(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ret;
    }

```



- 广度优先遍历BFS

```java
    public List<Integer> bfs(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ret.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
        }
        return ret;
    }

```




##### 特殊的树型结构

###### 二叉搜索树(Binary Search Tree)

也称为有序二叉树(Ordered Binary Tree), 排序二叉树(Sorted Binary Tree)。空树是一颗二叉搜索树。



非空二叉搜索树特点：

- 左子树上所有结点的值均小于它的根结点的值；
- 右子树上所有结点的值均大于它的根结点的值；
- 以此类推，左右子树也分别是二叉搜索树。(重复性！适用递归)

以上，二叉搜索树的中序遍历即所有结点_**升序排列**_。



操作复杂度：

增加:O(logN)

删除:O(logN)

查询:O(logN)



#### 堆

可以迅速找到一堆树中最大或最小值的数据结构。

根节点值最大的叫大顶堆，根节点值最小的叫小顶堆。



##### 堆的几种实现

- 二叉堆：完全二叉树实现

  二叉堆的性质：

  - 是一颗完全二叉树
  - 树中任意节点的值总是>=其其子节点的值
  
  
  
  二叉堆的调整:
  
  - 增加元素 heapifyUp
  - 删除非堆顶元素
  - 删除堆顶元素



- Fibonacci堆
- ...



#### 图

Graph<V,E>

V: vertex 点

- 度:入读、出度, 标识点与点之间是否连通

E: edge 边

- 权重

- 方向

根据边是否有方向和权重，有以下几种图：

- 无向无权图

- 有向无权图

- 无向有权图
- 有向有权图



##### 数学表示方法

- 邻接矩阵 二维数组
- 邻接表 数组+链表



##### 常见图算法

- DFS: 深度优先算法

与树的 DFS最大的区别:

**！！记录结点是否被访问过。visited = set() **



- BFS:广度优先算法

与树的 BFS最大的区别:

**！！记录结点是否被访问过。visited = set() **



##### 图的高级算法

- 连通图个数(常见题目)

- 拓扑排序
- 最短路径(dijkstra)
- 最小生成树



---

### 解题方法

##### 解题步骤:

1. clarification 与面试官确认习题的边界，如：取值范围，大小写敏感，上下界
2. possible solutions 列出所有可能的解法，分析时间复杂度和空间复杂度，从中选出最优解
3. code 开始编码
4. test cases 进行单元测试 


##### 升维思想

- 链表->跳表
- 链表->树