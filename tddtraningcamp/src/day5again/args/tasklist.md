```
Args arg = new Args("l,p#,d*", args);

-l -p 8080 -d /usr/logs

args : -g this,is,a,list -d 1,2,-3,5
```



- [x] char    - Boolean arg. ("l", args)
  - [x] 在schema中存在。在args中不存在返回 默认值
  - [x] 在schema中存在。在args中存在返回对应值
  - [x] 在schema中不存在 抛出错误
- [ ] argparser  
  - [x] 在argument中存在，返回对应值
  - [x] 不存在，返回默认值
  - [x] argument校验
    - [x] 每个flag长度不对
    - [x] 不以 - 开始
    - [x] 不是字母
    - [ ] argument中值和schema中的值类型正确
- [x] schema  
  - [x] 校验schema格式
  - [x] schema 判断类型
  - [x] schema判断String类型
- [ ] char*   - String arg.  
  - [ ] 在schema中类型正确，在argument 中存在获取对应值,
  - [ ] 在schema中类型正确，在argument中存在返回默认值
  - [ ] 在schema中类型错误
- [ ] char#   - Integer arg. 
- [ ] char##  - double arg.
- [ ] char[*] - one element of a string array. 

 -  校验 。schema is ""
   - arguments not in schema
     - 未准确提示哪个参数无效
   - get argument not in schema 
   - get argument type error 
   - schema无效字符串
   - 非bool型未指定参数
   - schema不符合规范 :长度小于2

//问题  校验应不应该写在构造方法里