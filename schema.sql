CREATE DATABASE IF NOT EXISTS `checkout-sandbox`;
USE `checkout-sandbox`;

create table if not exists `merchant`
(
    id                                 bigint auto_increment
        primary key,
    address                            varchar(255) null,
    checkout_display_address           varchar(255) null,
    checkout_display_logo_url          varchar(255) null,
    checkout_display_name              varchar(255) null,
    checkout_display_phone             varchar(255) null,
    integration_merchant_code          varchar(255) null,
    integration_notify_url             varchar(255) null,
    integration_secure_code            varchar(255) null,
    integration_secure_pass_massed_pan varchar(255) null,
    merchant_name                      varchar(255) null,
    merchant_tags                      varchar(255) null,
    merchant_type                      varchar(255) null,
    phone                              varchar(255) null,
    user_id                            varchar(255) null,
    constraint UK_nnipvy2969h4kwttrwvk6ano
        unique (user_id)
);

create table if not exists `merchant_fee`
(
    id                       bigint auto_increment
        primary key,
    is_default               bit          not null,
    max_amount               varchar(255) null,
    merchant_id              varchar(255) null,
    min_amount               varchar(255) null,
    payment_method_bank_code varchar(255) null,
    payment_method_bank_id   varchar(255) null,
    payment_method_code      varchar(255) null,
    payment_method_id        varchar(255) null,
    receiver_fee_fix         varchar(255) null,
    receiver_fee_percentage  varchar(255) null,
    sender_fee_fix           varchar(255) null,
    sender_fee_percentage    varchar(255) null,
    user_id                  varchar(255) null
);


create table if not exists `orders`
(
    id                                     bigint auto_increment
        primary key,
    selecteb_config_merchant_fee_id        varchar(255) null,
    selecteb_payment_method_bank_code      varchar(255) null,
    selecteb_payment_method_bank_code_time varchar(255) null,
    selected_payment_method_code           varchar(255) null,
    selected_payment_method_code_time      varchar(255) null,
    cancel_redirect_url                    varchar(255) null,
    cashin_id                              varchar(255) null,
    customer_ip_first_time                 varchar(255) null,
    display_request_first_time             varchar(255) null,
    display_request_last_time              varchar(255) null,
    merchant_code                          varchar(255) null,
    merchant_id                            varchar(255) null,
    order_amount                           varchar(255) null,
    order_code                             varchar(255) null,
    order_create_time                      varchar(255) null,
    order_merchant_time                    varchar(255) null,
    order_payment_method_bank_code         varchar(255) null,
    order_payment_method_code              varchar(255) null,
    status                                 varchar(255) null,
    success_callback_url                   varchar(255) null,
    success_redirect_url                   varchar(255) null,
    transaction_id                         varchar(255) null,
    user_id                                varchar(255) null
);