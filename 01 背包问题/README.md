| [Fixbag01.java](https://github.com/mzdora/DynamicProgramming/blob/master/01 背包问题/Fixbag01.java) | [bag01.java](https://github.com/mzdora/DynamicProgramming/blob/master/01 背包问题/bag01.java) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 实现空间优化                                                 | 基础思路                                                     |

1. 其实还有一种**暴力搜索法**，我把伪代码贴上。

   ```java
   if(当前容量>背包容量||枚举的物体>所有物体){
       return;
   }else{
       maxV = Math.max(MaxV,nowV);
   }
   for(枚举的物体){
       递归(A,V,i+1,nowA+A[i],nowV+V[i],m);
   }
   ```

   局限性在于复杂度太高，O(N^2)。

2. 贪心算法

   所有的贪心算法都是错误的。

   **取单位价值最高:**

   ​	m=2,A=[1,1,2],V=[2,2,3]

   ​	贪心: 3 正确答案: 4

   **取重量最轻:**

   ​	m=2,A=[1,1,2],V=[1,1,3]

   ​	贪心:2 正确答案:3

   **取单位价值最高:**

   ​	m=2,A=[1,1,3],V=[2,2,5]

   ​	贪心:4 正确答案:5

