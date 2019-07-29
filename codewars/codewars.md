#### Find the odd int

##### 异或

性质

```
1. 交换律 
2、结合律（即(a^b)^c == a^(b^c)） 
3、对于任何数x，都有x^x=0，x^0=x 
4、自反性 A XOR B XOR B = A xor 0 = A
```

使用异或的性质可以求 唯一奇数个数和唯一偶数个数

##### java stream



#### Weight for weight

```
String s ="a";
s.chars()方法，返回Stream
s.chars().sum()获得相加的结果
```





```
接口	参数	返回类型	说明
Predicate<T>	T	boolean	输入某个值，输出bool值，用于对某值进行判定
Consumer<T>	T	void	输入某值，无输出。用于消费某值
Function<T,R>	T	R	输入某类型值，输出另种类型值，用于类型转化等
Supplier<T>	None	T	无输入，输出某值，用于生产某值
UnaryOperator<T>	T	T	输入某类型值，输出同类型值，用于值的同类型转化，如对值进行四则运算等
BinaryOperator<T>	(T,T)	T	输入两个某类型值，输出一个同类型值，用于两值合并等
--------------------- 

```

