# springcloud-demo

EUREKA http://localhost:8761/

ADMIN http://localhost:8888/

SWAGGER http://localhost:10000/swagger-ui.html

测试 http://localhost:10000/order/create?userId=1&productId=1&count=10&money=100

## 分布式事务
本demo暂未实现。

### Seata
一阶段准备
![seata_1](docs/seata_1.png)

二阶段提交
![seata_2](docs/seata_2.png)

二阶段回滚
![seata_3](docs/seata_3.png)

### 2PC
![2pc](docs/2pc.png)

### 3PC
![3pc](docs/3pc.png)

### TCC
![tcc](docs/tcc.png)
