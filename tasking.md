#Locker

- [ ] Given Locker有空柜，When发出存包请求，Then成功存包且占用一个空位并返回Ticket
- [ ] Given Locker已满，When发出存包请求，Then返回"Locker已满"提示
- [ ] Given 取包信息核验正确，When用户扫Ticket请求取包，Then打开柜子成功取包
- [ ] Given Ticket信息不正确/已失效，When用户扫Ticket请求取包，Then取包失败并提示失败信息
