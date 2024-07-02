# X-Learn

i need 自由

**目标：早日退休，多多赚钱**

## Git提交规范

* ==**提交类型（type）**==用于说明此次提交的类型，常见的类型包括：

  * `feat`：表示添加了一个新功能
  * `fix`：修复了一个bug
  * `docs`：修改了项目文档
  * `style`：不改变代码逻辑的样式或格式化更改
  * `refactor`：改进了代码结构，但没有改变外部行为
  * `test`：添加或修改了测试代码
  * `chore`:修改了构建过程、依赖管理或其他非产品代码部分的维护
  * `perf`:优化了性能或减少了资源消耗
  * `revert`:撤销了某个特定的提交

## 代码规范

**尽量按照规范-非强制**

1.controller层返回vo
在controller层，将DTO转换成vo，返回给前端

2.数据库对象使用po(Persistent object 或者do)

3.service层返回DTO (Data Transfer Objec)

4.bo为业务实体
通常在service层，将po转换成bo， bo转换成dto返回

Entity表结构实体，对应DO
BO业务实体
VO视图实体,DTO可共用
入参封装
○ xxxParam
○ Query xxx Param
○ Save xxx Param
○ Edit xxx Param
○ Remove xxx Param
