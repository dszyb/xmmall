/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : xmmall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-09-05 22:02:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `carts`
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT NULL,
  `users_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carts
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '手机');
INSERT INTO `category` VALUES ('2', '电视');
INSERT INTO `category` VALUES ('3', '笔记本 平板');
INSERT INTO `category` VALUES ('4', '家电');
INSERT INTO `category` VALUES ('5', '出行 穿戴');
INSERT INTO `category` VALUES ('6', '智能 路由器');
INSERT INTO `category` VALUES ('7', '电源 配件');
INSERT INTO `category` VALUES ('8', '健康 儿童');
INSERT INTO `category` VALUES ('9', '耳机 音箱');
INSERT INTO `category` VALUES ('10', '生活 箱包');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cover` varchar(255) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '../upload/20210528235659.jpg', 'MIX FOLD折叠屏手机', '10999', null, '10000', '1');
INSERT INTO `goods` VALUES ('2', '../upload/20210528235852.jpg', '小米10', '3599', null, '10000', '1');
INSERT INTO `goods` VALUES ('3', '../upload/20210529000029.jpg', 'Note9 4G', '1299', null, '10000', '1');
INSERT INTO `goods` VALUES ('4', '../upload/20210529000224.jpg', '小米10S', '3299', null, '10000', '1');
INSERT INTO `goods` VALUES ('5', '../upload/20210529000518.jpg', '小米11 UItra', '5999', null, '10000', '1');
INSERT INTO `goods` VALUES ('6', '../upload/20210529000757.jpg', '小米11 Pro', '5299', null, '10000', '1');
INSERT INTO `goods` VALUES ('7', '../upload/20210529001121.jpg', '小米10 青春版 5G', '2099', null, '10000', '1');
INSERT INTO `goods` VALUES ('8', '../upload/20210529001251.jpg', '黑鲨4', '2699', null, '10000', '1');
INSERT INTO `goods` VALUES ('9', '../upload/20210529001610.jpg', '黑鲨4 Pro', '3999', null, '10000', '1');
INSERT INTO `goods` VALUES ('10', '../upload/20210529001819.jpg', 'Redmi Note10 Pro', '1599', null, '10000', '1');
INSERT INTO `goods` VALUES ('11', '../upload/20210529002110.jpg', 'Redmi Note10 5G', '1099', null, '10000', '1');
INSERT INTO `goods` VALUES ('12', '../upload/20210529002540.jpg', 'Note 9 5G', '1299', null, '10000', '1');
INSERT INTO `goods` VALUES ('13', '../upload/20210529002702.jpg', 'Note9 5G Pro', '1799', null, '10000', '1');
INSERT INTO `goods` VALUES ('14', '../upload/20210529002859.jpg', 'Redmi K40', '2699', null, '10000', '1');
INSERT INTO `goods` VALUES ('15', '../upload/20210529003046.jpg', 'Redmi 8A', '799', null, '10000', '1');
INSERT INTO `goods` VALUES ('16', '../upload/20210529003219.jpg', 'Redmi 9A', '599', null, '10000', '1');
INSERT INTO `goods` VALUES ('17', '../upload/20210529003503.jpg', 'Redmi 10X 4G', '999', null, '10000', '1');
INSERT INTO `goods` VALUES ('18', '../upload/20210529003720.jpg', 'Redmi 10X 5G', '1899', null, '10000', '1');
INSERT INTO `goods` VALUES ('19', '../upload/20210529003923.jpg', 'Redmi K30 5G', '1999', null, '10000', '1');
INSERT INTO `goods` VALUES ('20', '../upload/20210529004059.jpg', 'Redmi K40 游戏增强版', '2699', null, '10000', '1');
INSERT INTO `goods` VALUES ('21', '../upload/20210905215020.jpg', 'Xiaomi MIX 4', '5799', null, '10000', '1');
INSERT INTO `goods` VALUES ('22', '../upload/20210905215021.jpg', '小米11 青春版', '2049', null, '10000', '1');
INSERT INTO `goods` VALUES ('23', '../upload/20210905215022.jpg', 'Redmi K30S 至尊纪念版', '2799', null, '10000', '1');
INSERT INTO `goods` VALUES ('24', '../upload/20210905215023.jpg', 'Redmi K40', '2699', null, '10000', '1');

