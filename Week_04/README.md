## Week4 学习笔记


### 深度优先搜索&广度优先搜索

* 每个节点都要访问一次
* 每个节点仅仅要访问一次
* 对于节点的访问顺序不限

  - 深度优先：depth first search

  - 广度优先：breadth first search

#### 深度优先

##### 递归模板

```java
public List<List<Integer>> levelOrder(TreeNode root) {
  List<List<Integer>> allResults = new ArrayList<>();
  if(root==null){
    return allResults;
  }
  travel(root,0,allResults);
  return allResults;
}


private void travel(TreeNode root,int level,List<List<Integer>> results){
  if(results.size()==level){
    results.add(new ArrayList<>());
  }
  results.get(level).add(root.val);
  if(root.left!=null){
    travel(root.left,level+1,results);
  }
  if(root.right!=null){
    travel(root.right,level+1,results);
  }
}
```
##### 非递归模板

```java
public List<Integer> inorderTraversal(TreeNode root) {
  List<Integer> ret = new ArrayList<>();
  if (root == null) {
    return ret;
  }

  Stack<TreeNode> stack = new Stack<>();
  // 根节点入栈
  stack.push(root);
  while (!stack.isEmpty()) {
    // 有左子节点，依次入栈
    while (stack.peek().left != null) {
      stack.push(stack.peek().left);
    }
    TreeNode pop = stack.pop();
    ret.add(pop.val);
    if (pop.right != null) {
      stack.push(pop.right);
    }
  }
  return ret;
}
```


#### 广度优先

##### 代码模板

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```


### 贪心算法 Greedy

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。 

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。 

贪心法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码等。然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。 

#### 贪心算法的场景

简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。

这种子问题最优解称为最优子结构。 



---



### 二分查找

#### 二分查找的前提条件

- 目标函数单调性（单调递增或者递减） 
- 存在上下界（bounded） 
- 能够通过索引访问（index accessible) 



#### 代码模板

```java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}
```





