args

思考：

第一版任务拆分拆分

1. parser schema
2. 解析 arguments
3. 获取argument的值

问题

1. 按照这种拆分发现些测试用例时会暴露太多的内部实现
2. 不知道每个测试用例如何验证。
3. tdd步子太大了，走不下去了
4. 知道代码不好，不知道如何重构

结论：

1. 任务拆分应该根据输入输出取拆分，而不应该是我已经想好是怎么实现，然后把一个功能的几个阶段分别拆成一个任务
2. 子步骤也是可以拆分的，但是最好是可测试的拆分。
3. 不暴露状态的情况下可测试
4. 小步是为了降低输入输出的复杂度
5. 当发现一步做不出来时，再次拆分更小的task list
7. 小步修改


    public class ArgsMain {
      public static void main(String[] args) {
        try {
          Args arg = new Args("l,p#,d*", args);
          boolean logging = arg.getBoolean('l');
          int port = arg.getInt('p');
          String directory = arg.getString('d');
          executeApplication(logging, port, directory);
        } catch (ArgsException e) {
          System.out.printf("Argument error: %s\n", e.errorMessage());
        }
      }
    
      private static void executeApplication(boolean logging, int port, String directory) {
        System.out.printf("logging is %s, port:%d, directory:%s\n",logging, port, directory);
      }
    }
    
    Schema:
     - char    - Boolean arg.
     - char*   - String arg.
     - char#   - Integer arg.
     - char##  - double arg.
     - char[*] - one element of a string array.
    
    Example schema: (f,s*,n#,a##,p[*])
    Coresponding command line: "-f -s Bob -n 1 -a 3.2 -p e1 -p e2 -p e3
    

task list  


-  校验 。schema is ""
  - arguments not in schema
    - 未准确提示哪个参数无效
  - get argument not in schema 
  - get argument type error 
  - schema无效字符串
  - 非bool型未指定参数
  - schema不符合规范 :长度小于2
- 解析 bool
  - (f, "-f")
  - (f, "")
  - get “h”在schema不存在
- 解析 string
  - （s*, ""）
  - (s*, "-s a")
  - get  h
- 解析 integer
- 解析 double
- 解析 char[*] 
- 异常处理