-- ----------------------------
-- Table structure for `goodssku`
-- ----------------------------
DROP TABLE IF EXISTS `goodssku`;
CREATE TABLE `goodssku` (
  `skid` int(11) NOT NULL AUTO_INCREMENT,
  `edition` varchar(20) NOT NULL,
  `color` varchar(20) NOT NULL,
  `goods_id` int(11) NOT NULL,
  PRIMARY KEY (`skid`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodssku
-- ----------------------------
INSERT INTO `goodssku` VALUES ('1', '12GB+256GB', '黑色', '1');
INSERT INTO `goodssku` VALUES ('2', '12GB+512GB', '黑色', '1');
INSERT INTO `goodssku` VALUES ('3', '16GB+512GB', '黑色', '1');
INSERT INTO `goodssku` VALUES ('4', '8GB+128GB', '国风雅灰', '2');
INSERT INTO `goodssku` VALUES ('5', '8GB+256GB', '钛银黑', '2');
INSERT INTO `goodssku` VALUES ('6', '12GB+256GB', '冰海蓝', '2');
INSERT INTO `goodssku` VALUES ('7', '4GB+128GB', '烟波蓝', '3');
INSERT INTO `goodssku` VALUES ('8', '8GB+128GB', '羽墨黑', '3');
INSERT INTO `goodssku` VALUES ('9', '6GB+128GB', '曙光橙', '3');
INSERT INTO `goodssku` VALUES ('10', '8GB+256GB', '雾光青', '3');
INSERT INTO `goodssku` VALUES ('11', '8GB+128GB', '黑色', '4');
INSERT INTO `goodssku` VALUES ('12', '8GB+256GB', '白色', '4');
INSERT INTO `goodssku` VALUES ('13', '12GB+256GB', '蓝色', '4');
INSERT INTO `goodssku` VALUES ('14', '8GB+256GB', '陶瓷黑', '5');
INSERT INTO `goodssku` VALUES ('15', '12GB+256GB', '陶瓷白', '5');
INSERT INTO `goodssku` VALUES ('16', '12GB+512GB', '大理石纹特别版', '5');
INSERT INTO `goodssku` VALUES ('17', '8GB+256GB', '黑色', '6');
INSERT INTO `goodssku` VALUES ('18', '8GB+128GB', '绿色', '6');
INSERT INTO `goodssku` VALUES ('19', '12GB+256GB', '紫色', '6');
INSERT INTO `goodssku` VALUES ('20', '6GB+64GB', '白桃乌龙', '7');
INSERT INTO `goodssku` VALUES ('21', '6GB+128GB', '蓝莓薄荷', '7');
INSERT INTO `goodssku` VALUES ('22', '8GB+128GB', '黑巧风暴', '7');
INSERT INTO `goodssku` VALUES ('23', '8GB+256GB', '桃子西柚', '7');
INSERT INTO `goodssku` VALUES ('24', '12GB+256GB', '幻境黑', '8');
INSERT INTO `goodssku` VALUES ('25', '8GB+256GB', '墨海黑', '8');
INSERT INTO `goodssku` VALUES ('26', '12GB+128GB', '风暴蓝', '8');
INSERT INTO `goodssku` VALUES ('27', '8GB+128GB', '凌光灰', '8');
INSERT INTO `goodssku` VALUES ('28', '12GB+256GB', '墨海黑', '9');
INSERT INTO `goodssku` VALUES ('29', '16GB+512GB', '棱镜灰', '9');
INSERT INTO `goodssku` VALUES ('30', '8GB+256GB', '遂空黑', '9');
INSERT INTO `goodssku` VALUES ('31', '6GB+128GB', '月魄', '10');
INSERT INTO `goodssku` VALUES ('32', '8GB+128GB', '幻青', '10');
INSERT INTO `goodssku` VALUES ('33', '8GB+256GB', '星纱', '10');
INSERT INTO `goodssku` VALUES ('34', '4GB+128GB', '竹石青', '11');
INSERT INTO `goodssku` VALUES ('35', '6GB+128GB', '晴山蓝', '11');
INSERT INTO `goodssku` VALUES ('36', '8GB+128GB', '月影银', '11');
INSERT INTO `goodssku` VALUES ('37', '8GB+256GB', '星云灰', '11');
INSERT INTO `goodssku` VALUES ('38', '6GB+128GB', '云墨黑', '12');
INSERT INTO `goodssku` VALUES ('39', '6GB+256GB', '流影紫', '12');
INSERT INTO `goodssku` VALUES ('40', '8GB+128GB', '青山外', '12');
INSERT INTO `goodssku` VALUES ('41', '8GB+128GB', '湖光秋色', '13');
INSERT INTO `goodssku` VALUES ('42', '6GB+128GB', '碧海星辰', '13');
INSERT INTO `goodssku` VALUES ('43', '8GB+256GB', '静默星空', '13');
INSERT INTO `goodssku` VALUES ('44', '12GB+256GB', '墨羽', '14');
INSERT INTO `goodssku` VALUES ('45', '6GB+128GB', '幻境', '14');
INSERT INTO `goodssku` VALUES ('46', '8GB+128GB', '亮黑', '14');
INSERT INTO `goodssku` VALUES ('47', '8GB+256GB', '晴雪', '14');
INSERT INTO `goodssku` VALUES ('48', '4GB+64GB', '深海蓝', '15');
INSERT INTO `goodssku` VALUES ('49', '4GB+64GB', '砂石黑', '16');
INSERT INTO `goodssku` VALUES ('50', '4GB+128GB', '晴空蓝', '16');
INSERT INTO `goodssku` VALUES ('51', '6GB+128GB', '湖光绿', '16');
INSERT INTO `goodssku` VALUES ('52', '4GB+128GB', '冰雾白', '17');
INSERT INTO `goodssku` VALUES ('53', '6GB+128GB', '天际蓝', '17');
INSERT INTO `goodssku` VALUES ('54', '8GB+256GB', '凝夜紫', '18');
INSERT INTO `goodssku` VALUES ('55', '6GB+64GB', '深海微光', '19');
INSERT INTO `goodssku` VALUES ('56', '6GB+128GB', '时光独白', '19');
INSERT INTO `goodssku` VALUES ('57', '12GB+256GB', '暗影', '20');
INSERT INTO `goodssku` VALUES ('58', '12GB+128GB', '光刃', '20');
INSERT INTO `goodssku` VALUES ('59', '12GB+256GB', '陶瓷黑', '21');
INSERT INTO `goodssku` VALUES ('60', '8GB+128GB', '影青灰', '21');
INSERT INTO `goodssku` VALUES ('61', '8GB+256GB', '陶瓷白', '21');
INSERT INTO `goodssku` VALUES ('62', '8GB+128GB', '清凉薄荷', '22');
INSERT INTO `goodssku` VALUES ('63', '8GB+256GB', '冰峰黑提', '22');
INSERT INTO `goodssku` VALUES ('64', '8GB+256GB', '星际黑', '23');
INSERT INTO `goodssku` VALUES ('65', '8GB+128GB', '月光银', '23');
INSERT INTO `goodssku` VALUES ('66', '12GB+256GB', '墨羽', '24');
INSERT INTO `goodssku` VALUES ('67', '6GB+128GB', '幻境', '24');
INSERT INTO `goodssku` VALUES ('68', '8GB+128GB', '亮黑', '24');
INSERT INTO `goodssku` VALUES ('69', '8GB+256GB', '晴雪', '24');

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `items_id` int(11) NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `orders_id` varchar(14) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`items_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orders_id` varchar(14) NOT NULL,
  `total` float DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `users_id` int(11) DEFAULT NULL,
  `receiver_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`orders_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `receiver`
-- ----------------------------
DROP TABLE IF EXISTS `receiver`;
CREATE TABLE `receiver` (
  `receiver_id` int(11) NOT NULL AUTO_INCREMENT,
  `users_id` int(11) DEFAULT NULL,
  `receiver_name` varchar(20) DEFAULT NULL,
  `receiver_phone` varchar(11) DEFAULT NULL,
  `receiver_province` varchar(20) DEFAULT NULL,
  `receiver_city` varchar(20) DEFAULT NULL,
  `receiver_district` varchar(20) DEFAULT NULL,
  `receiver_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`receiver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receiver
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
