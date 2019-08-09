```
Args arg = new Args("l,p#,d*", args);

-l -p 8080 -d /usr/logs

args : -g this,is,a,list -d 1,2,-3,5
```



- [ ] char    - Boolean arg. ("l", args)
  - [ ] 在args中不存在返回 默认值
  - [ ] 在args中存在返回对应值
  - [ ] flag 在schema中不存在
- [ ] argparser  
- [ ] char*   - String arg.  
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