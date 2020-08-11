# 服务C
为服务A提供服务

## 前提
- 安装Git
- 安装maven
- 安装docker
- 安装k8s集群
- 安装istio

## 打包
```
cd service-c/
mvn clean package
```

## 构建镜像
```
docker build -t kyg/service-c-docker .
```

## 查看镜像
```
docker images kyg/service-c-docker
```

## 部署
```
kubectl apply -f service-c.yaml
kubectl patch svc service-c -p '{"spec": {"type": "LoadBalancer"}}'
kubectl edit service service-c
```

## 暴露服务
```
kubectl get svc
kubectl edit service service-c

spec:
  externalIPs:
  - 192.168.0.5
```

## 入口网关
```
kubectl apply -f c
```

## 访问
```
curl http://192.168.0.5:8093/userInfo?username=admin
```