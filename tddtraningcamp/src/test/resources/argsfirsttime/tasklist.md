```
Args arg = new Args("l,p#,d*", args);

-l -p 8080 -d /usr/logs

args : -g this,is,a,list -d 1,2,-3,5
```



- [ ] char    - Boolean arg. ("l", args)
  - [ ] 在schema中存在。在args中不存在返回 默认值 
  - [ ] 在schema中存在。在args中存在返回对应值
  - [ ] 在schema中不存在 抛出错误
- [ ] argparser  
  - [ ] 在argument中存在，返回对应值
  - [ ] 不存在，返回默认值
  - [ ] argument字符串校验
    - [ ] 第一个字符不是flag    "a,c" "a -c"
    - [ ] 以-开始  
      - [ ] 长度不为2 "a" "-ab"
      - [ ] 第二个字符不为字母 "a" "--"
      - [ ] flag 不在schema中存在
      - [ ] bool 情况不是最后一个字符并且下一个字符不为flag  "a" "-a b"
      - [ ] 非bool情况下为最后一个字符或者下一个不为value"a,b*" "-a -a"
    - [ ] 不以 -开头 不能出现连续的两个 value
- [ ] schema  
  - [ ] 校验schema格式
    - [ ] 长度>=0
    - [ ] 第一个character是字符串
    - [ ] 后面部分包含在制定类型中
  - [ ] schema 判断类型
- [ ] char*   - String arg.  
  - [ ] 在schema中类型正确，在argument 中存在获取对应值,
  - [ ] 在schema中类型正确，在argument中存在返回默认值
  - [ ] 在schema中类型错误
- [ ] char#   - Integer arg. 
- [ ] char##  - double arg.
- [ ] char[*] - one element of a string array. 


//问题  
校验应不应该写在构造方法里

####总结
1. tdd大步小步时取决于对这个问题的理解程度的，同一个粒度，刚接触这个问题的时候可能是一大步，到后面，可能是一小步
2. 写测试时，想想如何驱动出类和接口。