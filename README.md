# 密码中心 code-center

## 梗概
日常生活中总会围绕着很多个账号，基本上每个网站、APP等都会创建一个。这些账号的管理就给人造成了很大的困扰：

如果所有账号都用同一个密码，各个IT服务提供商设置的密码规则不尽相同，可能根本就无法统一密码。而且使用全局统一的密码显然降低了安全性，只要一处地方被怕破解则“满盘皆输”。

如果使用不同的密码，那么多不同的常用密码人脑显然无法全部记住，更别说那些常年都不登录一回的帐号了。如果写下来或记录在某个文件（密码本）里面，明文存储的密码同样存在极大的泄露风险。

有一种解决方案是，各处使用不同的、复杂的、无规则的密码，用一个或少数几个密钥通过可逆加密算法对密码进行可逆加密后，再登记到密码本中，待到使用的时候再用对应的密钥和加密算法解密出原密码。

**密码中心**应用程序的功能之一就是提供这种解决方案的加密解密手段。

## 版本

- `v1.0.0`：提供DES算法加密解密功能。

## 部署

### 容器化部署(推荐)

执行以下命令，从[https://hub.docker.com/repository/docker/wyatt6/code-center](https://hub.docker.com/repository/docker/wyatt6/code-center)拉取容器镜像：

```shell
docker pull wyatt6/code-center:${VERSION}
```

而后使用该镜像运行容器：

```shell
docker run --name code-cener -p 9001:9001 --restart=unless-stopped -d code-center:1.0.0
```
（`${VERSION}`表示版本号，如`1.0.0`）

浏览器输入`http://localhost:9001/code-center`即可使用密码中心的服务。

### jar包部署

下载源代码后，用maven打包工具打包成jar包`code-center.v${VERSION}.jar`（`${VERSION}`表示版本号，如`1.0.0`），并在控制台执行以下命令运行应用：

```shell
java -jar code-center.v${VERSION}.jar
```

浏览器输入`http://localhost:9001/code-center`即可使用密码中心的服务。