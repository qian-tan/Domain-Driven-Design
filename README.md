## DDD-Demo项目工程

## 项目结构:

* server : dubbo服务的provider
* starter : dubbo服务，server模块的启动starter，很薄的一层
* schedule : 定时任务模块，本质上是dubbo服务的consumer
* schedule-starter : 定时任务模块starter，很薄的一层
* web: 对外提供api服务，rest api,本质上是dubbo服务的consumer
* web-starter: rest api starter，很薄的一层
* common : 公共工具类库，比如es、异常等
* api : 定义服务提供方提供的facade api, 要暴露的服务接口放在这个模块
