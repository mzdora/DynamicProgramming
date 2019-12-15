# 背包问题九讲Java实现
有意无意的在网上看到了 **动态规划(BP)** 的入门书，叫[<背包九讲>](https://github.com/mzdora/DynamicProgramming/blob/master/%E8%83%8C%E5%8C%85%E4%B9%9D%E8%AE%B2.pdf)，是dd_engi大佬著的一本针对NOIP难度的BP入门书。</br>
其实最近自己也对动态规划挺感兴趣的，尤其是在LeetCode上有很多问题都能用动态规划解决。</br>
有人说你数据结构那一块还没更新完呢就开新坑。</br>
**红黑树、哈希表、B+树、Trie、线段树、并查集、AVL** 还有一些图论的东西也没更新。</br>
但都会在 <u>寒假期间(1月中旬到2月初)</u> 更新起来的！</br>
其实自己是挺想更新的，但是由于自己太菜，很多东西还在想方设法的实现，再加上期末马上来啦。</br>
<u>所以自己就决定先停下来数据结构的实现，转向动态规划。</u></br>
但还是在这里厚脸皮的发一下数据结构实现的地址:[数据结构](https://github.com/mzdora/DataStructure)</br>
###
目录  
第一讲 [01 背包问题](https://github.com/mzdora/DynamicProgramming/tree/master/01%20%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98)  
第二讲 [完全背包问题](https://github.com/mzdora/DynamicProgramming/tree/master/%E5%AE%8C%E5%85%A8%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98)  
第三讲 [多重背包问题](https://github.com/mzdora/DynamicProgramming/tree/master/%E5%A4%9A%E9%87%8D%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98)  
第四讲 混合三种背包问题  
第五讲 二维费用的背包问题  
第六讲 分组的背包问题  
第七讲 有依赖的背包问题  
第八讲 泛化物品  
第九讲 背包问题问法的变化
###
每当我完成一讲，目录将会变成一个可点击的链接。</br>
由Java语言实现，说不定哪天我也会用Python实现 :D(后话)</br>
然后的然后，我还打算另开一个[**数论**](https://github.com/mzdora/NumberTheory)的新坑。但是可能会在很久之后啦。</br>
其实也有人问我为什么不搞一波人工智能或者前端，毕竟这俩东西特吃香。</br>
只能说人各有志，正因为有这些有趣的算法和数据结构、以及这些数学的沉淀，科学才更好玩。</br>
科学不是跑数据，需要静心。</br>
大家也要加油。</br>
###
01背包问题的状态转移方程:</br>
![](http://latex.codecogs.com/gif.latex?dp%5Bi%5D%5Bv%5D%20%3D%20Math.max%28dp%5Bi-1%5D%5Bv%5D%2Cdp%5Bi-1%5D%5Bv-c%5Bi%5D%5D&plus;w%5Bi%5D%29)</br>
![](http://latex.codecogs.com/gif.latex?dp%5Bv%5D%20%3D%20Math.max%28dp%5Bv%5D%2Cdp%5Bv-c%5Bi%5D%5D&plus;w%5Bi%5D%29)</br>

完全背包问题的状态转移方程:</br>
![](http://latex.codecogs.com/gif.latex?dp%5Bi%5D%5Bv%5D%20%3D%20Math.max%28dp%5Bi-1%5D%5Bv%5D%2Cdp%5Bi-1%5D%5Bv%20-%20k%20%5Ctimes%20c%5Bi%5D%5D%20&plus;%20k%20%5Ctimes%20w%5Bi%5D%29%3B)</br>
![](http://latex.codecogs.com/gif.latex?dp%5Bi%5D%5Bv%5D%20%3D%20Math.max%28dp%5Bi-1%5D%5Bv%5D%2Cdp%5Bi%5D%5Bv-c%5Bi%5D%5D&plus;w%5Bi%5D%29)

...</br>
