/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     2021/2/10 2:27:09                            */
/*==============================================================*/


drop table if exists menu;

drop table if exists "order";

drop table if exists shop;

drop table if exists "user";

drop table if exists userShopToMenu;

drop table if exists userShopToShop;

drop table if exists userToOrder;

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu 
(
   id                   bigint                         not null,
   name                 varchar(100)                   null,
   price                decimal(10,2)                  null,
   sales                int                            null,
   type                 varchar(20)                    null,
   imgAddr              varchar(100)                   null,
   "desc"               varchar(200)                   null,
   createTime           varchar(100)                   null,
   updateTime           varchar(100)                   null,
   constraint PK_MENU primary key clustered (id)
);

comment on column menu.id is 
'id';

comment on column menu.name is 
'菜名';

comment on column menu.price is 
'菜的价格';

comment on column menu.sales is 
'销量';

comment on column menu.type is 
'菜的类型';

comment on column menu.imgAddr is 
'图片地址';

comment on column menu."desc" is 
'描述';

comment on column menu.createTime is 
'创建时间';

comment on column menu.updateTime is 
'修改时间';

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
create table "order" 
(
   id                   bigint                         not null,
   orderStatus          varchar(32)                    null,
   menuId               bigint                         null,
   orderPrice           decimal(10,2)                  null,
   deliveryAddr         varchar(300)                   null,
   createTime           varchar(50)                    null,
   updateTime           varchar(50)                    null,
   constraint PK_ORDER primary key clustered (id)
);

comment on column "order".id is 
'id';

comment on column "order".orderStatus is 
'订单状态';

comment on column "order".menuId is 
'菜单id';

comment on column "order".orderPrice is 
'订单金额';

comment on column "order".deliveryAddr is 
'配送地址';

comment on column "order".createTime is 
'订单创建时间';

comment on column "order".updateTime is 
'订单修改时间';

/*==============================================================*/
/* Table: shop                                                  */
/*==============================================================*/
create table shop 
(
   id                   bigint                         not null,
   shopName             varchar(50)                    null,
   "desc"               varchar(100)                   null,
   shopAddr             varchar(300)                   null,
   sendPrice            decimal(6,2)                   null,
   type                 int                            null,
   createTime           varchar(32)                    null,
   updateTime           varchar(32)                    null,
   openTime             varchar(32)                    null,
   closeTime            varchar(32)                    null,
   constraint PK_SHOP primary key clustered (id)
);

comment on column shop.id is 
'id';

comment on column shop.shopName is 
'店铺名称';

comment on column shop."desc" is 
'描述';

comment on column shop.shopAddr is 
'店铺地址';

comment on column shop.sendPrice is 
'起送价格';

comment on column shop.type is 
'店铺是否存在';

comment on column shop.createTime is 
'创建时间';

comment on column shop.updateTime is 
'修改时间';

comment on column shop.openTime is 
'店铺开启时间';

comment on column shop.closeTime is 
'店铺关闭时间';

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table "user" 
(
   id                   bigint                         not null,
   name                 varchar(32)                    null,
   phone                varchar(32)                    null,
   email                varchar(32)                    null,
   password             varchar(32)                    null,
   type                 varchar(20)                    null,
   addr                 varchar(100)                   null,
   createTime           varchar(50)                    null,
   updateTime           varchar(50)                    null,
   constraint PK_USER primary key clustered (id)
);

comment on column "user".id is 
'id';

comment on column "user".name is 
'姓名';

comment on column "user".phone is 
'手机号';

comment on column "user".email is 
'邮箱';

comment on column "user".password is 
'邮箱';

comment on column "user".type is 
'类型，有商家和普通用户';

comment on column "user".addr is 
'地址';

comment on column "user".createTime is 
'创建时间';

comment on column "user".updateTime is 
'修改时间';

/*==============================================================*/
/* Table: userShopToMenu                                        */
/*==============================================================*/
create table userShopToMenu 
(
   id                   bigint                         not null,
   userShopId           bigint                         null,
   menuId               bigint                         null,
   shopId               bigint                         null,
   constraint PK_USERSHOPTOMENU primary key clustered (id)
);

comment on column userShopToMenu.id is 
'id';

comment on column userShopToMenu.userShopId is 
'商家用户id';

comment on column userShopToMenu.menuId is 
'菜单id';

comment on column userShopToMenu.shopId is 
'店铺id';

/*==============================================================*/
/* Table: userShopToShop                                        */
/*==============================================================*/
create table userShopToShop 
(
   id                   bigint                         not null,
   shopUserId           bigint                         null,
   shopId               bigint                         null,
   constraint PK_USERSHOPTOSHOP primary key clustered (id)
);

comment on column userShopToShop.id is 
'id';

comment on column userShopToShop.shopUserId is 
'商家用户id';

comment on column userShopToShop.shopId is 
'店铺id';

/*==============================================================*/
/* Table: userToOrder                                           */
/*==============================================================*/
create table userToOrder 
(
   id                   bigint                         not null,
   order_id             bigint                         null,
   shop_id              bigint                         null,
   user_id              bigint                         null,
   constraint PK_USERTOORDER primary key clustered (id)
);

comment on column userToOrder.id is 
'id';

comment on column userToOrder.order_id is 
'orderId';

comment on column userToOrder.shop_id is 
'shopId';

comment on column userToOrder.user_id is 
'userId';

