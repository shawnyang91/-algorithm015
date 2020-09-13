## Week3 学习笔记



### 递归

通过调用函数本身来进行循环。使用递归解决的问题都可以用循环代替。



#### 递归特点

- 存在最近重复子问题
- 存在终止条件



#### 递归模板

```java
public void recur(int level, int param) { 

  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }

  // process current logic 
  process(level, param); 

  // drill down 
  recur(level + 1, newParam); 

  // restore current status if needed
}
```



#### 剪枝

递归问题复杂度通常是指数级的，在每次向下递归前，可以通过_**剪枝**_来减少无效计算。



---



### 分治

分治思想即“分而治之”，也就是将原问题划分成 n 个规模较小，并且结构与原问题相似的子问题，递归地解决这些子问题，然后再合并其结果，就得到原问题的解。分治思想一般用递归实现。

#### 分治条件

- 原问题和子问题具有相同的模式
- 原问题和子问题可以独立求解，子问题之间没有相关性
- 有分解终止条件，即子问题规模足够小时，可以直接求解
- 可以将子问题合并成原问题



#### 分治模板

```python
def divide_conquer(problem, param1, param2, ...): 
    # 递归终止条件
    if problem is None: 
        print_result 
        return 

    # prepare data 
    data = prepare_data(problem) 
    
    # 分解子问题
    subproblems = split_problem(problem, data) 

    # 递归求解子问题
    subresult1 = self.divide_conquer(subproblems[0], p1) 
    subresult2 = self.divide_conquer(subproblems[1], p1) 
    subresult3 = self.divide_conquer(subproblems[2], p1) 

    # 合并子问题的解，得到最终解
    result = process_result(subresult1, subresult2, subresult3, …)

    # revert the current level states
```



---



### 回溯

回溯算法思想类似枚举搜索，枚举所有可能的解，对每个解进行试错，如果不满条件，则回调到上次层，选择另外一个解继续尝试，直到找到一个符合条件的解或符合条件的所有解。

DFS 算法利用的就是回溯思想。





