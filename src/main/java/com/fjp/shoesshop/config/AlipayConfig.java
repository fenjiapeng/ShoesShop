package com.fjp.shoesshop.config;


/**
 * 支付宝的配置类,需要等会支付宝SDK提供的一个AlipayClient(支付宝客户端对象)将这些属性封装
 */
@SuppressWarnings("all")
public class AlipayConfig {
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数
    public static String return_url = "http://vjrv5v.natappfree.cc/ShoesShop_war_exploded/aliPayReturnUrlServlet";  // 此处使用外网ip(使用免费的花生壳或者netapp产生的外网域名)
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = " http://vjrv5v.natappfree.cc/ShoesShop_war_exploded/notify";
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "9021000124643147";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt83+DemgzKlDAt+xf+KIjdKEZPOPybrQwDooqOndohkS8gGlQsytAm3dR2JgEs06WznEztkK/zLBLl45zrRSA2SKNFCis+dQdKfy63QHzWuHnA6TLURnTcMU3dXz7XTzUJ2PIrQYlIxLpuXMOiExpVqqgmQtLQUJ+qrpZt1ItGVuMRKl99fDRhTVd3iHEPMgyRjCVTjZp3fPF69hOwreKJ6sHPu+4G2HbkD757J/kup6PONPhNloYJ0X/OcY2DpGgl6uD24HWQ1fIpQ5ZAONs8y8J7DPEX6nizc1xwAs/h8WQks2J1qOwSl9HzneJ9PEyqYqiDFXFjgZ1ss/rJfExQIDAQAB";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDBrZDe4niZNZou0KQqLVULhnpBvrTIN9QSKZTG4LaEbWx5HUw75LBAMCAtaTaJoKjSpAa+Qd+Cm/VANj0zmg65HxSfEwUDHiYn8/E9vRH6b1hUj27oikCJEGhbGsFan+5+bPsApEkcX67O1Yw9cm0sNEPAG/QdGJTawDepg+jDUq8DoJRn5RNc5HC91u7C/f3+tE5U9RwHlkcw7Pe4cnqTw7KRxB0jOg3NTXkAN/oK9ReAXjQIsDjI78VtmuuPU/xBa8+8KTT+/XqW2HKemHH8mYPkocbgaya0nYXuNyd7IwZZaNtWGjSkqVPd9ao4NdYxGmZbIqproHz3UnOq2pF9AgMBAAECggEBAJat3Ra6ZQ71V+XyJrY1nIOh9P2vS+C1JoWW2gu8CeOPaiPz+jpimgjmKDKMN4TtfEqcmC5u+2AWy8BQMl8yDSBTIOz9lBmv3AmbTOU2coU/GR54lNXPsZOxMy8l6qYB5T9ws/r01XiArHR4SWoI2wzYAJm2Zb45QJ3Li8KTQISsNcJct/rcaWwy3VbwoYJ+sCkgNUmWPY4ix6KOMDxwKeBQNee66MfGZiAf2xY4txLxWicEJK8iHDkObKzYQiwIonk9z0bLT4GpU/v8NV2A2MFs58PcF77J6vCBYnLbIAfOhxR5YDbjhFUbMNxQYXm6b99C9xt8mxokVlVJklTLrMECgYEA4ZW8A9VvCwJ8Up6NL1ntg83IvQ0/2GnQ6k9QrpjwXdw6lSiZv4MQygLZ9iX0eFAZ8vdNy2nRC7mA9O8CEoFv/TKyRwmfQcPM78Etg5LM/JqEWjAbwlgvMXD8i2IbLaBF2EddZNBIEHz5yvJjP2o8x0JPc9E9P03KFMM4YYUZ6A0CgYEA28qJLYb0zG+Sxb2SW4Y0YN3eKig5dVddywhprRdAfNMKIrK2XuCeUoEhm/8u620j/YQoPoyXfbMuTCCkOuo32kZuGPmASx86p/q0sU+JF1Sbug1F/5O/sUTpnHCJZZLKlpNCkuT6YzbYnGN/6UkD4/DAcR40X7r+fxcycv+hAzECgYEA0H+RqEVz/cwNVlt/CL3oXkMr/zgow4CB/J7UZpuqxkXPy58cA7tDIENkazKHc1Atu7hBqfmiomCRRVFHLA2AkZhy2F+XV7R+TTbSN2LOnca+/5Cph4X0EJFqifViQ1h4Vb8YHh64DK1GPwKrIqixhkXOo7BIGKNwXKJXESNxX10CgYA4Zit3PEc64nKGPVP+Glz8clJc/P9pheayf9EmMm5A2aKjLrqvc/IMd8hZEE1I6jOvDSeKjWceQUljDYk2+P0mDKaZ0AREwpm5mxKc4SzriLGBN4C7yX0KDwXnN9V59AX6R4VwzkMWDG/fCYU8JplR92haXobP/drqX9h5O/FkMQKBgQDfOoGy7x58fLDm0sjx2QzVmc5NcQMc9xuF3jKWEWRHq6T0RACxNuruQlt5mJnmBl0Kkc8xpTc0wrIv2uzRBKwm1LB2cHJD38MZpbKongQwUG9IbTGDUAkHwjVcN8EC5adANWMW2Xq49LeoZRuePy1l8ZLtP9/L1UiTVL51hxcnZA==";
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do" ;
}
