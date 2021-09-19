# Swagger进行接口测试
http://localhost:4000/swagger-ui.html

http://localhost:4000/doc.html

http://localhost:4000/docs.html

http://localhost:4000/document.html

# 后端接口说明：
## 1、登录接口 （get请求）
http://localhost:4000/api/v1/userLogin

## 2、注册接口 （post请求）
http://localhost:4000/api/v1/userResgit

## 3、查询全部商品信息（get请求）
http://localhost:4000/api/v1/goods/getAllGoods

## 4、根据商品ID查看商品详情（get请求）
http://localhost:4000/api/v1/goods/getGoodsById/{id}

## 5、根据类别ID查看商品（get请求）
http://localhost:4000/api/v1/goods/getGoodsByCId/{categoryId}

## 6、根据用户ID查看购物车（get请求）
http://localhost:4000/api/v1/carts/getCarts

## 7、根据ID集合查询对应的信息（get请求）
http://localhost:4000/api/v1/carts/listCartsByIds

## 8、添加购物车（post请求）
http://localhost:4000/api/v1/carts/insertCarts

## 9、更新购物车数量（get请求）
http://localhost:4000/api/v1/carts/updateAmount/{amount}/{id}/{usersId}

## 10、移除单个购物车列表信息（get请求）
http://localhost:4000/api/v1/carts/removeCartsById/{id}

## 11、查询全部收货地址信息（get请求）
http://localhost:4000/api/v1/receiver/getAllReceiver

## 12、根据用户ID查询收货地址信息（get请求）
http://localhost:4000/api/v1/receiver/getReceiverById/{usersId}

## 13、添加收货地址信息（post请求）
http://localhost:4000/api/v1/receiver/insertReceiver

## 14、修改收货地址信息（post请求）
http://localhost:4000/api/v1/receiver/updateReceiver

## 15、创建订单（post请求）
http://localhost:4000/api/v1/orders/insertOrders

## 16、根据用户ID查询订单详情（get请求）
http://localhost:4000/api/v1/orders/getOrders/{usersId}

## 17、根据订单号查看详情（get请求）
http://localhost:4000/api/v1/orders/selectByOId/{ordersId}
