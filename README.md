# 接口模拟服务应用 

## 配置接口
1.在src/main/resources/records.mappings 目录中配置，后者为.json 的接口描述文件

* get 样例如下

```json
{
  "request" : {
    "url" : "/api/mock/userInfo",
    "method" : "GET"
  },
  "response" : {
    "status" : 200,
    "jsonBody" : {
		"name":"mock name ",
		"age" : "113"
	},
    	"headers": {
      		"Content-Type": "application/json ; charset=UTF8"
    	}
  }
}
```

* Post 样例如下
```json
{
	"request": {
		"urlPath": "/api/mock/getinfos",
		"method": "POST",
	    "bodyPatterns" : [ {
			"equalToJson" : "{\"data\":{\"cardNo\":\"0006225780500018471\"},\"header\":{\"userId\":\"APTST01\"}}",
			"ignoreArrayOrder" : true,
			"ignoreExtraElements" : true
	    } ]
	},
	"response": {
    	"status": 200,
    	"jsonBody": {
						"code":"0",
						"msg":"成功",
						"data":{
							"custNo":"199400009",
							"expiMmyy":"965",
							"affiCode":"501",
							"cardType":"705",
							"name":"张省浅",
							"blockDte":"0",
							"relationship":"P",
							"acData":[{"acOrg":"156","acType":"2","acNo":"199400009002001"},{"acOrg":"840","acType":"2","acNo":"199400009002001"}]
						}
					},
    	"headers": {
      		"Content-Type": "application/json ; charset=UTF8"
    	}
  	}
}

```

## 服务启动 

* 编译打包 
```maven

mvn clean package -Dmaven.test.skip=true 

```

* 启动
```bash

java -jar wiremockserver-0.0.1-SNAPSHOT.jar --server.port=8888 --wireMock.files.path=/Users/skybird/IdeaWorkspace/wiremockserver/src/main/resources/records

```