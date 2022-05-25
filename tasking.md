#Locker

1. Given Locker有空柜，When发出存包请求，Then成功存包且占用一个空位并返回Ticket 
2. Given Locker已满，When发出存包请求，Then返回"Locker已满"提示 
3. Given 取包信息核验正确，When用户扫Ticket请求取包，Then打开柜子成功取包 
4. Given Ticket信息不正确/已失效，When用户扫Ticket请求取包，Then取包失败并提示失败信息



#Primary Locker Robot
1. Given robot管理两个locker，两个locker都有可用容量; When robot存包; Then 成功存入第一个locker，返回票据
2. Given robot管理两个locker，第一个locker已经存满，第二个locker有可用容量; When robot存包; Then 成功存入第二个locker，返回票据
3. Given robot管理两个locker，两个locker都没有可用容量; When robot存包; Then 存包失败，提示储物柜已满
4. Given robot管理两个locker，拿到一张有效的票; When robot取包; Then 取包成功
5. Given robot管理两个locker，拿到一张伪造的票; When robot取包; Then 取包失败，提示非法票据

