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
/* Table: Menu                                                  */
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
'����';

comment on column menu.price is 
'�˵ļ۸�';

comment on column menu.sales is 
'����';

comment on column menu.type is 
'�˵�����';

comment on column menu.imgAddr is 
'ͼƬ��ַ';

comment on column menu."desc" is 
'����';

comment on column menu.createTime is 
'����ʱ��';

comment on column menu.updateTime is 
'�޸�ʱ��';

/*==============================================================*/
/* Table: "Order"                                               */
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
'����״̬';

comment on column "order".menuId is 
'�˵�id';

comment on column "order".orderPrice is 
'�������';

comment on column "order".deliveryAddr is 
'���͵�ַ';

comment on column "order".createTime is 
'��������ʱ��';

comment on column "order".updateTime is 
'�����޸�ʱ��';

/*==============================================================*/
/* Table: Shop                                                  */
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
'��������';

comment on column shop."desc" is 
'����';

comment on column shop.shopAddr is 
'���̵�ַ';

comment on column shop.sendPrice is 
'���ͼ۸�';

comment on column shop.type is 
'�����Ƿ����';

comment on column shop.createTime is 
'����ʱ��';

comment on column shop.updateTime is 
'�޸�ʱ��';

comment on column shop.openTime is 
'���̿���ʱ��';

comment on column shop.closeTime is 
'���̹ر�ʱ��';

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
'����';

comment on column "user".phone is 
'�ֻ���';

comment on column "user".email is 
'����';

comment on column "user".password is 
'����';

comment on column "user".type is 
'���ͣ����̼Һ���ͨ�û�';

comment on column "user".addr is 
'��ַ';

comment on column "user".createTime is 
'����ʱ��';

comment on column "user".updateTime is 
'�޸�ʱ��';

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
'�̼��û�id';

comment on column userShopToMenu.menuId is 
'�˵�id';

comment on column userShopToMenu.shopId is 
'����id';

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
'�̼��û�id';

comment on column userShopToShop.shopId is 
'����id';

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

